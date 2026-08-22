Công thức trong ảnh `image_9c0747.png` (công thức 6.30) chính là **Công thức đa thức nội suy Newton Tiến dành cho trường hợp các mốc cách đều**, nhưng được viết dưới dạng sử dụng **biến phụ $q$** thay vì viết trực tiếp theo $x$.

Việc dùng biến $q$ này sẽ giúp biểu thức nhìn gọn gàng hơn rất nhiều, có quy luật rõ ràng: $q$, rồi $q(q-1)$, rồi $q(q-1)(q-2)$... nối đuôi nhau.

Để khớp 100% với form trình bày trên slide của thầy cô, mình sẽ làm lại bài giải sử dụng đúng công thức biến $q$ này để bạn ghi vào bài thi nhé:

**Bài làm:**

**1. Xác định bước nhảy và lập bảng sai phân**
Từ bảng số liệu, ta thấy các mốc $x$ cách đều nhau một khoảng (bước nhảy): $h = 1$.
Ta có bảng sai phân tiến như sau:

| $x_i$ | $y_i$ | Sai phân bậc 1 ($\Delta y$) | Sai phân bậc 2 ($\Delta^2 y$) | Sai phân bậc 3 ($\Delta^3 y$) |
| --- | --- | --- | --- | --- |
| **$0$** | **$-2$** | **$5$** | **$-7$** | **$8$** |
| $1$ | $3$ | $-2$ | $1$ |  |
| $2$ | $1$ | $-1$ |  |  |
| $3$ | $0$ |  |  |  |

**2. Xác định các hệ số và biến phụ $q$**
Sử dụng phương pháp nội suy Newton tiến, ta lấy các giá trị nằm trên đường chéo trên cùng của bảng sai phân:

* Mốc đầu: $x_0 = 0$
* $y_0 = -2$
* $\Delta y_0 = 5$
* $\Delta^2 y_0 = -7$
* $\Delta^3 y_0 = 8$

Đặt biến phụ $q$ theo công thức (6.31):


$$q = \frac{x - x_0}{h} = \frac{x - 0}{1} = x$$


*(Lưu ý: Vì bài này đặc biệt có $x_0 = 0$ và $h = 1$ nên biến $q$ tình cờ bằng đúng biến $x$. Ở các bài khác, bạn cứ bê nguyên biểu thức của $q$ vào nhé).*

**3. Xây dựng đa thức nội suy**
Công thức tổng quát của đa thức nội suy Newton tiến cho mốc cách đều xuất phát từ $x_0$ (công thức 6.30) là:


$$N_n^{(t)}(x) = y_0 + \frac{\Delta y_0}{1!}q + \frac{\Delta^2 y_0}{2!}q(q-1) + \dots + \frac{\Delta^n y_0}{n!}q(q-1)\dots(q-n+1)$$

Áp dụng cho bài toán với $n=3$, đa thức có dạng:


$$N_3^{(t)}(x) = y_0 + \frac{\Delta y_0}{1!}q + \frac{\Delta^2 y_0}{2!}q(q-1) + \frac{\Delta^3 y_0}{3!}q(q-1)(q-2)$$

Thay các giá trị đã tìm được vào công thức:


$$N_3^{(t)}(x) = -2 + \frac{5}{1}q - \frac{7}{2}q(q-1) + \frac{8}{6}q(q-1)(q-2)$$

Thay $q = x$ trở lại và rút gọn phân số, ta được:


$$N_3^{(t)}(x) = -2 + 5x - \frac{7}{2}x(x-1) + \frac{4}{3}x(x-1)(x-2)$$

**Kết luận:** Đa thức nội suy Newton tiến cần tìm là:


$$N_3^{(t)}(x) = -2 + 5x - \frac{7}{2}x(x-1) + \frac{4}{3}x(x-1)(x-2)$$ 
---


Dưới đây là cách trình bày chi tiết cho bài toán nội suy Newton lùi với các mốc cách đều, áp dụng chính xác công thức (6.35) và (6.36) từ slide bài giảng của bạn.

### 1. Lập bảng sai phân và xác định bước nhảy

Từ bảng số liệu, các mốc $x$ cách đều nhau với bước nhảy: $h = x_{i+1} - x_i = 1$.

Ta lập bảng sai phân tương tự như phương pháp Newton tiến, nhưng đối với **Newton lùi**, ta sẽ lấy các giá trị nằm trên **đường chéo dưới cùng** (xuất phát từ $y_n$ hất ngược lên):

| $x_i$ | $y_i$ | Sai phân bậc 1 | Sai phân bậc 2 | Sai phân bậc 3 |
| --- | --- | --- | --- | --- |
| $0$ | $-2$ | $5$ | $-7$ | $8$ |
| $1$ | $3$ | $-2$ | $1$ |  |
| $2$ | $1$ | **$-1$** |  |  |
| **$3$** | **$0$** |  |  |  |

*Lưu ý: Các giá trị in đậm ở đường chéo dưới cùng sẽ tương ứng với các hệ số trong công thức (6.35).*

### 2. Xác định các hệ số và biến phụ $p$

Dựa vào bảng sai phân và đối chiếu với ký hiệu trên công thức (6.35) cho trường hợp $n = 3$:

* Mốc cuối cùng: $x_3 = 3$
* $y_3 = 0$
* $\nabla y_2 = -1$ *(tương ứng vị trí sai phân bậc 1 ở đáy)*
* $\nabla^2 y_1 = 1$ *(tương ứng vị trí sai phân bậc 2 ở đáy)*
* $\nabla^3 y_0 = 8$ *(tương ứng vị trí sai phân bậc 3 ở đáy)*

Theo công thức (6.36), ta đặt biến phụ $p$:


$$p = \frac{x - x_n}{h} = \frac{x - 3}{1} = x - 3$$

### 3. Xây dựng đa thức nội suy Newton lùi

Áp dụng công thức (6.35) cho bài toán với $n=3$, đa thức nội suy Newton lùi có dạng:


$$N_3^{(l)}(x) = y_3 + \frac{\nabla y_2}{1!}p + \frac{\nabla^2 y_1}{2!}p(p+1) + \frac{\nabla^3 y_0}{3!}p(p+1)(p+2)$$

Thay các hệ số từ bảng sai phân vào công thức:


$$N_3^{(l)}(x) = 0 + \frac{-1}{1}p + \frac{1}{2}p(p+1) + \frac{8}{6}p(p+1)(p+2)$$

Rút gọn biểu thức theo $p$:


$$N_3^{(l)}(x) = -p + \frac{1}{2}p(p+1) + \frac{4}{3}p(p+1)(p+2)$$

Tiếp tục thay biến $p = x - 3$ trở lại biểu thức. Khi đó:

* $p + 1 = (x - 3) + 1 = x - 2$
* $p + 2 = (x - 3) + 2 = x - 1$

Ta được đa thức theo biến $x$:


$$N_3^{(l)}(x) = -(x - 3) + \frac{1}{2}(x - 3)(x - 2) + \frac{4}{3}(x - 3)(x - 2)(x - 1)$$

Sắp xếp lại các cụm nhân từ bậc thấp đến bậc cao cho thuận mắt:


$$N_3^{(l)}(x) = -(x - 3) + \frac{1}{2}(x - 2)(x - 3) + \frac{4}{3}(x - 1)(x - 2)(x - 3)$$

**Kết luận:**
Đa thức nội suy Newton lùi cần tìm là:


$$N_3^{(l)}(x) = -(x - 3) + \frac{1}{2}(x - 2)(x - 3) + \frac{4}{3}(x - 1)(x - 2)(x - 3)$$


Dưới đây là bản trình bày bài giải đã được điều chỉnh ký hiệu và thứ tự các phép nhân để khớp 100% với công thức trong slide bài giảng `image_9dc900.png`. Bạn có thể yên tâm sử dụng mẫu này để viết vào bài thi nhé:

**Bài làm:**

**1. Lập bảng tỷ sai phân**

Sử dụng công thức tính tỷ sai phân $f[x_i, \dots, x_k] = \frac{f[x_{i+1}, \dots, x_k] - f[x_i, \dots, x_{k-1}]}{x_k - x_i}$, ta có bảng sau:

| $x_i$ | $y_i$ | Tỷ sai phân bậc 1 | Tỷ sai phân bậc 2 | Tỷ sai phân bậc 3 |
| --- | --- | --- | --- | --- |
| $0$ | $-2$ |  |  |  |
| $1$ | $3$ | $5$ |  |  |
| $2$ | $1$ | $-2$ | $-\frac{7}{2}$ |  |
| **$3$** | **$0$** | **$-1$** | **$\frac{1}{2}$** | **$\frac{4}{3}$** |

**2. Xác định các hệ số và xây dựng đa thức**

Sử dụng phương pháp nội suy Newton lùi, ta lấy các giá trị nằm trên đường chéo dưới cùng của bảng tỷ sai phân (với $n=3$):

* Mốc cuối: $x_3 = 3$
* $y_3 = 0$
* Tỷ sai phân bậc 1: $f[x_2, x_3] = -1$
* Tỷ sai phân bậc 2: $f[x_1, x_2, x_3] = \frac{1}{2}$
* Tỷ sai phân bậc 3: $f[x_0, x_1, x_2, x_3] = \frac{4}{3}$

Công thức tổng quát của đa thức nội suy Newton lùi (trường hợp mốc không cách đều) xuất phát từ nút $x_n$ có dạng:

$$N_n^{(l)}(x) = y_n + f[x_{n-1}, x_n](x - x_n) + f[x_{n-2}, x_{n-1}, x_n](x - x_{n-1})(x - x_n) + \dots + f[x_0, x_1, \dots, x_n](x - x_1)(x - x_2)\dots(x - x_n)$$

Áp dụng cho bài toán với $n=3$, đa thức có dạng:


$$N_3^{(l)}(x) = y_3 + f[x_2, x_3](x - x_3) + f[x_1, x_2, x_3](x - x_2)(x - x_3) + f[x_0, x_1, x_2, x_3](x - x_1)(x - x_2)(x - x_3)$$

Thay các giá trị tương ứng từ bảng tỷ sai phân vào công thức, ta có:


$$N_3^{(l)}(x) = 0 + (-1)(x - 3) + \frac{1}{2}(x - 2)(x - 3) + \frac{4}{3}(x - 1)(x - 2)(x - 3)$$

Rút gọn biểu thức, ta được:


$$N_3^{(l)}(x) = -(x - 3) + \frac{1}{2}(x - 2)(x - 3) + \frac{4}{3}(x - 1)(x - 2)(x - 3)$$

**Kết luận:** Đa thức nội suy Newton lùi cần tìm là:


$$N_3^{(l)}(x) = -(x - 3) + \frac{1}{2}(x - 2)(x - 3) + \frac{4}{3}(x - 1)(x - 2)(x - 3)$$
Dù các mốc $x$ đề bài cho là $0, 1, 2, 3$ (thực chất là cách đều), nhưng khi áp dụng phương pháp **Newton cho mốc không cách đều**, chúng ta bắt buộc phải sử dụng **Bảng Tỷ sai phân** thay vì Bảng Sai phân thông thường. Cách làm này mang tính tổng quát và hoàn toàn hợp lệ.

Dưới đây là mẫu trình bày liền mạch, chuẩn mực để bạn ghi thẳng vào bài thi:

**Bài làm:**

**1. Lập bảng tỷ sai phân**
Sử dụng công thức tính tỷ sai phân $f[x_i, \dots, x_k] = \frac{f[x_{i+1}, \dots, x_k] - f[x_i, \dots, x_{k-1}]}{x_k - x_i}$, ta có bảng sau:

| $x_i$ | $y_i$ | Tỷ sai phân bậc 1 | Tỷ sai phân bậc 2 | Tỷ sai phân bậc 3 |
| --- | --- | --- | --- | --- |
| $0$ | $-2$ |  |  |  |
| $1$ | $3$ | $5$ |  |  |
| $2$ | $1$ | $-2$ | $-\frac{7}{2}$ |  |
| **$3$** | **$0$** | **$-1$** | **$\frac{1}{2}$** | **$\frac{4}{3}$** |

**2. Xác định các hệ số và xây dựng đa thức**
Sử dụng phương pháp nội suy Newton lùi (nội suy tại lân cận nút cuối), ta lấy các giá trị nằm trên **đường chéo dưới cùng** của bảng tỷ sai phân:

* Mốc cuối: $x_3 = 3$
* $f(x_3) = 0$
* Tỷ sai phân bậc 1: $f[x_2, x_3] = -1$
* Tỷ sai phân bậc 2: $f[x_1, x_2, x_3] = \frac{1}{2}$
* Tỷ sai phân bậc 3: $f[x_0, x_1, x_2, x_3] = \frac{4}{3}$

Công thức tổng quát của đa thức nội suy Newton lùi cho mốc không cách đều xuất phát từ $x_n$ là:


$$N(x) = f(x_n) + f[x_{n-1}, x_n](x - x_n) + f[x_{n-2}, x_{n-1}, x_n](x - x_n)(x - x_{n-1}) + \dots + f[x_0, \dots, x_n](x - x_n)\dots(x - x_1)$$

Thay các giá trị từ bảng tỷ sai phân vào công thức, ta có:


$$N(x) = 0 + (-1)(x - 3) + \frac{1}{2}(x - 3)(x - 2) + \frac{4}{3}(x - 3)(x - 2)(x - 1)$$

Rút gọn lại ta được:


$$N(x) = -(x - 3) + \frac{1}{2}(x - 3)(x - 2) + \frac{4}{3}(x - 3)(x - 2)(x - 1)$$

**Kết luận:** Đa thức nội suy Newton lùi cần tìm là:


$$N(x) = -(x - 3) + \frac{1}{2}(x - 3)(x - 2) + \frac{4}{3}(x - 3)(x - 2)(x - 1)$$

