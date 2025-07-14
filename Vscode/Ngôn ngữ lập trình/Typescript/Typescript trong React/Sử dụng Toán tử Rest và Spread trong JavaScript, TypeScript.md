<br>

## 1. React: Cập nhật State Immutably

### Tình huống

Khi làm việc với React state (dạng object), bạn cần cập nhật một thuộc tính mà không thay đổi state cũ.

### Giải pháp

Dùng spread operator để tạo bản sao của state trước đó và ghi đè thuộc tính cần thay đổi.

```jsx
// Component quản lý form đăng ký
const [user, setUser] = useState({
  name: "",
  email: "",
  password: ""
});

// Xử lý thay đổi input
const handleChange = (e) => {
  setUser({
    ...user, // Copy toàn bộ thuộc tính cũ
    [e.target.name]: e.target.value // Ghi đè thuộc tính động (name, email hoặc password)
  });
};
```

---

## 2. Gom Nhiều Đối số Hàm (Rest Parameter)

### Tình huống

Viết hàm xử lý nhiều đối số không cố định (ví dụ: tính tổng, log thông tin).

### Giải pháp

Dùng rest parameter để gom các đối số thành một mảng.

```jsx
// Hàm tính tổng các số truyền vào
function sum(...numbers: number[]): number {
  return numbers.reduce((acc, num) => acc + num, 0);
}

console.log(sum(1, 2, 3)); // 6
console.log(sum(10, 20));  // 30
```

---

## 3. Destructuring để Trích Xuất Dữ Liệu

### a. Với mảng:

```jsx
const tasks = ["Code", "Test", "Deploy", "Review"];

// Lấy task đầu tiên, giữ lại các task còn lại
const [currentTask, ...pendingTasks] = tasks;

console.log(currentTask); // "Code"
console.log(pendingTasks); // ["Test", "Deploy", "Review"]
```

### b. Với object:

```jsx
const post = {
  title: "Learn JavaScript",
  author: "Alice",
  category: "Programming",
  views: 1000
};

// Trích xuất title và giữ lại các thuộc tính khác
const { title, ...postDetails } = post;

console.log(title); // "Learn JavaScript"
console.log(postDetails); // { author: "Alice", category: "Programming", views: 1000 }
```

---

## 4. Merge Object/Mảng (Spread)

```jsx
// Merge object
const defaultSettings = { theme: "light", fontSize: 16 };
const userSettings = { theme: "dark", showNotifications: true };

const finalSettings = { ...defaultSettings, ...userSettings };
// { theme: "dark", fontSize: 16, showNotifications: true }

// Merge mảng
const arr1 = [1, 2];
const arr2 = [3, 4];
const combined = [...arr1, ...arr2]; // [1, 2, 3, 4]
```

---

## 5. Truyền Props trong React (Spread)

```jsx
// Component cha
<UserProfile name="Alice" age={30} country="USA" />

// Component con
const UserProfile = (props) => {
  return <ProfileCard {...props} />; // Truyền tất cả props vào ProfileCard
};
```

---

## 6. Xóa Một Thuộc tính khỏi Object (Rest + Destructuring)

```jsx
const user = { id: 1, name: "Bob", password: "secret" };

// Loại bỏ trường "password"
const { password, ...safeUser } = user;

console.log(safeUser); // { id: 1, name: "Bob" }
```

---

## 7. Xử lý API Call với Tham số Động

```jsx
function fetchData(url: string, ...queryParams: string[]) {
  const queryString = queryParams.join("&");
  return fetch(`${url}?${queryString}`);
}

// Gọi API với các tham số linh hoạt
fetchData("/api/users", "sort=asc", "limit=10", "page=2");
```

---

## 8. Clone Object/Mảng (Spread)

```jsx
// Clone mảng
const originalArray = [1, 2, 3];
const clonedArray = [...originalArray]; // [1, 2, 3]

// Clone object
const originalObject = { a: 1, b: 2 };
const clonedObject = { ...originalObject }; // { a: 1, b: 2 }
```

---

## 9. Xử lý Event Handler trong React (Spread)

```jsx
const Button = ({ onClick, children, ...restProps }) => {
  return (
    <button onClick={onClick} {...restProps}>
      {children}
    </button>
  );
};

// Sử dụng: Truyền className, id, aria-label tự động
<Button onClick={handleClick} className="btn" id="submit" aria-label="Submit">
  Click Me
</Button>
```

---

## 10. Tạo Hàm Đa Năng với Rest Parameter

```tsx
// Hàm log thông tin kèm timestamp
function logWithTimestamp(...messages: (string | number)[]) {
  const timestamp = new Date().toISOString();
  console.log(`[${timestamp}]`, ...messages);
}

logWithTimestamp("Error:", 404); // [2023-10-01T10:00:00Z] Error: 404
```

---

## 📌 Tổng kết khi nào dùng Spread vs Rest

|Toán tử|Khi nào dùng|
|---|---|
|`...spread`|Khi cần trải các phần tử (copy, merge, truyền đối số).|
|`...rest`|Khi cần gom các phần còn lại (destructuring, rest parameter trong hàm).|

Hy vọng qua các ví dụ trên, bạn đã hiểu rõ cách ứng dụng rest và spread trong thực tế! 😊