package com.example.learn.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * JWT Token Validation Filter
 * 
 * Filter này chạy cho mỗi HTTP request để:
 * 1. Kiểm tra xem request có chứa JWT token không
 * 2. Xác thực token có hợp lệ không
 * 3. Nếu hợp lệ, set thông tin authentication vào SecurityContext
 * 4. Nếu không hợp lệ, trả về lỗi 401 Unauthorized
 * 
 * OncePerRequestFilter đảm bảo filter chỉ chạy 1 lần cho mỗi request
 */
@Slf4j
public class JwtTokenValidator extends OncePerRequestFilter {

    private final JwtProvider jwtProvider;

    public JwtTokenValidator(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, 
                                  HttpServletResponse response, 
                                  FilterChain filterChain) throws ServletException, IOException {
        
        // Lấy JWT token từ header Authorization
        String jwt = request.getHeader(JwtConstants.JWT_HEADER);
        
        log.debug("Processing request to: {}", request.getRequestURI());
        log.debug("JWT token present: {}", jwt != null);

        // Kiểm tra xem có JWT token không và có đúng format không
        if (jwt == null || !jwt.startsWith(JwtConstants.TOKEN_PREFIX)) {
            log.debug("No valid JWT token found, continuing with filter chain");
            filterChain.doFilter(request, response);
            return;
        }

        try {
            // Xác thực token
            if (!jwtProvider.isTokenValid(jwt)) {
                log.warn("Invalid JWT token");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("Token JWT không hợp lệ");
                return;
            }

            // Trích xuất thông tin từ token
            String email = jwtProvider.getEmailFromJwtToken(jwt);
            String authorities = jwtProvider.getAuthoritiesFromJwtToken(jwt);
            
            log.debug("JWT valid for user: {} with authorities: {}", email, authorities);

            // Tạo Authentication object
            Authentication authentication = new UsernamePasswordAuthenticationToken(
                email, 
                null, 
                AuthorityUtils.commaSeparatedStringToAuthorityList(authorities)
            );

            // Set authentication vào SecurityContext
            SecurityContextHolder.getContext().setAuthentication(authentication);
            
            log.debug("Authentication set in SecurityContext for user: {}", email);

        } catch (Exception e) {
            log.error("JWT validation failed: {}", e.getMessage());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Xác thực JWT thất bại: " + e.getMessage());
            return;
        }

        // Tiếp tục với filter chain
        filterChain.doFilter(request, response);
    }

    /**
     * Xác định những request nào sẽ bỏ qua filter này
     * Ví dụ: static resources, login endpoint, public endpoints
     */
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String path = request.getRequestURI();
        
        // Bỏ qua filter cho các endpoints public
        return path.startsWith("/api/auth/") || 
               path.startsWith("/api/public/") ||
               path.equals("/api/health") ||
               path.startsWith("/swagger-ui/") ||
               path.startsWith("/v3/api-docs");
    }
}
