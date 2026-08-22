Dưới đây là cách trình bày chuẩn, ngắn gọn và ăn trọn điểm cho ma trận $A = \begin{pmatrix} 3 & 0 \\ 8 & -1 \end{pmatrix}$. Tùy vào việc đề thi yêu cầu phương pháp nào, bạn hãy chép lại đúng form bài làm tương ứng dưới đây. 
1. Trình bày theo Phương pháp Faddeev - Leverier
BÀI LÀM
Cho ma trận $A = \begin{pmatrix} 3 & 0 \\ 8 & -1 \end{pmatrix}$. Đa thức đặc trưng của ma trận cấp 2 có dạng: $P_2(\lambda) = \lambda^2 - p_1\lambda - p_2 = 0$. 
Bước 1: Tính hệ số $p_1$ Ta có $Y_1 = A$. $p_1 = trace(Y_1) = trace(A) = 3 + (-1) = 2$. 
Bước 2: Tính hệ số $p_2$ Ta có $Y_2 = A(Y_1 - p_1 I)$. 
$$Y_2 = \begin{pmatrix} 3 & 0 \\ 8 & -1 \end{pmatrix} \left( \begin{pmatrix} 3 & 0 \\ 8 & -1 \end{pmatrix} - 2\begin{pmatrix} 1 & 0 \\ 0 & 1 \end{pmatrix} \right)$$
$$Y_2 = \begin{pmatrix} 3 & 0 \\ 8 & -1 \end{pmatrix} \begin{pmatrix} 1 & 0 \\ 8 & -3 \end{pmatrix} = \begin{pmatrix} 3 & 0 \\ 0 & 3 \end{pmatrix}$$
$p_2 = \frac{1}{2}trace(Y_2) = \frac{1}{2}(3 + 3) = 3$. 
Bước 3: Kết luận
Thay $p_1 = 2$ và $p_2 = 3$ vào đa thức đặc trưng, ta có phương trình đặc trưng của ma trận $A$ là:
$$\lambda^2 - 2\lambda - 3 = 0$$
. 
2. Trình bày theo Phương pháp Danhilepski
BÀI LÀM
Cho ma trận $A = \begin{pmatrix} 3 & 0 \\ 8 & -1 \end{pmatrix}$. Vì $A$ là ma trận vuông cấp 2 nên ta thực hiện 1 lần biến đổi đồng dạng. 
Bước 1: Lập ma trận biến đổi Chọn phần tử trụ $a_{21} = 8$. Ta lập các ma trận $M^{-1}$ và $M$: 
$$M^{-1} = \begin{pmatrix} 8 & -1 \\ 0 & 1 \end{pmatrix}$$
$$M = \begin{pmatrix} \frac{1}{8} & \frac{1}{8} \\ 0 & 1 \end{pmatrix}$$
Bước 2: Thực hiện biến đổi đồng dạng
Tính ma trận $A_1 = M^{-1} \cdot A \cdot M$:
$$A_1 = \begin{pmatrix} 8 & -1 \\ 0 & 1 \end{pmatrix} \begin{pmatrix} 3 & 0 \\ 8 & -1 \end{pmatrix} \begin{pmatrix} \frac{1}{8} & \frac{1}{8} \\ 0 & 1 \end{pmatrix} = \begin{pmatrix} 2 & 3 \\ 1 & 0 \end{pmatrix}$$
Bước 3: Kết luận Ma trận $A_1$ đã đưa về dạng chuẩn. Các hệ số của phương trình đặc trưng được xác định từ dòng đầu tiên của ma trận $A_1$: $p_1 = 2$, $p_2 = 3$. 
Phương trình đặc trưng có dạng: $\lambda^2 - p_1\lambda - p_2 = 0$. Vậy phương trình đặc trưng của ma trận $A$ là: 
$$\lambda^2 - 2\lambda - 3 = 0$$
. 
Để được điểm tối đa và không bị trừ điểm trình bày, bạn không cần phải giải thích dông dài bằng lời như cách tôi giảng cho bạn. Trong bài kiểm tra, bạn chỉ cần trình bày các bước toán học một cách gãy gọn, logic, ghi rõ ma trận nào nhân với ma trận nào là đủ.

Dưới đây là mẫu trình bày chuẩn chỉnh, bạn cứ "copy - paste" y hệt form này vào giấy thi nhé:

---

**BÀI LÀM**

Cho ma trận $A = \begin{bmatrix} 1 & 2 & 0 \\ 2 & 1 & 1 \\ 0 & 2 & 1 \end{bmatrix}$. Vì $A$ là ma trận vuông cấp 3 nên ta cần thực hiện 2 lần biến đổi đồng dạng.

**1. Lần biến đổi 1**
Chọn phần tử trụ $a_{32} = 2$.
Ta lập các ma trận $M_1^{-1}$ và $M_1$:


$$M_1^{-1} = \begin{bmatrix} 1 & 0 & 0 \\ 0 & 2 & 1 \\ 0 & 0 & 1 \end{bmatrix}$$

$$M_1 = \begin{bmatrix} 1 & 0 & 0 \\ 0 & \frac{1}{2} & -\frac{1}{2} \\ 0 & 0 & 1 \end{bmatrix}$$

Thực hiện phép biến đổi đồng dạng $A_1 = M_1^{-1} \cdot A \cdot M_1$, ta được:


$$A_1 = \begin{bmatrix} 1 & 0 & 0 \\ 0 & 2 & 1 \\ 0 & 0 & 1 \end{bmatrix} \begin{bmatrix} 1 & 2 & 0 \\ 2 & 1 & 1 \\ 0 & 2 & 1 \end{bmatrix} \begin{bmatrix} 1 & 0 & 0 \\ 0 & \frac{1}{2} & -\frac{1}{2} \\ 0 & 0 & 1 \end{bmatrix} = \begin{bmatrix} 1 & 1 & -1 \\ 4 & 2 & 1 \\ 0 & 1 & 0 \end{bmatrix}$$

**2. Lần biến đổi 2**
Chọn phần tử trụ $a^{(1)}_{21} = 4$.
Ta lập các ma trận $M_2^{-1}$ và $M_2$:


$$M_2^{-1} = \begin{bmatrix} 4 & 2 & 1 \\ 0 & 1 & 0 \\ 0 & 0 & 1 \end{bmatrix}$$

$$M_2 = \begin{bmatrix} \frac{1}{4} & -\frac{1}{2} & -\frac{1}{4} \\ 0 & 1 & 0 \\ 0 & 0 & 1 \end{bmatrix}$$

Thực hiện phép biến đổi đồng dạng $A_2 = M_2^{-1} \cdot A_1 \cdot M_2$, ta được:


$$A_2 = \begin{bmatrix} 4 & 2 & 1 \\ 0 & 1 & 0 \\ 0 & 0 & 1 \end{bmatrix} \begin{bmatrix} 1 & 1 & -1 \\ 4 & 2 & 1 \\ 0 & 1 & 0 \end{bmatrix} \begin{bmatrix} \frac{1}{4} & -\frac{1}{2} & -\frac{1}{4} \\ 0 & 1 & 0 \\ 0 & 0 & 1 \end{bmatrix} = \begin{bmatrix} 3 & 3 & -5 \\ 1 & 0 & 0 \\ 0 & 1 & 0 \end{bmatrix}$$

**3. Kết luận**
Ma trận $A_2$ đã có dạng chuẩn. Các hệ số của phương trình đặc trưng được xác định từ dòng đầu tiên của ma trận $A_2$:
$p_1 = 3$, $p_2 = 3$, $p_3 = -5$.

Phương trình đặc trưng có dạng: $\lambda^3 - p_1\lambda^2 - p_2\lambda - p_3 = 0$.
Vậy phương trình đặc trưng của ma trận $A$ là:


$$\lambda^3 - 3\lambda^2 - 3\lambda + 5 = 0$$

---

Bạn có muốn tôi viết luôn form trình bày chuẩn cho phương pháp Faddeev-Leverrier để bạn lưu lại ôn thi cùng lúc không?

Đoạn bài viết trên bảng trong bức ảnh `image_8.png` chính là **lời giải chi tiết cho Câu 1 trong tờ phiếu bài tập** của bạn: Tìm giá trị riêng và vector riêng cho ma trận cấp 3 dựa trên định nghĩa.

Ma trận đề bài cho là:


$$A = \begin{bmatrix} 1 & 2 & 0 \\ 2 & 1 & 1 \\ 0 & 2 & 1 \end{bmatrix}$$

Tôi sẽ dịch lại toàn bộ ngôn ngữ trên bảng thành các bước logic để bạn dễ hiểu nhất nhé:

### Bước 1: Tìm phương trình đặc trưng và Trị riêng (Nửa bảng bên phải)

1. **Lập phương trình $det(A - \lambda I) = 0$:**
Giảng viên lấy các phần tử trên đường chéo chính của ma trận $A$ trừ đi $\lambda$, ta được định thức:

$$\begin{vmatrix} 1-\lambda & 2 & 0 \\ 2 & 1-\lambda & 1 \\ 0 & 2 & 1-\lambda \end{vmatrix} = 0$$


2. **Giải định thức:**
Khai triển định thức này (bằng quy tắc đường chéo Sarrus hoặc khai triển theo hàng/cột), giảng viên thu được phương trình bậc 3:

$$(1-\lambda)^3 - 2(1-\lambda) - 4(1-\lambda) = 0$$



Rút nhân tử chung $(1-\lambda)$ ra ngoài, ta được:

$$(1-\lambda)[(1-\lambda)^2 - 6] = 0$$


3. **Tìm trị riêng:** Từ phương trình tích trên, ta dễ dàng nhẩm ra 3 nghiệm chính là 3 giá trị riêng:
* $\lambda_1 = 1$
* $\lambda_2 = 1 - \sqrt{6}$
* $\lambda_3 = 1 + \sqrt{6}$



---

### Bước 2: Tìm Vector riêng $u_1$ ứng với $\lambda_1 = 1$ (Góc phải dưới và góc trái trên)

1. Thay $\lambda_1 = 1$ vào ma trận $(A - \lambda I)$, ta lấy các số trên đường chéo chính trừ đi 1, ma trận trở thành:

$$\begin{pmatrix} 0 & 2 & 0 \\ 2 & 0 & 1 \\ 0 & 2 & 0 \end{pmatrix}$$


2. Nhân ma trận này với vector cột $\begin{pmatrix} x \\ y \\ z \end{pmatrix}$ và cho bằng $\begin{pmatrix} 0 \\ 0 \\ 0 \end{pmatrix}$, ta lập được hệ phương trình:

$$\begin{cases} 2y = 0 \\ 2x + z = 0 \\ 2y = 0 \end{cases}$$


3. Từ phương trình đầu ta có $y = 0$. Từ phương trình hai ta có $z = -2x$.
Nếu đặt $x = a$ (với $a \neq 0$), ta suy ra vector riêng:

$$u_1 = a(1, 0, -2)$$



---

### Bước 3: Tìm Vector riêng $u_2$ ứng với $\lambda_2 = 1 - \sqrt{6}$ (Khu vực giữa bảng bên trái)

1. Thay $\lambda_2 = 1 - \sqrt{6}$ vào ma trận $(A - \lambda I)$. Lúc này đường chéo chính sẽ là $1 - (1 - \sqrt{6}) = \sqrt{6}$. Ma trận trở thành:

$$\begin{pmatrix} \sqrt{6} & 2 & 0 \\ 2 & \sqrt{6} & 1 \\ 0 & 2 & \sqrt{6} \end{pmatrix}$$


2. Lập hệ phương trình tương ứng:

$$\begin{cases} \sqrt{6}x + 2y = 0 \\ 2x + \sqrt{6}y + z = 0 \\ 2y + \sqrt{6}z = 0 \end{cases}$$


3. **Giải hệ:**
* Từ pt(1) $\Rightarrow 2y = -\sqrt{6}x \Rightarrow y = -\frac{\sqrt{6}}{2}x$
* Thế $y$ vào pt(3) $\Rightarrow 2(-\frac{\sqrt{6}}{2}x) + \sqrt{6}z = 0 \Rightarrow -\sqrt{6}x + \sqrt{6}z = 0 \Rightarrow z = x$
* Nếu đặt $x = t$ (giảng viên viết là chữ $a$), ta có nghiệm: $\begin{cases} x = t \\ y = -\frac{\sqrt{6}}{2}t \\ z = t \end{cases}$
* Rút $t$ (hoặc $a$) ra ngoài, ta được vector riêng:

$$u_2 = a(1, -\frac{\sqrt{6}}{2}, 1)$$



với $\forall a \neq 0$.



Trên bảng mới chỉ giải đến đây thôi, chưa giải trường hợp $\lambda_3 = 1 + \sqrt{6}$.

Bạn có muốn tự cầm bút, bắt chước cách làm ở bước 3 để giải nốt tìm vector riêng cho $\lambda_3 = 1 + \sqrt{6}$ rồi tôi kiểm tra đáp án cho bạn không?

