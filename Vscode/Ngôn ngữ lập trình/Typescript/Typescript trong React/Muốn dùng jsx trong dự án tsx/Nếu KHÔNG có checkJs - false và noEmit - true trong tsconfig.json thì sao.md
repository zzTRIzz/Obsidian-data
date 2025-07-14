<br>

# Sử dụng .tsx và .jsx trong dự án React + TypeScript

Khi sử dụng cả `.tsx` và `.jsx` trong một dự án React + TypeScript, hai tùy chọn `checkJs` và `noEmit` trong `tsconfig.json` giúp kiểm soát cách TypeScript xử lý file `.jsx`. Nếu loại bỏ chúng, có thể gặp một số vấn đề quan trọng.

---

## 1. Ảnh hưởng khi bỏ `checkJs: false`

🔴 **TypeScript sẽ kiểm tra lỗi (type checking) trong file** `**.jsx**`

- `.jsx` không có khai báo kiểu dữ liệu rõ ràng, khiến TypeScript báo lỗi không cần thiết.
    
- TypeScript sẽ cố gắng kiểm tra kiểu dữ liệu dù các file `.jsx` không có type annotations.
    

### 🔹 Ví dụ lỗi khi không có `checkJs: false`

#### 📌 **File** `**Button.jsx**`

```js
export const Button = ({ label, onClick }) => {
  return <button onClick={onClick}>{label.toUpperCase()}</button>; // ❌ TypeScript có thể cảnh báo lỗi
};
```

#### 📌 **File** `**App.tsx**`

```js
import { Button } from "./Button.jsx"; // ✅ Import được nhưng có thể bị lỗi type checking

function App() {
  return <Button label={123} onClick={() => console.log("Clicked")} />; // ❌ TypeScript báo lỗi vì label không phải string
}
```

👉 **Không có** `**checkJs: false**`**, TypeScript sẽ kiểm tra** `**.jsx**`**, gây lỗi không mong muốn.**

### ✅ **Giải pháp:**

- Nếu không muốn TypeScript kiểm tra `.jsx`, hãy giữ `checkJs: false`.
    
- Nếu muốn TypeScript kiểm tra `.jsx`, có thể bỏ `checkJs: false`, nhưng dễ gặp lỗi do thiếu type annotations.
    

---

## 2. Ảnh hưởng khi bỏ `noEmit: true`

🔴 **TypeScript sẽ cố biên dịch (emit) các file** `**.js**` **và** `**.jsx**`

- Dự án React thường dùng Babel/Webpack để build, không cần TypeScript biên dịch `.jsx`.
    
- Nếu không có `noEmit: true`, TypeScript có thể tạo file `.js` không mong muốn, gây lỗi build.
    

### 🔹 Ví dụ lỗi khi không có `noEmit: true`

- Nếu có file `Button.jsx`, TypeScript có thể biên dịch ra `Button.js`, dù Webpack đã xử lý file này.
    
- Dẫn đến lỗi build hoặc tạo file dư thừa trong thư mục `dist/`.
    

### ✅ **Giải pháp:**

- Nếu chỉ muốn kiểm tra code mà không cần TypeScript biên dịch, hãy giữ `noEmit: true`.
    
- Nếu thực sự muốn TypeScript biên dịch `.jsx` (hiếm khi cần), có thể bỏ `noEmit: true`.
    

---

## 3. **Tóm lại: Có nên giữ** `**checkJs: false**` **và** `**noEmit: true**` **không?**

|Tùy chọn|Nên bật ✅|Khi nào có thể bỏ?|
|---|---|---|
|`checkJs: false`|✅ Tránh lỗi không cần thiết khi import `.jsx` vào `.tsx`.|Nếu muốn TypeScript kiểm tra `.jsx` (hiếm khi cần).|
|`noEmit: true`|✅ Ngăn TypeScript biên dịch `.jsx`, tránh lỗi build.|Nếu thực sự muốn TypeScript biên dịch `.jsx` (rất hiếm khi cần).|

### 💡 **Khuyến nghị:**

✔ Nếu sử dụng `.jsx` trong dự án TypeScript mà không muốn lỗi, **nên giữ cả** `**checkJs: false**` **và** `**noEmit: true**`. ✔ Nếu muốn kiểm tra lỗi `.jsx` hoặc để TypeScript biên dịch `.jsx`, **có thể bỏ chúng**, nhưng cần cẩn thận với lỗi build.

🚀 **Giữ hai tùy chọn này giúp đảm bảo dự án hoạt động trơn tru mà không gây xung đột giữa** `**.tsx**` **và** `**.jsx**`**!**