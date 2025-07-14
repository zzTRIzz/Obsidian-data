

Khi nhiều nhân viên cùng chọn một IMEI cùng lúc, bạn cần triển khai cơ chế để tránh xung đột. Dưới đây là các giải pháp phổ biến:

## 1. Khóa Optimistic (Optimistic Locking)

**Cách hoạt động**:
- Sử dụng version number/timestamp để kiểm tra xung đột
- Khi có xung đột, thông báo cho người dùng biết IMEI đã bị thay đổi

**Triển khai với JPA/Hibernate**:
```java
@Entity
public class Phone {
    @Id
    private Long id;
    
    private String imei;
    
    @Version
    private Integer version;
    // getters & setters
}
```

Khi update:
```java
@Transactional
public void reserveImei(Long phoneId, String reservedBy) {
    Phone phone = phoneRepository.findById(phoneId)
        .orElseThrow(() -> new ResourceNotFoundException("Phone not found"));
    
    if (phone.getReservedBy() != null) {
        throw new ConflictException("IMEI đã được chọn bởi người khác");
    }
    
    phone.setReservedBy(reservedBy);
    phoneRepository.save(phone); // Sẽ throw ObjectOptimisticLockingFailureException nếu có xung đột
}
```

## 2. Khóa Pessimistic (Pessimistic Locking)

**Cách hoạt động**:
- Khóa bản ghi ngay khi bắt đầu transaction
- Chỉ một người có thể thao tác tại một thời điểm

```java
@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {
    
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT p FROM Phone p WHERE p.imei = :imei")
    Phone findByImeiWithPessimisticLock(@Param("imei") String imei);
}
```

## 3. Redis Distributed Lock

**Phù hợp cho hệ thống phân tán**:
```java
public boolean tryReserveImei(String imei, String employeeId) {
    String lockKey = "imei_lock:" + imei;
    String token = UUID.randomUUID().toString();
    
    try {
        // Thử khóa trong 5 giây
        boolean locked = redisTemplate.opsForValue()
            .setIfAbsent(lockKey, token, 5, TimeUnit.SECONDS);
        
        if (!locked) {
            return false;
        }
        
        // Thực hiện logic reserve IMEI
        return reserveImeiInDatabase(imei, employeeId);
    } finally {
        // Giải phóng khóa
        if (token.equals(redisTemplate.opsForValue().get(lockKey))) {
            redisTemplate.delete(lockKey);
        }
    }
}
```

## 4. Database Unique Constraint + Transaction

Thêm ràng buộc duy nhất và xử lý transaction:
```sql
ALTER TABLE phone_reservations 
ADD CONSTRAINT unique_imei_reservation UNIQUE (imei);
```

```java
@Transactional
public void reserveImei(String imei, String employeeId) {
    try {
        // Thử chèn bản ghi mới
        reservationRepository.insertNewReservation(imei, employeeId);
    } catch (DataIntegrityViolationException e) {
        throw new ConflictException("IMEI đã được chọn bởi nhân viên khác");
    }
}
```

## 5. Frontend xử lý real-time

Kết hợp WebSocket để thông báo real-time:
```javascript
// Khi nhân viên chọn IMEI
function selectImei(imei) {
    socket.send(`/app/reserveImei`, {imei: imei, employeeId: currentUser});
    
    socket.subscribe(`/topic/imei/${imei}`, (message) => {
        const data = JSON.parse(message.body);
        if (data.status === 'reserved' && data.employeeId !== currentUser) {
            alert(`IMEI ${imei} vừa được chọn bởi ${data.employeeName}`);
            // Cập nhật UI
        }
    });
}
```

## Lựa chọn giải pháp phù hợp

1. **Ứng dụng đơn giản**: Optimistic Locking (dễ triển khai)
2. **Tần suất xung đột cao**: Pessimistic Locking (hiệu suất tốt hơn)
3. **Hệ thống phân tán**: Redis Lock
4. **Yêu cầu real-time mạnh**: Kết hợp WebSocket + Database Lock

Bạn nên kết hợp nhiều cơ chế để có trải nghiệm người dùng tốt nhất, ví dụ:
- Dùng Optimistic Locking để kiểm tra
- WebSocket để thông báo real-time
- Redis Lock cho hệ thống phân tán