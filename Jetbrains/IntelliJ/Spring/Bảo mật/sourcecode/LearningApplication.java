package com.example.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

/**
 * Main Application Class
 * 
 * Để chạy ứng dụng này, bạn cần:
 * 1. Copy tất cả files trong folder này vào src/main/java/com/example/learn/
 * 2. Thêm các dependencies cần thiết vào pom.xml
 * 3. Chạy ứng dụng
 * 
 * Note: Đây là version đơn giản để học Spring Security và JWT
 */
@SpringBootApplication
public class LearningApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearningApplication.class, args);
    }
    
    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("🚀 SPRING SECURITY JWT LEARNING APP STARTED! 🚀");
        System.out.println("=".repeat(60));
        System.out.println("📚 Học Spring Security với JWT");
        System.out.println("🌐 Server: http://localhost:8080");
        System.out.println("📖 API Info: http://localhost:8080/api/public/info");
        System.out.println("=".repeat(60));
        System.out.println("👤 Sample Accounts:");
        System.out.println("   Admin: admin@example.com / admin123");
        System.out.println("   User:  user@example.com / user123");
        System.out.println("=".repeat(60));
        System.out.println("🔧 Test với Postman hoặc curl:");
        System.out.println("   POST /api/auth/login");
        System.out.println("   GET  /api/user/profile (with JWT token)");
        System.out.println("   GET  /api/admin/users (admin only)");
        System.out.println("=".repeat(60) + "\n");
    }
}
