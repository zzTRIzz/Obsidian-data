package com.example.learn.config;

/**
 * Lớp chứa các hằng số JWT
 * - SECRET_KEY: Khóa bí mật để ký và xác thực JWT token
 * - JWT_HEADER: Tên header chứa JWT token trong HTTP request
 * - TOKEN_PREFIX: Tiền tố của token (Bearer )
 * - EXPIRATION_TIME: Thời gian hết hạn token (7 ngày)
 */
public class JwtConstants {
    // Khóa bí mật để ký JWT (trong thực tế nên lưu trong biến môi trường)
    public static final String SECRET_KEY = "MySecretKeyForLearningJWT2024SpringSecurityExample";
    
    // Tên header chứa JWT token
    public static final String JWT_HEADER = "Authorization";
    
    // Tiền tố của token
    public static final String TOKEN_PREFIX = "Bearer ";
    
    // Thời gian hết hạn token (7 ngày tính bằng milliseconds)
    public static final long EXPIRATION_TIME = 604800000; // 7 * 24 * 60 * 60 * 1000
}
