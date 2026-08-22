Dưới đây là cách trình bày chi tiết cho bài toán nội suy Newton lùi với các mốc cách đều, áp dụng chính xác công thức (6.35) và (6.36) từ slide bài giảng của bạn.

  

### 1. Lập bảng sai phân và xác định bước nhảy

Từ bảng số liệu, các mốc $x$ cách đều nhau với bước nhảy: $h = x_{i+1} - x_i = 1$.

  

Ta lập bảng sai phân tương tự như phương pháp Newton tiến, nhưng đối với **Newton lùi**, ta sẽ lấy các giá trị nằm trên **đường chéo dưới cùng** (xuất phát từ $y_n$ hất ngược lên):

  

|**xi​**|**yi​**|**Sai phân bậc 1**|**Sai phân bậc 2**|**Sai phân bậc 3**|
|---|---|---|---|---|
|$0$|$-2$|$5$|$-7$|$8$|
|$1$|$3$|$-2$|$1$||
|$2$|$1$|**$-1$**|||
|**$3$**|**$0$**||||

_Lưu ý: Các giá trị in đậm ở đường chéo dưới cùng sẽ tương ứng với các hệ số trong công thức (6.35)._

  

### 2. Xác định các hệ số và biến phụ $p$

Dựa vào bảng sai phân và đối chiếu với ký hiệu trên công thức (6.35) cho trường hợp $n = 3$:

  

- Mốc cuối cùng: $x_3 = 3$
    
      
    
- $y_3 = 0$
    
      
    
- $\nabla y_2 = -1$ _(tương ứng vị trí sai phân bậc 1 ở đáy)_
    
      
    
- $\nabla^2 y_1 = 1$ _(tương ứng vị trí sai phân bậc 2 ở đáy)_
    
      
    
- $\nabla^3 y_0 = 8$ _(tương ứng vị trí sai phân bậc 3 ở đáy)_
    
      
    

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

  

- $p + 1 = (x - 3) + 1 = x - 2$
    
      
    
- $p + 2 = (x - 3) + 2 = x - 1$
    
      
    

Ta được đa thức theo biến $x$:

  

$$N_3^{(l)}(x) = -(x - 3) + \frac{1}{2}(x - 3)(x - 2) + \frac{4}{3}(x - 3)(x - 2)(x - 1)$$

Sắp xếp lại các cụm nhân từ bậc thấp đến bậc cao cho thuận mắt:

  

$$N_3^{(l)}(x) = -(x - 3) + \frac{1}{2}(x - 2)(x - 3) + \frac{4}{3}(x - 1)(x - 2)(x - 3)$$

**Kết luận:**

Đa thức nội suy Newton lùi cần tìm là:

$$N_3^{(l)}(x) = -(x - 3) + \frac{1}{2}(x - 2)(x - 3) + \frac{4}{3}(x - 1)(x - 2)(x - 3)$$