package com.example.learn.controller;

import com.example.learn.dto.response.ApiResponse;
import com.example.learn.dto.response.UserResponse;
import com.example.learn.model.User;
import com.example.learn.service.AuthService;
import com.example.learn.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller dành cho User thường
 * 
 * Tất cả endpoints đều yêu cầu authentication (JWT token hợp lệ)
 * 
 * Endpoints:
 * - GET /api/user/profile - Lấy thông tin profile
 * - PUT /api/user/change-password - Đổi mật khẩu
 * - GET /api/user/dashboard - Dashboard của user
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {
    
    private final UserService userService;
    private final AuthService authService;
    
    public UserController(UserService userService, AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }
    
    /**
     * Lấy thông tin profile của user hiện tại
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
     * Đổi mật khẩu
     */
    @PutMapping("/change-password")
    public ResponseEntity<ApiResponse<String>> changePassword(
            @RequestParam String oldPassword,
            @RequestParam String newPassword,
            @RequestHeader("Authorization") String token) {
        
        try {
            User user = authService.getUserFromToken(token);
            boolean success = userService.changePassword(user.getEmail(), oldPassword, newPassword);
            
            if (success) {
                return ResponseEntity.ok(ApiResponse.success("Đổi mật khẩu thành công", "OK"));
            } else {
                return ResponseEntity.badRequest()
                        .body(ApiResponse.error("Mật khẩu cũ không chính xác"));
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(ApiResponse.error("Lỗi khi đổi mật khẩu: " + e.getMessage()));
        }
    }
    
    /**
     * Dashboard của user
     */
    @GetMapping("/dashboard")
    public ResponseEntity<ApiResponse<Object>> getUserDashboard(@RequestHeader("Authorization") String token) {
        try {
            User user = authService.getUserFromToken(token);
            
            // Tạo dashboard info cho user
            var dashboard = new Object() {
                public final String email = user.getEmail();
                public final String fullName = user.getFullName();
                public final String role = user.getRole();
                public final boolean active = user.isActive();
                public final String welcomeMessage = "Xin chào " + user.getFullName() + "!";
                public final String accountInfo = "Bạn đang đăng nhập với quyền " + user.getRole();
            };
            
            return ResponseEntity.ok(ApiResponse.success("Lấy thông tin dashboard thành công", dashboard));
            
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(ApiResponse.error("Lỗi khi lấy dashboard: " + e.getMessage()));
        }
    }
    
    /**
     * Test endpoint cho user
     */
    @GetMapping("/test")
    public ResponseEntity<ApiResponse<String>> userTest(@RequestHeader("Authorization") String token) {
        try {
            User user = authService.getUserFromToken(token);
            return ResponseEntity.ok(ApiResponse.success(
                    "User endpoint hoạt động", 
                    "Xin chào " + user.getFullName() + " (" + user.getRole() + ")"
            ));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(ApiResponse.error("Lỗi: " + e.getMessage()));
        }
    }
}
