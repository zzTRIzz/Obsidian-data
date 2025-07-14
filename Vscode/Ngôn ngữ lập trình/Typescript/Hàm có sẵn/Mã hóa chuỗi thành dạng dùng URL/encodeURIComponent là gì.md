<br>

## Giới thiệu

`encodeURIComponent` là một hàm trong **JavaScript** dùng để mã hóa một chuỗi thành dạng có thể dùng trong **URL**, giúp đảm bảo dữ liệu không bị lỗi khi truyền qua tham số URL.

### Cách hoạt động:

Hàm này mã hóa các ký tự đặc biệt trong chuỗi bằng cách thay thế chúng bằng **percent-encoding** (ví dụ: `?` → `%3F`, `=` → `%3D`, `&` → `%26`).

## Cú pháp

```js
encodeURIComponent(str);
```

- `str`: Chuỗi cần mã hóa.
    
- **Trả về**: Chuỗi đã được mã hóa.
    

## Ví dụ

### 1. Mã hóa một chuỗi chứa ký tự đặc biệt

```js
const query = "iPhone 16 128GB Xanh Lưu Ly";
const encodedQuery = encodeURIComponent(query);

console.log(encodedQuery);
// Kết quả: "iPhone%2016%20128GB%20Xanh%20L%C6%B0u%20Ly"
```

**Giải thích:**

- Dấu cách ( ) → `%20`
    
- Chữ `ư` → `%C6%B0`
    

### 2. Mã hóa một đối tượng JSON

Dùng `encodeURIComponent` để mã hóa JSON thành chuỗi có thể đặt vào URL.

```js
const product = {
  id: "item-1743174768391-0",
  name: "iPhone 16 128GB Xanh Lưu Ly",
  price: 31390000
};

const jsonString = JSON.stringify(product);
const encodedString = encodeURIComponent(jsonString);

console.log(encodedString);
// Kết quả: "%7B%22id%22%3A%22item-1743174768391-0%22%2C%22name%22%3A%22iPhone%2016%20128GB%20Xanh%20L%C6%B0u%20Ly%22%2C%22price%22%3A31390000%7D"
```

**Giải thích:**

- `{` → `%7B`
    
- `}` → `%7D`
    
- `"` → `%22`
    
- `:` → `%3A`
    
- `,` → `%2C`
    

### 3. Tạo URL có tham số chứa JSON

Nếu bạn cần chuyển danh sách sản phẩm vào URL:

```js
const selectedProducts = [
  { id: "item-1", name: "iPhone 16", price: 31390000 },
  { id: "item-2", name: "Xiaomi Poco X6", price: 27990000 }
];

const encodedData = encodeURIComponent(JSON.stringify(selectedProducts));
const url = `http://localhost:5173/dat-hang?selectedProducts=${encodedData}`;

console.log(url);
```

👉 Khi truy cập URL, backend hoặc frontend chỉ cần **giải mã dữ liệu** bằng `decodeURIComponent` và chuyển lại thành JSON.

## decodeURIComponent là gì?

Hàm `decodeURIComponent` làm ngược lại, giúp giải mã dữ liệu từ URL về dạng ban đầu.

**Ví dụ:**

```js
const decodedString = decodeURIComponent(encodedString);
console.log(decodedString);
```

## Khi nào dùng `encodeURIComponent`?

- Khi gửi dữ liệu có ký tự đặc biệt qua URL.
    
- Khi nhúng **JSON object** vào URL.
    
- Khi cần đảm bảo dữ liệu không bị lỗi do dấu `&`, `?`, `=` trong query string.
    

## 🔥 Lưu ý:

- **Không** dùng `encodeURIComponent` cho toàn bộ URL, chỉ dùng cho từng tham số.
    
- Nếu cần mã hóa toàn bộ URL, hãy dùng `**encodeURI()` thay vì `encodeURIComponent()`.