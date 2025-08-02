package com.example.learn.dto.response;

import lombok.Data;

/**
 * Generic API Response wrapper
 * 
 * Wrapper cho tất cả API responses để có format thống nhất:
 * - success: Trạng thái thành công/thất bại
 * - message: Thông báo kết quả
 * - data: Dữ liệu trả về (có thể là object hoặc list)
 */
@Data
public class ApiResponse<T> {
    private boolean success;
    private String message;
    private T data;
    
    public ApiResponse() {}
    
    public ApiResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
    
    public ApiResponse(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }
    
    // Static methods để tạo response nhanh
    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>(true, message, data);
    }
    
    public static <T> ApiResponse<T> success(String message) {
        return new ApiResponse<>(true, message);
    }
    
    public static <T> ApiResponse<T> error(String message) {
        return new ApiResponse<>(false, message);
    }
    
    public static <T> ApiResponse<T> error(String message, T data) {
        return new ApiResponse<>(false, message, data);
    }
}
