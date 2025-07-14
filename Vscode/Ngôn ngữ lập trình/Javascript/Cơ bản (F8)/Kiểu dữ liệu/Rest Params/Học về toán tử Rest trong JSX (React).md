<br>

## 1. Toán tử Rest trong JavaScript

Toán tử `rest (...)` được dùng để thu thập các phần còn lại của mảng hoặc object vào một biến mới.

### Ví dụ với mảng:

```js
const numbers = [1, 2, 3, 4];
const [first, ...rest] = numbers;
console.log(rest); // [2, 3, 4]
```

### Ví dụ với object:

```js
const user = { name: "Alice", age: 25, role: "admin" };
const { name, ...rest } = user;
console.log(rest); // { age: 25, role: "admin" }
```

---

## 2. Sử dụng toán tử Rest trong JSX (React)

Trong React, JSX cho phép bạn truyền props vào component. Toán tử `rest` giúp truyền nhiều props động một cách linh hoạt.

### Ví dụ 1: Truyền props còn lại vào component

```jsx
// Component nhận các props và truyền phần còn lại vào thẻ button
function CustomButton({ children, ...restProps }) {
  return (
    <button {...restProps} className="custom-btn">
      {children}
    </button>
  );
}

// Sử dụng: Truyền onClick và aria-label qua restProps
<CustomButton onClick={handleClick} aria-label="Submit">
  Click me
</CustomButton>
```

**Giải thích:**

- `...restProps` thu thập tất cả props không được khai báo trực tiếp (ở đây là `onClick` và `aria-label`).
    
- `{...restProps}` giải phóng các props này vào thẻ `<button>`.
    

### Ví dụ 2: Kết hợp với props mặc định

```jsx
function InputField({ label, ...inputProps }) {
  return (
    <div className="input-container">
      <label>{label}</label>
      <input {...inputProps} />
    </div>
  );
}

// Sử dụng: Truyền type, placeholder, onChange
<InputField
  label="Email"
  type="email"
  placeholder="Enter your email"
  onChange={handleEmailChange}
/>
```

---

## 3. Lưu ý quan trọng

### 1. Tránh truyền props không hợp lệ vào DOM

Nếu component của bạn render một thẻ DOM (như `div`, `button`), đảm bảo không truyền props không phải là thuộc tính hợp lệ.

**Ví dụ sai:**

```jsx
function Card({ isActive, ...rest }) {
  return <div {...rest} />;
}
```

**Cách sửa đúng:**

```jsx
function Card({ isActive, ...rest }) {
  const { isActive: _, ...safeProps } = rest;
  return <div {...safeProps} />;
}
```

### 2. Thứ tự spread props

Props được spread sau sẽ ghi đè props trước:

```jsx
<button {...restProps} className="my-class" />
// className trong restProps bị ghi đè bởi "my-class"
```

### 3. Không dùng rest cho `children`

Prop `children` cần được khai báo riêng:

```jsx
function List({ children, ...rest }) {
  return <ul {...rest}>{children}</ul>;
}
```

---

## 4. Bài tập thực hành

### Bài 1: Tạo component `FlexContainer`

```jsx
function FlexContainer({ gap = "8px", direction = "row", children, ...rest }) {
  return (
    <div
      {...rest}
      style={{
        display: "flex",
        gap: gap,
        flexDirection: direction,
      }}
    >
      {children}
    </div>
  );
}

// Sử dụng:
<FlexContainer gap="16px" direction="column" className="container">
  <div>Item 1</div>
  <div>Item 2</div>
</FlexContainer>
```

### Bài 2: Component `IconButton`

```jsx
function IconButton({ icon, children, ...buttonProps }) {
  return (
    <button {...buttonProps} className="icon-btn">
      {icon && <span className="icon">{icon}</span>}
      {children}
    </button>
  );
}

// Sử dụng:
<IconButton icon="⭐" onClick={handleStarClick}>
  Star
</IconButton>
```

---

## 5. Tài nguyên tham khảo

- React Documentation: JSX In Depth
    
- [MDN Web Docs: Rest parameters](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Functions/rest_parameters)
    

Chúc bạn học tốt! Hãy thử code ngay để nắm vững cách sử dụng toán tử Rest trong JSX nhé! 🚀