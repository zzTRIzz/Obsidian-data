<br>

Trong Java cũng phân biệt kiểu dữ liệu nguyên thủy và kiểu dữ liệu tham chiếu tương tự như JavaScript, nhưng có một số khác biệt rõ rệt về cách thức hoạt động và cú pháp.

## 1. Kiểu dữ liệu nguyên thủy (Primitive Types)

Các kiểu dữ liệu nguyên thủy trong Java bao gồm:

- `byte`, `short`, `int`, `long`
    
- `float`, `double`
    
- `char`
    
- `boolean`
    

Khi gán giá trị của biến nguyên thủy cho biến khác, toàn bộ giá trị được sao chép. Điều này có nghĩa là các biến hoàn toàn độc lập sau khi gán.

### Ví dụ:

```java
int a = 5;
int b = a;   // b nhận giá trị 5 (sao chép giá trị)
a = 10;
System.out.println(b);  // In ra 5, không bị ảnh hưởng bởi thay đổi của a
```

## 2. Kiểu dữ liệu tham chiếu (Reference Types)

Các kiểu dữ liệu tham chiếu trong Java là các đối tượng, bao gồm:

- Các lớp (classes)
    
- Mảng (arrays)
    
- Giao diện (interfaces)
    
- Kiểu dữ liệu đặc biệt như `String`
    

Khi gán một biến kiểu đối tượng cho biến khác, chỉ có địa chỉ (tham chiếu) của đối tượng được sao chép. Do đó, cả hai biến đều trỏ đến cùng một đối tượng trong bộ nhớ.

### Ví dụ:

```java
class Person {
    String name;
}

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person();
        person1.name = "Alice";
        
        Person person2 = person1;  // Chỉ sao chép tham chiếu, không tạo đối tượng mới
        
        person2.name = "Bob";
        
        System.out.println(person1.name);  // In ra "Bob"
        System.out.println(person2.name);  // In ra "Bob"
    }
}
```

Ở ví dụ trên, thay đổi thuộc tính `name` qua biến `person2` sẽ ảnh hưởng đến `person1` vì cả hai đều tham chiếu đến cùng một đối tượng.

## 3. Vấn đề sao chép đối tượng: Shallow Copy và Deep Copy

### **Shallow Copy (sao chép nông)**:

Khi sao chép một đối tượng, nếu chỉ sao chép các tham chiếu của các trường đối tượng mà không tạo bản sao mới cho các đối tượng con, thì thay đổi trên một phần của đối tượng sẽ ảnh hưởng đến đối tượng gốc.

### **Deep Copy (sao chép sâu)**:

Để có bản sao độc lập hoàn toàn, cần sao chép cả các đối tượng con, đảm bảo mỗi đối tượng đều có phiên bản riêng biệt. Trong Java, việc này thường được thực hiện thông qua việc cài đặt giao diện `Cloneable` và ghi đè phương thức `clone()` hoặc thông qua các phương pháp thủ công.

### Ví dụ về **shallow copy** trong mảng:

```java
class Account {
    int id;
    String name;
}

public class Main {
    public static void main(String[] args) {
        Account[] accounts = new Account[2];
        accounts[0] = new Account();
        accounts[0].id = 1;
        accounts[0].name = "Nguyễn Văn A";
        accounts[1] = new Account();
        accounts[1].id = 2;
        accounts[1].name = "Nguyễn Văn B";
        
        // Shallow copy mảng
        Account[] accountsCopy = accounts.clone();
        
        accountsCopy[0].name = "Nguyễn Văn C";
        
        System.out.println(accounts[0].name);  // In ra "Nguyễn Văn C"
    }
}
```

### Ví dụ về **deep copy**:

```java
public class Main {
    public static void main(String[] args) {
        Account[] accounts = new Account[2];
        accounts[0] = new Account();
        accounts[0].id = 1;
        accounts[0].name = "Nguyễn Văn A";
        accounts[1] = new Account();
        accounts[1].id = 2;
        accounts[1].name = "Nguyễn Văn B";
        
        // Deep copy mảng
        Account[] accountsDeepCopy = new Account[accounts.length];
        for (int i = 0; i < accounts.length; i++) {
            accountsDeepCopy[i] = new Account();
            accountsDeepCopy[i].id = accounts[i].id;
            accountsDeepCopy[i].name = accounts[i].name;
        }
        
        accountsDeepCopy[0].name = "Nguyễn Văn C";
        
        System.out.println(accounts[0].name);      // Vẫn in "Nguyễn Văn A"
        System.out.println(accountsDeepCopy[0].name);  // In "Nguyễn Văn C"
    }
}
```

## 4. Điểm đặc biệt của `String`

Mặc dù `String` là kiểu đối tượng trong Java, nhưng vì tính **bất biến (immutable)**, nên khi thao tác, Java sẽ tạo ra các đối tượng `String` mới nếu có thay đổi. Điều này mang lại hành vi tương tự như kiểu nguyên thủy về mặt sao chép và xử lý.

## Kết luận

- **Nguyên thủy**: Cả Java và JavaScript đều sao chép giá trị thực khi gán biến.
    
- **Tham chiếu**: Trong cả hai ngôn ngữ, các đối tượng hoặc mảng đều được sao chép theo địa chỉ.
    
- **Deep Copy**: Cần thiết nếu muốn tránh việc thay đổi ảnh hưởng qua các tham chiếu.
    

Các cơ chế trên giúp lập trình viên hiểu và kiểm soát tốt hơn việc thao tác với dữ liệu trong các ứng dụng.