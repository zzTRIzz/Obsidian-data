<br>

## Tại sao `es` lại chứa event object?

React tự động inject event vào tham số đầu tiên của hàm xử lý sự kiện.

- **Tên tham số không quan trọng**: Bạn có thể đặt tên bất kỳ (`es`, `e`, `event`, `abc`...).
    
- **Cơ chế "implicit parameter passing" của JavaScript**: React truyền event object vào hàm handler một cách tự động.
    

### Ví dụ:

```jsx
// Cách viết của bạn
<Button onClick={(es) => { 
  console.log(es.clientX); // Vẫn hoạt động
}} />

// Cách viết thông thường
<Button onClick={(e) => { 
  console.log(e.clientX); 
}} />
```

## Cơ chế hoạt động chi tiết:

Khi bạn click vào button, React xử lý sự kiện như sau:

```jsx
// React nội bộ
const fakeEvent = {
  clientX: 123,
  clientY: 456,
  //... các thuộc tính khác
}

// Gọi hàm handler của bạn và truyền event
yourOnClickFunction(fakeEvent); // <-- Event được truyền vào
```

Bạn có thể bắt tham số đầu tiên bằng tên bất kỳ:

```jsx
const handler = (thu_gi_do) => {
  console.log(thu_gi_do.clientX); // Vẫn lấy được giá trị
}
```

## Tại sao không cần khai báo trước?

- **JavaScript là ngôn ngữ dynamic typing** → Không cần định nghĩa kiểu tham số.
    
- **React tự động truyền event vào handler**.
    
- **Quy ước: Tham số đầu tiên của handler luôn là event object**.
    

## Ví dụ mở rộng:

### Bỏ qua event nếu không dùng:

```jsx
<Button onClick={() => console.log("Clicked!")} />
```

### Lấy nhiều tham số hơn (tham số sau sẽ là `undefined`):

```jsx
<Button onClick={(es, param2) => {
  console.log(es); // Event object
  console.log(param2); // undefined
}} />
```

## TypeScript version (nếu dùng TypeScript):

```jsx
<Button onClick={(es: React.MouseEvent<HTMLButtonElement>) => {
  console.log(es.clientX); // TypeScript sẽ kiểm tra kiểu dữ liệu
}} />
```

## Tóm lại:

✅ **React luôn truyền event object vào tham số đầu tiên của hàm handler**.

✅ **Bạn có toàn quyền đặt tên tham số** (nhưng nên dùng `e` hoặc `event` để code dễ hiểu).

✅ **Đây là cơ chế thiết kế sẵn của React, không phải magic** 😄.

👉 Hãy thử nghiệm với các tên tham số khác nhau để hiểu rõ hơn về cơ chế này!