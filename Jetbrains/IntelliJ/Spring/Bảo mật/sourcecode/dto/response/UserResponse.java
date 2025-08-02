package com.example.learn.dto.response;

import lombok.Data;

/**
 * DTO cho thông tin user (không bao gồm password)
 * 
 * Sử dụng để trả về thông tin user trong các API
 * Không bao gồm password vì lý do bảo mật
 */
@Data
public class UserResponse {
    private Long id;
    private String email;
    private String fullName;
    private String role;
    private boolean active;
    
    public UserResponse() {}
    
    public UserResponse(Long id, String email, String fullName, String role, boolean active) {
        this.id = id;
        this.email = email;
        this.fullName = fullName;
        this.role = role;
        this.active = active;
    }
}
