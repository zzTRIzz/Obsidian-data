package com.example.learn.dto.request;

import lombok.Data;

/**
 * DTO cho request đăng ký tài khoản mới
 * 
 * Chứa thông tin cần thiết để tạo user mới:
 * - email: Email của user (unique)
 * - password: Mật khẩu (sẽ được mã hóa)
 * - fullName: Họ tên đầy đủ
 * - role: Vai trò (mặc định là USER)
 */
@Data
public class RegisterRequest {
    private String email;
    private String password;
    private String fullName;
    private String role = "USER"; // Mặc định là USER
    
    public RegisterRequest() {}
    
    public RegisterRequest(String email, String password, String fullName) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
    }
    
    public RegisterRequest(String email, String password, String fullName, String role) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.role = role;
    }
}
