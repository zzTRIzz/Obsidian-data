# Hướng dẫn sử dụng Spring Security JWT Learning App

## 📋 Mục tiêu học tập

Dự án này giúp bạn hiểu và thực hành:
- **Spring Security 6  Configuration**
- **JWT Token Authentication** 
- **Role-based Authorization**
- **Password Encoding với BCrypt**
- **CORS Configuration**
- **RESTful API Security**

## 🏗️ Cấu trúc dự án

```
src ne/
├── config/
│   ├── JwtConstants.java        # Hằng số JWT
│   ├── JwtProvider.java         # Tạo và xác thực JWT
│   ├── JwtTokenValidator.java   # Filter xác thực JWT
│   └── SecurityConfig.java      # Cấu hình Spring Security
├── controller/
│   ├── AuthController.java      # Authentication endpoints
│   ├── AdminController.java     # Admin endpoints
│   ├── UserController.java      # User endpoints
│   └── PublicController.java    # Public endpoints
├── dto/
│   ├── request/
│   │   ├── LoginRequest.java
│   │   └── RegisterRequest.java
│   └── response/
│       ├── ApiResponse.java
│       ├── AuthResponse.java
│       └── UserResponse.java
├── model/
│   └── User.java               # User model
├── service/
│   ├── AuthService.java        # Authentication service
│   └── UserService.java        # User management service
└── LearningApplication.java    # Main application
```

## 🚀 Cách chạy ứng dụng

### Bước 1: Copy code vào project chính
```bash
# Copy tất cả files từ "src ne" vào:
src/main/java/com/example/learn/
```

### Bước 2: Đảm bảo dependencies trong pom.xml
```xml
<!-- Spring Boot Starter Web -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<!-- Spring Boot Starter Security -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>

<!-- JWT -->
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-api</artifactId>
    <version>0.11.2</version>
</dependency>
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-impl</artifactId>
    <version>0.11.2</version>
    <scope>runtime</scope>
</dependency>
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-jackson</artifactId>
    <version>0.11.2</version>
    <scope>runtime</scope>
</dependency>

<!-- Lombok -->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <optional>true</optional>
</dependency>
```

### Bước 3: Chạy ứng dụng
```bash
mvn spring-boot:run
# hoặc
./mvnw spring-boot:run
```

## 🧪 Test API với Postman/curl

### 1. Đăng nhập (Login)
```bash
POST http://localhost:8080/api/auth/login
Content-Type: application/json

{
  "email": "admin@example.com",
  "password": "admin123"
}
```

**Response:**
```json
{
  "success": true,
  "message": "Đăng nhập thành công",
  "data": {
    "token": "eyJhbGciOiJIUzI1NiJ9...",
    "type": "Bearer",
    "email": "admin@example.com",
    "role": "ADMIN"
  }
}
```

### 2. Truy cập protected endpoint
```bash
GET http://localhost:8080/api/user/profile
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9...
```

### 3. Admin endpoint
```bash
GET http://localhost:8080/api/admin/users
Authorization: Bearer <ADMIN_TOKEN>
```

### 4. Đăng ký user mới
```bash
POST http://localhost:8080/api/auth/register
Content-Type: application/json

{
  "email": "newuser@example.com",
  "password": "password123",
  "fullName": "New User",
  "role": "USER"
}
```

## 🔐 Tài khoản mẫu

| Email | Password | Role |
|-------|----------|------|
| admin@example.com | admin123 | ADMIN |
| user@example.com | user123 | USER |

## 📚 Kiến thức học được

### 1. JWT (JSON Web Token)
- Cấu trúc: Header.Payload.Signature
- Tạo token khi đăng nhập thành công
- Gửi token trong header `Authorization: Bearer <token>`
- Xác thực token cho mỗi request

### 2. Spring Security Configuration
```java
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
        return http
            .sessionManagement(session -> 
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/**").permitAll()
                .requestMatchers("/api/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated())
            .addFilterBefore(new JwtTokenValidator(), BasicAuthenticationFilter.class)
            .build();
    }
}
```

### 3. JWT Filter
```java
public class JwtTokenValidator extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, 
                                  HttpServletResponse response, 
                                  FilterChain filterChain) {
        // 1. Lấy JWT từ header
        // 2. Xác thực token
        // 3. Set Authentication vào SecurityContext
        // 4. Tiếp tục filter chain
    }
}
```

### 4. Password Encoding
```java
@Bean
public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}

// Sử dụng
String encodedPassword = passwordEncoder.encode("plainPassword");
boolean matches = passwordEncoder.matches("plainPassword", encodedPassword);
```

### 5. Role-based Authorization
```java
// Trong controller
@PreAuthorize("hasRole('ADMIN')")
@GetMapping("/admin/users")
public ResponseEntity<?> getUsers() { ... }

// Hoặc trong SecurityConfig
.requestMatchers("/api/admin/**").hasRole("ADMIN")
```

## 🎯 Các endpoint chính

### Public Endpoints (không cần JWT)
- `GET /` - Welcome message
- `GET /api/public/health` - Health check
- `GET /api/public/info` - App info
- `POST /api/auth/register` - Đăng ký
- `POST /api/auth/login` - Đăng nhập

### Authenticated Endpoints (cần JWT)
- `GET /api/auth/profile` - Profile user
- `GET /api/auth/validate` - Validate token
- `GET /api/user/profile` - User profile
- `PUT /api/user/change-password` - Đổi mật khẩu
- `GET /api/user/dashboard` - User dashboard

### Admin Only Endpoints (cần JWT + role ADMIN)
- `GET /api/admin/users` - Danh sách users
- `PUT /api/admin/users/{email}/status` - Cập nhật trạng thái user
- `GET /api/admin/dashboard` - Admin dashboard

## 🔧 Customization

### Thay đổi thời gian hết hạn token
```java
// Trong JwtConstants.java
public static final long EXPIRATION_TIME = 604800000; // 7 ngày
```

### Thêm role mới
```java
// Trong UserService.java
User user = new User();
user.setRole("MANAGER"); // Role mới

// Trong SecurityConfig.java
.requestMatchers("/api/manager/**").hasRole("MANAGER")
```

### Thêm claims vào JWT
```java
// Trong JwtProvider.java
return Jwts.builder()
    .claim("email", auth.getName())
    .claim("role", roles)
    .claim("customField", "customValue") // Thêm claim mới
    .signWith(key)
    .compact();
```

## 🚨 Lưu ý quan trọng

1. **Secret Key**: Trong production, lưu SECRET_KEY trong environment variables
2. **HTTPS**: Luôn sử dụng HTTPS trong production
3. **Token Storage**: Lưu JWT token an toàn ở client (HttpOnly cookies)
4. **Token Refresh**: Implement refresh token mechanism
5. **Rate Limiting**: Thêm rate limiting cho login endpoints

## 📖 Tài liệu tham khảo

- [Spring Security Documentation](https://docs.spring.io/spring-security/reference/)
- [JWT.io](https://jwt.io/)
- [Spring Boot Security](https://spring.io/guides/gs/securing-web/)
- [BCrypt](https://en.wikipedia.org/wiki/Bcrypt)
