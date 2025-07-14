<br>

## 1. Cú pháp

### Interface:

Khai báo với từ khóa `interface`, thường dùng cho định nghĩa hình dạng đối tượng (object shape).

```ts
interface Person {
  name: string;
  age: number;
}
```

### Type:

Khai báo với từ khóa `type`, linh hoạt hơn, có thể định nghĩa union, tuple, primitive, hoặc kiểu phức tạp.

```ts
type PersonType = {
  name: string;
  age: number;
};

type Status = "success" | "error"; // Union type
type Point = [number, number]; // Tuple
```

---

## 2. Kế thừa/Mở rộng

### Interface:

Dùng `extends` để kế thừa từ interface khác.

```ts
interface Animal {
  name: string;
}

interface Dog extends Animal {
  bark(): void;
}
```

### Type:

Dùng toán tử `&` để kết hợp (intersection).

```ts
type AnimalType = {
  name: string;
};

type DogType = AnimalType & {
  bark(): void;
};
```

---

## 3. Declaration Merging (Gộp khai báo)

### Interface:

Có thể gộp nếu khai báo nhiều lần cùng tên.

```ts
interface User {
  name: string;
}

interface User {
  age: number;
}

// Kết quả: { name: string; age: number; }
```

### Type:

Không thể gộp, sẽ báo lỗi nếu trùng tên.

```ts
type User = { name: string }; // Error nếu khai báo lại.
```

---

## 4. Tính linh hoạt

### Interface:

Chỉ định nghĩa kiểu object, không thể mô tả union, tuple, hay primitive.

```ts
interface UserID extends string {} // ❌ Không hợp lệ!
```

### Type:

Linh hoạt hơn, có thể định nghĩa bất kỳ kiểu nào:

```ts
type UserID = string; // Primitive ✅
type Coordinates = [number, number]; // Tuple ✅
type Result = { data: string } | { error: string }; // Union ✅
```

---

## 5. Mapped Types và Utility Types

### Type:

Hỗ trợ mapped types và các utility type (như `Pick`, `Omit`).

```ts
type Keys = "name" | "age";
type Person = {
  [K in Keys]: string;
};
```

### Interface:

Không hỗ trợ mapped types trực tiếp. Phải dùng kết hợp với type.

---

## 6. Class Implements

Cả hai đều có thể được dùng để ràng buộc lớp thông qua `implements`.

```ts
interface IPerson {
  name: string;
}

class Person implements IPerson {
  name: string;
}

type PersonType = {
  name: string;
};

class AnotherPerson implements PersonType {
  name: string;
}
```

---

## 7. Hiệu năng

- **Interface**: Được tối ưu tốt hơn trong các trường hợp kế thừa phức tạp, do TypeScript xử lý chúng hiệu quả hơn.
    
- **Type**: Khi dùng với các phép toán phức tạp (như union/intersection), có thể ảnh hưởng đến thời gian biên dịch.
    

---

## 8. Best Practices

### Dùng `interface` khi:

✔ Định nghĩa object shape. ✔ Cần gộp khai báo (declaration merging). ✔ Làm việc với OOP và `implements`.

### Dùng `type` khi:

✔ Cần union, tuple, mapped types. ✔ Định nghĩa alias cho primitive. ✔ Tạo kiểu phức tạp (kết hợp nhiều kiểu).

---

## Tổng kết

|Feature|Interface|Type|
|---|---|---|
|Khai báo đối tượng|✅|✅|
|Union/Tuple|❌|✅|
|Merging|✅|❌|
|Extends|`extends`|`&`|
|Mapped Types|❌|✅|
|Primitive Alias|❌|✅|
|Class Implements|✅|✅|