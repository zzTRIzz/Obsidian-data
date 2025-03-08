<br>

## 1. Giới thiệu

`spring.jpa.hibernate.ddl-auto` là thuộc tính trong Spring Boot giúp kiểm soát cách Hibernate quản lý schema của cơ sở dữ liệu. Dưới đây là các tùy chọn và cách sử dụng tối ưu cho từng trường hợp.

---

## 2. Các tùy chọn `ddl-auto`

### 2.1 `update`

```java
spring.jpa.hibernate.ddl-auto=update
```

- **Chức năng**: Cập nhật schema để khớp với các entity trong mã nguồn mà không làm mất dữ liệu hiện có.
    
- **Khi nào sử dụng**:
    
    - Môi trường phát triển hoặc môi trường cần tự động cập nhật schema mà không mất dữ liệu.
        
    - Không phù hợp cho môi trường sản xuất vì có thể gây lỗi không mong muốn.
        

### 2.2 `create`

```java
spring.jpa.hibernate.ddl-auto=create
```

- **Chức năng**: Xóa toàn bộ bảng và tạo lại schema từ đầu mỗi khi ứng dụng chạy.
    
- **Khi nào sử dụng**:
    
    - Phù hợp cho môi trường phát triển hoặc thử nghiệm, nơi dữ liệu không quan trọng.
        
    - Không dùng trong sản xuất vì dữ liệu sẽ bị mất mỗi lần khởi động lại.
        

### 2.3 `create-drop`

```java
spring.jpa.hibernate.ddl-auto=create-drop
```

- **Chức năng**: Tạo schema khi ứng dụng chạy và xóa schema khi ứng dụng dừng lại.
    
- **Khi nào sử dụng**:
    
    - Phù hợp cho môi trường thử nghiệm, nơi không cần giữ dữ liệu sau khi ứng dụng dừng.
        
    - Không thích hợp cho môi trường có dữ liệu quan trọng.
        

### 2.4 `validate`

```java
spring.jpa.hibernate.ddl-auto=validate
```

- **Chức năng**: Kiểm tra schema hiện tại để đảm bảo nó khớp với các entity trong mã nguồn mà không thực hiện bất kỳ thay đổi nào.
    
- **Khi nào sử dụng**:
    
    - Phù hợp cho môi trường sản xuất khi bạn muốn đảm bảo schema đúng nhưng không muốn Hibernate tự động thay đổi nó.
        

### 2.5 `none`

```java
spring.jpa.hibernate.ddl-auto=none
```

- **Chức năng**: Không thay đổi hoặc kiểm tra schema.
    
- **Khi nào sử dụng**:
    
    - Dành cho môi trường sản xuất khi bạn muốn hoàn toàn kiểm soát schema mà không để Hibernate tự động quản lý.
        

---

## 3. Tóm tắt lựa chọn phù hợp

| Tùy chọn        | Chức năng                                   | Khi nào sử dụng                   |
| --------------- | ------------------------------------------- | --------------------------------- |
| **update**      | Cập nhật schema mà không làm mất dữ liệu    | Môi trường phát triển             |
| **create**      | Xóa và tạo lại schema mỗi khi chạy ứng dụng | Môi trường phát triển, thử nghiệm |
| **create-drop** | Xóa schema khi ứng dụng dừng                | Môi trường thử nghiệm             |
| **validate**    | Kiểm tra schema mà không thay đổi           | Môi trường sản xuất               |
| **none**        | Không thay đổi schema                       | Môi trường sản xuất               |

- Nếu bạn chưa có cơ sở dữ liệu:
    
    - `**create**` **hoặc** `**create-drop**` là lựa chọn tốt.
        
    - Dùng `**create**` nếu muốn giữ schema sau mỗi lần chạy.
        
    - Dùng `**create-drop**` nếu không cần dữ liệu sau khi ứng dụng dừng.