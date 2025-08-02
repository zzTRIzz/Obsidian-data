package com.example.learn.service;

import com.example.learn.config.JwtProvider;
import com.example.learn.dto.request.LoginRequest;
import com.example.learn.dto.request.RegisterRequest;
import com.example.learn.dto.response.AuthResponse;
import com.example.learn.dto.response.UserResponse;
import com.example.learn.model.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * Service xử lý Authentication và Authorization
 * 
 * Chức năng chính:
 * 1. Đăng ký user mới
 * 2. Đăng nhập và tạo JWT token
 * 3. Lấy thông tin user từ JWT token
 * 4. Xác thực và phân quyền
 */
@Service
public class AuthService {
    
    private final UserService userService;
    private final JwtProvider jwtProvider;
    
    public AuthService(UserService userService, JwtProvider jwtProvider) {
        this.userService = userService;
        this.jwtProvider = jwtProvider;
    }
    
    /**
     * Đăng ký user mới
     */
    public AuthResponse register(RegisterRequest request) {
        try {
            // Kiểm tra email đã tồn tại
            if (userService.existsByEmail(request.getEmail())) {
                throw new RuntimeException("Email đã được sử dụng: " + request.getEmail());
            }
            
            // Tạo user mới
            User user = userService.createUser(
                request.getEmail(),
                request.getPassword(),
                request.getFullName(),
                request.getRole()
            );
            
            // Tạo JWT token
            Authentication authentication = createAuthentication(user);
            String token = jwtProvider.generateToken(authentication);
            
            return new AuthResponse(token, user.getEmail(), user.getRole(), "Đăng ký thành công");
            
        } catch (Exception e) {
            throw new RuntimeException("Đăng ký thất bại: " + e.getMessage());
        }
    }
    
    /**
     * Đăng nhập
     */
    public AuthResponse login(LoginRequest request) {
        try {
            // Xác thực user
            if (!userService.authenticateUser(request.getEmail(), request.getPassword())) {
                throw new RuntimeException("Email hoặc mật khẩu không chính xác");
            }
            
            // Lấy thông tin user
            User user = userService.findByEmail(request.getEmail());
            if (user == null || !user.isActive()) {
                throw new RuntimeException("Tài khoản không tồn tại hoặc đã bị vô hiệu hóa");
            }
            
            // Tạo JWT token
            Authentication authentication = createAuthentication(user);
            String token = jwtProvider.generateToken(authentication);
            
            return new AuthResponse(token, user.getEmail(), user.getRole(), "Đăng nhập thành công");
            
        } catch (Exception e) {
            throw new RuntimeException("Đăng nhập thất bại: " + e.getMessage());
        }
    }
    
    /**
     * Lấy thông tin user từ JWT token
     */
    public UserResponse getUserProfile(String token) {
        try {
            String email = jwtProvider.getEmailFromJwtToken(token);
            User user = userService.findByEmail(email);
            
            if (user == null) {
                throw new RuntimeException("User không tồn tại");
            }
            
            return new UserResponse(
                user.getId(),
                user.getEmail(),
                user.getFullName(),
                user.getRole(),
                user.isActive()
            );
            
        } catch (Exception e) {
            throw new RuntimeException("Không thể lấy thông tin user: " + e.getMessage());
        }
    }
    
    /**
     * Lấy User object từ JWT token
     */
    public User getUserFromToken(String token) {
        String email = jwtProvider.getEmailFromJwtToken(token);
        User user = userService.findByEmail(email);
        
        if (user == null || !user.isActive()) {
            throw new RuntimeException("User không tồn tại hoặc đã bị vô hiệu hóa");
        }
        
        return user;
    }
    
    /**
     * Kiểm tra user có quyền admin không
     */
    public boolean isAdmin(String token) {
        try {
            User user = getUserFromToken(token);
            return "ADMIN".equals(user.getRole());
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * Kiểm tra token có hợp lệ không
     */
    public boolean isTokenValid(String token) {
        try {
            return jwtProvider.isTokenValid(token);
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * Tạo Authentication object từ User
     */
    private Authentication createAuthentication(User user) {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + user.getRole());
        return new UsernamePasswordAuthenticationToken(
            user.getEmail(), 
            null, 
            Collections.singletonList(authority)
        );
    }
}
