<br>

### 1. Tạo chuỗi gồm 6 chữ số (bao gồm số 0 ở đầu)

```ts
const generateSixDigits = (): string => {
  // Tạo số ngẫu nhiên từ 0 đến 999999, sau đó thêm các số 0 ở đầu nếu cần
  return Math.floor(Math.random() * 1000000).toString().padStart(6, '0');
};

// Ví dụ sử dụng
console.log(generateSixDigits()); // Kết quả có thể là "012345", "987654",...
```

#### Giải thích:

- `Math.random() * 1000000`: Tạo số ngẫu nhiên từ 0 (bao gồm) đến 1000000 (không bao gồm).
    
- `Math.floor()`: Làm tròn xuống để lấy số nguyên từ 0 đến 999999.
    
- `.toString().padStart(6, '0')`: Chuyển số thành chuỗi và đảm bảo chuỗi có đủ 6 chữ số bằng cách thêm số 0 ở đầu nếu cần.
    

---

### 2. Tạo số ngẫu nhiên 6 chữ số (không có số 0 ở đầu)

```ts
const generateSixDigitNumber = (): number => {
  // Tạo số ngẫu nhiên từ 100000 đến 999999
  return Math.floor(Math.random() * 900000) + 100000;
};

// Ví dụ sử dụng
console.log(generateSixDigitNumber()); // Kết quả có thể là 123456, 654321,...
```

#### Giải thích:

- `Math.random() * 900000`: Tạo số ngẫu nhiên từ 0 đến 899999.
    
- `Math.floor()`: Làm tròn xuống để lấy số nguyên.
    
- `+ 100000`: Đảm bảo số luôn có ít nhất 6 chữ số.
    

### Kết luận

Tùy vào nhu cầu sử dụng, bạn có thể chọn cách phù hợp:

- **Dùng** `generateSixDigits()` nếu cần kết quả dưới dạng chuỗi và có thể có số 0 ở đầu.
    
- **Dùng** `generateSixDigitNumber()` nếu cần kết quả dưới dạng số nguyên không có số 0 ở đầu.