package com.example.learn.controller;

import com.example.learn.dto.response.ApiResponse;
import com.example.learn.dto.response.UserResponse;
import com.example.learn.model.User;
import com.example.learn.service.AuthService;
import com.example.learn.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller dành cho Admin
 * 
 * Tất cả endpoints trong controller này đều yêu cầu quyền ADMIN
 * 
 * Endpoints:
 * - GET /api/admin/users - Lấy danh sách tất cả users
 * - PUT /api/admin/users/{email}/status - Cập nhật trạng thái user
 * - GET /api/admin/dashboard - Dashboard thống kê
 */
@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class AdminController {
    
    private final UserService userService;
    private final AuthService authService;
    
    public AdminController(UserService userService, AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }
    
    /**
     * Lấy danh sách tất cả users
     * Chỉ admin mới được truy cập
     */
    @GetMapping("/users")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<List<UserResponse>>> getAllUsers(@RequestHeader("Authorization") String token) {
        try {
            // Kiểm tra quyền admin
            if (!authService.isAdmin(token)) {
                return ResponseEntity.status(403)
                        .body(ApiResponse.error("Không có quyền truy cập"));
            }
            
            List<User> users = userService.getAllUsers();
            List<UserResponse> userResponses = users.stream()
                    .map(user -> new UserResponse(
                            user.getId(),
                            user.getEmail(),
                            user.getFullName(),
                            user.getRole(),
                            user.isActive()
                    ))
                    .collect(Collectors.toList());
            
            return ResponseEntity.ok(ApiResponse.success("Lấy danh sách users thành công", userResponses));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(ApiResponse.error("Lỗi khi lấy danh sách users: " + e.getMessage()));
        }
    }
    
    /**
     * Cập nhật trạng thái user (active/inactive)
     */
    @PutMapping("/users/{email}/status")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<UserResponse>> updateUserStatus(
            @PathVariable String email,
            @RequestParam boolean active,
            @RequestHeader("Authorization") String token) {
        
        try {
            // Kiểm tra quyền admin
            if (!authService.isAdmin(token)) {
                return ResponseEntity.status(403)
                        .body(ApiResponse.error("Không có quyền truy cập"));
            }
            
            User updatedUser = userService.updateUserStatus(email, active);
            if (updatedUser == null) {
                return ResponseEntity.notFound().build();
            }
            
            UserResponse userResponse = new UserResponse(
                    updatedUser.getId(),
                    updatedUser.getEmail(),
                    updatedUser.getFullName(),
                    updatedUser.getRole(),
                    updatedUser.isActive()
            );
            
            String message = active ? "Kích hoạt user thành công" : "Vô hiệu hóa user thành công";
            return ResponseEntity.ok(ApiResponse.success(message, userResponse));
            
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(ApiResponse.error("Lỗi khi cập nhật trạng thái user: " + e.getMessage()));
        }
    }
    
    /**
     * Dashboard thống kê cho admin
     */
    @GetMapping("/dashboard")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<Object>> getDashboard(@RequestHeader("Authorization") String token) {
        try {
            // Kiểm tra quyền admin
            if (!authService.isAdmin(token)) {
                return ResponseEntity.status(403)
                        .body(ApiResponse.error("Không có quyền truy cập"));
            }
            
            List<User> allUsers = userService.getAllUsers();
            
            // Tạo thống kê
            long totalUsers = allUsers.size();
            long activeUsers = allUsers.stream().filter(User::isActive).count();
            long adminUsers = allUsers.stream().filter(user -> "ADMIN".equals(user.getRole())).count();
            long regularUsers = allUsers.stream().filter(user -> "USER".equals(user.getRole())).count();
            
            // Tạo object thống kê
            var dashboard = new Object() {
                public final long totalUsers = totalUsers;
                public final long activeUsers = activeUsers;
                public final long inactiveUsers = totalUsers - activeUsers;
                public final long adminUsers = adminUsers;
                public final long regularUsers = regularUsers;
            };
            
            return ResponseEntity.ok(ApiResponse.success("Lấy thống kê dashboard thành công", dashboard));
            
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(ApiResponse.error("Lỗi khi lấy thống kê dashboard: " + e.getMessage()));
        }
    }
    
    /**
     * Test endpoint cho admin
     */
    @GetMapping("/test")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<String>> adminTest(@RequestHeader("Authorization") String token) {
        try {
            User admin = authService.getUserFromToken(token);
            return ResponseEntity.ok(ApiResponse.success(
                    "Admin endpoint hoạt động", 
                    "Xin chào " + admin.getFullName() + " (Admin)"
            ));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(ApiResponse.error("Lỗi: " + e.getMessage()));
        }
    }
}
