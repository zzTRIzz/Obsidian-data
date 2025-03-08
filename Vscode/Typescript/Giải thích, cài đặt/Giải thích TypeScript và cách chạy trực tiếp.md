<br>

## TypeScript cần biên dịch để chạy được

🏗️ **Giống như bản vẽ kiến trúc**: Bản thân bản vẽ không phải là tòa nhà, cần xây dựng để có tòa nhà thực.

TypeScript là phiên bản nâng cao của JavaScript với kiểu dữ liệu tĩnh, nhưng trình duyệt không hiểu trực tiếp.

## Tại sao cần cài đặt TypeScript?

### TypeScript là ngôn ngữ riêng biệt:

- Mở rộng từ JavaScript với thêm kiểu dữ liệu tĩnh.
    
- File có đuôi `.ts` hoặc `.tsx` (cho React).
    

### Trình duyệt chỉ hiểu JavaScript:

- TypeScript phải được **biên dịch (transpile)** thành JavaScript.
    
- Quá trình này cần có **TypeScript Compiler**.
    

## Cách cài đặt và sử dụng TypeScript

### 1. Cài đặt TypeScript

```shell
# Cài đặt TypeScript toàn cục
npm install -g typescript

# Kiểm tra phiên bản TypeScript đã cài
tsc --version
```

### 2. Viết và biên dịch TypeScript

#### a) Tạo file TypeScript

```shell
// File: main.ts
const greeting: string = "Hello, TypeScript!";
console.log(greeting);
```

#### b) Biên dịch file TypeScript thành JavaScript

```shell
# Biên dịch file TypeScript
tsc main.ts
```

Sau khi biên dịch, một file `main.js` sẽ được tạo.

#### c) Chạy file JavaScript

```shell
node main.js
```

### 3. Sử dụng TypeScript trong React (.tsx)

```js
// File: App.tsx
import React from 'react';

const App: React.FC = () => {
  return <h1>Hello, TypeScript with React!</h1>;
};

export default App;
```

## Các phương pháp làm việc với TypeScript

### 1. Biên dịch thủ công

```shell
# Chạy trình biên dịch TypeScript
tsc
```

### 2. Sử dụng môi trường phát triển (IDE) như VS Code

- Cài extension **TypeScript**.
    
- Sử dụng **terminal tích hợp** để biên dịch.
    

### 3. Các công cụ online để thử nghiệm

- TypeScript Playground
    
- [StackBlitz](https://stackblitz.com/) - Môi trường phát triển trực tuyến.
    

## Cấu hình `tsconfig.json`

Tạo file `tsconfig.json` để điều chỉnh cách TypeScript biên dịch.

```
{
  "compilerOptions": {
    "target": "ES6",
    "module": "CommonJS",
    "outDir": "./dist",
    "strict": true
  }
}
```

Sau khi tạo file, chỉ cần chạy:

```
tsc
```

TypeScript sẽ tự động biên dịch tất cả các file `.ts` trong thư mục.

## 3 lưu ý quan trọng

1. **TypeScript chỉ kiểm tra lúc biên dịch**: Sau khi biên dịch, mọi thông tin kiểu dữ liệu biến mất.
    
2. **Cấu hình với** `**tsconfig.json**`: Giúp kiểm soát quá trình biên dịch.
    
3. **Mỗi khi sửa file** `**.ts/.tsx**`, cần biên dịch lại thành JS để thấy thay đổi.
    

---

✅ **Tóm lại:** TypeScript **cần được cài đặt và biên dịch thành JavaScript** trước khi có thể chạy được trong trình duyệt hoặc môi trường Node.js!