Một phát hiện rất thú vị ở đề bài này: Các mốc $x$ (0, 1, 2, 3) thực chất đang **cách đều nhau** một khoảng bằng 1. Tuy nhiên, nếu đề yêu cầu bạn giải theo hướng "không cách đều", chúng ta sẽ sử dụng phương pháp tổng quát nhất: **Nội suy Newton với Tỷ sai phân** (Divided Differences).

  

Phương pháp này chính là "trùm cuối". Nó không cần quan tâm khoảng cách giữa các $x$ là bao nhiêu, và dĩ nhiên nó dùng được cho cả bài cách đều.

  

Thay vì tính "Sai phân" đơn thuần như lúc nãy, chúng ta sẽ lập **Bảng Tỷ sai phân**.

  

### Bước 1: Trò chơi "Kẻ bảng Tỷ sai phân"

Quy luật của Tỷ sai phân hơi khác một chút: **(Số dưới trừ số trên) chia cho (mốc $x$ xa nhất bên dưới trừ mốc $x$ xa nhất bên trên)**.

  

Dưới đây là bảng chi tiết. Hãy chú ý cách chia ở dưới mẫu số:

  

|**x**|**y**|**Tỷ sai phân bậc 1**|**Tỷ sai phân bậc 2**|**Tỷ sai phân bậc 3**|
|---|---|---|---|---|
|**0**|**-2**||||
|1|3|$\frac{3 - (-2)}{1 - 0} = \mathbf{5}$|||
|2|1|$\frac{1 - 3}{2 - 1} = -2$|$\frac{-2 - 5}{2 - 0} = \mathbf{-3.5}$ (hay $-\frac{7}{2}$)||
|3|0|$\frac{0 - 1}{3 - 2} = -1$|$\frac{-1 - (-2)}{3 - 1} = 0.5$ (hay $\frac{1}{2}$)|$\frac{0.5 - (-3.5)}{3 - 0} = \mathbf{\frac{4}{3}}$|

**Giải thích cách chia ở mẫu số (để bạn không bị nhầm lẫn):**

  

- **Bậc 1:** Chỉ liên quan 2 hàng liền kề, ví dụ tính số $5$: ta lấy $(y \text{ tại } x=1) - (y \text{ tại } x=0)$ nên mẫu số là $1 - 0$.
    
      
    
- **Bậc 2:** Liên quan 3 hàng. Ví dụ tính số $-3.5$: nó được tạo ra từ hàng có $x=2$ và $x=0$, nên mẫu số là $2 - 0$.
    
      
    
- **Bậc 3:** Liên quan 4 hàng. Tính số $\frac{4}{3}$: nó bao trùm từ $x=3$ về tận $x=0$, nên mẫu số là $3 - 0$.
    
      
    

### Bước 2: "Hái quả" trên đường chéo

Tương tự như phương pháp trước, vì gọi là "Newton tiến", chúng ta chỉ quan tâm đến hàng chéo trên cùng của bảng (những số in đậm):

  

- $y_0 = -2$
    
      
    
- Tỷ sai phân bậc 1: $f[x_0, x_1] = 5$
    
      
    
- Tỷ sai phân bậc 2: $f[x_0, x_1, x_2] = -\frac{7}{2}$
    
      
    
- Tỷ sai phân bậc 3: $f[x_0, x_1, x_2, x_3] = \frac{4}{3}$
    
      
    

### Bước 3: Lắp ráp vào công thức tổng quát

Khuôn mẫu của công thức Newton tổng quát (cho mốc không cách đều) dùng trực tiếp $x$ và các mốc $x_0, x_1, x_2...$ chứ không cần tính trung gian qua biến $t$:

  

$$N(x) = y_0 + f[x_0, x_1](x - x_0) + f[x_0, x_1, x_2](x - x_0)(x - x_1) + f[x_0, x_1, x_2, x_3](x - x_0)(x - x_1)(x - x_2)$$

Bây giờ bạn rải các "nguyên liệu" thu được ở Bước 2 vào, kết hợp với các mốc $x$ tương ứng ($x_0=0, x_1=1, x_2=2$):

  

$$N(x) = -2 + 5(x - 0) - \frac{7}{2}(x - 0)(x - 1) + \frac{4}{3}(x - 0)(x - 1)(x - 2)$$

Viết gọn lại (chỉ bỏ con số 0 đi):

  

$$N(x) = -2 + 5x - \frac{7}{2}x(x - 1) + \frac{4}{3}x(x - 1)(x - 2)$$

**Bạn thấy điều kỳ diệu chứ?**

Kết quả đa thức này **giống y hệt 100%** với đa thức chúng ta tính bằng Newton có biến $t$ (mốc cách đều) ở phần trước! Toán học luôn thống nhất với nhau, dù đi bằng đường nào thì cũng về chung một đích.

  

Bạn đã nắm được quy luật tính mẫu số trong bảng Tỷ sai phân chưa, hay có cột nào làm bạn thấy băn khoăn không?