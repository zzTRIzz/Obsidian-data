<br>

## 1. So sánh const, let, và var trong JavaScript

### var

- Khai báo biến truyền thống trong JavaScript (trước ES5).
    
- Phạm vi toàn cục (global scope) hoặc phạm vi hàm (function scope).
    
- Cho phép khai báo lại (re-declaration) và gán lại giá trị (re-assignment).
    
- Có hiện tượng "hoisting" (đưa lên đầu scope nhưng giá trị là `undefined` nếu chưa gán).
    

### let

- Giới thiệu trong ES6 (2015).
    
- Phạm vi khối (block scope, trong `{}` của if, for, v.v.).
    
- Không cho phép khai báo lại trong cùng scope, nhưng có thể gán lại giá trị.
    
- Không bị hoisting như `var` (chỉ được dùng sau khi khai báo).
    

### const

- Giới thiệu trong ES6.
    
- Phạm vi khối (block scope).
    
- Không cho phép khai báo lại hoặc gán lại giá trị (giá trị bất biến). Tuy nhiên, nếu là object hoặc array, các phần tử bên trong vẫn có thể thay đổi.
    
- Phải gán giá trị ngay khi khai báo.
    

### Ví dụ trong JavaScript:

```js
// var
var x = 10;
var x = 20; // OK, khai báo lại được
x = 30;     // OK, gán lại được
console.log(x); // 30

// let
let y = 10;
// let y = 20; // Lỗi: không thể khai báo lại
y = 20;        // OK, gán lại được
console.log(y); // 20

// const
const z = 10;
// z = 20;     // Lỗi: không thể gán lại
// const z = 30; // Lỗi: không thể khai báo lại
const arr = [1, 2, 3];
arr[0] = 4;    // OK, thay đổi nội dung mảng
console.log(arr); // [4, 2, 3]
```

## 2. So sánh với Java

### Trong Java:

- `int`, `String`, v.v.: Tương tự `let`, có thể gán lại giá trị nếu không khai báo với `final`.
    
- `final`: Tương tự `const`, không thể gán lại giá trị sau khi khởi tạo, nhưng nếu là object, các thuộc tính bên trong vẫn có thể thay đổi.
    
- Không có "hoisting" như `var` trong JavaScript.
    

### Ví dụ trong Java:

```java
public class Main {
    public static void main(String[] args) {
        // Tương tự let
        int x = 10;
        x = 20; // OK, gán lại được
        // int x = 30; // Lỗi: không thể khai báo lại trong cùng scope
        System.out.println(x); // 20

        // Tương tự const
        final int y = 10;
        // y = 20; // Lỗi: không thể gán lại
        System.out.println(y); // 10

        final int[] arr = {1, 2, 3};
        arr[0] = 4; // OK, thay đổi nội dung mảng
        // arr = new int[]{5, 6, 7}; // Lỗi: không thể gán lại tham chiếu
        System.out.println(arr[0]); // 4
    }
}
```

## 3. So sánh với Java Spring Boot

Java Spring Boot không thay đổi cách khai báo biến trong Java, nhưng `final` thường được sử dụng cho các biến bất biến như hằng số cấu hình (`static final`) hoặc dependency injection.

### Ví dụ trong Spring Boot:

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    private final String MY_CONSTANT = "Hello"; // Tương tự const
    private final SomeDependency dependency;

    @Autowired
    public MyService(SomeDependency dependency) {
        this.dependency = dependency; // final nên chỉ gán 1 lần
    }
}
```

## 4. Cái nào hay dùng hơn?

### Trong JavaScript:

- `const`: Được khuyến khích khi giá trị không cần thay đổi, giúp code rõ ràng và tránh lỗi vô tình gán lại.
    
- `let`: Dùng khi cần thay đổi giá trị biến trong phạm vi khối, thay thế cho `var` trong code hiện đại.
    
- `var`: Ít được dùng trong code mới do nhược điểm về scope và hoisting.
    

### Trong Java/Java Spring Boot:

- `final`: Phổ biến khi làm việc với hằng số hoặc đảm bảo tính bất biến trong lập trình hướng đối tượng.
    
- Biến thông thường (không `final`): Tương tự `let`, dùng trong logic thay đổi giá trị.
    

## 5. Kết luận

- Trong JavaScript, ưu tiên `const` và `let`, tránh `var`.
    
- Trong Java và Spring Boot, ưu tiên `final` cho các giá trị không đổi và biến thường cho logic động. Spring Boot không thay đổi cách dùng biến, nhưng `final` thường thấy trong dependency injection.