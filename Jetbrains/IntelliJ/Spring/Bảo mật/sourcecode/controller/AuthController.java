package com.example.learn.controller;

import com.example.learn.dto.request.LoginRequest;
import com.example.learn.dto.request.RegisterRequest;
import com.example.learn.dto.response.ApiResponse;
import com.example.learn.dto.response.AuthResponse;
import com.example.learn.dto.response.UserResponse;
import com.example.learn.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller xử lý Authentication
 * 
 * Endpoints:
 * - POST /api/auth/register - Đăng ký tài khoản mới
 * - POST /api/auth/login - Đăng nhập
 * - GET /api/auth/profile - Lấy thông tin profile (cần JWT token)
 * - GET /api/auth/validate - Kiểm tra token có hợp lệ không
 */
@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    
    private final AuthService authService;
    
    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    
    /**
     * Đăng ký tài khoản mới
     * 
     * Body: {
     *   "email": "user@example.com",
     *   "password": "password123",
     *   "fullName": "Full Name",
     *   "role": "USER" (optional, default: USER)
     * }
     */
    @PostMapping("/register")
    public ResponseEntity<ApiResponse<AuthResponse>> register(@RequestBody RegisterRequest request) {
        try {
            AuthResponse authResponse = authService.register(request);
            return ResponseEntity.ok(ApiResponse.success("Đăng ký thành công", authResponse));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(ApiResponse.error("Đăng ký thất bại: " + e.getMessage()));
        }
    }
    
    /**
     * Đăng nhập
     * 
     * Body: {
     *   "email": "user@example.com",
     *   "password": "password123"
     * }
     */
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<AuthResponse>> login(@RequestBody LoginRequest request) {
        try {
            AuthResponse authResponse = authService.login(request);
            return ResponseEntity.ok(ApiResponse.success("Đăng nhập thành công", authResponse));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(ApiResponse.error("Đăng nhập thất bại: " + e.getMessage()));
        }
    }
    
    /**
     * Lấy thông tin profile của user hiện tại
     * Header: Authorization: Bearer <JWT_TOKEN>
     */
    @GetMapping("/profile")
    public ResponseEntity<ApiResponse<UserResponse>> getProfile(@RequestHeader("Authorization") String token) {
        try {
            UserResponse userResponse = authService.getUserProfile(token);
            return ResponseEntity.ok(ApiResponse.success("Lấy thông tin profile thành công", userResponse));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(ApiResponse.error("Không thể lấy thông tin profile: " + e.getMessage()));
        }
    }
    
    /**
     * Kiểm tra token có hợp lệ không
     * Header: Authorization: Bearer <JWT_TOKEN>
     */
    @GetMapping("/validate")
    public ResponseEntity<ApiResponse<Boolean>> validateToken(@RequestHeader("Authorization") String token) {
        try {
            boolean valid = authService.isTokenValid(token);
            String message = valid ? "Token hợp lệ" : "Token không hợp lệ";
            return ResponseEntity.ok(ApiResponse.success(message, valid));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(ApiResponse.error("Lỗi kiểm tra token: " + e.getMessage(), false));
        }
    }
    
    /**
     * Test endpoint - không cần authentication
     */
    @GetMapping("/test")
    public ResponseEntity<ApiResponse<String>> test() {
        return ResponseEntity.ok(ApiResponse.success("Auth controller đang hoạt động", "OK"));
    }
}
