
## 1. Cài đặt pnpm

### Sử dụng winget (Windows)

Nếu đã cài đặt `winget`, bạn có thể cài đặt `pnpm` bằng lệnh sau:

```bash
winget install -e --id pnpm.pnpm
```

### Sử dụng npm (Nếu đã cài đặt Node.js)

```bash
npm install -g pnpm
```

### Sử dụng Corepack (Node.js 16.10 trở lên)

```bash
corepack enable
pnpm --version
```

---

## 2. Xóa thư mục `node_modules`

### Trong PowerShell:

```bash
Remove-Item -Recurse -Force .\node_modules
```

### Trong Git Bash:

```bash
rm -rf node_modules
```

### Trong Command Prompt (CMD):

```bash
rmdir /s /q node_modules
```

---

## 3. Cài đặt dependencies

```bash
pnpm install
```

## 4. Chạy dự án

```bash
pnpm run dev
```