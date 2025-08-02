package com.example.learn.model;

import lombok.Data;

/**
 * Entity đại diện cho User trong hệ thống
 * 
 * Trong thực tế, đây sẽ là JPA Entity để lưu vào database
 * Ở đây đơn giản hóa để học về JWT và Spring Security
 */
@Data
public class User {
    private Long id;
    private String email;
    private String password; // Đã được mã hóa bằng BCrypt
    private String fullName;
    private String role; // ADMIN, USER, MANAGER, etc.
    private boolean active = true;
    
    public User() {}
    
    public User(String email, String password, String fullName, String role) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.role = role;
    }
    
    /**
     * Kiểm tra user có role cụ thể không
     */
    public boolean hasRole(String role) {
        return this.role != null && this.role.equals(role);
    }
    
    /**
     * Kiểm tra user có active không
     */
    public boolean isActive() {
        return this.active;
    }
}
