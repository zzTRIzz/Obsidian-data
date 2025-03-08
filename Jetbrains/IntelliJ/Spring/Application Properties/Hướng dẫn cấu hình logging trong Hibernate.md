<br>

## 1. Thiết lập mức độ log cho Hibernate

Để ghi lại tất cả các câu lệnh SQL do Hibernate thực thi, bạn có thể thiết lập mức log ở chế độ **DEBUG** bằng cách thêm dòng sau vào file cấu hình:

```java
logging.level.org.hibernate.SQL=DEBUG
```

Điều này giúp theo dõi chi tiết các truy vấn SQL do Hibernate tạo ra.

---

## 2. Định nghĩa file log

Bạn có thể chỉ định tên file nơi các log sẽ được lưu lại bằng cách thiết lập:

```java
logging.file.name=app.log
```

Trong ví dụ này, tất cả log sẽ được ghi vào file **app.log**.

---

## 3. Cấu hình bổ sung (tuỳ chọn)

Nếu muốn ghi log chi tiết hơn về các tham số truyền vào SQL, thêm dòng sau:

```java
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE
```

Điều này giúp hiển thị giá trị thực tế của các tham số trong câu SQL.