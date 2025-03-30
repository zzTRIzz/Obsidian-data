<br>

Trong JavaScript, có hai loại kiểu dữ liệu chính:

## 1. Kiểu dữ liệu nguyên thủy (Primitive Types)

Các kiểu dữ liệu nguyên thủy bao gồm:

- `number`
    
- `string`
    
- `boolean`
    
- `null`
    
- `undefined`
    
- `symbol`
    
- `bigint`
    

Các giá trị này được **sao chép trực tiếp**, có nghĩa là khi gán một giá trị từ biến này sang biến khác, chúng **hoàn toàn độc lập** và không ảnh hưởng đến nhau.

Ví dụ:

```js
let a = 5;
let b = a;  // b sẽ có giá trị 5, độc lập với a
a = 10;
console.log(b);  // In ra 5, không ảnh hưởng gì từ a
```

## 2. Kiểu dữ liệu tham chiếu (Reference Types)

Các kiểu dữ liệu tham chiếu bao gồm:

- `object`
    
- `array`
    
- `function`
    

Khi sao chép một đối tượng hoặc mảng, JavaScript **không sao chép giá trị bên trong**, mà chỉ sao chép địa chỉ bộ nhớ nơi đối tượng đó được lưu trữ. Do đó, khi thay đổi giá trị trong đối tượng này, những thay đổi đó cũng ảnh hưởng đến các biến khác cùng tham chiếu đến đối tượng đó.

Ví dụ:

```js
let a = { name: "Alice" };
let b = a;  // b tham chiếu đến cùng một đối tượng với a
a.name = "Bob";
console.log(b.name);  // In ra "Bob", vì a và b đều tham chiếu đến cùng một đối tượng
```

---

## 3. Vấn đề trong mã của bạn

Trong đoạn mã của bạn, bạn đang làm việc với mảng `accounts`, trong đó mỗi phần tử là một đối tượng. Khi thực hiện cú pháp:

```js
const [...restsss] = accounts;
```

Bạn tạo ra một **bản sao mới của mảng** `accounts`, nhưng **các đối tượng bên trong vẫn được sao chép theo tham chiếu**.

Điều này có nghĩa là nếu bạn thay đổi thuộc tính của một đối tượng trong `restsss`, mảng `accounts` cũng bị ảnh hưởng.

Ví dụ:

```js
const accounts = [
    { id: 1, name: "Nguyễn Văn A", birthday: "2000-01-01", status: true },
    { id: 2, name: "Nguyễn Văn B", birthday: "2000-02-02", status: false }
];

const [...restsss] = accounts;  // restsss là một bản sao của mảng accounts

// Thay đổi tên trong mảng restsss
restsss[0].name = "Nguyễn Văn C";

console.log(accounts[0].name);  // In ra "Nguyễn Văn C"
console.log(restsss[0].name);   // Cũng in "Nguyễn Văn C"
```

Ở đây, mặc dù `restsss` là một mảng mới, nhưng do **tính chất tham chiếu của đối tượng**, khi bạn thay đổi `restsss[0].name`, giá trị trong `accounts[0]` cũng bị thay đổi.

---

## 4. Cách tránh vấn đề này

Nếu bạn muốn **sao chép hoàn toàn** các đối tượng, bạn cần sử dụng **deep copy** thay vì chỉ sao chép mảng hoặc đối tượng. Một trong những cách đơn giản nhất là sử dụng `JSON.parse(JSON.stringify(obj))` để tạo một bản sao sâu:

```js
const restsss = JSON.parse(JSON.stringify(accounts));  // deep copy mảng
restsss[0].name = "Nguyễn Văn C";

console.log(accounts[0].name);  // In ra "Nguyễn Văn A", không thay đổi
console.log(restsss[0].name);   // In ra "Nguyễn Văn C"
```

Cách này giúp sao chép **toàn bộ đối tượng**, tránh việc thay đổi không mong muốn trong mảng gốc.

---

## 5. Tóm lại

✅ **Tính chất tham chiếu** có nghĩa là khi bạn sao chép một đối tượng hoặc mảng, bạn chỉ sao chép địa chỉ bộ nhớ, không phải giá trị thực sự.

✅ Khi thay đổi một đối tượng trong mảng sao chép **theo tham chiếu**, thay đổi đó cũng ảnh hưởng đến mảng gốc.

✅ Để sao chép mảng hoặc đối tượng mà **không thay đổi mảng gốc**, bạn cần sử dụng **deep copy**.

Hy vọng giải thích này giúp bạn hiểu rõ hơn về tính chất tham chiếu và cách xử lý nó trong JavaScript! 🚀