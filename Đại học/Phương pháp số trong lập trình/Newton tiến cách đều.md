Công thức trong ảnh `image_9c0747.png` (công thức 6.30) chính là **Công thức đa thức nội suy Newton Tiến dành cho trường hợp các mốc cách đều**, nhưng được viết dưới dạng sử dụng **biến phụ $q$** thay vì viết trực tiếp theo $x$.

  

Việc dùng biến $q$ này sẽ giúp biểu thức nhìn gọn gàng hơn rất nhiều, có quy luật rõ ràng: $q$, rồi $q(q-1)$, rồi $q(q-1)(q-2)$... nối đuôi nhau.

  

Để khớp 100% với form trình bày trên slide của thầy cô, mình sẽ làm lại bài giải sử dụng đúng công thức biến $q$ này để bạn ghi vào bài thi nhé:

  

**Bài làm:**

  

**1. Xác định bước nhảy và lập bảng sai phân**

Từ bảng số liệu, ta thấy các mốc $x$ cách đều nhau một khoảng (bước nhảy): $h = 1$.

Ta có bảng sai phân tiến như sau:

  

|**xi​**|**yi​**|**Sai phân bậc 1 (Δy)**|**Sai phân bậc 2 (Δ2y)**|**Sai phân bậc 3 (Δ3y)**|
|---|---|---|---|---|
|**$0$**|**$-2$**|**$5$**|**$-7$**|**$8$**|
|$1$|$3$|$-2$|$1$||
|$2$|$1$|$-1$|||
|$3$|$0$||||

**2. Xác định các hệ số và biến phụ $q$**

Sử dụng phương pháp nội suy Newton tiến, ta lấy các giá trị nằm trên đường chéo trên cùng của bảng sai phân:

  

- Mốc đầu: $x_0 = 0$
    
      
    
- $y_0 = -2$
    
      
    
- $\Delta y_0 = 5$
    
      
    
- $\Delta^2 y_0 = -7$
    
      
    
- $\Delta^3 y_0 = 8$
    
      
    

Đặt biến phụ $q$ theo công thức (6.31):

  

$$q = \frac{x - x_0}{h} = \frac{x - 0}{1} = x$$

_(Lưu ý: Vì bài này đặc biệt có $x_0 = 0$ và $h = 1$ nên biến $q$ tình cờ bằng đúng biến $x$. Ở các bài khác, bạn cứ bê nguyên biểu thức của $q$ vào nhé)._

  

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