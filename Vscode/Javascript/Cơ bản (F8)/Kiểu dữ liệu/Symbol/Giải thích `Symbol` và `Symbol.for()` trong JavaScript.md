<br>

## 1. `Symbol` - "Con dấu định danh duy nhất"

### Khái niệm:

🔐 **Giống như dấu vân tay**: Mỗi người có dấu vân tay riêng, không ai giống ai.

### Tính chất:

- **Luôn duy nhất**, bất kể tham số truyền vào có giống nhau.
    
- Ví dụ:
    
    ```js
    console.log(Symbol('id') === Symbol('id')); // false
    ```
    
    Lý do là vì mỗi lần tạo `Symbol`, nó sẽ sinh ra một giá trị khác nhau, giống như hai con dấu khác nhau dù có chạm khắc cùng một hình.
    

## 2. `Symbol.for()` - "Sổ đăng ký toàn cục"

### Khái niệm:

🗂️ **Giống như sổ đăng ký tên miền**: Kiểm tra xem tên đã có ai đăng ký chưa, nếu chưa thì đăng ký mới, nếu rồi thì dùng lại.

### Tính chất:

- **Tìm kiếm trong global symbol registry trước khi tạo mới**.
    
- Ví dụ:
    
    ```js
    let sym1 = Symbol.for('id');
    let sym2 = Symbol.for('id');
    console.log(sym1 === sym2); // true
    ```
    
    Lệnh đầu tiên tạo và đăng ký `Symbol('id')`, lệnh thứ hai tìm thấy nó đã tồn tại nên trả về cùng một `Symbol`.
    

## 3. So sánh `Symbol` và `Symbol.for()`

|Đặc điểm|`Symbol`|`Symbol.for()`|
|---|---|---|
|**Tính duy nhất**|Luôn tạo mới|Tái sử dụng nếu có cùng key|
|**Phạm vi**|Local|Global (chia sẻ giữa các frame, service workers)|
|**Ứng dụng**|Private properties|Chia sẻ Symbol giữa các đoạn code|
|**Ví dụ thực tế**|Khóa phòng riêng|Chìa khóa phòng chung|

## 4. Ví dụ thực tế

### Ví dụ về `Symbol`:

```js
const mySymbol = Symbol('privateKey');
const obj = {
  [mySymbol]: 'Secret Data'
};
console.log(obj[mySymbol]); // 'Secret Data'
```

### Ví dụ về `Symbol.for()`:

```js
const globalSym = Symbol.for('sharedKey');
const obj2 = {
  [globalSym]: 'Shared Data'
};
console.log(obj2[Symbol.for('sharedKey')]); // 'Shared Data'
```

## 5. Lưu ý quan trọng

1. `Symbol` **không tự động chuyển thành string**:
    
    ```js
    console.log('x' + Symbol()); // TypeError
    ```
    
2. `Symbol.for()` **là toàn cục**: Cẩn thận với xung đột tên trong ứng dụng lớn.
    
3. `Symbol` **thường không xuất hiện trong** `for...in`: Giúp bảo vệ thuộc tính khỏi vòng lặp.
    

### Tổng kết

`Symbol` là một tính năng mạnh mẽ của JavaScript hiện đại, đặc biệt hữu ích khi cần tạo các thuộc tính "bán riêng tư" hoặc áp dụng trong meta-programming!