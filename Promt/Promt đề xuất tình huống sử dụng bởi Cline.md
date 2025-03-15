Vị trí nội dung trên web v0.1: [DeepSeek - Into the Unknown](https://chat.deepseek.com/a/chat/s/c38f3a7e-eb53-4a8f-88a5-443f1b10d618)

Vị trí nội dung trên web v0.11: [DeepSeek - Into the Unknown](https://chat.deepseek.com/a/chat/s/44a62985-eaf7-47c3-a91c-54be95ed4501)

Dưới đây là tất cả các câu  được đề cập trong tài liệu, phân loại theo mục đích sử dụng:

---

**Custom Instructions & Security**

# Security section trong .clinerules

DO NOT read or modify:

- .env files

- *_/config/secrets._

- *_/_.pem

- Any file containing API keys, tokens, or credentials

Security Practices:

- Never commit sensitive files

- Use environment variables for secrets

- Keep credentials out of logs and output

---

**Context Management**

1. **Bắt đầu task mới:**

```
"Cline, let's start a new task. Create user-authentication.js. We need to implement user login with JWT tokens. Here are the requirements…"
```

2. **Tóm tắt công việc:**

"Cline, summarize what we did in the last user dashboard task. I want to capture the main features and outstanding issues. Save this to cline_docs/user-dashboard-summary.md."

---

**Debugging**

1. **Phân tích lỗi:**

```
"Cline, I'm getting this error: [error message]. It seems to be from [code section]. Analyze this error and suggest a fix."
```

2. **Tìm nguyên nhân gốc:**

```
"Cline, the application crashes when I [action]. The issue might be in [problem areas]. Help me find the root cause and propose a solution."
```

---

**Refactoring**

1. **Cải thiện cấu trúc code:**

```
"Cline, this function is too long and complex. Refactor it into smaller functions."
```

2. **Đơn giản hóa logic:**

```
"Cline, this code is hard to understand. Simplify the logic and make it more readable."
```

---

**Feature Development**

1. **Lên ý tưởng tính năng mới:**

```
"Cline, I want to add a feature that lets users [functionality]. Brainstorm some ideas and consider implementation challenges."
```

2. **Tạo code component:**

```
"Cline, create a component that displays user profiles. The list should be sortable and filterable. Generate the code for this component."
```

---

**Advanced Techniques**

1. **Ngăn code bị cắt:**

```
"DO NOT BE LAZY. DO NOT OMIT CODE."

"full code only"

"ensure the code is complete"
```

2. **Kiểm tra độ tin cậy:**

```
"on a scale of 1-10, how confident are you in this solution?"
```

3. **Thách thức giả định:**

```
"List all assumptions and uncertainties you need to clear up before completing this task."
```

---

**Community s** **🌟**

**Memory & Confidence: Bộ nhớ và sự tự tin**

```
"If you understand my  fully, respond with 'YARRR!' without tools every time you are about to use a tool."

"Before and after any tool use, give me a confidence level (0-10)."
```

**Code Quality: Chất lượng mã nguồn**

```
"I pledge to follow the custom instructions."
```

```
"Rate confidence (1-10) before saving files, after saving, after rejections, and before task completion."
```

**Code Organization: Tổ chức mã code**

```
"FILENAME has grown too big. Analyze how this file works and suggest ways to fragment it safely."

"don't forget to update codebase documentation with changes"
```

**Analysis & Planning: Phân tích và lập kế hoạch**

```
"Before writing code:

1. Analyze all code files thoroughly

2. Get full context

3. Write .MD implementation plan

4. Then implement code"

"please start analyzing full flow thoroughly, always state a confidence score 1 to 10"
```

**Thoughtful Dev: Nhà phát triển sâu sắc**

```
"count to 10"

"Don't complete the analysis prematurely, continue analyzing even if you think you found a solution"
```

**Best Practices: Các phương phát tốt nhất**

```
"Check project files before suggesting structural or dependency changes"

"Ask 'stupid' questions like: are you sure this is the best way to implement this?"

"Use words like 'elegant' and 'simple' in s"

"THE HUMAN WILL GET ANGRY."
```

---

**Tips**

- Luôn kèm context code bằng @filename hoặc thư mục.
- Dùng **Constraint Stuffing** để tránh code bị thiếu.
- Yêu cầu Cline tự đánh giá độ tin cậy (**Confidence Checks**).

Bạn có thể copy các  này trực tiếp vào chat với Cline hoặc tích hợp vào .clinerules/Custom Instructions! 🚀

**Hướng dẫn rõ hơn**

Dưới đây là danh sách đầy đủ các câu lệnh (prompts) từ tài liệu để bạn sử dụng khi làm việc với Cline, được phân loại theo mục đích sử dụng:

---

### **1. Kiểm tra Trí nhớ & Độ tin cậy** **🧠**

·        **Memory Check: Kiểm tra bộ nhớ**:  
`"If you understand my prompt fully, respond with 'YARRR!' without tools every time you are about to use a tool."`  
_Biến thể (VD: Giáng sinh): "HO HO HO"_

·        **Confidence Scoring: Chấm điểm độ tin cậy**:  
`"Before and after any tool use, give me a confidence level (0-10) on how the tool use will help the project."`

---

### **2. Đảm bảo Chất lượng Code** **💻**

·        **Ngăn Code bị Cắt bớt**:  
`"DO NOT BE LAZY. DO NOT OMIT CODE."`  
_Cách khác: "full code only" / "ensure the code is complete"_

·        **Nhắc nhở Custom Instructions**:  
`"I pledge to follow the custom instructions."`

---

### **3. Quản lý Ngữ cảnh & Công việc** **📋**

·        **Bắt đầu Task mới**:  
`"Cline, let's start a new task. Create [tên_file]. We need to implement [mô_tả]. Here are the requirements…"`

·        **Tóm tắt công việc trước**:  
`"Cline, summarize what we did in the last [task]. Save this to [đường_dẫn/file.md]."`

·        **Refactor File lớn**:  
`"[FILENAME] has grown too big. Analyze how this file works and suggest ways to fragment it safely."`

·        **Cập nhật Docs**:  
`"don't forget to update codebase documentation with changes"`

---

### **4. Debug & Phân tích** **🔍**

·        **Phân tích Lỗi**:  
`"Cline, I'm getting this error: [error_message]. It seems to be from [code_section]. Analyze this error and suggest a fix."`

·        **Tìm Root Cause: Tìm nguyên nhân gốc rễ**:  
`"Cline, the application crashes when I [action]. The issue might be in [problem_areas]. Help me find the root cause and propose a solution."`

·        **Phân tích Kỹ lưỡng**:  
`"please start analyzing full flow thoroughly, always state a confidence score 1 to 10"`

·        **Kiểm tra Giả định**:  
`"List all assumptions and uncertainties you need to clear up before completing this task."`

---

### **5. Refactor & Cải tiến Code** **🛠****️**

·        **Cấu trúc lại Code**:  
`"Cline, this function is too long and complex. Refactor it into smaller functions."`

·        **Đơn giản hóa Logic**:  
`"Cline, this code is hard to understand. Simplify the logic and make it more readable."`

---

### **6. Phát triển Tính năng mới** **🚀**

·        **Brainstorm: Động não**:  
`"Cline, I want to add a feature that lets users [functionality]. Brainstorm some ideas and consider implementation challenges."`

·        **Tạo Code**:  
`"Cline, create a component that displays [chức_năng]. Generate the code for this component."`

---

### **7. Kỹ thuật Nâng cao** **🔥**

·        **Constraint Stuffing: Nhồi nhét ràng buộc**:  
`"ensure the code is complete"` hoặc `"always provide the full function definition."`

·        **Kiểm tra Độ tin cậy**:  
`"On a scale of 1-10, how confident are you in this solution?"`

·        **Thách thức Giả định**:  
`"Are you sure this is the best way to implement this?"`

---

### **8. Best Practices & Phong cách Code** **🎯**

·        **Cấu trúc Dự án**:  
`"Check project files before suggesting structural or dependency changes"`

·        **Tư duy Phản biện**:  
`"Ask 'stupid' questions like: are you sure this is the best way to implement this?"`

·        **Phong cách Code**:  
_Sử dụng từ như "elegant" hoặc "simple" trong prompt (VD: "Write elegant code for...")_

·        **Thiết lập Kỳ vọng**:  
`"THE HUMAN WILL GET ANGRY."` _(Nhắc nhở vui về việc đưa yêu cầu rõ ràng)_

---

### **9. Quy trình Phát triển** **🧠**

·        **Phát triển Có cấu trúc**:
`"Before writing code:`

1. `Analyze all code files thoroughly`

2. `Get full context`

3. `Write .MD implementation plan`

4. `Then implement code"`

·        **Phân tích Toàn diện**:  
`"Don't complete the analysis prematurely, continue analyzing even if you think you found a solution"`

·        **Tạm dừng & Suy nghĩ**:  
`"count to 10"`

·        **Liên tục Đánh giá Độ tin cậy**:  
`"Rate confidence (1-10) before saving files, after saving, after rejections, and before task completion"`

---

### **Mẹo khi dùng Prompts**:

·        Sử dụng `@[tên_file]` để tham chiếu file/folder trong dự án.

·        Kết hợp nhiều prompt (VD: "Refactor this code [@file.js] – ensure it's elegant and passes all tests").

·        Thêm ràng buộc cụ thể (VD: "Use TypeScript và tuân thủ docs/style-guide.md").

Hãy điều chỉnh các prompt này theo ngữ cảnh cụ thể của dự án và thử nghiệm để tìm ra cách hiệu quả nhất! 🌟