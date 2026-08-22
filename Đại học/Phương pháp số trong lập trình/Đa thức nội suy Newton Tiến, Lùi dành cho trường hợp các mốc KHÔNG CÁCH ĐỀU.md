Dù các mốc $x$ đề bài cho là $0, 1, 2, 3$ (thực chất là cách đều), nhưng khi áp dụng phương pháp **Newton cho mốc không cách đều**, chúng ta bắt buộc phải sử dụng **Bảng Tỷ sai phân** thay vì Bảng Sai phân thông thường. Cách làm này mang tính tổng quát và hoàn toàn hợp lệ.

  

Dưới đây là mẫu trình bày liền mạch, chuẩn mực để bạn ghi thẳng vào bài thi:

  

Dưới đây là bản trình bày bài giải đã được điều chỉnh ký hiệu và thứ tự các phép nhân để khớp 100% với công thức trong slide bài giảng `image_9dc900.png`. Bạn có thể yên tâm sử dụng mẫu này để viết vào bài thi nhé:

  

**Bài làm:**

  

**1. Lập bảng tỷ sai phân**

  

Sử dụng công thức tính tỷ sai phân $f[x_i, \dots, x_k] = \frac{f[x_{i+1}, \dots, x_k] - f[x_i, \dots, x_{k-1}]}{x_k - x_i}$, ta có bảng sau:

  

|**xi​**|**yi​**|**Tỷ sai phân bậc 1**|**Tỷ sai phân bậc 2**|**Tỷ sai phân bậc 3**|
|---|---|---|---|---|
|$0$|$-2$||||
|$1$|$3$|$5$|||
|$2$|$1$|$-2$|$-\frac{7}{2}$||
|**$3$**|**$0$**|**$-1$**|**$\frac{1}{2}$**|**$\frac{4}{3}$**|

**2. Xác định các hệ số và xây dựng đa thức**

  

Sử dụng phương pháp nội suy Newton lùi, ta lấy các giá trị nằm trên đường chéo dưới cùng của bảng tỷ sai phân (với $n=3$):

  

- Mốc cuối: $x_3 = 3$
    
      
    
- $y_3 = 0$
    
      
    
- Tỷ sai phân bậc 1: $f[x_2, x_3] = -1$
    
      
    
- Tỷ sai phân bậc 2: $f[x_1, x_2, x_3] = \frac{1}{2}$
    
      
    
- Tỷ sai phân bậc 3: $f[x_0, x_1, x_2, x_3] = \frac{4}{3}$
    
      
    

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