Hướng dẫn có code ở trong đường dẫn này :
```cardlink
url: https://www.heroui.com/docs/guide/routing
title: "Routing"
description: "Learn how to integrate client side routing into your HeroUI application."
host: www.heroui.com
favicon: https://www.heroui.com/favicon.ico
image: https://heroui.com/heroui.jpg
```

# Giải thích Routing là gì?

Routing trong ứng dụng web giống như bản đồ dẫn đường trong trung tâm thương mại. Nó giúp bạn di chuyển từ khu này sang khu khác (trang này sang trang khác) mà không cần "đi bộ xa" (tải lại toàn bộ trang). Đặc biệt với HeroUI Components, bạn có thể dùng các thành phần như Tabs, Dropdown, hay Link để "lướt" qua các trang một cách mượt mà nhờ client-side router.

## Routing là gì?

Hãy tưởng tượng bạn đang ở trung tâm thương mại. Không có bản đồ (routing), mỗi lần muốn sang cửa hàng khác, bạn phải ra ngoài, vào lại từ đầu – chậm chạp và mệt mỏi (full page reload). Routing là tấm bản đồ thông minh, dẫn bạn đi thẳng tới nơi mà không cần rời khỏi tòa nhà.

## Client-side router làm gì?

Thay vì nhờ trình duyệt tải lại trang (như đi bộ ra ngoài), nó "vẽ lại" nội dung ngay trong ứng dụng. Nhanh như búng tay!

## HeroUIProvider trong vai trò gì?

Nó giống như người hướng dẫn viên trong trung tâm thương mại. Bạn chỉ cần nói "Tôi muốn tới khu Home" (`href="/home"`), nó sẽ dẫn bạn đi đúng đường bằng router bạn chọn (như TanStack Router).

## Ví dụ thực tế

Trong một ứng dụng, bạn nhấp vào tab "About" (`href="/about"`). Thay vì tải lại cả trang web, client-side router chỉ thay đổi phần nội dung thành trang About – nhanh gọn như đổi kênh TV.

## Cách HeroUI Components dùng Routing

- **Cài đặt đơn giản**: Đặt `HeroUIProvider` ở gốc ứng dụng, cung cấp router (như TanStack). Từ đó, mọi thành phần như Tabs, Listbox, Dropdown đều tự động dùng router để điều hướng.
    
- **Ví dụ ẩn dụ**: Bạn đưa bản đồ (router) cho hướng dẫn viên (`HeroUIProvider`). Sau đó, dù bạn chọn đi bằng cầu thang (Tabs), thang máy (Dropdown), hay lối tắt (Link), hướng dẫn viên đều biết đường!
    

## Code minh họa (dùng TanStack Router):

```js
import { HeroUIProvider } from "@heroui/react";
import { createRouter } from "@tanstack/react-router";

const router = createRouter({ /* config */ });

function App() {
  return (
    <HeroUIProvider navigate={router.navigate} useHref={router.buildLocation}>
      <Tabs aria-label="Navigation">
        <Tab key="home" href="/home">Home</Tab>
        <Tab key="about" href="/about">About</Tab>
      </Tabs>
    </HeroUIProvider>
  );
}
```

`href="/home"`: Bạn nói "Đưa tôi tới Home", `HeroUIProvider` dùng `router.navigate` để chuyển hướng mà không reload.

## Bảng so sánh Routing truyền thống vs Client-side:

|Tiêu chí|Truyền thống (Browser)|Client-side (HeroUI + Router)|
|---|---|---|
|Tốc độ|Chậm như đi bộ vòng quanh|Nhanh như đi thang máy|
|Trải nghiệm|Giật cục, reload toàn bộ|Mượt mà, chỉ đổi nội dung|
|Ví dụ trung tâm|Ra ngoài, vào lại cửa chính|Đi thẳng bằng lối trong|

### Tone hài hước

Routing truyền thống giống như bà cô chậm chạp, cứ "Đợi tí, để tôi tải lại cả thế giới!". Còn client-side routing thì như anh bạn năng động: "Xong ngay, đi đâu cũng được!" 🚀

Hy vọng bạn thấy Routing với HeroUI dễ hiểu hơn rồi nhé! Có muốn mình giải thích thêm phần nào không? Chẳng hạn như cách tích hợp sâu hơn với TanStack Router?