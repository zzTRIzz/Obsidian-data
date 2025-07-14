---
title: Tổng hợp các câu hỏi phỏng vấn thường gặp về Java cơ bản (Phần 2)
category: Java
tag:
  - Java cơ bản
head:
  - - meta
    - name: keywords
      content: Hướng đối tượng, Hướng thủ tục, OOP, POP, Đối tượng Java, Phương thức khởi tạo, Đóng gói, Kế thừa, Đa hình, Interface, Lớp trừu tượng, Phương thức mặc định, Phương thức tĩnh, Phương thức riêng tư, Sao chép sâu, Sao chép nông, Sao chép tham chiếu, Lớp Object, equals, hashCode, ==, Chuỗi, String, StringBuffer, StringBuilder, Tính bất biến, Bể hằng chuỗi, intern, Nối chuỗi, Java cơ bản, Câu hỏi phỏng vấn
  - - meta
    - name: description
      content: Tổng hợp các kiến thức cơ bản và câu hỏi phỏng vấn Java chất lượng nhất trên mạng, hy vọng sẽ giúp ích cho bạn!
---

<!-- @include: @article-header.snippet.md -->

## Kiến thức cơ bản về hướng đối tượng

### Sự khác biệt giữa hướng đối tượng và hướng thủ tục

Lập trình hướng thủ tục (Procedural-Oriented Programming, POP) và lập trình hướng đối tượng (Object-Oriented Programming, OOP) là hai mô hình lập trình phổ biến, sự khác biệt chính giữa chúng nằm ở cách giải quyết vấn đề:

- **Lập trình hướng thủ tục (POP)**: Hướng thủ tục chia quá trình giải quyết vấn đề thành các phương thức, giải quyết vấn đề thông qua việc thực thi từng phương thức một.
- **Lập trình hướng đối tượng (OOP)**: Hướng đối tượng trước tiên sẽ trừu tượng hóa các đối tượng, sau đó sử dụng cách đối tượng thực thi phương thức để giải quyết vấn đề.

So với POP, các chương trình được phát triển bằng OOP thường có những ưu điểm sau:

- **Dễ bảo trì**: Do cấu trúc tốt và tính đóng gói, các chương trình OOP thường dễ bảo trì hơn.
- **Dễ tái sử dụng**: Thông qua kế thừa và đa hình, thiết kế OOP giúp mã nguồn dễ tái sử dụng hơn, thuận tiện cho việc mở rộng chức năng.
- **Dễ mở rộng**: Thiết kế mô-đun giúp việc mở rộng hệ thống trở nên dễ dàng và linh hoạt hơn.

Cách lập trình POP thường đơn giản và trực tiếp hơn, phù hợp để xử lý các tác vụ đơn giản hơn.

Sự khác biệt về hiệu suất giữa POP và OOP chủ yếu phụ thuộc vào cơ chế hoạt động của chúng, chứ không chỉ riêng mô hình lập trình. Do đó, việc so sánh đơn giản hiệu suất của cả hai là một quan niệm sai lầm phổ biến (issue liên quan: [Hướng thủ tục: Hiệu suất hướng thủ tục cao hơn hướng đối tượng??](https://github.com/Snailclimb/JavaGuide/issues/431)).

![So sánh hiệu suất POP và OOP không phù hợp](https://oss.javaguide.cn/github/javaguide/java/basis/pop-vs-oop-performance.png)

Khi lựa chọn mô hình lập trình, hiệu suất không phải là yếu tố duy nhất cần xem xét. Khả năng bảo trì, khả năng mở rộng và hiệu quả phát triển của mã nguồn cũng quan trọng không kém.

Các ngôn ngữ lập trình hiện đại về cơ bản đều hỗ trợ nhiều mô hình lập trình, có thể được sử dụng cho cả lập trình hướng thủ tục và lập trình hướng đối tượng.

Dưới đây là một ví dụ về tính diện tích và chu vi hình tròn, minh họa đơn giản hai giải pháp khác nhau theo hướng đối tượng và hướng thủ tục.

**Hướng đối tượng**:

```java
public class Circle {
    // Định nghĩa bán kính hình tròn
    private double radius;

    // Phương thức khởi tạo
    public Circle(double radius) {
        this.radius = radius;
    }

    // Tính diện tích hình tròn
    public double getArea() {
        return Math.PI * radius * radius;
    }

    // Tính chu vi hình tròn
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public static void main(String[] args) {
        // Tạo một hình tròn có bán kính là 3
        Circle circle = new Circle(3.0);

        // Xuất ra diện tích và chu vi hình tròn
        System.out.println("Diện tích hình tròn là：" + circle.getArea());
        System.out.println("Chu vi hình tròn là：" + circle.getPerimeter());
    }
}
```

Chúng ta định nghĩa một lớp `Circle` để biểu diễn hình tròn, lớp này bao gồm thuộc tính bán kính của hình tròn và các phương thức tính diện tích, chu vi.

**Hướng thủ tục**:

```java
public class Main {
    public static void main(String[] args) {
        // Định nghĩa bán kính hình tròn
        double radius = 3.0;

        // Tính diện tích và chu vi hình tròn
        double area = Math.PI * radius * radius;
        double perimeter = 2 * Math.PI * radius;

        // Xuất ra diện tích và chu vi hình tròn
        System.out.println("Diện tích hình tròn là：" + area);
        System.out.println("Chu vi hình tròn là：" + perimeter);
    }
}
```

Chúng ta trực tiếp định nghĩa bán kính của hình tròn và sử dụng bán kính đó để tính trực tiếp diện tích và chu vi của hình tròn.

### Toán tử nào được sử dụng để tạo đối tượng? Thực thể đối tượng và tham chiếu đối tượng khác nhau như thế nào?

Toán tử `new`, `new` tạo ra thể hiện đối tượng (thể hiện đối tượng nằm trong bộ nhớ heap), tham chiếu đối tượng trỏ đến thể hiện đối tượng (tham chiếu đối tượng được lưu trữ trong bộ nhớ stack).

- Một tham chiếu đối tượng có thể trỏ đến 0 hoặc 1 đối tượng (một sợi dây có thể không buộc quả bóng bay nào, hoặc có thể buộc một quả bóng bay);
- Một đối tượng có thể có n tham chiếu trỏ đến nó (có thể dùng n sợi dây để buộc một quả bóng bay).

### Sự khác biệt giữa sự bằng nhau của đối tượng và sự bằng nhau của tham chiếu?

- Sự bằng nhau của đối tượng thường so sánh nội dung được lưu trữ trong bộ nhớ có bằng nhau hay không.
- Sự bằng nhau của tham chiếu thường so sánh địa chỉ bộ nhớ mà chúng trỏ đến có bằng nhau hay không.

Đây là một ví dụ:

```java
String str1 = "hello";
String str2 = new String("hello");
String str3 = "hello";
// Sử dụng == để so sánh sự bằng nhau của tham chiếu chuỗi
System.out.println(str1 == str2);
System.out.println(str1 == str3);
// Sử dụng phương thức equals để so sánh sự bằng nhau của chuỗi
System.out.println(str1.equals(str2));
System.out.println(str1.equals(str3));

```

Kết quả đầu ra:

```plain
false
true
true
true
```

Từ kết quả đầu ra của đoạn mã trên, có thể thấy:

- `str1` và `str2` không bằng nhau, trong khi `str1` và `str3` bằng nhau. Điều này là do toán tử `==` so sánh xem tham chiếu của chuỗi có bằng nhau hay không.
- Nội dung của `str1`, `str2`, `str3` đều bằng nhau. Điều này là do phương thức `equals` so sánh nội dung của chuỗi, ngay cả khi tham chiếu đối tượng của các chuỗi này khác nhau, miễn là nội dung của chúng bằng nhau, chúng được coi là bằng nhau.

### Nếu một lớp không khai báo phương thức khởi tạo, chương trình có thể thực thi chính xác không?

Phương thức khởi tạo là một loại phương thức đặc biệt, vai trò chính của nó là hoàn thành công việc khởi tạo đối tượng.

Nếu một lớp không khai báo phương thức khởi tạo, nó vẫn có thể thực thi! Bởi vì ngay cả khi một lớp không khai báo phương thức khởi tạo, nó vẫn sẽ có một phương thức khởi tạo mặc định không có tham số. Nếu chúng ta tự thêm phương thức khởi tạo cho lớp (dù có tham số hay không), Java sẽ không thêm phương thức khởi tạo không tham số mặc định nữa.

Chúng ta đã vô tình sử dụng phương thức khởi tạo, đó cũng là lý do tại sao khi tạo đối tượng, chúng ta phải thêm dấu ngoặc đơn ở phía sau (vì phải gọi phương thức khởi tạo không tham số). Nếu chúng ta nạp chồng phương thức khởi tạo có tham số, hãy nhớ viết cả phương thức khởi tạo không tham số (dù có dùng đến hay không), vì điều này có thể giúp chúng ta tránh được những lỗi không đáng có khi tạo đối tượng.

### Phương thức khởi tạo có những đặc điểm nào? Có thể bị ghi đè (override) không?

Phương thức khởi tạo có những đặc điểm sau:

- **Tên trùng với tên lớp**: Tên của phương thức khởi tạo phải hoàn toàn giống với tên lớp.
- **Không có giá trị trả về**: Phương thức khởi tạo không có kiểu trả về, và không thể sử dụng `void` để khai báo.
- **Tự động thực thi**: Khi tạo đối tượng của lớp, phương thức khởi tạo sẽ tự động được thực thi, không cần gọi một cách tường minh.

Phương thức khởi tạo **không thể bị ghi đè (override)**, nhưng **có thể bị nạp chồng (overload)**. Do đó, một lớp có thể có nhiều phương thức khởi tạo, các phương thức khởi tạo này có thể có danh sách tham số khác nhau, để cung cấp các cách khởi tạo đối tượng khác nhau.

### Ba đặc trưng của hướng đối tượng

#### Đóng gói

Đóng gói có nghĩa là ẩn thông tin trạng thái (tức là thuộc tính) của một đối tượng bên trong đối tượng, không cho phép các đối tượng bên ngoài truy cập trực tiếp vào thông tin bên trong của đối tượng. Tuy nhiên, có thể cung cấp một số phương thức có thể được truy cập từ bên ngoài để thao tác các thuộc tính. Giống như chúng ta không thể nhìn thấy các bộ phận bên trong (tức là thuộc tính) của máy điều hòa treo trên tường, nhưng có thể điều khiển máy điều hòa thông qua điều khiển từ xa (phương thức). Nếu thuộc tính không muốn bị truy cập từ bên ngoài, chúng ta hoàn toàn không cần cung cấp phương thức cho bên ngoài truy cập. Nhưng nếu một lớp không cung cấp phương thức cho bên ngoài truy cập, thì lớp đó cũng không có nhiều ý nghĩa. Giống như nếu không có điều khiển từ xa của máy điều hòa, thì chúng ta không thể điều khiển máy điều hòa làm mát, bản thân máy điều hòa sẽ không có ý nghĩa (tất nhiên hiện nay còn nhiều phương pháp khác, ở đây chỉ để ví dụ).

```java
public class Student {
    private int id;//thuộc tính id được đặt là private
    private String name;//thuộc tính name được đặt là private

    //phương thức lấy id
    public int getId() {
        return id;
    }

    //phương thức đặt id
    public void setId(int id) {
        this.id = id;
    }

    //phương thức lấy name
    public String getName() {
        return name;
    }

    //phương thức đặt name
    public void setName(String name) {
        this.name = name;
    }
}
```

#### Kế thừa

Các đối tượng thuộc các loại khác nhau thường có một số điểm chung nhất định. Ví dụ, bạn học Tiểu Minh, bạn học Tiểu Hồng, bạn học Tiểu Lý, đều có chung các đặc điểm của học sinh (lớp, mã số sinh viên, v.v.). Đồng thời, mỗi đối tượng còn định nghĩa thêm các đặc điểm khác biệt khiến chúng trở nên độc đáo. Ví dụ, Tiểu Minh giỏi toán hơn, tính cách của Tiểu Hồng đáng yêu hơn; Tiểu Lý khỏe hơn. Kế thừa là kỹ thuật sử dụng định nghĩa của các lớp đã có sẵn làm cơ sở để xây dựng các lớp mới, định nghĩa của lớp mới có thể thêm dữ liệu mới hoặc chức năng mới, cũng có thể sử dụng chức năng của lớp cha, nhưng không thể kế thừa có chọn lọc từ lớp cha. Bằng cách sử dụng kế thừa, có thể nhanh chóng tạo ra các lớp mới, có thể cải thiện khả năng tái sử dụng mã, khả năng bảo trì chương trình, tiết kiệm nhiều thời gian tạo lớp mới, nâng cao hiệu quả phát triển của chúng ta.

**Về kế thừa, hãy nhớ 3 điểm sau:**

1. Lớp con sở hữu tất cả các thuộc tính và phương thức của đối tượng lớp cha (bao gồm cả thuộc tính riêng tư và phương thức riêng tư), nhưng lớp con không thể truy cập các thuộc tính và phương thức riêng tư của lớp cha, **chỉ sở hữu**.
2. Lớp con có thể có các thuộc tính và phương thức của riêng mình, tức là lớp con có thể mở rộng lớp cha.
3. Lớp con có thể triển khai các phương thức của lớp cha theo cách riêng của mình. (sẽ giới thiệu sau).

#### Đa hình

Đa hình, đúng như tên gọi, có nghĩa là một đối tượng có nhiều trạng thái, biểu hiện cụ thể là tham chiếu của lớp cha trỏ đến thể hiện của lớp con.

**Đặc điểm của đa hình:**

- Kiểu đối tượng và kiểu tham chiếu có mối quan hệ kế thừa (lớp)/thực thi (giao diện);
- Việc gọi phương thức của biến kiểu tham chiếu thực sự là phương thức của lớp nào, phải được xác định trong thời gian chạy chương trình;
- Đa hình không thể gọi các phương thức "chỉ tồn tại trong lớp con mà không tồn tại trong lớp cha";
- Nếu lớp con ghi đè phương thức của lớp cha, thì phương thức được thực thi thực sự là phương thức được ghi đè của lớp con, nếu lớp con không ghi đè phương thức của lớp cha, thì phương thức được thực thi là phương thức của lớp cha.

### Interface và lớp trừu tượng có những điểm chung và khác biệt nào?

#### Điểm chung của Interface và lớp trừu tượng

- **Khởi tạo**: Cả interface và lớp trừu tượng đều không thể được khởi tạo trực tiếp, chỉ có thể được triển khai (interface) hoặc kế thừa (lớp trừu tượng) sau đó mới tạo được đối tượng cụ thể.
- **Phương thức trừu tượng**: Cả interface và lớp trừu tượng đều có thể chứa các phương thức trừu tượng. Phương thức trừu tượng không có thân phương thức, phải được triển khai trong lớp con hoặc lớp triển khai.

#### Sự khác biệt giữa Interface và lớp trừu tượng

- **Mục đích thiết kế**: Interface chủ yếu được sử dụng để ràng buộc hành vi của các lớp, bạn triển khai một interface nào đó thì sẽ có hành vi tương ứng. Lớp trừu tượng chủ yếu được sử dụng để tái sử dụng mã, nhấn mạnh mối quan hệ thuộc về.
- **Kế thừa và triển khai**: Một lớp chỉ có thể kế thừa một lớp (bao gồm cả lớp trừu tượng), vì Java không hỗ trợ đa kế thừa. Nhưng một lớp có thể triển khai nhiều interface, một interface cũng có thể kế thừa nhiều interface khác.
- **Biến thành viên**: Biến thành viên trong interface chỉ có thể là kiểu `public static final`, không thể bị sửa đổi và phải có giá trị khởi tạo. Biến thành viên của lớp trừu tượng có thể có bất kỳ bổ từ nào (`private`, `protected`, `public`), có thể được định nghĩa lại hoặc gán giá trị trong lớp con.
- **Phương thức**:
  - Trước Java 8, các phương thức trong interface mặc định là `public abstract`, tức là chỉ có thể có khai báo phương thức. Từ Java 8 trở đi, có thể định nghĩa các phương thức `default` (mặc định) và `static` (tĩnh) trong interface. Từ Java 9 trở đi, interface có thể chứa các phương thức `private`.
  - Lớp trừu tượng có thể chứa các phương thức trừu tượng và các phương thức không trừu tượng. Phương thức trừu tượng không có thân phương thức, phải được triển khai trong lớp con. Phương thức không trừu tượng có triển khai cụ thể, có thể được sử dụng trực tiếp trong lớp trừu tượng hoặc được ghi đè trong lớp con.

Trong Java 8 trở lên, interface đã giới thiệu các loại phương thức mới: phương thức `default`, phương thức `static` và phương thức `private`. Những phương thức này giúp việc sử dụng interface linh hoạt hơn.

Phương thức `default` được giới thiệu trong Java 8 dùng để cung cấp triển khai mặc định cho các phương thức của interface, có thể được ghi đè trong lớp triển khai. Điều này cho phép thêm chức năng mới vào các interface hiện có mà không cần sửa đổi các lớp triển khai, từ đó tăng cường khả năng mở rộng và tính tương thích ngược của interface.

```java
public interface MyInterface {
    default void defaultMethod() {
        System.out.println("Đây là một phương thức mặc định.");
    }
}
```

Phương thức `static` được giới thiệu trong Java 8 không thể bị ghi đè trong lớp triển khai, chỉ có thể được gọi trực tiếp thông qua tên interface (`MyInterface.staticMethod()`), tương tự như các phương thức tĩnh trong lớp. Phương thức `static` thường được sử dụng để định nghĩa một số phương thức tiện ích chung, liên quan đến interface, thường ít được sử dụng.

```java
public interface MyInterface {
    static void staticMethod() {
        System.out.println("Đây là một phương thức tĩnh trong interface.");
    }
}
```

Java 9 cho phép sử dụng phương thức `private` trong interface. Phương thức `private` có thể được sử dụng để chia sẻ mã bên trong interface, không hiển thị ra bên ngoài.

```java
public interface MyInterface {
    // phương thức default
    default void defaultMethod() {
        commonMethod();
    }

    // phương thức static
    static void staticMethod() {
        commonMethod();
    }

    // phương thức tĩnh riêng tư, có thể được gọi bởi phương thức static và default
    private static void commonMethod() {
        System.out.println("Đây là một phương thức riêng tư được sử dụng nội bộ.");
    }

      // phương thức riêng tư của thể hiện, chỉ có thể được gọi bởi phương thức default.
    private void instanceCommonMethod() {
        System.out.println("Đây là một phương thức riêng tư của thể hiện được sử dụng nội bộ.");
    }
}
```

### Bạn có hiểu về sự khác biệt giữa sao chép sâu và sao chép nông không? Sao chép tham chiếu là gì?

Về sự khác biệt giữa sao chép sâu và sao chép nông, tôi xin đưa ra kết luận trước:

- **Sao chép nông (Shallow Copy)**: Sao chép nông sẽ tạo một đối tượng mới trên heap (khác với sao chép tham chiếu ở điểm này), tuy nhiên, nếu các thuộc tính bên trong của đối tượng gốc là kiểu tham chiếu, sao chép nông sẽ trực tiếp sao chép địa chỉ tham chiếu của đối tượng bên trong, nghĩa là đối tượng sao chép và đối tượng gốc cùng chia sẻ một đối tượng bên trong.
- **Sao chép sâu (Deep Copy)**: Sao chép sâu sẽ sao chép hoàn toàn toàn bộ đối tượng, bao gồm cả các đối tượng bên trong mà đối tượng này chứa.

Nếu bạn chưa hiểu hoàn toàn kết luận trên cũng không sao, chúng ta hãy xem một ví dụ cụ thể!

#### Sao chép nông

Mã ví dụ về sao chép nông như sau, ở đây chúng ta triển khai interface `Cloneable` và ghi đè phương thức `clone()`.

Việc triển khai phương thức `clone()` rất đơn giản, trực tiếp gọi phương thức `clone()` của lớp cha `Object`.

```java
public class Address implements Cloneable{
    private String name;
    // Bỏ qua hàm khởi tạo, phương thức Getter&Setter
    @Override
    public Address clone() {
        try {
            return (Address) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

public class Person implements Cloneable {
    private Address address;
    // Bỏ qua hàm khởi tạo, phương thức Getter&Setter
    @Override
    public Person clone() {
        try {
            Person person = (Person) super.clone();
            return person;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
```

Kiểm tra:

```java
Person person1 = new Person(new Address("Vũ Hán"));
Person person1Copy = person1.clone();
// true
System.out.println(person1.getAddress() == person1Copy.getAddress());
```

Từ kết quả đầu ra có thể thấy, đối tượng nhân bản của `person1` và `person1` vẫn sử dụng cùng một đối tượng `Address`.

#### Sao chép sâu

Ở đây chúng ta chỉ cần sửa đổi một chút phương thức `clone()` của lớp `Person`, đồng thời sao chép cả đối tượng `Address` bên trong đối tượng `Person`.

```java
@Override
public Person clone() {
    try {
        Person person = (Person) super.clone();
        person.setAddress(person.getAddress().clone());
        return person;
    } catch (CloneNotSupportedException e) {
        throw new AssertionError();
    }
}
```

Kiểm tra:

```java
Person person1 = new Person(new Address("Vũ Hán"));
Person person1Copy = person1.clone();
// false
System.out.println(person1.getAddress() == person1Copy.getAddress());
```

Từ kết quả đầu ra có thể thấy, rõ ràng đối tượng nhân bản của `person1` và đối tượng `Address` mà `person1` chứa đã khác nhau.

**Vậy sao chép tham chiếu là gì?** Nói một cách đơn giản, sao chép tham chiếu là hai tham chiếu khác nhau trỏ đến cùng một đối tượng.

Tôi đã vẽ một sơ đồ để mô tả sao chép nông, sao chép sâu và sao chép tham chiếu:

![shallow&deep-copy](https://oss.javaguide.cn/github/javaguide/java/basis/shallow&deep-copy.png)

## Object

### Các phương thức phổ biến của lớp Object là gì?

Lớp Object là một lớp đặc biệt, là lớp cha của tất cả các lớp, chủ yếu cung cấp 11 phương thức sau:

```java
/**
 * Phương thức native, dùng để trả về đối tượng Class của đối tượng runtime hiện tại, được sửa đổi bằng từ khóa final, do đó không cho phép lớp con ghi đè.
 */
public final native Class<?> getClass()
/**
 * Phương thức native, dùng để trả về mã băm của đối tượng, chủ yếu được sử dụng trong các bảng băm, ví dụ như HashMap trong JDK.
 */
public native int hashCode()
/**
 * Dùng để so sánh địa chỉ bộ nhớ của 2 đối tượng có bằng nhau không, lớp String đã ghi đè phương thức này để so sánh giá trị của chuỗi có bằng nhau không.
 */
public boolean equals(Object obj)
/**
 * Phương thức native, dùng để tạo và trả về một bản sao của đối tượng hiện tại.
 */
protected native Object clone() throws CloneNotSupportedException
/**
 * Trả về chuỗi hexa của mã băm của thể hiện tên lớp. Khuyến nghị tất cả các lớp con của Object đều ghi đè phương thức này.
 */
public String toString()
/**
 * Phương thức native, và không thể ghi đè. Đánh thức một luồng đang đợi trên monitor của đối tượng này (monitor tương đương với khái niệm khóa). Nếu có nhiều luồng đang đợi, chỉ đánh thức một luồng bất kỳ.
 */
public final native void notify()
/**
 * Phương thức native, và không thể ghi đè. Giống như notify, điểm khác biệt duy nhất là sẽ đánh thức tất cả các luồng đang đợi trên monitor của đối tượng này, chứ không phải một luồng.
 */
public final native void notifyAll()
/**
 * Phương thức native, và không thể ghi đè. Tạm dừng việc thực thi của luồng. Chú ý: phương thức sleep không giải phóng khóa, trong khi phương thức wait giải phóng khóa, timeout là thời gian chờ.
 */
public final native void wait(long timeout) throws InterruptedException
/**
 * Thêm tham số nanos, tham số này biểu thị thời gian bổ sung (tính bằng nano giây, phạm vi từ 0-999999). Vì vậy, thời gian chờ còn cần cộng thêm nanos nano giây..
 */
public final void wait(long timeout, int nanos) throws InterruptedException
/**
 * Giống như 2 phương thức wait trước đó, chỉ khác là phương thức này đợi mãi, không có khái niệm thời gian chờ
 */
public final void wait() throws InterruptedException
/**
 * Thao tác được kích hoạt khi thể hiện bị bộ thu gom rác thu hồi
 */
protected void finalize() throws Throwable { }
```

### Sự khác biệt giữa == và equals()?

**`==`** có tác dụng khác nhau đối với kiểu cơ bản và kiểu tham chiếu:

- Đối với kiểu dữ liệu cơ bản, `==` so sánh giá trị.
- Đối với kiểu dữ liệu tham chiếu, `==` so sánh địa chỉ bộ nhớ của đối tượng.

> Bởi vì Java chỉ có truyền giá trị, nên đối với `==`, dù là so sánh biến kiểu dữ liệu cơ bản hay kiểu dữ liệu tham chiếu, bản chất của nó đều là so sánh giá trị, chỉ là biến kiểu tham chiếu lưu trữ giá trị là địa chỉ của đối tượng.

**`equals()`** không thể được sử dụng để đánh giá các biến kiểu dữ liệu cơ bản, chỉ có thể được sử dụng để đánh giá xem hai đối tượng có bằng nhau hay không. Phương thức `equals()` tồn tại trong lớp `Object`, và lớp `Object` là lớp cha trực tiếp hoặc gián tiếp của tất cả các lớp, do đó tất cả các lớp đều có phương thức `equals()`.

Phương thức `equals()` của lớp `Object`:

```java
public boolean equals(Object obj) {
     return (this == obj);
}
```

Phương thức `equals()` có hai trường hợp sử dụng:

- **Lớp không ghi đè phương thức `equals()`**: Khi so sánh hai đối tượng của lớp đó bằng `equals()`, tương đương với việc so sánh hai đối tượng đó bằng “==”, sử dụng mặc định là phương thức `equals()` của lớp `Object`.
- **Lớp đã ghi đè phương thức `equals()`**: Thông thường chúng ta đều ghi đè phương thức `equals()` để so sánh xem các thuộc tính trong hai đối tượng có bằng nhau hay không; nếu các thuộc tính của chúng bằng nhau, thì trả về true (tức là, coi hai đối tượng đó bằng nhau).

Ví dụ (đây chỉ là ví dụ. Thực tế, nếu bạn viết theo cách dưới đây, các IDE thông minh như IDEA sẽ nhắc bạn đổi `==` thành `equals()`):

```java
String a = new String("ab"); // a là một tham chiếu
String b = new String("ab"); // b là một tham chiếu khác, nội dung đối tượng giống nhau
String aa = "ab"; // đặt trong bể hằng
String bb = "ab"; // tìm kiếm từ bể hằng
System.out.println(aa == bb);// true
System.out.println(a == b);// false
System.out.println(a.equals(b));// true
System.out.println(42 == 42.0);// true
```

Phương thức `equals` trong `String` đã được ghi đè, bởi vì phương thức `equals` của `Object` so sánh địa chỉ bộ nhớ của đối tượng, trong khi phương thức `equals` của `String` so sánh giá trị của đối tượng.

Khi tạo đối tượng kiểu `String`, máy ảo sẽ tìm trong bể hằng xem có đối tượng nào có giá trị giống với giá trị cần tạo hay không, nếu có thì gán nó cho tham chiếu hiện tại. Nếu không có thì tạo mới một đối tượng `String` trong bể hằng.

Phương thức `equals()` của lớp `String`:

```java
public boolean equals(Object anObject) {
    if (this == anObject) {
        return true;
    }
    if (anObject instanceof String) {
        String anotherString = (String)anObject;
        int n = value.length;
        if (n == anotherString.value.length) {
            char v1[] = value;
            char v2[] = anotherString.value;
            int i = 0;
            while (n-- != 0) {
                if (v1[i] != v2[i])
                    return false;
                i++;
            }
            return true;
        }
    }
    return false;
}
```

### hashCode() có tác dụng gì?

Tác dụng của `hashCode()` là lấy mã băm (`int` số nguyên), còn được gọi là mã phân tán. Mã băm này có tác dụng xác định vị trí chỉ mục của đối tượng đó trong bảng băm.

![Phương thức hashCode()](https://oss.javaguide.cn/github/javaguide/java/basis/java-hashcode-method.png)

`hashCode()` được định nghĩa trong lớp `Object` của JDK, điều này có nghĩa là bất kỳ lớp nào trong Java cũng đều chứa hàm `hashCode()`. Ngoài ra, cần lưu ý rằng: phương thức `hashCode()` của `Object` là một phương thức cục bộ, tức là được triển khai bằng ngôn ngữ C hoặc C++.

> ⚠️ Chú ý: Phương thức này trong **Oracle OpenJDK8** mặc định là "sử dụng trạng thái cục bộ của luồng để triển khai trình tạo số ngẫu nhiên xor-shift của Marsaglia", không phải là "địa chỉ" hoặc "được chuyển đổi từ địa chỉ", các JDK/VM khác nhau có thể khác nhau. Trong **Oracle OpenJDK8** có sáu cách tạo (trong đó cách thứ năm là trả về địa chỉ), bằng cách thêm tham số VM: -XX:hashCode=4 để bật cách thứ năm. Tham khảo mã nguồn:
>
> - <https://hg.openjdk.org/jdk8u/jdk8u/hotspot/file/87ee5ee27509/src/share/vm/runtime/globals.hpp> (dòng 1127)
> - <https://hg.openjdk.org/jdk8u/jdk8u/hotspot/file/87ee5ee27509/src/share/vm/runtime/synchronizer.cpp> (bắt đầu từ dòng 537)

```java
public native int hashCode();
```

Bảng băm lưu trữ các cặp khóa-giá trị (key-value), đặc điểm của nó là: **có thể nhanh chóng truy xuất "giá trị" tương ứng dựa trên "khóa". Điều này chính là nhờ vào mã băm! (có thể nhanh chóng tìm thấy đối tượng cần thiết)**

### Tại sao cần có hashCode?

Chúng ta hãy lấy ví dụ về cách "`HashSet` kiểm tra sự trùng lặp" để giải thích tại sao cần có `hashCode`.

Đoạn văn dưới đây được trích từ cuốn sách khai sáng Java của tôi, "Head First Java":

> Khi bạn thêm đối tượng vào `HashSet`, `HashSet` trước tiên sẽ tính toán giá trị `hashCode` của đối tượng để xác định vị trí thêm đối tượng, đồng thời cũng so sánh với giá trị `hashCode` của các đối tượng đã được thêm vào, nếu không có `hashCode` nào khớp, `HashSet` sẽ giả định rằng đối tượng không bị trùng lặp. Nhưng nếu phát hiện có đối tượng có giá trị `hashCode` giống nhau, lúc này sẽ gọi phương thức `equals()` để kiểm tra xem các đối tượng có `hashCode` bằng nhau có thực sự giống nhau hay không. Nếu cả hai giống nhau, `HashSet` sẽ không cho phép thao tác thêm thành công. Nếu khác nhau, nó sẽ được băm lại vào một vị trí khác. Bằng cách này, chúng ta đã giảm đáng kể số lần gọi `equals`, do đó cải thiện đáng kể tốc độ thực thi.

Thực ra, cả `hashCode()` và `equals()` đều được sử dụng để so sánh xem hai đối tượng có bằng nhau hay không.

**Vậy tại sao JDK lại cung cấp đồng thời cả hai phương thức này?**

Điều này là do trong một số bộ chứa (ví dụ như `HashMap`, `HashSet`), sau khi có `hashCode()`, hiệu quả của việc xác định xem một phần tử có trong bộ chứa tương ứng hay không sẽ cao hơn (tham khảo quá trình thêm phần tử vào `HashSet`)!

Chúng ta cũng đã đề cập đến quá trình thêm phần tử vào `HashSet` ở phần trước, nếu `HashSet` khi so sánh, cùng một `hashCode` có nhiều đối tượng, nó sẽ tiếp tục sử dụng `equals()` để xác định xem chúng có thực sự giống nhau hay không. Nghĩa là `hashCode` giúp chúng ta giảm đáng kể chi phí tìm kiếm.

**Vậy tại sao không chỉ cung cấp phương thức `hashCode()`?**

Điều này là do giá trị `hashCode` của hai đối tượng bằng nhau không có nghĩa là hai đối tượng đó bằng nhau.

**Vậy tại sao hai đối tượng có cùng giá trị `hashCode` mà chúng không nhất thiết phải bằng nhau?**

Bởi vì thuật toán băm được sử dụng bởi `hashCode()` có thể tình cờ khiến nhiều đối tượng trả về cùng một giá trị băm. Thuật toán băm càng tệ thì càng dễ xảy ra xung đột, nhưng điều này cũng liên quan đến đặc điểm phân bố miền giá trị dữ liệu (cái gọi là xung đột băm chính là chỉ các đối tượng khác nhau nhận được cùng một `hashCode`).

Tóm lại là:

- Nếu giá trị `hashCode` của hai đối tượng bằng nhau, thì hai đối tượng đó không nhất thiết bằng nhau (xung đột băm).
- Nếu giá trị `hashCode` của hai đối tượng bằng nhau và phương thức `equals()` cũng trả về `true`, chúng ta mới coi hai đối tượng đó bằng nhau.
- Nếu giá trị `hashCode` của hai đối tượng không bằng nhau, chúng ta có thể trực tiếp coi hai đối tượng đó không bằng nhau.

Tin rằng sau khi các bạn xem phần giới thiệu của tôi về `hashCode()` và `equals()` ở trên, câu hỏi dưới đây sẽ không còn làm khó các bạn nữa.

### Tại sao khi ghi đè equals() thì bắt buộc phải ghi đè phương thức hashCode()?

Bởi vì giá trị `hashCode` của hai đối tượng bằng nhau phải bằng nhau. Nghĩa là nếu phương thức `equals` xác định hai đối tượng bằng nhau, thì giá trị `hashCode` của hai đối tượng đó cũng phải bằng nhau.

Nếu khi ghi đè `equals()` mà không ghi đè phương thức `hashCode()`, có thể dẫn đến tình trạng hai đối tượng được phương thức `equals` xác định là bằng nhau, nhưng giá trị `hashCode` lại không bằng nhau.

**Suy nghĩ**: Nếu khi ghi đè `equals()` mà không ghi đè phương thức `hashCode()`, việc sử dụng `HashMap` có thể gặp phải vấn đề gì?

**Tổng kết**:

- Phương thức `equals` xác định hai đối tượng bằng nhau, thì giá trị `hashCode` của hai đối tượng đó cũng phải bằng nhau.
- Hai đối tượng có cùng giá trị `hashCode`, chúng không nhất thiết phải bằng nhau (xung đột băm).

Để biết thêm nội dung về `hashCode()` và `equals()`, bạn có thể xem: [Giải đáp một số vấn đề về Java hashCode() và equals()](https://www.cnblogs.com/skywang12345/p/3324958.html)

## String

### Sự khác biệt giữa String, StringBuffer, StringBuilder là gì?

**Tính khả biến**

`String` là bất biến (sẽ phân tích chi tiết lý do sau).

`StringBuilder` và `StringBuffer` đều kế thừa từ lớp `AbstractStringBuilder`, trong `AbstractStringBuilder` cũng sử dụng mảng ký tự để lưu trữ chuỗi, tuy nhiên không sử dụng từ khóa `final` và `private` để sửa đổi, điều quan trọng nhất là lớp `AbstractStringBuilder` này còn cung cấp nhiều phương thức sửa đổi chuỗi như phương thức `append`.

```java
abstract class AbstractStringBuilder implements Appendable, CharSequence {
    char[] value;
    public AbstractStringBuilder append(String str) {
        if (str == null)
            return appendNull();
        int len = str.length();
        ensureCapacityInternal(count + len);
        str.getChars(0, len, value, count);
        count += len;
        return this;
    }
    //...
}
```

**An toàn luồng**

Đối tượng trong `String` là bất biến, cũng có thể hiểu là hằng số, an toàn luồng. `AbstractStringBuilder` là lớp cha chung của `StringBuilder` và `StringBuffer`, định nghĩa một số thao tác chuỗi cơ bản, như các phương thức chung `expandCapacity`, `append`, `insert`, `indexOf`, v.v. `StringBuffer` đã thêm khóa đồng bộ hóa vào các phương thức hoặc các phương thức được gọi, do đó nó an toàn luồng. `StringBuilder` không thêm khóa đồng bộ hóa vào các phương thức, do đó nó không an toàn luồng.

**Hiệu suất**

Mỗi khi thay đổi kiểu `String`, một đối tượng `String` mới sẽ được tạo ra, sau đó con trỏ sẽ trỏ đến đối tượng `String` mới. `StringBuffer` mỗi lần đều thao tác trên chính đối tượng `StringBuffer`, chứ không phải tạo đối tượng mới và thay đổi tham chiếu đối tượng. Trong cùng điều kiện, việc sử dụng `StringBuilder` so với `StringBuffer` chỉ có thể đạt được hiệu suất tăng khoảng 10%~15%, nhưng lại phải đối mặt với nguy cơ không an toàn đa luồng.

**Tổng kết về việc sử dụng ba loại này:**

- Thao tác với lượng nhỏ dữ liệu: Sử dụng `String`
- Thao tác với lượng lớn dữ liệu trong bộ đệm chuỗi đơn luồng: Sử dụng `StringBuilder`
- Thao tác với lượng lớn dữ liệu trong bộ đệm chuỗi đa luồng: Sử dụng `StringBuffer`

### Tại sao String lại bất biến?

Lớp `String` sử dụng mảng ký tự được sửa đổi bởi từ khóa `final` để lưu trữ chuỗi, ~~do đó đối tượng `String` là bất biến.~~

```java
public final class String implements java.io.Serializable, Comparable<String>, CharSequence {
    private final char value[];
  //...
}
```

> 🐛 Chỉnh sửa: Chúng ta biết rằng lớp được sửa đổi bởi từ khóa `final` không thể được kế thừa, phương thức được sửa đổi không thể được ghi đè, biến được sửa đổi là kiểu dữ liệu cơ bản thì giá trị không thể thay đổi, biến được sửa đổi là kiểu tham chiếu thì không thể trỏ đến đối tượng khác. Do đó, việc mảng được sửa đổi bởi `final` lưu trữ chuỗi không phải là nguyên nhân cơ bản khiến `String` bất biến, bởi vì chuỗi được lưu trữ trong mảng này là khả biến (trường hợp biến kiểu tham chiếu được sửa đổi bởi `final`).
>
> `String` thực sự bất biến vì những lý do sau:
>
> 1. Mảng lưu trữ chuỗi được sửa đổi bởi `final` và là `private`, đồng thời lớp `String` không cung cấp/hiển thị các phương thức để sửa đổi chuỗi này.
> 2. Lớp `String` được sửa đổi bởi `final` khiến nó không thể được kế thừa, từ đó tránh việc các lớp con phá vỡ tính bất biến của `String`.
>
> Đọc thêm: [Làm thế nào để hiểu tính bất biến của giá trị kiểu String? - Câu hỏi trên Zhihu](https://www.zhihu.com/question/20618891/answer/114125846)
>
> Bổ sung (từ [issue 675](https://github.com/Snailclimb/JavaGuide/issues/675)): Sau Java 9, việc triển khai `String`, `StringBuilder` và `StringBuffer` đã được thay đổi để sử dụng mảng `byte` để lưu trữ chuỗi.
>
> ```java
> public final class String implements java.io.Serializable,Comparable<String>, CharSequence {
>     // Chú thích @Stable cho biết biến chỉ được sửa đổi nhiều nhất một lần, được gọi là "ổn định".
>     @Stable
>     private final byte[] value;
> }
>
> abstract class AbstractStringBuilder implements Appendable, CharSequence {
>     byte[] value;
>
> }
> ```
>
> **Tại sao Java 9 lại thay đổi cách triển khai cơ bản của `String` từ `char[]` thành `byte[]`?**
>
> Phiên bản String mới thực sự hỗ trợ hai lược đồ mã hóa: Latin-1 và UTF-16. Nếu chuỗi chứa các ký tự tiếng Trung không vượt quá phạm vi ký tự có thể biểu diễn của Latin-1, thì Latin-1 sẽ được sử dụng làm lược đồ mã hóa. Trong lược đồ mã hóa Latin-1, `byte` chiếm một byte (8 bit), `char` chiếm 2 byte (16 bit), `byte` tiết kiệm một nửa không gian bộ nhớ so với `char`.
>
> JDK chính thức đã nói rằng phần lớn các đối tượng chuỗi chỉ chứa các ký tự có thể biểu diễn bằng Latin-1.
>
> ![](https://oss.javaguide.cn/github/javaguide/jdk9-string-latin1.png)
>
> Nếu chuỗi chứa các ký tự tiếng Trung vượt quá phạm vi ký tự có thể biểu diễn của Latin-1, thì không gian mà `byte` và `char` chiếm dụng là như nhau.
>
> Đây là giới thiệu chính thức: <https://openjdk.java.net/jeps/254> .

### Nối chuỗi dùng “+” hay StringBuilder?

Bản thân ngôn ngữ Java không hỗ trợ nạp chồng toán tử, “+” và “+=” là các toán tử được nạp chồng đặc biệt cho lớp String, cũng là hai toán tử duy nhất được nạp chồng trong Java.

```java
String str1 = "he";
String str2 = "llo";
String str3 = "world";
String str4 = str1 + str2 + str3;
```

Mã byte tương ứng với đoạn mã trên như sau:

![](https://oss.javaguide.cn/github/javaguide/java/image-20220422161637929.png)

Có thể thấy, cách nối chuỗi bằng toán tử “+” của đối tượng chuỗi thực chất được thực hiện thông qua việc gọi phương thức `append()` của `StringBuilder`, sau khi nối xong sẽ gọi `toString()` để nhận được một đối tượng `String`.

Tuy nhiên, việc sử dụng “+” để nối chuỗi trong vòng lặp có một nhược điểm khá rõ ràng: **trình biên dịch sẽ không tạo một `StringBuilder` duy nhất để tái sử dụng, dẫn đến việc tạo ra quá nhiều đối tượng `StringBuilder`**.

```java
String[] arr = {"he", "llo", "world"};
String s = "";
for (int i = 0; i < arr.length; i++) {
    s += arr[i];
}
System.out.println(s);
```

Đối tượng `StringBuilder` được tạo bên trong vòng lặp, điều này có nghĩa là mỗi lần lặp sẽ tạo một đối tượng `StringBuilder`.

![](https://oss.javaguide.cn/github/javaguide/java/image-20220422161320823.png)

Nếu trực tiếp sử dụng đối tượng `StringBuilder` để nối chuỗi thì sẽ không tồn tại vấn đề này.

```java
String[] arr = {"he", "llo", "world"};
StringBuilder s = new StringBuilder();
for (String value : arr) {
    s.append(value);
}
System.out.println(s);
```

![](https://oss.javaguide.cn/github/javaguide/java/image-20220422162327415.png)

Nếu bạn sử dụng IDEA, cơ chế kiểm tra mã tích hợp của IDEA cũng sẽ nhắc bạn sửa đổi mã.

Trong JDK 9, việc cộng chuỗi “+” được thay đổi để sử dụng phương thức động `makeConcatWithConstants()` để triển khai, thông qua việc phân bổ không gian trước để giảm một phần việc tạo đối tượng tạm thời. Tuy nhiên, tối ưu hóa này chủ yếu nhắm vào việc nối chuỗi đơn giản, ví dụ: `a+b+c`. Đối với các thao tác nối lớn trong vòng lặp, nó vẫn sẽ phân bổ bộ nhớ động từng cái một (tương tự như khái niệm nối hai cái một), không hiệu quả bằng việc sử dụng StringBuilder thủ công để nối. Cải tiến này được đề xuất trong [JEP 280](https://openjdk.org/jeps/280) của JDK9, về phần giới thiệu chi tiết về cải tiến này, khuyến nghị đọc bài viết này: [Vẫn còn dùng StringBuilder một cách vô tội vạ? Hãy cùng ôn lại về việc nối chuỗi nhé](https://juejin.cn/post/7182872058743750715) và tham khảo [issue#2442](https://github.com/Snailclimb/JavaGuide/issues/2442).

### String#equals() và Object#equals() có gì khác biệt?

Phương thức `equals` trong `String` đã được ghi đè, so sánh xem giá trị của chuỗi String có bằng nhau hay không. Phương thức `equals` của `Object` so sánh địa chỉ bộ nhớ của đối tượng.

### Bạn có hiểu về tác dụng của bể hằng chuỗi không?

**Bể hằng chuỗi** là một vùng được JVM dành riêng cho chuỗi (lớp String) để cải thiện hiệu suất và giảm tiêu thụ bộ nhớ, mục đích chính là để tránh việc tạo chuỗi lặp đi lặp lại.

```java
// Tạo đối tượng chuỗi "ab" trong bể hằng chuỗi
// Gán tham chiếu của đối tượng chuỗi "ab" cho aa
String aa = "ab";
// Trực tiếp trả về đối tượng chuỗi "ab" trong bể hằng chuỗi, gán cho tham chiếu bb
String bb = "ab";
System.out.println(aa==bb); // true
```

Để biết thêm thông tin về bể hằng chuỗi, bạn có thể xem bài viết [Giải thích chi tiết về vùng nhớ Java](https://javaguide.cn/java/jvm/memory-area.html).

### Câu lệnh `String s1 = new String("abc");` tạo ra bao nhiêu đối tượng chuỗi?

Câu trả lời trước: sẽ tạo ra 1 hoặc 2 đối tượng chuỗi.

1. Bể hằng chuỗi không tồn tại "abc": sẽ tạo ra 2 đối tượng chuỗi. Một trong bể hằng chuỗi, được tạo bởi lệnh `ldc`. Một trong heap, được tạo bởi `new String()`, và được khởi tạo bằng "abc" trong bể hằng.
2. Bể hằng chuỗi đã tồn tại "abc": sẽ tạo ra 1 đối tượng chuỗi. Đối tượng này nằm trong heap, được tạo bởi `new String()`, và được khởi tạo bằng "abc" trong bể hằng.

Sau đây là phân tích chi tiết.

1. Nếu bể hằng chuỗi không tồn tại đối tượng chuỗi “abc”, thì trước tiên nó sẽ tạo đối tượng chuỗi "abc" trong bể hằng chuỗi, sau đó tạo thêm một đối tượng chuỗi "abc" khác trong bộ nhớ heap.

Mã ví dụ (JDK 1.8):

```java
String s1 = new String("abc");
```

Mã byte tương ứng:

```java
// Phân bổ một đối tượng String chưa được khởi tạo trong bộ nhớ heap.
// #2 là một tham chiếu ký hiệu trong bể hằng, trỏ đến lớp java/lang/String.
// Trong giai đoạn phân giải khi tải lớp, tham chiếu ký hiệu này sẽ được phân giải thành tham chiếu trực tiếp, tức là trỏ đến lớp java/lang/String thực tế.
0 new #2 <java/lang/String>
// Sao chép tham chiếu đối tượng String trên đỉnh ngăn xếp, chuẩn bị cho việc gọi hàm tạo sau này.
// Lúc này, ngăn xếp toán hạng có hai tham chiếu đối tượng giống hệt nhau: một để truyền cho hàm tạo, một để giữ tham chiếu đến đối tượng mới, sau đó sẽ được lưu trữ vào bảng biến cục bộ.
3 dup
// JVM trước tiên kiểm tra xem "abc" có tồn tại trong bể hằng chuỗi hay không.
// Nếu "abc" đã tồn tại trong bể hằng, thì trực tiếp trả về tham chiếu của chuỗi đó;
// Nếu "abc" không tồn tại trong bể hằng, thì JVM sẽ tạo chuỗi ký tự đó trong bể hằng và trả về tham chiếu của nó.
// Tham chiếu này được đẩy vào ngăn xếp toán hạng, được sử dụng làm tham số cho hàm tạo.
4 ldc #3 <abc>
// Gọi phương thức khởi tạo, sử dụng "abc" được tải từ bể hằng để khởi tạo đối tượng String trong heap
// Đối tượng String mới sẽ chứa nội dung giống như "abc" trong bể hằng, nhưng nó là một đối tượng độc lập, được lưu trữ trong heap.
6 invokespecial #4 <java/lang/String.<init> : (Ljava/lang/String;)V>
// Lưu trữ tham chiếu đối tượng String trong heap vào bảng biến cục bộ
9 astore_1
// Trả về, kết thúc phương thức
10 return
```

Lệnh `ldc (load constant)` thực sự tải các loại hằng số khác nhau từ bể hằng, bao gồm hằng chuỗi, hằng số nguyên, hằng số thực, thậm chí cả tham chiếu lớp, v.v. Đối với hằng chuỗi, hành vi của lệnh `ldc` như sau:

1. **Tải chuỗi từ bể hằng**: `ldc` trước tiên kiểm tra xem bể hằng chuỗi đã có đối tượng chuỗi có nội dung giống nhau hay chưa.
2. **Tái sử dụng đối tượng chuỗi hiện có**: Nếu bể hằng chuỗi đã tồn tại đối tượng chuỗi có nội dung giống nhau, `ldc` sẽ tải tham chiếu của đối tượng đó lên ngăn xếp toán hạng.
3. **Nếu không có thì tạo đối tượng mới và thêm vào bể hằng**: Nếu bể hằng chuỗi không có đối tượng chuỗi có nội dung giống nhau, JVM sẽ tạo một đối tượng chuỗi mới trong bể hằng và tải tham chiếu của nó lên ngăn xếp toán hạng.

2. Nếu bể hằng chuỗi đã tồn tại đối tượng chuỗi “abc”, thì chỉ tạo 1 đối tượng chuỗi “abc” trong heap.

Mã ví dụ (JDK 1.8):

```java
// Bể hằng chuỗi đã tồn tại đối tượng chuỗi “abc”
String s1 = "abc";
// Đoạn mã dưới đây chỉ tạo 1 đối tượng chuỗi “abc” trong heap
String s2 = new String("abc");
```

Mã byte tương ứng:

```java
0 ldc #2 <abc>
2 astore_1
3 new #3 <java/lang/String>
6 dup
7 ldc #2 <abc>
9 invokespecial #4 <java/lang/String.<init> : (Ljava/lang/String;)V>
12 astore_2
13 return
```

Ở đây sẽ không chú thích chi tiết mã byte ở trên, lệnh `ldc` ở vị trí 7 sẽ không tạo đối tượng chuỗi mới “abc” trong heap, bởi vì vị trí 0 đã thực thi một lần lệnh `ldc`, đã tạo đối tượng chuỗi “abc” trong heap một lần rồi. Lệnh `ldc` ở vị trí 7 sẽ trực tiếp trả về tham chiếu tương ứng với đối tượng chuỗi “abc” trong bể hằng chuỗi.

### Phương thức String#intern có tác dụng gì?

`String.intern()` là một phương thức `native` (cục bộ), được sử dụng để xử lý các tham chiếu đối tượng chuỗi trong bể hằng chuỗi. Quy trình làm việc của nó có thể được tóm tắt thành hai trường hợp sau:

1. **Bể hằng đã có đối tượng chuỗi cùng nội dung**: Nếu bể hằng chuỗi đã có một đối tượng `String` có nội dung giống với chuỗi gọi phương thức `intern()`, phương thức `intern()` sẽ trực tiếp trả về tham chiếu của đối tượng đó trong bể hằng.
2. **Bể hằng không có đối tượng chuỗi cùng nội dung**: Nếu bể hằng chuỗi chưa có một đối tượng có nội dung giống với chuỗi gọi phương thức `intern()`, phương thức `intern()` sẽ thêm tham chiếu của đối tượng chuỗi hiện tại vào bể hằng chuỗi và trả về tham chiếu đó.

Tóm lại:

- Tác dụng chính của phương thức `intern()` là đảm bảo tính duy nhất của tham chiếu chuỗi trong bể hằng.
- Khi gọi `intern()`, nếu bể hằng đã tồn tại chuỗi có cùng nội dung, thì trả về tham chiếu của đối tượng đã có trong bể hằng; ngược lại, thêm chuỗi đó vào bể hằng và trả về tham chiếu của nó.

Mã ví dụ (JDK 1.8) :

```java
// s1 trỏ đến đối tượng "Java" trong bể hằng chuỗi
String s1 = "Java";
// s2 cũng trỏ đến đối tượng "Java" trong bể hằng chuỗi, là cùng một đối tượng với s1
String s2 = s1.intern();
// Tạo một đối tượng "Java" mới trong heap, s3 trỏ đến nó
String s3 = new String("Java");
// s4 trỏ đến đối tượng "Java" trong bể hằng chuỗi, là cùng một đối tượng với s1
String s4 = s3.intern();
// s1 và s2 trỏ đến cùng một đối tượng trong bể hằng
System.out.println(s1 == s2); // true
// s3 trỏ đến đối tượng trong heap, s4 trỏ đến đối tượng trong bể hằng, nên khác nhau
System.out.println(s3 == s4); // false
// s1 và s4 đều trỏ đến cùng một đối tượng trong bể hằng
System.out.println(s1 == s4); // true
```

### Điều gì xảy ra khi biến và hằng số kiểu String thực hiện phép toán “+”?

Trước tiên, hãy xem xét trường hợp nối chuỗi không sử dụng từ khóa `final`.（JDK1.8）：

```java
String str1 = "str";
String str2 = "ing";
String str3 = "str" + "ing";
String str4 = str1 + str2;
String str5 = "string";
System.out.println(str3 == str4);//false
System.out.println(str3 == str5);//true
System.out.println(str4 == str5);//false
```

> **Chú ý**: Để so sánh giá trị của hai chuỗi String có bằng nhau hay không, nên sử dụng phương thức `equals()`. Phương thức `equals` trong `String` đã được ghi đè. Phương thức `equals` của `Object` so sánh địa chỉ bộ nhớ của đối tượng, trong khi phương thức `equals` của `String` so sánh giá trị của chuỗi. Nếu bạn sử dụng `==` để so sánh hai chuỗi, IDEA sẽ gợi ý bạn sử dụng phương thức `equals()` thay thế.

![](https://oss.javaguide.cn/java-guide-blog/image-20210817123252441.png)

**Đối với những chuỗi có giá trị có thể xác định được tại thời điểm biên dịch, tức là hằng chuỗi, JVM sẽ lưu trữ chúng trong bể hằng chuỗi. Hơn nữa, hằng chuỗi được tạo ra từ việc nối các hằng chuỗi cũng đã được lưu vào bể hằng chuỗi ngay tại giai đoạn biên dịch, điều này nhờ vào việc tối ưu hóa của trình biên dịch.**

Trong quá trình biên dịch, trình biên dịch Javac (sau đây gọi chung là trình biên dịch) sẽ thực hiện một tối ưu hóa mã gọi là **gấp hằng số (Constant Folding)**. Cuốn "Hiểu sâu về Máy ảo Java" cũng có đề cập đến điều này:

![](https://oss.javaguide.cn/javaguide/image-20210817142715396.png)

Gấp hằng số sẽ tính toán giá trị của biểu thức hằng và nhúng kết quả vào mã cuối cùng được tạo ra, đây là một trong số ít các biện pháp tối ưu hóa mà trình biên dịch Javac thực hiện trên mã nguồn (hầu hết việc tối ưu hóa mã đều được thực hiện trong trình biên dịch just-in-time).

Với `String str3 = "str" + "ing";`, trình biên dịch sẽ tối ưu hóa thành `String str3 = "string";`.

Không phải tất cả các hằng số đều được gấp, chỉ những hằng số mà trình biên dịch có thể xác định giá trị tại thời điểm biên dịch mới được gấp:

- Kiểu dữ liệu cơ bản (`byte`, `boolean`, `short`, `char`, `int`, `float`, `long`, `double`) và hằng chuỗi.
- Biến kiểu dữ liệu cơ bản và chuỗi được đánh dấu `final`
- Chuỗi được tạo ra từ phép nối "+" giữa các chuỗi, phép toán số học (cộng trừ nhân chia) giữa các kiểu dữ liệu cơ bản, phép toán bit (<<, >>, >>>) giữa các kiểu dữ liệu cơ bản

**Giá trị của tham chiếu không thể xác định được tại thời điểm biên dịch, nên trình biên dịch không thể tối ưu hóa chúng.**

Việc nối chuỗi bằng "+" giữa các tham chiếu đối tượng thực chất được thực hiện thông qua `StringBuilder` bằng cách gọi phương thức `append()`, sau khi nối xong sẽ gọi `toString()` để nhận được một đối tượng `String`.

```java
String str4 = new StringBuilder().append(str1).append(str2).toString();
```

Trong khi viết mã, chúng ta nên tránh nối nhiều đối tượng chuỗi, vì điều này sẽ tạo ra các đối tượng mới. Nếu cần thay đổi chuỗi, có thể sử dụng `StringBuilder` hoặc `StringBuffer`.

Tuy nhiên, khi chuỗi được khai báo với từ khóa `final`, trình biên dịch có thể xử lý nó như một hằng số.

Ví dụ:

```java
final String str1 = "str";
final String str2 = "ing";
// Hai biểu thức dưới đây thực chất là tương đương
String c = "str" + "ing";// đối tượng trong bể hằng chuỗi
String d = str1 + str2; // đối tượng trong bể hằng chuỗi
System.out.println(c == d);// true
```

Khi `String` được đánh dấu bằng từ khóa `final`, nó sẽ được trình biên dịch xử lý như một hằng số, trình biên dịch có thể xác định giá trị của nó tại thời điểm biên dịch, và hiệu quả của nó giống như truy cập một hằng số.

Tuy nhiên, nếu trình biên dịch chỉ có thể biết được giá trị chính xác của nó tại thời điểm chạy, thì không thể tối ưu hóa.

Ví dụ (`str2` chỉ có thể xác định giá trị tại thời điểm chạy):

```java
final String str1 = "str";
final String str2 = getStr();
String c = "str" + "ing";// đối tượng trong bể hằng chuỗi
String d = str1 + str2; // một đối tượng mới được tạo trên heap
System.out.println(c == d);// false
public static String getStr() {
      return "ing";
}
```

## Tham khảo

- Phân tích sâu về String#intern: <https://tech.meituan.com/2014/03/06/in-depth-understanding-string-intern.html>
- Giải mã mã nguồn Java String: <http://keaper.cn/2020/09/08/java-string-mian-mian-guan/>
- Câu trả lời của R đại (RednaxelaFX) về gấp hằng số: <https://www.zhihu.com/question/55976094/answer/147302764>

<!-- @include: @article-footer.snippet.md -->
