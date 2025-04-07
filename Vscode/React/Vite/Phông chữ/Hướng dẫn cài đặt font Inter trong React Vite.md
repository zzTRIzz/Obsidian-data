<br>

## 1. Ưu tiên: Cài đặt **Inter Variable**

### Sử dụng npm package `@fontsource/inter` (Khuyến nghị)

#### Bước 1: Cài đặt package

```bash
npm install @fontsource/inter  # hoặc dùng yarn/pnpm
```

#### Bước 2: Import font vào dự án

**Cách 1: Import trong file CSS**

```css
/* Trong file global.css hoặc App.css */
@import '@fontsource/inter';
```

**Cách 2: Import trong file JS/JSX**

```js
import '@fontsource/inter';
```

#### Bước 3: Áp dụng font trong CSS

```css
body {
  font-family: 'Inter', sans-serif;
}
```

#### **Tùy chọn nâng cao**:

- Import font với trọng số cụ thể để giảm kích thước bundle:
    

```css
import '@fontsource/inter/400.css'; // Regular
import '@fontsource/inter/700.css'; // Bold
```

- Sử dụng **Inter Variable Font** để linh hoạt điều chỉnh weight:
    

```bash
npm install @fontsource-variable/inter
```

```css
import '@fontsource-variable/inter';
```

```css
body {
  font-family: 'Inter Variable', sans-serif;
  font-weight: 100 900; /* Điều chỉnh từ 100 đến 900 */
}
```

---

## 2. Sử dụng Google Fonts CDN

#### Bước 1: Thêm link CDN vào `index.html`

```html
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;700&display=swap" rel="stylesheet">
```

#### Bước 2: Áp dụng font trong CSS

```css
body {
  font-family: 'Inter', sans-serif;
}
```

---

## 3. Tự host font (Manual)

#### Bước 1: Tải font từ [Google Fonts](https://fonts.google.com/) hoặc trang chủ Inter, sau đó lưu vào thư mục `public/fonts/`.

#### Bước 2: Khai báo font trong CSS

```css
/* Trong file global.css */
@font-face {
  font-family: 'Inter';
  src: url('/fonts/Inter.woff2') format('woff2'),
       url('/fonts/Inter.woff') format('woff');
  font-weight: 100 900; /* Variable font */
  font-style: normal;
  font-display: swap;
}

body {
  font-family: 'Inter', sans-serif;
}
```

---

## 4. Kiểm tra kết quả

Tạo một component React để kiểm tra font:

```js
export default function App() {
  return (
    <div style={{ fontFamily: 'Inter, sans-serif' }}>
      Hello World with Inter Font!
    </div>
  );
}
```

---

## 5. Lưu ý

- **Nên sử dụng Variable Font** để tối ưu hiệu suất và linh hoạt.
    
- Nếu dùng **CDN**, cần kiểm tra **GDPR/performance** nếu cần.
    
- **Vite tự động xử lý assets** trong thư mục `public/`.