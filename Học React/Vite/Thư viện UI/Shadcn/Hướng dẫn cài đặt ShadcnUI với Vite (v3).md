<br>

[Vào trang chủ cài đặt Shadcn/ui](https://ui.shadcn.com/docs/installation/vite)
## 1. Cài đặt Tailwind CSS

Do **shadcn/ui** yêu cầu **Tailwind CSS**, trước tiên cần cài đặt phiên bản **v3**:

```
pnpm add -D tailwindcss@3 postcss autoprefixer
```

Sau đó, khởi tạo cấu hình Tailwind:

```
tailwindcss init -p
```

---

## 2. Cài đặt shadcn/ui

Chạy lệnh sau để cài đặt **shadcn/ui**:

```
pnpm dlx shadcn-ui@latest init
```

Khi được hỏi về framework, chọn **Vite**.

---

## 3. Cấu hình Tailwind CSS

Mở file `tailwind.config.cjs` hoặc `tailwind.config.js` và cập nhật như sau:

```
/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    './index.html',
    './src/**/*.{js,ts,jsx,tsx}',
    './components/**/*.{js,ts,jsx,tsx}',
  ],
  theme: {
    extend: {},
  },
  plugins: [],
};
```

---

## 4. Kiểm tra kết quả

Tạo một component React để kiểm tra **shadcn/ui**:

```
import { Button } from '@/components/ui/button';

export default function App() {
  return (
    <div className="flex justify-center items-center h-screen">
      <Button variant="default">Click me</Button>
    </div>
  );
}
```

---

## 5. Lưu ý

- **Sử dụng phiên bản v3** do v4 có nhiều thay đổi và tài liệu hướng dẫn còn hạn chế.
    
- **Đảm bảo Tailwind CSS được cấu hình đúng** để shadcn/ui hoạt động mượt mà.
    
- **Kiểm tra alias trong** `**tsconfig.json**` **hoặc** `**vite.config.js**` nếu có lỗi import component.