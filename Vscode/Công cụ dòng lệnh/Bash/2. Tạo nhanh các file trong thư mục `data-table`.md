<br>

## 1. Tạo file đơn giản

Để tạo nhanh các file `columns.tsx` và `data.tsx`, bạn có thể dùng lệnh:

```
touch columns.tsx data.tsx
```

## 2. Tạo thư mục và các file con bên trong

Nếu cần tạo một thư mục `data-table` chứa nhiều file con, sử dụng lệnh sau:

```
mkdir -p data-table && \
touch data-table/columns.tsx && \
touch data-table/data-table.tsx && \
touch data-table/data-table-pagination.tsx && \
touch data-table/data-table-toolbar.tsx && \
touch data-table/data-table-row-actions.tsx
```

### Giải thích câu lệnh:

- `mkdir -p data-table`: Tạo thư mục `data-table` nếu chưa tồn tại.
    
- `touch data-table/columns.tsx`: Tạo file `columns.tsx` trong thư mục `data-table`.
    
- Các lệnh `touch` tiếp theo tạo các file:
    
    - `data-table.tsx`
        
    - `data-table-pagination.tsx`
        
    - `data-table-toolbar.tsx`
        
    - `data-table-row-actions.tsx`
        

## 3. Cấu trúc thư mục sau khi tạo

Sau khi chạy các lệnh trên, bạn sẽ có cấu trúc thư mục như sau:

```
data-table/
│   ├── columns.tsx
│   ├── data-table.tsx
│   ├── data-table-pagination.tsx
│   ├── data-table-toolbar.tsx
│   └── data-table-row-actions.tsx
```

Tài liệu này giúp bạn thiết lập nhanh các file cần thiết trong dự án React/Vite.