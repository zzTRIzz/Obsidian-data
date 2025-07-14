
```vid
https://www.youtube.com/watch?v=7zNmLhWerng
Title: How to install NextUI in React with Vite
Author: Devtamin
Thumbnail: https://i.ytimg.com/vi/7zNmLhWerng/mqdefault.jpg
AuthorUrl: https://www.youtube.com/@Devtamin
```
Muốn cài 2 thư viện thì vào cài **Shadcn** trước
Rồi tiếp theo vào cài cái này **HeroUI**

# Hướng dẫn cài đặt HeroUI với Tailwind CSS

## 1. Tạo file `.npmrc`

Thêm nội dung sau vào file:

```
public-hoist-pattern[]=*@heroui/*
```

## 2. Chỉnh sửa `tailwind.config.js`

- Thêm dòng import ở đầu file:
    

```
const {heroui} = require("@heroui/react");
```

- Thêm đường dẫn trong `content`:
    

```
content: [
  "./node_modules/@heroui/theme/dist/**/*.{js,ts,jsx,tsx}",
],
```

- Thêm plugin HeroUI vào trong `plugins`:
    

```
plugins: [heroui()],
```

### Code mẫu hoàn chỉnh:

```
// tailwind.config.js
const {heroui} = require("@heroui/react");

/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./node_modules/@heroui/theme/dist/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {},
  },
  darkMode: "class",
  plugins: [heroui()],
};
```

## 3. Cài đặt các package cần thiết

```
pnpm install
pnpm add @heroui/react framer-motion
```

## 4. (Không bắt buộc) Thêm `HeroUIProvider`

Chỉ thực hiện nếu giao diện không hoạt động sau các bước trên.

```
import * as React from "react";
import {HeroUIProvider} from "@heroui/react";

function App() {
  return (
    <HeroUIProvider>
      <YourApplication />
    </HeroUIProvider>
  );
}
```

## Tham khảo video hướng dẫn
https://drive.google.com/drive/folders/1MFJATW2-MGvV9eTy99nBZIqGnekXilAk?usp=drive_link
[Video hướng dẫn từ YouTube](https://www.youtube.com/watch?v=7zNmLhWerng)
