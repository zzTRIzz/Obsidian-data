package com.example.learn.dto.response;

import lombok.Data;

/**
 * DTO cho response của các API liên quan đến authentication
 * 
 * Chứa thông tin trả về sau khi đăng nhập/đăng ký thành công:
 * - token: JWT token để sử dụng cho các request tiếp theo
 * - type: Loại token (thường là "Bearer")
 * - email: Email của user
 * - role: Vai trò của user
 * - message: Thông báo kết quả
 */
@Data
public class AuthResponse {
    private String token;
    private String type = "Bearer";
    private String email;
    private String role;
    private String message;
    
    public AuthResponse() {}
    
    public AuthResponse(String token, String email, String role, String message) {
        this.token = token;
        this.email = email;
        this.role = role;
        this.message = message;
    }
    
    public AuthResponse(String token, String email, String role) {
        this.token = token;
        this.email = email;
        this.role = role;
        this.message = "Authentication successful";
    }
}
