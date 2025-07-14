<br>

## 1. Giới thiệu

Hàm `encodeURIComponent` là một hàm có sẵn trong JavaScript, không cần phải đặt trong bất kỳ thư mục nào. Tuy nhiên, để tổ chức mã nguồn một cách khoa học, bạn có thể đặt nó trong một file/module riêng để tái sử dụng trong dự án.

---

## 2. Sử dụng trong **Frontend** (React, Vue, Angular, Vanilla JS)

Bạn có thể tạo một thư mục `utils/` để chứa các hàm tiện ích.

### 📂 Cấu trúc thư mục gợi ý:

```
/src
  /utils
    urlHelper.js
  /components
  /pages
```

### 📌 Tạo file `src/utils/urlHelper.js`

```js
// src/utils/urlHelper.js
export function encodeData(data) {
  return encodeURIComponent(JSON.stringify(data));
}

export function decodeData(encodedData) {
  return JSON.parse(decodeURIComponent(encodedData));
}
```

### 🔥 Cách sử dụng trong một component (React):

```jsx
import { encodeData, decodeData } from "../utils/urlHelper";

const selectedProducts = [
  { id: "item-1", name: "iPhone 16", price: 31390000 },
  { id: "item-2", name: "Xiaomi Poco X6", price: 27990000 }
];

// Mã hóa dữ liệu để truyền vào URL
const encodedProducts = encodeData(selectedProducts);
console.log(encodedProducts);

// Giải mã dữ liệu khi nhận từ URL
const decodedProducts = decodeData(encodedProducts);
console.log(decodedProducts);
```

---

## 3. Sử dụng trong **Backend** (Node.js, Express, NestJS, Next.js API route)

Trong backend, bạn cũng có thể tạo thư mục `utils/` để chứa file tiện ích.

### 📂 Cấu trúc thư mục gợi ý:

```
/src
  /utils
    urlHelper.js
  /routes
  /controllers
  /services
```

### 📌 Tạo file `src/utils/urlHelper.js`

```js
// src/utils/urlHelper.js
module.exports = {
  encodeData: (data) => encodeURIComponent(JSON.stringify(data)),
  decodeData: (encodedData) => JSON.parse(decodeURIComponent(encodedData))
};
```

### 🔥 Cách sử dụng trong một route của Express:

```jsx
const express = require("express");
const { encodeData, decodeData } = require("../utils/urlHelper");

const router = express.Router();

router.get("/encode", (req, res) => {
  const data = { message: "Hello, world!" };
  res.send({ encoded: encodeData(data) });
});

router.get("/decode", (req, res) => {
  const { encodedData } = req.query;
  res.send({ decoded: decodeData(encodedData) });
});

module.exports = router;
```

---

## 4. 🔥 Kết luận

✅ Nếu dùng **Frontend**, đặt trong `/src/utils/urlHelper.js`. ✅ Nếu dùng **Backend**, đặt trong `/src/utils/urlHelper.js` và export phù hợp (`module.exports` trong Node.js).

### **🎯 Lợi ích:**

- **Dễ bảo trì**
    
- **Có thể tái sử dụng**
    
- **Tránh trùng lặp code**
    

🔹 **Tóm lại**: `encodeURIComponent` là hàm có sẵn, nhưng để tổ chức mã nguồn tốt hơn, bạn nên đặt nó trong `utils/urlHelper.js` để tái sử dụng trong nhiều nơi. 🚀