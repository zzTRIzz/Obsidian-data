<br>

## 1. Mô hình API

### REST

- Tiêu chuẩn phổ biến, dựa trên kiến trúc client-server không trạng thái.
    
- Sử dụng phương thức HTTP (`GET`, `POST`, `PUT`, `DELETE`) để thao tác tài nguyên.
    
- Đơn giản, dễ mở rộng.
    

### GraphQL

- Cho phép client chỉ định chính xác dữ liệu cần lấy.
    
- Tránh truyền dữ liệu thừa, tối ưu hóa hiệu suất.
    

### gRPC

- Sử dụng **Protocol Buffers** để tối ưu hiệu suất.
    
- Hỗ trợ truyền phát hai chiều (bi-directional streaming).
    
- Phù hợp cho hệ thống microservices.
    

---

## 2. Ánh xạ CRUD sang REST

```bash
# CREATE (POST): Thêm tài nguyên mới
POST /products

# READ (GET): Lấy thông tin
GET /products
GET /products/123

# UPDATE (PUT/PATCH): Sửa tài nguyên
PUT /products/123  # Cập nhật toàn bộ
PATCH /products/123  # Cập nhật một phần

# DELETE (DELETE): Xóa tài nguyên
DELETE /products/123
```

---

## 3. Tính nhất quán và độ tin cậy

- **Cấu trúc phản hồi**: Đảm bảo **DTO (Data Transfer Object)** nhất quán giữa các endpoint.
    
- **Xử lý lỗi**:
    
    - Phản hồi lỗi thống nhất (`400` cho lỗi client, `500` cho lỗi server).
        
    - Trả về thông tin chi tiết trong body.
        

---

## 4. Tối ưu hóa API

### Phiên bản (Versioning)

- **Quản lý qua URL**: `/v1/products`
    
- **Quản lý qua tiêu đề**: `Accept: application/vnd.api+json; version=1`
    

### Phân trang, lọc, sắp xếp

```bash
GET /products?page=2&limit=10&sort=price
```

### Caching

- **Client-side caching**
    
- **CDN caching**
    
- **Server-side caching** (Redis, Memcached)
    

---

## 5. Bảo mật

### Xác thực & Ủy quyền

- **Sử dụng JWT (JSON Web Token)** để quản lý phiên đăng nhập.
    
- **Lưu ý:**
    
    - Đặt thời hạn cho token.
        
    - Không lưu thông tin nhạy cảm trong token.
        
    - Luôn dùng **HTTPS** để mã hóa dữ liệu.
        

### Rate Limiting

- Giới hạn số request/client để tránh lạm dụng.
    
- **Ví dụ:** thuật toán **Token Bucket**.
    

---

## 6. Hiệu suất

### Giới hạn tốc độ (Rate Limiting)

- Ngăn chặn tấn công **DDoS** hoặc quá tải server.
    

### Tối ưu truy vấn

- **Tránh trả về dữ liệu thừa**.
    
- **Sử dụng phân trang** cho tập dữ liệu lớn.
    

---

## 7. Tài liệu hóa

### OpenAPI

- **Chuẩn công nghiệp** để mô tả endpoint, tham số, phản hồi, và xử lý lỗi.
    
- Giúp **API dễ hiểu, dễ tích hợp**.
    

---

## 8. Ví dụ minh họa (Nền tảng thương mại điện tử)

```bash
# Thêm sản phẩm
POST /products  # Trả về mã 201 và ID sản phẩm

# Lấy danh sách sản phẩm
GET /products?category=electronics&page=1

# Xóa sản phẩm
DELETE /products/123  # Trả về mã 204
```

---

## 9. Kết luận

- Thiết kế API tốt đòi hỏi **sự nhất quán, bảo mật, hiệu suất và tài liệu rõ ràng**.
    
- **REST** vẫn là lựa chọn hàng đầu nhờ **tính đơn giản và khả năng mở rộng**.
    
- **Kết hợp các công cụ như OpenAPI và JWT** giúp tối ưu quá trình phát triển và vận hành.