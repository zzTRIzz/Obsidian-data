<br>

## `Object.getOwnPropertySymbols()` - "Săn lùng báu vật ẩn"

Trong đoạn code của bạn có một lỗi nhỏ - nên viết hoa chữ O trong `Object`:

```js
// Sai

console.log(object.getOwnPropertySymbols(user));
```

```js
// Đúng

console.log(Object.getOwnPropertySymbols(user));
```

### Giải thích đơn giản:

- 🔍 **Giống như một thám tử đặc biệt** chỉ tìm kiếm các chìa khóa bí mật (Symbol) trong một ngôi nhà (Object), không quan tâm đến các chìa khóa thông thường

### Cách hoạt động:

- **`Object.getOwnPropertySymbols()`** trả về một mảng chứa tất cả các thuộc tính kiểu Symbol của một object
- Symbol là kiểu dữ liệu đặc biệt trong JavaScript tạo ra các định danh duy nhất, thường dùng làm key "ẩn" trong object

### Phân tích code của bạn:

```js
const id = Symbol('id');

const user = {

    name: 'Nguyen Quoc Tri',

    id: 1

};

console.log(Object.getOwnPropertySymbols(user)); // Kết quả: []
```

Kết quả là mảng rỗng `[]` vì:

- Bạn đã tạo một biến [id](vscode-file://vscode-app/c:/Users/ADMIN/AppData/Local/Programs/Microsoft%20VS%20Code/resources/app/out/vs/code/electron-sandbox/workbench/workbench.html) với kiểu Symbol
- Nhưng bạn KHÔNG sử dụng Symbol này làm key trong object [user](vscode-file://vscode-app/c:/Users/ADMIN/AppData/Local/Programs/Microsoft%20VS%20Code/resources/app/out/vs/code/electron-sandbox/workbench/workbench.html)
- Thuộc tính [id: 1](vscode-file://vscode-app/c:/Users/ADMIN/AppData/Local/Programs/Microsoft%20VS%20Code/resources/app/out/vs/code/electron-sandbox/workbench/workbench.html) trong [user](vscode-file://vscode-app/c:/Users/ADMIN/AppData/Local/Programs/Microsoft%20VS%20Code/resources/app/out/vs/code/electron-sandbox/workbench/workbench.html) là key thông thường, không phải Symbol

### Ví dụ để hiểu rõ hơn:

```js
// Tạo Symbol và sử dụng làm key trong object

const symbolId = Symbol('id');

const user = {

    name: 'Nguyen Quoc Tri',

    [symbolId]: 'SECRET-123' // Sử dụng Symbol làm key

};

// Các phương thức thông thường không thấy Symbol

console.log(Object.keys(user)); // ['name']

console.log(user.symbolId); // undefined - không thể truy cập bằng cách thông thường

// Chỉ getOwnPropertySymbols mới thấy được

console.log(Object.getOwnPropertySymbols(user)); // [Symbol(id)]

console.log(user[symbolId]); // 'SECRET-123' - truy cập đúng cách
```

### Công dụng thực tế:

- **Tạo thuộc tính "riêng tư"**: Thuộc tính Symbol không xuất hiện trong vòng lặp thông thường
- **Tránh xung đột tên thuộc tính**: Symbol luôn duy nhất, an toàn khi làm việc với thư viện bên thứ 3
- **Metadata**: Lưu trữ thông tin "meta" mà không làm "ô nhiễm" object gốc

### Mẹo nhỏ:

Để thực hành hiệu quả, hãy thử thêm Symbol vào object và xem sự khác biệt giữa các phương thức:

- `Object.keys()` - Chỉ thấy key thường
- `Object.getOwnPropertyNames()` - Cũng chỉ thấy key thường
- `Object.getOwnPropertySymbols()` - Chỉ thấy Symbol
- `Reflect.ownKeys()` - Thấy cả hai loại

Symbol là một trong những tính năng thú vị của JavaScript hiện đại, giúp làm việc với object linh hoạt hơn! 😊