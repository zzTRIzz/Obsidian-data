<br>

## 1. Package by Layer

### Định nghĩa

Tổ chức code theo tầng nghiệp vụ (controller, service, repository, model...). Mỗi package đại diện cho một tầng trong kiến trúc ứng dụng.

### Ví dụ

```
src/main/java
└── com.example.app
    ├── controller
    │   ├── UserController.java
    │   └── ProductController.java
    ├── service
    │   ├── UserService.java
    │   └── ProductService.java
    ├── repository
    │   ├── UserRepository.java
    │   └── ProductRepository.java
    ├── model
    │   ├── User.java
    │   └── Product.java
    ├── config
    │   └── SecurityConfig.java
    └── exception
        └── GlobalExceptionHandler.java
```

### Ưu điểm

- Dễ hiểu, phù hợp cho dự án nhỏ hoặc team mới làm quen với Spring Boot.
    
- Tách biệt rõ ràng giữa các tầng (ví dụ: controller không chứa logic nghiệp vụ).
    

### Nhược điểm

- Khó mở rộng: Khi dự án phát triển, các package trở nên "phình to", khó quản lý.
    
- Thay đổi một tính năng phải sửa nhiều package (controller, service, repository...).
    
- Giảm tính gắn kết: Code liên quan đến một nghiệp vụ nằm rải rác ở nhiều nơi.
    

## 2. Package by Feature

### Định nghĩa

Tổ chức code theo tính năng (user, product, order...). Mỗi package chứa tất cả các lớp liên quan đến một tính năng (controller, service, repository, model).

### Ví dụ

```
src/main/java
└── com.example.app
    ├── user
    │   ├── UserController.java
    │   ├── UserService.java
    │   ├── UserRepository.java
    │   └── model
    │       └── User.java
    ├── product
    │   ├── ProductController.java
    │   ├── ProductService.java
    │   ├── ProductRepository.java
    │   └── model
    │       └── Product.java
    ├── config
    │   └── SecurityConfig.java
    └── exception
        └── GlobalExceptionHandler.java
```

### Ưu điểm

- **Tính module hóa cao**: Mọi thứ liên quan đến một tính năng đều tập trung tại một chỗ.
    
- **Dễ bảo trì**: Thêm/xóa tính năng chỉ cần làm việc trong một package.
    
- **Phù hợp với Domain-Driven Design (DDD)** và các dự án lớn.
    

### Nhược điểm

- Có thể trùng lặp code nếu các tính năng dùng chung logic (cần tách thành module riêng như common).
    
- Khó tiếp cận với người quen làm việc theo layer.
    

## 3. Khi nào nên dùng?

|Package by Layer|Package by Feature|
|---|---|
|Dự án nhỏ, ít tính năng|Dự án lớn, nhiều tính năng|
|Team mới, chưa có kinh nghiệm|Team có kinh nghiệm, hướng tới kiến trúc module|
|Ưu tiên sự đơn giản|Ưu tiên khả năng mở rộng và bảo trì|

## 4. Lưu ý

- **Spring Boot Component Scanning**: Cả hai cách đều hoạt động tốt vì component scan mặc định quét toàn bộ package gốc và các package con.
    
- **Kết hợp cả hai**: Có thể kết hợp bằng cách nhóm các tính năng theo package con trong từng layer (ví dụ: `service.user`, `service.product`).
    

---

Hy vọng qua ví dụ trên, bạn đã hiểu rõ sự khác biệt giữa hai cách tổ chức code phổ biến này!