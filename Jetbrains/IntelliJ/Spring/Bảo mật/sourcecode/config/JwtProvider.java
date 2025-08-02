package com.example.learn.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

/**
 * Service để tạo và xác thực JWT token
 * 
 * Chức năng chính:
 * 1. Tạo JWT token từ thông tin Authentication
 * 2. Trích xuất email từ JWT token
 * 3. Trích xuất roles từ JWT token
 * 4. Xác thực tính hợp lệ của token
 */
@Service
public class JwtProvider {
    
    // Tạo khóa bí mật từ SECRET_KEY
    private final SecretKey key = Keys.hmacShaKeyFor(JwtConstants.SECRET_KEY.getBytes());

    /**
     * Tạo JWT token từ thông tin xác thực
     * @param auth - Thông tin xác thực của user
     * @return JWT token string
     */
    public String generateToken(Authentication auth) {
        // Lấy danh sách quyền của user
        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
        String roles = populateAuthorities(authorities);
        
        return Jwts.builder()
                .setIssuedAt(new Date()) // Thời gian tạo token
                .setExpiration(new Date(new Date().getTime() + JwtConstants.EXPIRATION_TIME)) // Thời gian hết hạn
                .claim("email", auth.getName()) // Thêm email vào payload
                .claim("authorities", roles) // Thêm quyền vào payload
                .signWith(key) // Ký token bằng khóa bí mật
                .compact(); // Tạo string token
    }

    /**
     * Trích xuất email từ JWT token
     * @param jwt - JWT token (có hoặc không có prefix "Bearer ")
     * @return email của user
     */
    public String getEmailFromJwtToken(String jwt) {
        try {
            // Loại bỏ prefix "Bearer " nếu có
            if (jwt.startsWith(JwtConstants.TOKEN_PREFIX)) {
                jwt = jwt.substring(7);
            }
            
            // Parse token và lấy claims
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(jwt)
                    .getBody();
            
            return String.valueOf(claims.get("email"));
        } catch (JwtException e) {
            throw new RuntimeException("Token JWT không hợp lệ hoặc đã hết hạn");
        }
    }

    /**
     * Trích xuất authorities từ JWT token
     * @param jwt - JWT token
     * @return chuỗi authorities
     */
    public String getAuthoritiesFromJwtToken(String jwt) {
        try {
            if (jwt.startsWith(JwtConstants.TOKEN_PREFIX)) {
                jwt = jwt.substring(7);
            }
            
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(jwt)
                    .getBody();
            
            return String.valueOf(claims.get("authorities"));
        } catch (JwtException e) {
            throw new RuntimeException("Token JWT không hợp lệ hoặc đã hết hạn");
        }
    }

    /**
     * Kiểm tra token có hợp lệ không
     * @param jwt - JWT token
     * @return true nếu hợp lệ, false nếu không
     */
    public boolean isTokenValid(String jwt) {
        try {
            if (jwt.startsWith(JwtConstants.TOKEN_PREFIX)) {
                jwt = jwt.substring(7);
            }
            
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(jwt);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }

    /**
     * Chuyển đổi Collection authorities thành chuỗi
     * @param authorities - Danh sách quyền
     * @return chuỗi quyền ngăn cách bởi dấu phẩy
     */
    private String populateAuthorities(Collection<? extends GrantedAuthority> authorities) {
        return authorities.stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
    }
}
