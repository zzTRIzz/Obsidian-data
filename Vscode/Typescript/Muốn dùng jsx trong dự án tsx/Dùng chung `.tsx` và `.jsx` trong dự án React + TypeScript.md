<br>

## 1. Cấu hình `tsconfig.json` để hỗ trợ `.jsx` trong TypeScript

Bạn cần thêm các tùy chọn sau vào `tsconfig.json`:

```js
{
  "compilerOptions": {
    "allowJs": true,       // Cho phép dùng file .js và .jsx
    "jsx": "react-jsx",    // Hỗ trợ JSX trong TypeScript
    "checkJs": false,      // Không kiểm tra lỗi trong file .jsx
    "noEmit": true         // Không biên dịch file .js/.jsx
  }
}
```

### 🔹 Giải thích:

- `allowJs: true` → Cho phép dùng file `.js` và `.jsx`.
    
- `jsx: "react-jsx"` → Hỗ trợ JSX trong `.tsx`.
    
- `checkJs: false` → Không kiểm tra lỗi trong `.jsx`, tránh xung đột khi import vào `.tsx`.
    
- `noEmit: true` → Đảm bảo TypeScript không biên dịch `.jsx`, chỉ kiểm tra `.tsx`.
    

---

## 2. Cách tổ chức code hợp lý

Bạn có thể chia dự án như sau:

```js
src/
│── components/
│   │── Button.jsx      <-- Dùng JSX cho code đơn giản
│   │── Card.jsx        <-- Dùng JSX cho code đơn giản
│   │── Header.tsx      <-- Dùng TSX cho các thành phần quan trọng
│
│── layouts/
│   │── MainLayout.tsx  <-- Dùng TSX để kiểm soát theme & route
│
│── pages/
│   │── Home.tsx        <-- Dùng TSX cho các page chính
│   │── About.tsx       <-- Dùng TSX cho page chính
│
│── App.tsx            <-- TSX cho cấu trúc chính
│── index.tsx          <-- TSX cho entry point
```

### 👉 Quy tắc:

✅ Dùng `.jsx` cho component đơn giản không cần type checking (UI nhỏ, helper component).  
✅ Dùng `.tsx` cho component quan trọng, theme, route, logic chính.

---

## 3. Ví dụ thực tế: Dùng chung `.tsx` và `.jsx`

### 📌 1. File `Button.jsx` (Component đơn giản - không cần TypeScript)

```js
import React from "react";

const Button = ({ label, onClick }) => {
  return <button onClick={onClick}>{label}</button>;
};

export default Button;
```

#### 📌 Lý do dùng `.jsx` ở đây:

- Component nhỏ, không cần kiểm tra kiểu dữ liệu.
    
- Giữ code đơn giản, dễ viết.
    

---

### 📌 2. File `MainLayout.tsx` (Theme & Route - cần TypeScript)

```js
import React from "react";
import Button from "../components/Button.jsx";  // ✅ Import .jsx không lỗi

const MainLayout: React.FC<{ title: string }> = ({ title, children }) => {
  return (
    <div>
      <h1>{title}</h1>
      <Button label="Click me" onClick={() => alert("Hello!")} /> {/* ✅ Dùng JSX trong TSX */}
      {children}
    </div>
  );
};

export default MainLayout;
```

#### 📌 Lý do dùng `.tsx` ở đây:

- Có kiểm tra kiểu dữ liệu, tránh lỗi khi truyền props sai.
    
- Là layout chính, cần đảm bảo chặt chẽ về type checking.
    

---

### 📌 3. File `App.tsx` (React Router với TSX, vẫn gọi được `.jsx`)

```js
import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import MainLayout from "./layouts/MainLayout";
import Home from "./pages/Home";
import About from "./pages/About";

function App() {
  return (
    <Router>
      <MainLayout title="My Website">
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/about" element={<About />} />
        </Routes>
      </MainLayout>
    </Router>
  );
}

export default App;
```

📌 Ở đây `.tsx` vẫn có thể import `.jsx` mà không lỗi.

---

## 4. Có vấn đề gì khi dùng chung `.tsx` và `.jsx` không?

|Vấn đề|Giải pháp|
|---|---|
|TypeScript không kiểm tra `.jsx`|Chấp nhận hoặc chuyển dần sang `.tsx` nếu cần.|
|IDE không hỗ trợ tốt `.jsx` trong dự án TS|Bật `allowJs: true` để tránh lỗi import.|
|Lỗi khi build nếu `.jsx` chứa lỗi|Bật `checkJs: false` để tránh ảnh hưởng.|

---

## 5. Khi nào **NÊN** và **KHÔNG NÊN** dùng chung `.tsx` và `.jsx`?

### ✅ **NÊN DÙNG CHUNG KHI:**

✔ Dự án đang chuyển từ JavaScript sang TypeScript, cần thời gian để migrate.  
✔ Muốn giữ code UI đơn giản mà không cần type checking.  
✔ Đã bật `allowJs: true` để hỗ trợ import `.jsx` vào `.tsx`.

### ❌ **KHÔNG NÊN DÙNG CHUNG KHI:**

🚫 Dự án cần kiểm tra chặt chẽ về kiểu dữ liệu, tránh lỗi runtime.  
🚫 Làm việc nhóm, cần consistency cao trong codebase.  
🚫 Muốn tận dụng tối đa TypeScript để tối ưu hiệu suất và debug sớm.

---

## 6. Kết luận

🚀 Bạn có thể dùng `.tsx` cho theme, route và `.jsx` cho code đơn giản nếu cấu hình đúng.  
✅ Bật `allowJs: true` trong `tsconfig.json` để tránh lỗi import `.jsx` vào `.tsx`.  
⚡ Nên dần dần chuyển `.jsx` thành `.tsx` nếu cần kiểm tra kiểu dữ liệu chặt chẽ hơn.  
👉 Giải pháp này giúp bạn giữ code đơn giản nhưng vẫn đảm bảo TypeScript hoạt động tốt! 🚀