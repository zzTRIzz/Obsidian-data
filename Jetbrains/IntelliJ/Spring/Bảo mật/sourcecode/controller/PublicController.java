package com.example.learn.controller;

import com.example.learn.dto.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller cho các public endpoints
 * 
 * Các endpoints này không yêu cầu authentication
 * 
 * Endpoints:
 * - GET /api/public/health - Health check
 * - GET /api/public/info - Thông tin ứng dụng
 * - GET / - Welcome message
 */
@RestController
@RequestMapping("/api/public")
@CrossOrigin(origins = "*")
public class PublicController {
    
    /**
     * Health check endpoint
     */
    @GetMapping("/health")
    public ResponseEntity<ApiResponse<String>> health() {
        return ResponseEntity.ok(ApiResponse.success("Ứng dụng đang hoạt động", "OK"));
    }
    
    /**
     * Thông tin ứng dụng
     */
    @GetMapping("/info")
    public ResponseEntity<ApiResponse<Object>> info() {
        var appInfo = new Object() {
            public final String name = "Spring Security JWT Learning App";
            public final String version = "1.0.0";
            public final String description = "Ứng dụng học Spring Security với JWT";
            public final String[] features = {
                "JWT Authentication",
                "Role-based Authorization", 
                "Password Encoding",
                "CORS Configuration",
                "RESTful API"
            };
            public final Object endpoints = new Object() {
                public final String[] publicEndpoints = {
                    "GET /api/public/health",
                    "GET /api/public/info",
                    "POST /api/auth/register",
                    "POST /api/auth/login"
                };
                public final String[] authenticatedEndpoints = {
                    "GET /api/auth/profile",
                    "GET /api/user/profile",
                    "PUT /api/user/change-password",
                    "GET /api/user/dashboard"
                };
                public final String[] adminEndpoints = {
                    "GET /api/admin/users",
                    "PUT /api/admin/users/{email}/status",
                    "GET /api/admin/dashboard"
                };
            };
            public final Object sampleAccounts = new Object() {
                public final String admin = "admin@example.com / admin123";
                public final String user = "user@example.com / user123";
            };
        };
        
        return ResponseEntity.ok(ApiResponse.success("Thông tin ứng dụng", appInfo));
    }
}

/**
 * Root controller để xử lý request tới root path
 */
@RestController
@CrossOrigin(origins = "*")
class RootController {
    
    @GetMapping("/")
    public ResponseEntity<ApiResponse<String>> welcome() {
        return ResponseEntity.ok(ApiResponse.success(
            "Chào mừng đến với Spring Security JWT Learning App", 
            "Truy cập /api/public/info để xem thông tin chi tiết"
        ));
    }
}
