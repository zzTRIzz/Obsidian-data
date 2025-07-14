Trong Tailwind CSS:

- `my-4` sẽ áp dụng cả `margin-top` và `margin-bottom` với giá trị 1rem (16px)
- `mt-4` chỉ áp dụng `margin-top`
- `mb-4` chỉ áp dụng `margin-bottom`

### Các utility class margin trong Tailwind:

- `m-4`: margin ở tất cả các phía (16px)
- `mx-4`: margin trái và phải (16px)
- `my-4`: margin trên và dưới (16px)
- `mt-4`: margin-top (16px)
- `mr-4`: margin-right (16px)
- `mb-4`: margin-bottom (16px)
- `ml-4`: margin-left (16px)

### Các giá trị spacing phổ biến:

- `0`: 0px
- `1`: 0.25rem (4px)
- `2`: 0.5rem (8px)
- `3`: 0.75rem (12px)
- `4`: 1rem (16px)
- `6`: 1.5rem (24px)
- `8`: 2rem (32px)

# Cách áp dụng margin-y (my) cho tất cả phần tử trong component

Để áp dụng margin trên và dưới (my) cho tất cả phần tử trong component của bạn, có một số cách thực hiện:

## 1. Sử dụng space-y trong container

Cách tốt nhất là sử dụng `space-y-4` (hoặc giá trị khác) trong container cha: