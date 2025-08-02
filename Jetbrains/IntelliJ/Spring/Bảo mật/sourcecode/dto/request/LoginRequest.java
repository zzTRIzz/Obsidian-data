package com.example.learn.dto.request;

import lombok.Data;

/**
 * DTO cho request đăng nhập
 * 
 * Chứa thông tin cần thiết để user đăng nhập:
 * - email: Email của user
 * - password: Mật khẩu (chưa mã hóa)
 */
@Data
public class LoginRequest {
    private String email;
    private String password;
    
    public LoginRequest() {}
    
    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
