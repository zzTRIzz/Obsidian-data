package com.example.learn.service;

import com.example.learn.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Service quản lý User
 * 
 * Trong thực tế sẽ sử dụng JPA Repository để tương tác với database
 * Ở đây sử dụng HashMap để lưu trữ trong memory cho mục đích học
 */
@Service
public class UserService {
    
    // Simulate database với HashMap
    private final Map<String, User> users = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);
    
    private final PasswordEncoder passwordEncoder;
    
    public UserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        initSampleData();
    }
    
    /**
     * Khởi tạo dữ liệu mẫu
     */
    private void initSampleData() {
        // Tạo admin user
        User admin = new User();
        admin.setId(idGenerator.getAndIncrement());
        admin.setEmail("admin@example.com");
        admin.setPassword(passwordEncoder.encode("admin123"));
        admin.setFullName("System Administrator");
        admin.setRole("ADMIN");
        admin.setActive(true);
        users.put(admin.getEmail(), admin);
        
        // Tạo user thường
        User user = new User();
        user.setId(idGenerator.getAndIncrement());
        user.setEmail("user@example.com");
        user.setPassword(passwordEncoder.encode("user123"));
        user.setFullName("Regular User");
        user.setRole("USER");
        user.setActive(true);
        users.put(user.getEmail(), user);
        
        System.out.println("Initialized sample data:");
        System.out.println("Admin: admin@example.com / admin123");
        System.out.println("User: user@example.com / user123");
    }
    
    /**
     * Tìm user theo email
     */
    public User findByEmail(String email) {
        return users.get(email);
    }
    
    /**
     * Kiểm tra email đã tồn tại chưa
     */
    public boolean existsByEmail(String email) {
        return users.containsKey(email);
    }
    
    /**
     * Tạo user mới
     */
    public User createUser(String email, String password, String fullName, String role) {
        if (existsByEmail(email)) {
            throw new RuntimeException("Email đã tồn tại: " + email);
        }
        
        User user = new User();
        user.setId(idGenerator.getAndIncrement());
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setFullName(fullName);
        user.setRole(role != null ? role : "USER");
        user.setActive(true);
        
        users.put(email, user);
        return user;
    }
    
    /**
     * Xác thực user
     */
    public boolean authenticateUser(String email, String password) {
        User user = findByEmail(email);
        if (user == null || !user.isActive()) {
            return false;
        }
        
        return passwordEncoder.matches(password, user.getPassword());
    }
    
    /**
     * Lấy danh sách tất cả users (chỉ admin)
     */
    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }
    
    /**
     * Cập nhật trạng thái active của user
     */
    public User updateUserStatus(String email, boolean active) {
        User user = findByEmail(email);
        if (user != null) {
            user.setActive(active);
        }
        return user;
    }
    
    /**
     * Đổi mật khẩu
     */
    public boolean changePassword(String email, String oldPassword, String newPassword) {
        User user = findByEmail(email);
        if (user == null) {
            return false;
        }
        
        if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
            return false;
        }
        
        user.setPassword(passwordEncoder.encode(newPassword));
        return true;
    }
}
