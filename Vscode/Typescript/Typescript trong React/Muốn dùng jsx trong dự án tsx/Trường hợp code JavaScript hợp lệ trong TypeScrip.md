<br>

TypeScript là một **superset** của JavaScript, nghĩa là hầu hết code JavaScript hợp lệ trong TypeScript. Tuy nhiên, có một số quy tắc cần lưu ý.

## 1. JavaScript thuần (Không có kiểu dữ liệu) → Hợp lệ

Nếu bạn viết JavaScript bình thường mà không có lỗi cú pháp, TypeScript vẫn có thể chạy được:

```js
function greet(name) {
    console.log("Hello, " + name);
}
greet("Alice");
```

✅ Hợp lệ nhưng TypeScript có thể cảnh báo vì thiếu kiểu dữ liệu.

---

## 2. Sử dụng `any` để bỏ qua kiểm tra kiểu → Hợp lệ

```js
function add(a: any, b: any) {
    return a + b;
}
console.log(add(5, "10")); // Kết quả: "510" (không an toàn nhưng hợp lệ)
```

✅ Hợp lệ nhưng có thể dẫn đến lỗi runtime.

---

## 3. Kích hoạt `allowJs` để import file `.js` trong dự án TypeScript

Nếu bạn có file JavaScript (`utils.js`) và muốn sử dụng trong TypeScript:

**Cấu hình** `**tsconfig.json**`**:**

```js
{
  "compilerOptions": {
  "jsx": "react-jsx",
    "allowJs": true,
  }
}
```

**Sử dụng trong TypeScript:**

```js
import { myFunction } from "./utils.js";
myFunction();
```

✅ Hợp lệ nếu `allowJs: true` trong `tsconfig.json`.

---

# Trường hợp code JavaScript bị lỗi trong TypeScript

TypeScript có thể báo lỗi nếu code JavaScript không tuân thủ quy tắc của nó.

## 1. Sử dụng JavaScript mà không bật `allowJs` → Lỗi

Nếu bạn cố gắng import file `.js` vào TypeScript mà chưa bật `allowJs`:

```js
import { someFunction } from "./legacy.js";
```

❌ **Lỗi:** `Cannot find module './legacy.js'`

✔ **Cách khắc phục:** Bật `"allowJs": true` trong `tsconfig.json`.

---

## 2. Dùng JavaScript không có kiểu dữ liệu nhưng bị chặn bởi `strict`

Nếu `tsconfig.json` bật `strict: true`, TypeScript sẽ báo lỗi khi không có kiểu dữ liệu rõ ràng:

```js
function multiply(a, b) {
    return a * b;
}
```

❌ **Lỗi:** `Parameter 'a' implicitly has an 'any' type.`

✔ **Cách khắc phục:** Thêm kiểu dữ liệu:

```js
function multiply(a: number, b: number): number {
    return a * b;
}
```

---

## 3. Truy cập thuộc tính không tồn tại → Lỗi

```js
let obj = {};
console.log(obj.name.toUpperCase());
```

❌ **Lỗi:** `Object is possibly 'undefined'`

✔ **Cách khắc phục:**

```js
if (obj && obj.name) {
    console.log(obj.name.toUpperCase());
}
```

---

## 4. Gán kiểu không phù hợp → Lỗi

```js
let age: number = "30";
```

❌ **Lỗi:** `Type 'string' is not assignable to type 'number'`

✔ **Cách khắc phục:**

```js
let age: number = 30;
```

---

# Kết luận

✅ **Hợp lệ khi:**

- Viết JavaScript thuần mà không có lỗi cú pháp.
    
- Dùng `any` để bỏ qua kiểm tra kiểu.
    
- Bật `allowJs` để import file `.js` vào TypeScript.
    

🚨 **Lỗi khi:**

- Không khai báo kiểu trong chế độ `strict`.
    
- Truy cập thuộc tính không tồn tại.
    
- Gán sai kiểu dữ liệu.
    
- Import file `.js` mà chưa bật `allowJs`.
    

👉 **Khuyến nghị:** Nếu dùng TypeScript, bạn nên tận dụng hệ thống kiểu thay vì viết JavaScript không kiểm soát.