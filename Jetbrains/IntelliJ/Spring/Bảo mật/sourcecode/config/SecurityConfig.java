package com.example.learn.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

/**
 * Cấu hình Spring Security chính
 * 
 * Các thành phần chính:
 * 1. SecurityFilterChain - Cấu hình bảo mật cho các endpoints
 * 2. CORS Configuration - Cấu hình Cross-Origin Resource Sharing
 * 3. Password Encoder - Mã hóa mật khẩu
 * 4. JWT Filter - Thêm filter xác thực JWT
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtProvider jwtProvider;

    /**
     * Cấu hình Security Filter Chain
     * Đây là cấu hình chính để xác định:
     * - Endpoints nào cần xác thực
     * - Endpoints nào được public
     * - Cách xử lý CORS
     * - Loại session management
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Cấu hình session management
            .sessionManagement(session -> 
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Không sử dụng session
            )
            
            // Cấu hình authorization rules
            .authorizeHttpRequests(auth -> auth
                // Public endpoints - không cần xác thực
                .requestMatchers("/api/auth/**").permitAll()           // Authentication endpoints
                .requestMatchers("/api/public/**").permitAll()         // Public API
                .requestMatchers("/api/health").permitAll()            // Health check
                .requestMatchers("/swagger-ui/**").permitAll()         // Swagger UI
                .requestMatchers("/v3/api-docs/**").permitAll()        // API docs
                .requestMatchers("/").permitAll()                      // Root path
                
                // Admin endpoints - chỉ admin mới truy cập được
                .requestMatchers("/api/admin/**").hasRole("ADMIN")
                
                // User endpoints - cần xác thực
                .requestMatchers("/api/user/**").authenticated()
                
                // Tất cả các request khác đều cần xác thực
                .anyRequest().authenticated()
            )
            
            // Thêm JWT filter trước BasicAuthenticationFilter
            .addFilterBefore(new JwtTokenValidator(jwtProvider), BasicAuthenticationFilter.class)
            
            // Tắt CSRF vì sử dụng JWT
            .csrf(csrf -> csrf.disable())
            
            // Cấu hình CORS
            .cors(cors -> cors.configurationSource(corsConfigurationSource()));

        return http.build();
    }

    /**
     * Cấu hình CORS (Cross-Origin Resource Sharing)
     * Cho phép frontend từ domain khác truy cập API
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        
        // Cho phép các origin này truy cập API
        configuration.setAllowedOrigins(Arrays.asList(
            "http://localhost:3000",    // React development server
            "http://localhost:5173",    // Vite development server
            "http://localhost:8080"     // Local development
        ));
        
        // Cho phép tất cả HTTP methods
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        
        // Cho phép tất cả headers
        configuration.setAllowedHeaders(List.of("*"));
        
        // Cho phép gửi credentials (cookies, authorization headers)
        configuration.setAllowCredentials(true);
        
        // Cho phép client đọc các headers này từ response
        configuration.setExposedHeaders(Arrays.asList("Authorization", "Content-Type"));
        
        // Cache CORS preflight response trong 1 giờ
        configuration.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        
        return source;
    }

    /**
     * Bean để mã hóa mật khẩu
     * BCryptPasswordEncoder là thuật toán mã hóa an toàn
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
