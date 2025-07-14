---
title: Tổng hợp các câu hỏi phỏng vấn thường gặp về Java cơ bản (Phần 1)
category: Java
tag:
  - Java cơ bản
head:
  - - meta
    - name: keywords
      content: Đặc điểm Java,Java SE,Java EE,Java ME,Máy ảo Java,JVM,JDK,JRE,Bytecode,Biên dịch và thông dịch Java,Biên dịch AOT,Cloud Native,So sánh AOT và JIT,GraalVM,Sự khác biệt giữa Oracle JDK và OpenJDK,OpenJDK,Hỗ trợ LTS,Hỗ trợ đa luồng,Biến tĩnh,Sự khác biệt giữa biến thành viên và biến cục bộ,Cơ chế bộ đệm kiểu bao bọc,Tự động đóng hộp và mở hộp,Mất độ chính xác số thực,BigDecimal,Kiểu dữ liệu cơ bản Java,Định danh và từ khóa Java,Toán tử dịch chuyển bit,Chú thích Java,Phương thức tĩnh và phương thức thể hiện,Nạp chồng và ghi đè phương thức,Tham số biến đổi độ dài,Tối ưu hóa hiệu suất Java
  - - meta
    - name: description
      content: Tổng hợp các kiến thức cơ bản và câu hỏi phỏng vấn Java chất lượng nhất trên mạng, hy vọng sẽ giúp ích cho bạn!
---

<!-- @include: @small-advertisement.snippet.md -->

## Khái niệm cơ bản và kiến thức phổ thông

### Ngôn ngữ Java có những đặc điểm nào?

1.  Đơn giản, dễ học (cú pháp đơn giản, dễ làm quen);
2.  Hướng đối tượng (đóng gói, kế thừa, đa hình);
3.  Độc lập nền tảng (Máy ảo Java thực hiện tính độc lập nền tảng);
4.  Hỗ trợ đa luồng (Ngôn ngữ C++ không có cơ chế đa luồng tích hợp sẵn, do đó phải gọi các chức năng đa luồng của hệ điều hành để thiết kế chương trình đa luồng, trong khi ngôn ngữ Java lại cung cấp hỗ trợ đa luồng);
5.  Độ tin cậy (có cơ chế xử lý ngoại lệ và quản lý bộ nhớ tự động);
6.  Tính bảo mật (Thiết kế của ngôn ngữ Java cung cấp nhiều cơ chế bảo vệ an toàn như các từ khóa kiểm soát truy cập, hạn chế chương trình truy cập trực tiếp tài nguyên hệ điều hành);
7.  Hiệu quả (Thông qua các kỹ thuật tối ưu hóa như trình biên dịch Just In Time, hiệu suất chạy của ngôn ngữ Java vẫn rất tốt);
8.  Hỗ trợ lập trình mạng và rất tiện lợi;
9.  Cùng tồn tại cả biên dịch và thông dịch;
10. ...

> **🐛 Chỉnh sửa (tham khảo: [issue#544](https://github.com/Snailclimb/JavaGuide/issues/544))**: Bắt đầu từ C++11 (năm 2011), C++ đã giới thiệu thư viện đa luồng, trên windows, linux, macos đều có thể sử dụng `std::thread` và `std::async` để tạo luồng. Link tham khảo: <http://www.cplusplus.com/reference/thread/thread/?kw=thread>

🌈 Mở rộng thêm:

Khẩu hiệu quảng cáo "Write Once, Run Anywhere (Viết một lần, chạy mọi nơi)" thực sự kinh điển, đã lưu truyền nhiều năm! Đến nỗi, cho đến tận hôm nay, vẫn có nhiều người cho rằng tính đa nền tảng là ưu điểm lớn nhất của ngôn ngữ Java. Thực tế, tính đa nền tảng không còn là điểm mạnh nhất của Java, các tính năng mới của JDK cũng không phải. Hiện nay, công nghệ ảo hóa trên thị trường đã rất trưởng thành, ví dụ như bạn có thể dễ dàng thực hiện đa nền tảng thông qua Docker. Theo tôi, hệ sinh thái mạnh mẽ của Java mới là điều quan trọng nhất!

### Java SE và Java EE

-   Java SE (Java Platform, Standard Edition): Phiên bản tiêu chuẩn của nền tảng Java, là nền tảng của ngôn ngữ lập trình Java. Nó bao gồm các thư viện lớp cốt lõi và các thành phần cốt lõi như máy ảo để hỗ trợ phát triển và chạy các ứng dụng Java. Java SE có thể được sử dụng để xây dựng các ứng dụng máy tính để bàn hoặc các ứng dụng máy chủ đơn giản.
-   Java EE (Java Platform, Enterprise Edition): Phiên bản doanh nghiệp của nền tảng Java, được xây dựng trên nền tảng Java SE. Nó bao gồm các tiêu chuẩn và đặc tả hỗ trợ phát triển và triển khai các ứng dụng cấp doanh nghiệp (ví dụ: Servlet, JSP, EJB, JDBC, JPA, JTA, JavaMail, JMS). Java EE có thể được sử dụng để xây dựng các ứng dụng Java phía máy chủ phân tán, di động, mạnh mẽ, có khả năng mở rộng và an toàn, ví dụ như các ứng dụng Web.

Nói một cách đơn giản, Java SE là phiên bản cơ bản của Java, Java EE là phiên bản nâng cao của Java. Java SE phù hợp hơn để phát triển các ứng dụng máy tính để bàn hoặc các ứng dụng máy chủ đơn giản, Java EE phù hợp hơn để phát triển các ứng dụng cấp doanh nghiệp phức tạp hoặc các ứng dụng Web.

Ngoài Java SE và Java EE, còn có Java ME (Java Platform, Micro Edition). Java ME là phiên bản thu nhỏ của Java, chủ yếu được sử dụng để phát triển các ứng dụng cho thiết bị điện tử tiêu dùng nhúng, ví dụ như điện thoại di động, PDA, set-top box, tủ lạnh, máy điều hòa, v.v. Java ME không cần phải quan tâm nhiều, chỉ cần biết là có nó là được, hiện tại đã không còn được sử dụng nữa.

### JVM, JDK và JRE

#### JVM

Máy ảo Java (Java Virtual Machine, JVM) là máy ảo chạy mã byte Java. JVM có các triển khai cụ thể cho các hệ thống khác nhau (Windows, Linux, macOS), mục đích là sử dụng cùng một mã byte, chúng đều sẽ cho ra kết quả giống nhau. Mã byte và các triển khai JVM cho các hệ thống khác nhau là mấu chốt của khẩu hiệu "biên dịch một lần, chạy mọi nơi" của ngôn ngữ Java.

Như hình dưới đây, các ngôn ngữ lập trình khác nhau (Java, Groovy, Kotlin, JRuby, Clojure ...) thông qua các trình biên dịch riêng của chúng được biên dịch thành tệp `.class`, và cuối cùng chạy trên các nền tảng khác nhau (Windows, Mac, Linux) thông qua JVM.

![Các ngôn ngữ lập trình chạy trên Máy ảo Java](https://oss.javaguide.cn/github/javaguide/java/basis/java-virtual-machine-program-language-os.png)

**JVM không chỉ có một loại! Chỉ cần đáp ứng đặc tả JVM, mỗi công ty, tổ chức hoặc cá nhân đều có thể phát triển JVM độc quyền của riêng mình.** Điều đó có nghĩa là HotSpot VM mà chúng ta thường tiếp xúc chỉ là một trong những triển khai của đặc tả JVM.

Ngoài HotSpot VM mà chúng ta thường sử dụng nhất, còn có các JVM khác như J9 VM, Zing VM, JRockit VM. Trên Wikipedia có so sánh các JVM phổ biến: [Comparison of Java virtual machines](https://en.wikipedia.org/wiki/Comparison_of_Java_virtual_machines), nếu bạn quan tâm có thể xem thử. Hơn nữa, bạn có thể tìm thấy đặc tả JVM tương ứng với từng phiên bản JDK trên [Java SE Specifications](https://docs.oracle.com/javase/specs/index.html).

![](https://oss.javaguide.cn/github/javaguide/java/basis/JavaSeSpecifications.jpg)

#### JDK và JRE

JDK (Java Development Kit) là một bộ công cụ phát triển Java đầy đủ tính năng, dành cho các nhà phát triển sử dụng để tạo và biên dịch các chương trình Java. Nó bao gồm JRE (Java Runtime Environment), cũng như trình biên dịch javac và các công cụ khác như javadoc (trình tạo tài liệu), jdb (trình gỡ lỗi), jconsole (công cụ giám sát), javap (công cụ dịch ngược), v.v.

JRE là môi trường cần thiết để chạy các chương trình Java đã được biên dịch, chủ yếu bao gồm hai phần sau:

1.  **JVM**: Chính là Máy ảo Java mà chúng ta đã đề cập ở trên.
2.  **Thư viện lớp cơ bản của Java (Class Library)**: Một tập hợp các thư viện tiêu chuẩn, cung cấp các chức năng và API thường dùng (như thao tác I/O, giao tiếp mạng, cấu trúc dữ liệu, v.v.).

Nói một cách đơn giản, JRE chỉ bao gồm môi trường và thư viện lớp cần thiết để chạy chương trình Java, trong khi JDK không chỉ bao gồm JRE mà còn cả các công cụ dùng để phát triển và gỡ lỗi chương trình Java.

Nếu cần viết, biên dịch chương trình Java hoặc sử dụng tài liệu API Java, bạn cần cài đặt JDK. Một số ứng dụng yêu cầu các tính năng của Java (như chuyển đổi JSP thành Servlet hoặc sử dụng reflection) cũng có thể cần JDK để biên dịch và chạy mã Java. Do đó, ngay cả khi không làm công việc phát triển Java, đôi khi bạn vẫn có thể cần cài đặt JDK.

Hình dưới đây thể hiện rõ mối quan hệ giữa JDK, JRE và JVM.

![jdk-bao-gồm-jre](https://oss.javaguide.cn/github/javaguide/java/basis/jdk-include-jre.png)

Tuy nhiên, từ JDK 9 trở đi, không cần phải phân biệt mối quan hệ giữa JDK và JRE nữa, thay vào đó là hệ thống mô-đun (JDK được tổ chức lại thành 94 mô-đun) + công cụ [jlink](http://openjdk.java.net/jeps/282) (công cụ dòng lệnh mới được phát hành cùng với Java 9, dùng để tạo ảnh thực thi Java tùy chỉnh, ảnh này chỉ chứa các mô-đun cần thiết cho một ứng dụng nhất định). Hơn nữa, từ JDK 11 trở đi, Oracle không còn cung cấp bản tải xuống JRE riêng biệt nữa.

Trong bài viết [Tổng quan về các tính năng mới của Java 9](https://javaguide.cn/java/new-features/java9.html), khi giới thiệu về hệ thống mô-đun, tôi đã đề cập:

> Sau khi giới thiệu hệ thống mô-đun, JDK được tổ chức lại thành 94 mô-đun. Các ứng dụng Java có thể thông qua công cụ jlink mới được thêm vào để tạo ra một ảnh thực thi tùy chỉnh chỉ chứa các mô-đun JDK mà nó phụ thuộc. Điều này có thể giảm đáng kể kích thước của môi trường thực thi Java.

Nói cách khác, bạn có thể sử dụng jlink để tạo một runtime (môi trường thực thi) nhỏ hơn theo nhu cầu của mình, thay vì ứng dụng nào cũng sử dụng cùng một JRE.

Ảnh thực thi Java tùy chỉnh, được mô-đun hóa giúp đơn giản hóa việc triển khai ứng dụng Java, tiết kiệm bộ nhớ, đồng thời tăng cường tính bảo mật và khả năng bảo trì. Điều này rất quan trọng để đáp ứng nhu cầu của các kiến trúc ứng dụng hiện đại như ảo hóa, container hóa, microservice và phát triển cloud native.

### Bytecode là gì? Lợi ích của việc sử dụng bytecode là gì?

Trong Java, mã mà JVM có thể hiểu được gọi là bytecode (tức là tệp có phần mở rộng là `.class`). Nó không hướng đến bất kỳ bộ xử lý cụ thể nào, mà chỉ hướng đến máy ảo. Ngôn ngữ Java, thông qua bytecode, đã giải quyết ở một mức độ nhất định vấn đề hiệu suất thực thi thấp của các ngôn ngữ thông dịch truyền thống, đồng thời vẫn giữ được đặc tính di động của ngôn ngữ thông dịch. Do đó, chương trình Java khi chạy tương đối hiệu quả (tuy nhiên, vẫn có một khoảng cách nhất định so với các ngôn ngữ như C, C++, Rust, Go), và vì bytecode không nhắm vào một loại máy cụ thể nào, nên chương trình Java không cần phải biên dịch lại mà vẫn có thể chạy trên nhiều máy tính có hệ điều hành khác nhau.

**Quá trình từ mã nguồn đến khi chạy của chương trình Java được thể hiện trong hình dưới đây**:

![Quá trình chương trình Java chuyển đổi thành mã máy](https://oss.javaguide.cn/github/javaguide/java/basis/java-code-to-machine-code.png)

Chúng ta cần đặc biệt lưu ý bước `.class->mã máy`. Ở bước này, trình nạp lớp của JVM trước tiên sẽ tải tệp bytecode, sau đó thông qua trình thông dịch để giải thích và thực thi từng dòng, tốc độ thực thi theo cách này sẽ tương đối chậm. Hơn nữa, một số phương thức và khối mã thường xuyên được gọi (còn gọi là mã nóng), vì vậy sau này đã giới thiệu trình biên dịch **JIT (Just in Time Compilation)**, và JIT thuộc loại biên dịch thời gian chạy. Khi trình biên dịch JIT hoàn thành lần biên dịch đầu tiên, nó sẽ lưu lại mã máy tương ứng với bytecode, lần sau có thể sử dụng trực tiếp. Và chúng ta biết rằng, hiệu suất chạy của mã máy chắc chắn cao hơn trình thông dịch Java. Điều này cũng giải thích tại sao chúng ta thường nói **Java là ngôn ngữ cùng tồn tại cả biên dịch và thông dịch** .

> 🌈 Đọc thêm:
>
> -   [Kiến thức cơ bản | Phân tích nguyên lý và thực tiễn của trình biên dịch Java Just-In-Time - Nhóm kỹ thuật Meituan](https://tech.meituan.com/2020/10/22/java-jit-practice-in-meituan.html)
> -   [Xây dựng ứng dụng microservice dựa trên biên dịch tĩnh - Alibaba Middleware](https://mp.weixin.qq.com/s/4haTyXUmh8m-dBQaEzwDJw)

![Quá trình chương trình Java chuyển đổi thành mã máy với JIT](https://oss.javaguide.cn/github/javaguide/java/basis/java-code-to-machine-code-with-jit.png)

> HotSpot áp dụng phương pháp đánh giá lười (Lazy Evaluation), theo nguyên tắc 80/20, chỉ một phần nhỏ mã (mã nóng) tiêu tốn phần lớn tài nguyên hệ thống, và đây chính là phần mà JIT cần biên dịch. JVM sẽ thu thập thông tin dựa trên tình hình thực thi của mã mỗi lần và thực hiện một số tối ưu hóa tương ứng, do đó, số lần thực thi càng nhiều, tốc độ của nó càng nhanh.

Mối quan hệ giữa JDK, JRE, JVM, JIT được thể hiện trong hình dưới đây.

![Mối quan hệ giữa JDK, JRE, JVM, JIT](https://oss.javaguide.cn/github/javaguide/java/basis/jdk-jre-jvm-jit.png)

Hình dưới đây là mô hình cấu trúc tổng quan của JVM.

![Mô hình cấu trúc tổng quan của JVM](https://oss.javaguide.cn/github/javaguide/java/basis/jvm-rough-structure-model.png)

### Tại sao nói ngôn ngữ Java "cùng tồn tại cả biên dịch và thông dịch"?

Thực ra vấn đề này chúng ta đã đề cập khi nói về bytecode, vì nó khá quan trọng nên ở đây chúng ta sẽ nhắc lại.

Chúng ta có thể chia các ngôn ngữ lập trình bậc cao thành hai loại dựa trên cách thực thi chương trình:

-   **Biên dịch**: [Ngôn ngữ biên dịch](https://vi.wikipedia.org/wiki/Ng%C3%B4n_ng%E1%BB%AF_bi%C3%AAn_d%E1%BB%8Bch) sẽ thông qua [trình biên dịch](https://vi.wikipedia.org/wiki/Tr%C3%ACnh_bi%C3%AAn_d%E1%BB%8Bch) để dịch toàn bộ mã nguồn một lần thành mã máy có thể thực thi trên nền tảng đó. Thông thường, tốc độ thực thi của ngôn ngữ biên dịch nhanh hơn, hiệu quả phát triển thấp hơn. Các ngôn ngữ biên dịch phổ biến bao gồm C, C++, Go, Rust, v.v.
-   **Thông dịch**: [Ngôn ngữ thông dịch](https://vi.wikipedia.org/wiki/Ng%C3%B4n_ng%E1%BB%AF_th%C3%B4ng_d%E1%BB%8Bch) sẽ thông qua [trình thông dịch](https://vi.wikipedia.org/wiki/Tr%C3%ACnh_th%C3%B4ng_d%E1%BB%8Bch) để giải thích từng dòng mã thành mã máy rồi mới thực thi. Hiệu quả phát triển của ngôn ngữ thông dịch nhanh hơn, tốc độ thực thi chậm hơn. Các ngôn ngữ thông dịch phổ biến bao gồm Python, JavaScript, PHP, v.v.

![Ngôn ngữ biên dịch và ngôn ngữ thông dịch](https://oss.javaguide.cn/github/javaguide/java/basis/compiled-and-interpreted-languages.png)

Theo giới thiệu của Wikipedia:

> Để cải thiện hiệu quả của ngôn ngữ thông dịch, kỹ thuật [biên dịch tức thời (JIT)](https://vi.wikipedia.org/wiki/Bi%C3%AAn_d%E1%BB%8Bch_t%E1%BB%A9c_th%E1%BB%9Di) đã được phát triển, thu hẹp khoảng cách giữa hai loại ngôn ngữ này. Kỹ thuật này kết hợp ưu điểm của ngôn ngữ biên dịch và ngôn ngữ thông dịch, nó giống như ngôn ngữ biên dịch, trước tiên biên dịch mã nguồn chương trình thành [bytecode](https://vi.wikipedia.org/wiki/Bytecode). Đến thời điểm thực thi, bytecode sẽ được thông dịch trực tiếp, sau đó thực thi. [Java](https://vi.wikipedia.org/wiki/Java) và [LLVM](https://vi.wikipedia.org/wiki/LLVM) là những sản phẩm tiêu biểu của kỹ thuật này.
>
> Đọc thêm: [Kiến thức cơ bản | Phân tích nguyên lý và thực tiễn của trình biên dịch Java Just-In-Time](https://tech.meituan.com/2020/10/22/java-jit-practice-in-meituan.html)

**Tại sao nói ngôn ngữ Java "cùng tồn tại cả biên dịch và thông dịch"?**

Điều này là do ngôn ngữ Java vừa có đặc điểm của ngôn ngữ biên dịch, vừa có đặc điểm của ngôn ngữ thông dịch. Bởi vì chương trình Java phải trải qua hai bước: biên dịch trước, sau đó thông dịch. Chương trình được viết bằng Java cần phải qua bước biên dịch trước để tạo ra bytecode (tệp `.class`), loại bytecode này phải được trình thông dịch Java giải thích và thực thi.

### AOT có những ưu điểm gì? Tại sao không sử dụng hoàn toàn AOT?

JDK 9 đã giới thiệu một chế độ biên dịch mới là **AOT (Ahead of Time Compilation)**. Khác với JIT, chế độ biên dịch này sẽ biên dịch chương trình thành mã máy trước khi nó được thực thi, thuộc loại biên dịch tĩnh (các ngôn ngữ như C, C++, Rust, Go là biên dịch tĩnh). AOT tránh được các chi phí khởi động của JIT, có thể tăng tốc độ khởi động của chương trình Java, tránh thời gian khởi động dài. Hơn nữa, AOT còn có thể giảm mức sử dụng bộ nhớ và tăng cường tính bảo mật của chương trình Java (mã được biên dịch AOT không dễ bị dịch ngược và sửa đổi), đặc biệt phù hợp với các kịch bản cloud native.

**So sánh các chỉ số chính giữa JIT và AOT**:

<img src="https://oss.javaguide.cn/github/javaguide/java/basis/jit-vs-aot.png" alt="JIT và AOT" style="zoom: 25%;" />

Có thể thấy, ưu điểm chính của AOT nằm ở thời gian khởi động, mức sử dụng bộ nhớ và kích thước đóng gói. Ưu điểm chính của JIT là có khả năng xử lý cực hạn cao hơn, có thể giảm độ trễ tối đa của yêu cầu.

Nói đến AOT thì không thể không nhắc đến [GraalVM](https://www.graalvm.org/)! GraalVM là một JDK hiệu suất cao (phiên bản phát hành JDK hoàn chỉnh), nó có thể chạy Java và các ngôn ngữ JVM khác, cũng như các ngôn ngữ không phải JVM như JavaScript, Python. GraalVM không chỉ cung cấp biên dịch AOT mà còn cung cấp biên dịch JIT. Các bạn quan tâm có thể xem tài liệu chính thức của GraalVM: <https://www.graalvm.org/latest/docs/>. Nếu cảm thấy tài liệu chính thức khó hiểu, bạn cũng có thể tìm một số bài viết để xem, ví dụ:

-   [Xây dựng ứng dụng microservice dựa trên biên dịch tĩnh](https://mp.weixin.qq.com/s/4haTyXUmh8m-dBQaEzwDJw)
-   [Hướng tới Native hóa: Ví dụ và giải thích nguyên lý kỹ thuật AOT của Spring & Dubbo](https://cn.dubbo.apache.org/zh-cn/blog/2023/06/28/%e8%b5%b0%e5%90%91-native-%e5%8c%96springdubbo-aot-%e6%8a%80%e6%9c%af%e7%a4%ba%e4%be%8b%e4%b8%8e%e5%8e%9f%e7%90%86%e8%ae%b2%e8%a7%a3/)

**Vì AOT có nhiều ưu điểm như vậy, tại sao không sử dụng hoàn toàn phương pháp biên dịch này?**

Chúng ta đã so sánh JIT và AOT ở phần trước, cả hai đều có những ưu điểm riêng, chỉ có thể nói AOT phù hợp hơn với các kịch bản cloud native hiện tại và hỗ trợ tốt hơn cho kiến trúc microservice. Ngoài ra, biên dịch AOT không thể hỗ trợ một số tính năng động của Java như reflection, dynamic proxy, dynamic loading, JNI (Java Native Interface), v.v. Tuy nhiên, nhiều framework và thư viện (như Spring, CGLIB) đều sử dụng các tính năng này. Nếu chỉ sử dụng biên dịch AOT, thì sẽ không thể sử dụng các framework và thư viện này, hoặc cần phải thực hiện các điều chỉnh và tối ưu hóa cụ thể. Ví dụ, CGLIB dynamic proxy sử dụng kỹ thuật ASM, nguyên lý đại khái của kỹ thuật này là tạo và tải trực tiếp tệp bytecode đã sửa đổi (tức là tệp `.class`) trong bộ nhớ khi chạy, nếu sử dụng hoàn toàn biên dịch AOT trước, thì sẽ không thể sử dụng kỹ thuật ASM. Để hỗ trợ các tính năng động tương tự, người ta chọn sử dụng trình biên dịch JIT.

### Oracle JDK và OpenJDK

Có thể trước khi xem vấn đề này, nhiều người giống như tôi chưa từng tiếp xúc và sử dụng OpenJDK. Vậy giữa Oracle JDK và OpenJDK có sự khác biệt lớn nào không? Dưới đây, thông qua một số tài liệu thu thập được, tôi sẽ giải đáp cho bạn vấn đề thường bị nhiều người bỏ qua này.

Đầu tiên, vào năm 2006, công ty SUN đã mã nguồn mở Java, từ đó OpenJDK ra đời. Năm 2009, Oracle mua lại công ty Sun, sau đó tự mình phát triển Oracle JDK dựa trên OpenJDK. Oracle JDK không phải là mã nguồn mở, và trong vài phiên bản đầu (Java 8 ~ Java 11), nó còn thêm một số tính năng và công cụ độc quyền so với OpenJDK.

Thứ hai, đối với Java 7, OpenJDK và Oracle JDK rất giống nhau. Oracle JDK được xây dựng dựa trên OpenJDK 7, chỉ thêm một vài tính năng nhỏ, được duy trì bởi các kỹ sư của Oracle.

Đoạn văn dưới đây được trích từ một blog chính thức của Oracle đăng năm 2012:

> Hỏi: Có sự khác biệt nào giữa mã nguồn trong kho lưu trữ OpenJDK và mã được sử dụng để xây dựng Oracle JDK không?
>
> Đáp: Rất gần nhau - Quá trình xây dựng phiên bản Oracle JDK của chúng tôi dựa trên OpenJDK 7, chỉ thêm một vài phần, ví dụ như mã triển khai, bao gồm plugin Java của Oracle và triển khai Java WebStart, cũng như một số thành phần của bên thứ ba mã nguồn đóng, như trình raster hóa đồ họa, một số thành phần của bên thứ ba mã nguồn mở, như Rhino, và một số thứ lặt vặt khác, như tài liệu bổ sung hoặc phông chữ của bên thứ ba. Trong tương lai, mục tiêu của chúng tôi là mã nguồn mở tất cả các phần của Oracle JDK, ngoại trừ những phần mà chúng tôi coi là tính năng thương mại.

Cuối cùng, tóm tắt đơn giản sự khác biệt giữa Oracle JDK và OpenJDK:

1.  **Tính mã nguồn mở**: OpenJDK là một mô hình tham chiếu và hoàn toàn là mã nguồn mở, trong khi Oracle JDK được triển khai dựa trên OpenJDK và không hoàn toàn là mã nguồn mở (Quan điểm cá nhân: Mọi người đều biết, JDK ban đầu do công ty SUN phát triển, sau đó công ty SUN lại bán cho công ty Oracle, công ty Oracle nổi tiếng với cơ sở dữ liệu Oracle, và cơ sở dữ liệu Oracle lại là mã nguồn đóng. Lúc này, công ty Oracle không muốn hoàn toàn mã nguồn mở nữa, nhưng công ty SUN trước đó đã mã nguồn mở JDK rồi. Nếu lúc này Oracle mua lại rồi đóng mã nguồn, chắc chắn sẽ gây ra sự bất mãn của nhiều nhà phát triển Java, khiến mọi người mất niềm tin vào Java, vậy thì công ty Oracle mua lại chẳng phải là ôm một mớ Java bỏ đi sao! Sau đó, công ty Oracle đã nghĩ ra một chiêu trò, đại khái là: tôi sẽ mã nguồn mở một phần mã cốt lõi cho các bạn dùng thử, và tôi muốn phân biệt với JDK do các bạn tự phát triển, các bạn gọi là OpenJDK, tôi gọi là Oracle JDK, tôi phát hành của tôi, các bạn cứ tiếp tục phát triển của các bạn, nếu các bạn tạo ra thứ gì đó hay ho, sau này khi tôi phát hành Oracle JDK cũng sẽ lấy dùng, một công đôi việc!) Dự án mã nguồn mở OpenJDK: [https://github.com/openjdk/jdk](https://github.com/openjdk/jdk) .
2.  **Tính miễn phí**: Oracle JDK sẽ cung cấp các phiên bản miễn phí, nhưng thường có giới hạn thời gian. Các phiên bản sau JDK17 có thể được phân phối và sử dụng thương mại miễn phí, nhưng chỉ trong 3 năm, sau 3 năm không thể sử dụng thương mại miễn phí nữa. Tuy nhiên, trước JDK8u221, nếu không nâng cấp thì có thể sử dụng miễn phí vô thời hạn. OpenJDK hoàn toàn miễn phí.
3.  **Chức năng**: Oracle JDK đã thêm một số tính năng và công cụ độc quyền dựa trên OpenJDK, ví dụ như Java Flight Recorder (JFR, một công cụ giám sát), Java Mission Control (JMC, một công cụ giám sát), v.v. Tuy nhiên, sau Java 11, chức năng của OracleJDK và OpenJDK về cơ bản là giống nhau, hầu hết các thành phần riêng tư trong OracleJDK trước đây cũng đã được quyên góp cho các tổ chức mã nguồn mở.
4.  **Tính ổn định**: OpenJDK không cung cấp dịch vụ LTS, trong khi OracleJDK khoảng ba năm một lần sẽ tung ra một phiên bản LTS để hỗ trợ dài hạn. Tuy nhiên, nhiều công ty đã cung cấp các phiên bản LTS tương ứng dựa trên OpenJDK với chu kỳ giống như OracleJDK. Do đó, tính ổn định của cả hai thực ra cũng tương tự nhau.
5.  **Giấy phép**: Oracle JDK được cấp phép theo giấy phép BCL/OTN, trong khi OpenJDK được cấp phép theo giấy phép GPL v2.

> Vì Oracle JDK tốt như vậy, tại sao vẫn cần OpenJDK?
>
> Đáp:
>
> 1.  OpenJDK là mã nguồn mở, mã nguồn mở có nghĩa là bạn có thể sửa đổi, tối ưu hóa nó theo nhu cầu của riêng mình, ví dụ như Alibaba đã phát triển Dragonwell8 dựa trên OpenJDK: [https://github.com/alibaba/dragonwell8](https://github.com/alibaba/dragonwell8)
> 2.  OpenJDK miễn phí cho mục đích thương mại (đó cũng là lý do tại sao JDK được cài đặt mặc định thông qua trình quản lý gói yum là OpenJDK chứ không phải Oracle JDK). Mặc dù Oracle JDK cũng miễn phí cho mục đích thương mại (ví dụ JDK 8), nhưng không phải tất cả các phiên bản đều miễn phí.
> 3.  Tần suất cập nhật của OpenJDK nhanh hơn. Oracle JDK thường phát hành phiên bản mới sau mỗi 6 tháng, trong khi OpenJDK thường phát hành phiên bản mới sau mỗi 3 tháng. (Bây giờ bạn đã biết tại sao Oracle JDK ổn định hơn rồi chứ, trước tiên thử nghiệm trên OpenJDK, giải quyết hầu hết các vấn đề rồi mới phát hành trên Oracle JDK)
>
> Dựa trên những lý do trên, OpenJDK vẫn cần thiết phải tồn tại!

![Lịch phát hành Oracle JDK](https://oss.javaguide.cn/github/javaguide/java/basis/oracle-jdk-release-cadence.jpg)

**Nên chọn Oracle JDK hay OpenJDK?**

Khuyến nghị chọn OpenJDK hoặc các bản phân phối dựa trên OpenJDK, ví dụ như Amazon Corretto của AWS, Alibaba Dragonwell của Alibaba.

🌈 Mở rộng thêm:

-   Giấy phép BCL (Oracle Binary Code License Agreement): Có thể sử dụng JDK (hỗ trợ thương mại), nhưng không được sửa đổi.
-   Giấy phép OTN (Oracle Technology Network License Agreement): Các JDK mới được phát hành từ phiên bản 11 trở đi đều sử dụng giấy phép này, có thể sử dụng cá nhân, nhưng sử dụng thương mại cần phải trả phí.

### Sự khác biệt giữa Java và C++?

Tôi biết nhiều người chưa học C++, nhưng người phỏng vấn lại thích so sánh Java của chúng ta với C++! Không còn cách nào khác!!! Ngay cả khi chưa học C++, cũng phải ghi nhớ.

Mặc dù Java và C++ đều là ngôn ngữ hướng đối tượng, đều hỗ trợ đóng gói, kế thừa và đa hình, nhưng chúng vẫn có khá nhiều điểm khác biệt:

-   Java không cung cấp con trỏ để truy cập trực tiếp vào bộ nhớ, bộ nhớ chương trình an toàn hơn
-   Lớp của Java là đơn kế thừa, C++ hỗ trợ đa kế thừa; mặc dù lớp của Java không thể đa kế thừa, nhưng interface có thể đa kế thừa.
-   Java có cơ chế quản lý bộ nhớ tự động thu gom rác (GC), lập trình viên không cần giải phóng bộ nhớ không sử dụng theo cách thủ công.
-   C++ hỗ trợ đồng thời nạp chồng phương thức và nạp chồng toán tử, nhưng Java chỉ hỗ trợ nạp chồng phương thức (nạp chồng toán tử làm tăng độ phức tạp, điều này không phù hợp với tư tưởng thiết kế ban đầu của Java).
-   ...

## Cú pháp cơ bản

### Có những dạng chú thích nào?

Trong Java có ba loại chú thích:

1.  **Chú thích một dòng**: Thường được sử dụng để giải thích tác dụng của một dòng mã cụ thể trong phương thức.
2.  **Chú thích nhiều dòng**: Thường được sử dụng để giải thích tác dụng của một đoạn mã.
3.  **Chú thích tài liệu**: Thường được sử dụng để tạo tài liệu phát triển Java.

Chú thích một dòng và chú thích tài liệu được sử dụng nhiều hơn, chú thích nhiều dòng tương đối ít được sử dụng trong phát triển thực tế.

![](https://oss.javaguide.cn/github/javaguide/java/basis/image-20220714112336911.png)

Khi chúng ta viết mã, nếu lượng mã tương đối ít, bản thân chúng ta hoặc các thành viên khác trong nhóm vẫn có thể dễ dàng hiểu được mã. Nhưng khi cấu trúc dự án trở nên phức tạp, chúng ta cần sử dụng chú thích. Chú thích sẽ không được thực thi (trình biên dịch sẽ xóa tất cả các chú thích trong mã trước khi biên dịch, bytecode không giữ lại chú thích), đó là những gì lập trình viên viết cho chính mình xem. Chú thích là bản hướng dẫn sử dụng mã của bạn, có thể giúp người đọc mã nhanh chóng hiểu rõ mối quan hệ logic giữa các đoạn mã. Do đó, việc thêm chú thích khi viết chương trình là một thói quen rất tốt.

Cuốn sách "Clean Code" chỉ rõ:

> **Chú thích của mã không phải càng chi tiết càng tốt. Thực tế, mã tốt tự nó đã là chú thích, chúng ta nên cố gắng chuẩn hóa và làm đẹp mã của mình để giảm bớt những chú thích không cần thiết.**
>
> **Nếu ngôn ngữ lập trình đủ diễn đạt, thì không cần chú thích, hãy cố gắng diễn giải thông qua mã.**
>
> Ví dụ:
>
> Bỏ đi chú thích phức tạp dưới đây, chỉ cần tạo một hàm thực hiện cùng một việc như chú thích đã nói là được
>
> ```java
> // check to see if the employee is eligible for full benefits
> if ((employee.flags & HOURLY_FLAG) && (employee.age > 65))
> ```
>
> Nên thay thế bằng
>
> ```java
> if (employee.isEligibleForFullBenefits())
> ```

### Sự khác biệt giữa định danh và từ khóa là gì?

Khi chúng ta viết chương trình, cần phải đặt tên rất nhiều cho chương trình, lớp, biến, phương thức, v.v., từ đó xuất hiện **định danh**. Nói một cách đơn giản, **định danh là một cái tên** .

Có một số định danh mà ngôn ngữ Java đã gán cho chúng những ý nghĩa đặc biệt, chỉ có thể được sử dụng ở những nơi cụ thể, những định danh đặc biệt này chính là **từ khóa**. Nói một cách đơn giản, **từ khóa là những định danh được gán ý nghĩa đặc biệt**. Ví dụ, trong cuộc sống hàng ngày của chúng ta, nếu muốn mở một cửa hàng, chúng ta phải đặt tên cho cửa hàng đó, "tên" được đặt này gọi là định danh. Nhưng tên cửa hàng của chúng ta không thể là "Sở cảnh sát", bởi vì tên "Sở cảnh sát" đã được gán ý nghĩa đặc biệt, và "Sở cảnh sát" chính là từ khóa trong cuộc sống hàng ngày của chúng ta.

### Ngôn ngữ Java có những từ khóa nào?

| Phân loại             | Từ khóa   |            |          |              |            |           |        |
| :------------------- | -------- | ---------- | -------- | ------------ | ---------- | --------- | ------ |
| Kiểm soát truy cập   | private  | protected  | public   |              |            |           |        |
| Từ khóa sửa đổi lớp, phương thức và biến | abstract | class      | extends  | final        | implements | interface | native |
|                      | new      | static     | strictfp | synchronized | transient  | volatile  | enum   |
| Điều khiển chương trình | break    | continue   | return   | do           | while      | if        | else   |
|                      | for      | instanceof | switch   | case         | default    | assert    |        |
| Xử lý lỗi            | try      | catch      | throw    | throws       | finally    |           |        |
| Liên quan đến gói    | import   | package    |          |              |            |           |        |
| Kiểu cơ bản          | boolean  | byte       | char     | double       | float      | int       | long   |
|                      | short    |            |          |              |            |           |        |
| Tham chiếu biến      | super    | this       | void     |              |            |           |        |
| Từ dành riêng        | goto     | const      |          |              |            |           |        |

> Mẹo: Tất cả các từ khóa đều được viết thường, trong IDE sẽ được hiển thị bằng màu đặc biệt.
>
> Từ khóa `default` này rất đặc biệt, vừa thuộc điều khiển chương trình, vừa thuộc từ khóa sửa đổi lớp, phương thức và biến, lại vừa thuộc kiểm soát truy cập.
>
> -   Trong điều khiển chương trình, khi không có trường hợp nào khớp trong `switch`, có thể sử dụng `default` để viết trường hợp khớp mặc định.
> -   Trong từ khóa sửa đổi lớp, phương thức và biến, kể từ JDK8 đã giới thiệu phương thức mặc định, có thể sử dụng từ khóa `default` để định nghĩa một triển khai mặc định của phương thức.
> -   Trong kiểm soát truy cập, nếu một phương thức không có bất kỳ từ khóa sửa đổi nào ở phía trước, thì mặc định sẽ có một từ khóa sửa đổi `default`, nhưng nếu thêm từ khóa sửa đổi này vào sẽ báo lỗi.

⚠️ Chú ý: Mặc dù `true`, `false`, và `null` trông giống như từ khóa nhưng thực tế chúng là các giá trị chữ, đồng thời bạn cũng không thể sử dụng chúng làm định danh.

Tài liệu chính thức: [https://docs.oracle.com/javase/tutorial/java/nutsandbolts/_keywords.html](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/_keywords.html)

### Toán tử tăng giảm

Trong quá trình viết mã, một trường hợp phổ biến là cần tăng hoặc giảm giá trị của một biến kiểu số nguyên đi 1. Java cung cấp toán tử tăng (`++`) và toán tử giảm (`--`) để đơn giản hóa thao tác này.

Toán tử `++` và `--` có thể được đặt trước hoặc sau biến:

-   **Dạng tiền tố** (ví dụ `++a` hoặc `--a`): Trước tiên tăng/giảm giá trị của biến, sau đó mới sử dụng biến đó. Ví dụ, `b = ++a` trước tiên tăng `a` lên 1, sau đó gán giá trị đã tăng cho `b`.
-   **Dạng hậu tố** (ví dụ `a++` hoặc `a--`): Trước tiên sử dụng giá trị hiện tại của biến, sau đó mới tăng/giảm giá trị của biến. Ví dụ, `b = a++` trước tiên gán giá trị hiện tại của `a` cho `b`, sau đó mới tăng `a` lên 1`.

Để dễ nhớ, có thể sử dụng khẩu quyết sau: **Ký hiệu ở trước thì cộng/trừ trước, ký hiệu ở sau thì cộng/trừ sau**.

Dưới đây là một câu hỏi thi viết thường gặp kiểm tra toán tử tăng giảm: Sau khi thực thi đoạn mã dưới đây, giá trị của `a`, `b`, `c`, `d` và `e` là bao nhiêu?

```java
int a = 9;
int b = a++;
int c = ++a;
int d = c--;
int e = --d;
```

Đáp án: `a = 11` , `b = 9` , `c = 10` , `d = 10` , `e = 10`.

### Toán tử dịch chuyển bit

Toán tử dịch chuyển bit là một trong những toán tử cơ bản nhất, hầu hết mọi ngôn ngữ lập trình đều có toán tử này. Trong thao tác dịch chuyển, dữ liệu được thao tác được coi là số nhị phân, dịch chuyển là phép toán di chuyển nó sang trái hoặc sang phải một số bit nhất định.

Toán tử dịch chuyển bit được sử dụng khá rộng rãi trong các framework khác nhau cũng như trong mã nguồn của chính JDK. Mã nguồn của phương thức `hash` trong `HashMap` (JDK1.8) đã sử dụng toán tử dịch chuyển bit:

```java
static final int hash(Object key) {
    int h;
    // key.hashCode(): trả về giá trị băm tức là hashcode
    // ^: phép XOR bit
    // >>>: dịch phải không dấu, bỏ qua bit dấu, các vị trí trống đều được điền bằng 0
    return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
  }

```

**Lý do chính sử dụng toán tử dịch chuyển bit**:

1.  **Hiệu quả**: Toán tử dịch chuyển bit tương ứng trực tiếp với các lệnh dịch chuyển của bộ xử lý. Các bộ xử lý hiện đại có các lệnh phần cứng chuyên dụng để thực hiện các thao tác dịch chuyển này, các lệnh này thường hoàn thành trong một chu kỳ xung nhịp. Ngược lại, các phép toán số học như nhân và chia ở cấp độ phần cứng cần nhiều chu kỳ xung nhịp hơn để hoàn thành.
2.  **Tiết kiệm bộ nhớ**: Thông qua thao tác dịch chuyển, có thể sử dụng một số nguyên (như `int` hoặc `long`) để lưu trữ nhiều giá trị boolean hoặc cờ hiệu, từ đó tiết kiệm bộ nhớ.

Toán tử dịch chuyển bit thường được sử dụng nhất để nhân hoặc chia nhanh cho lũy thừa của 2. Ngoài ra, nó còn đóng vai trò quan trọng trong các khía cạnh sau:

-   **Quản lý trường bit**: Ví dụ như lưu trữ và thao tác nhiều giá trị boolean.
-   **Thuật toán băm và mã hóa/giải mã**: Thông qua các thao tác dịch chuyển và AND, OR, v.v. để làm xáo trộn dữ liệu.
-   **Nén dữ liệu**: Ví dụ, mã hóa Huffman thông qua toán tử dịch chuyển bit có thể xử lý và thao tác nhanh chóng dữ liệu nhị phân để tạo ra định dạng nén nhỏ gọn.
-   **Kiểm tra dữ liệu**: Ví dụ, CRC (Kiểm tra dư thừa theo chu kỳ) thông qua dịch chuyển và phép chia đa thức để tạo và kiểm tra tính toàn vẹn của dữ liệu.
-   **Căn chỉnh bộ nhớ**: Thông qua thao tác dịch chuyển, có thể dễ dàng tính toán và điều chỉnh địa chỉ căn chỉnh của dữ liệu.

Việc nắm vững kiến thức cơ bản nhất về toán tử dịch chuyển bit là rất cần thiết, điều này không chỉ giúp chúng ta sử dụng trong mã mà còn giúp chúng ta hiểu được mã nguồn liên quan đến toán tử dịch chuyển bit.

Trong Java có ba loại toán tử dịch chuyển bit:

-   `<<` : Toán tử dịch trái, dịch sang trái một số bit nhất định, các bit cao bị loại bỏ, các bit thấp được điền bằng số không. `x << n`, tương đương với x nhân với 2 mũ n (trong trường hợp không bị tràn số).
-   `>>` : Dịch phải có dấu, dịch sang phải một số bit nhất định, bit cao được điền bằng bit dấu, các bit thấp bị loại bỏ. Số dương thì bit cao điền 0, số âm thì bit cao điền 1. `x >> n`, tương đương với x chia cho 2 mũ n.
-   `>>>` : Dịch phải không dấu, bỏ qua bit dấu, các vị trí trống đều được điền bằng 0.

Mặc dù về bản chất, phép toán dịch chuyển có thể được chia thành dịch trái và dịch phải, nhưng trong ứng dụng thực tế, thao tác dịch phải cần xem xét cách xử lý bit dấu.

Do `double`, `float` có biểu diễn khá đặc biệt trong hệ nhị phân, nên không thể thực hiện thao tác dịch chuyển bit.

Toán tử dịch chuyển thực tế chỉ hỗ trợ các kiểu `int` và `long`. Trước khi dịch chuyển các kiểu `short`, `byte`, `char`, trình biên dịch sẽ chuyển đổi chúng thành kiểu `int` rồi mới thao tác.

**Nếu số bit dịch chuyển vượt quá số bit mà giá trị chiếm giữ thì sao？**

Khi kiểu int thực hiện thao tác dịch trái/phải với số bit lớn hơn hoặc bằng 32, nó sẽ thực hiện phép chia lấy dư (%) trước rồi mới thực hiện thao tác dịch trái/phải. Nghĩa là, dịch trái/phải 32 bit tương đương với không dịch chuyển (32%32=0), dịch trái/phải 42 bit tương đương với dịch trái/phải 10 bit (42%32=10). Khi kiểu long thực hiện thao tác dịch trái/phải, do long tương ứng với 64 bit nhị phân, nên cơ số của phép chia lấy dư cũng trở thành 64.

Nói cách khác: `x<<42` tương đương với `x<<10`, `x>>42` tương đương với `x>>10`, `x >>>42` tương đương với `x >>> 10`.

**Ví dụ mã toán tử dịch trái**:

```java
int i = -1;
System.out.println("Dữ liệu ban đầu: " + i);
System.out.println("Chuỗi nhị phân tương ứng của dữ liệu ban đầu: " + Integer.toBinaryString(i));
i <<= 10;
System.out.println("Dữ liệu sau khi dịch trái 10 bit: " + i);
System.out.println("Chuỗi nhị phân tương ứng của dữ liệu sau khi dịch trái 10 bit: " + Integer.toBinaryString(i));
```

Kết quả:

```plain
Dữ liệu ban đầu: -1
Chuỗi nhị phân tương ứng của dữ liệu ban đầu: 11111111111111111111111111111111
Dữ liệu sau khi dịch trái 10 bit: -1024
Chuỗi nhị phân tương ứng của dữ liệu sau khi dịch trái 10 bit: 11111111111111111111110000000000
```

Do khi số bit dịch trái lớn hơn hoặc bằng 32, nó sẽ thực hiện phép chia lấy dư (%) trước rồi mới thực hiện thao tác dịch trái, nên đoạn mã dưới đây dịch trái 42 bit tương đương với dịch trái 10 bit (42%32=10), kết quả đầu ra giống như đoạn mã trước.

```java
int i = -1;
System.out.println("Dữ liệu ban đầu: " + i);
System.out.println("Chuỗi nhị phân tương ứng của dữ liệu ban đầu: " + Integer.toBinaryString(i));
i <<= 42;
System.out.println("Dữ liệu sau khi dịch trái 10 bit: " + i); // Thực tế là 42%32 = 10 bit
System.out.println("Chuỗi nhị phân tương ứng của dữ liệu sau khi dịch trái 10 bit: " + Integer.toBinaryString(i));
```

Toán tử dịch phải sử dụng tương tự, do giới hạn về độ dài, ở đây sẽ không trình bày ví dụ.

### Sự khác biệt giữa continue, break và return là gì?

Trong cấu trúc lặp, khi điều kiện lặp không còn thỏa mãn hoặc số lần lặp đã đạt yêu cầu, vòng lặp sẽ kết thúc bình thường. Tuy nhiên, đôi khi trong quá trình lặp, khi một điều kiện nào đó xảy ra, có thể cần phải kết thúc vòng lặp sớm, lúc này cần sử dụng các từ khóa sau:

1.  `continue`：Chỉ việc bỏ qua lần lặp hiện tại, tiếp tục lần lặp tiếp theo.
2.  `break`：Chỉ việc thoát khỏi toàn bộ khối lặp, tiếp tục thực thi các câu lệnh bên dưới vòng lặp.

`return` được sử dụng để thoát khỏi phương thức hiện tại, kết thúc việc thực thi của phương thức đó. `return` thường có hai cách sử dụng:

1.  `return;`：Sử dụng trực tiếp `return` để kết thúc việc thực thi phương thức, dùng cho các phương thức không có giá trị trả về
2.  `return value;`：Trả về một giá trị cụ thể, dùng cho các phương thức có giá trị trả về

Suy nghĩ một chút: Kết quả chạy của đoạn mã sau là gì?

```java
public static void main(String[] args) {
    boolean flag = false;
    for (int i = 0; i <= 3; i++) {
        if (i == 0) {
            System.out.println("0");
        } else if (i == 1) {
            System.out.println("1");
            continue;
        } else if (i == 2) {
            System.out.println("2");
            flag = true;
        } else if (i == 3) {
            System.out.println("3");
            break;
        } else if (i == 4) {
            System.out.println("4");
        }
        System.out.println("xixi");
    }
    if (flag) {
        System.out.println("haha");
        return;
    }
    System.out.println("heihei");
}
```

Kết quả chạy:

```plain
0
xixi
1
2
xixi
3
haha
```

## Kiểu dữ liệu cơ bản

### Bạn có biết về các kiểu dữ liệu cơ bản trong Java không?

Trong Java có 8 kiểu dữ liệu cơ bản, bao gồm:

-   6 kiểu số:
    -   4 kiểu số nguyên: `byte`、`short`、`int`、`long`
    -   2 kiểu số thực: `float`、`double`
-   1 kiểu ký tự: `char`
-   1 kiểu boolean: `boolean`.

Giá trị mặc định và kích thước không gian chiếm dụng của 8 kiểu dữ liệu cơ bản này như sau:

| Kiểu cơ bản | Số bit | Số byte | Giá trị mặc định | Phạm vi giá trị                                                       |
| :-------- | :--- | :--- | :------ | -------------------------------------------------------------- |
| `byte`    | 8    | 1    | 0       | -128 ~ 127                                                     |
| `short`   | 16   | 2    | 0       | -32768 (-2^15) ~ 32767 (2^15 - 1)                            |
| `int`     | 32   | 4    | 0       | -2147483648 ~ 2147483647                                       |
| `long`    | 64   | 8    | 0L      | -9223372036854775808 (-2^63) ~ 9223372036854775807 (2^63 -1) |
| `char`    | 16   | 2    | '\u0000' | 0 ~ 65535 (2^16 - 1)                                          |
| `float`   | 32   | 4    | 0f      | 1.4E-45 ~ 3.4028235E38                                         |
| `double`  | 64   | 8    | 0d      | 4.9E-324 ~ 1.7976931348623157E308                              |
| `boolean` | 1    |      | false   | true, false                                                    |

Có thể thấy, các số dương lớn nhất mà `byte`, `short`, `int`, `long` có thể biểu diễn đều bị trừ đi 1. Tại sao lại như vậy? Đó là bởi vì trong biểu diễn bù hai của số nhị phân, bit cao nhất được sử dụng để biểu thị dấu (0 biểu thị số dương, 1 biểu thị số âm), các bit còn lại biểu thị phần giá trị. Vì vậy, nếu chúng ta muốn biểu diễn số dương lớn nhất, chúng ta cần đặt tất cả các bit ngoại trừ bit cao nhất thành 1. Nếu chúng ta cộng thêm 1, sẽ dẫn đến tràn số, biến thành một số âm.

Đối với `boolean`, tài liệu chính thức không định nghĩa rõ ràng, nó phụ thuộc vào việc triển khai cụ thể của nhà sản xuất JVM. Về mặt logic, nó chiếm 1 bit, nhưng trong thực tế sẽ xem xét các yếu tố lưu trữ hiệu quả của máy tính.

Ngoài ra, kích thước không gian lưu trữ mà mỗi kiểu dữ liệu cơ bản chiếm dụng sẽ không thay đổi theo kiến trúc phần cứng máy tính như hầu hết các ngôn ngữ khác. Tính bất biến về kích thước không gian lưu trữ này là một trong những lý do khiến chương trình Java có tính di động cao hơn so với các chương trình được viết bằng hầu hết các ngôn ngữ khác (được đề cập trong mục 2.2 của "Tư duy Lập trình Java").

**Chú ý：**

1.  Trong Java, khi sử dụng dữ liệu kiểu `long`, bắt buộc phải thêm **L** vào sau giá trị, nếu không sẽ được phân tích cú pháp như kiểu số nguyên.
2.  Trong Java, khi sử dụng dữ liệu kiểu `float`, bắt buộc phải thêm **f hoặc F** vào sau giá trị, nếu không sẽ không thể biên dịch.
3.  `char a = 'h'` char : dấu nháy đơn，`String a = "hello"` : dấu nháy kép.

Tám kiểu dữ liệu cơ bản này đều có các lớp bao bọc tương ứng là：`Byte`、`Short`、`Integer`、`Long`、`Float`、`Double`、`Character`、`Boolean` .

### Sự khác biệt giữa kiểu cơ bản và kiểu bao bọc?

-   **Mục đích sử dụng**: Ngoài việc định nghĩa một số hằng số và biến cục bộ, chúng ta hiếm khi sử dụng kiểu cơ bản để định nghĩa biến ở những nơi khác như tham số phương thức, thuộc tính đối tượng. Hơn nữa, kiểu bao bọc có thể được sử dụng trong generic, trong khi kiểu cơ bản thì không.
-   **Cách lưu trữ**: Biến cục bộ của kiểu dữ liệu cơ bản được lưu trữ trong bảng biến cục bộ của ngăn xếp máy ảo Java, biến thành viên của kiểu dữ liệu cơ bản (không được sửa đổi bằng `static` ) được lưu trữ trong heap của máy ảo Java. Kiểu bao bọc thuộc loại đối tượng, chúng ta biết rằng hầu hết tất cả các thể hiện đối tượng đều tồn tại trong heap.
-   **Không gian chiếm dụng**: So với kiểu bao bọc (kiểu đối tượng), kiểu dữ liệu cơ bản thường chiếm không gian rất nhỏ.
-   **Giá trị mặc định**: Biến thành viên kiểu bao bọc nếu không được gán giá trị sẽ là `null` , trong khi kiểu cơ bản có giá trị mặc định và không phải là `null`.
-   **Cách so sánh**: Đối với kiểu dữ liệu cơ bản, `==` so sánh giá trị. Đối với kiểu dữ liệu bao bọc, `==` so sánh địa chỉ bộ nhớ của đối tượng. Việc so sánh giá trị giữa tất cả các đối tượng lớp bao bọc kiểu số nguyên đều sử dụng phương thức `equals()`.

**Tại sao lại nói là hầu hết tất cả các thể hiện đối tượng đều tồn tại trong heap?** Điều này là do sau khi máy ảo HotSpot giới thiệu tối ưu hóa JIT, nó sẽ thực hiện phân tích thoát đối với đối tượng, nếu phát hiện một đối tượng nào đó không thoát ra ngoài phương thức, thì có thể thông qua thay thế vô hướng để thực hiện phân bổ trên ngăn xếp, và tránh phân bổ bộ nhớ trên heap

⚠️ Chú ý: **Việc kiểu dữ liệu cơ bản được lưu trữ trong ngăn xếp là một quan niệm sai lầm phổ biến!** Vị trí lưu trữ của kiểu dữ liệu cơ bản phụ thuộc vào phạm vi và cách khai báo của chúng. Nếu chúng là biến cục bộ, chúng sẽ được lưu trữ trong ngăn xếp; nếu chúng là biến thành viên, chúng sẽ được lưu trữ trong heap/vùng phương thức/metaspace.

```java
public class Test {
    // Biến thành viên, được lưu trữ trong heap
    int a = 10;
    // Biến thành viên được sửa đổi bằng static, JDK 1.7 trở về trước nằm trong vùng phương thức, từ 1.8 trở đi được lưu trữ trong metaspace, đều không được lưu trữ trong heap.
    // Biến thuộc về lớp, không thuộc về đối tượng.
    static int b = 20;

    public void method() {
        // Biến cục bộ, được lưu trữ trong ngăn xếp
        int c = 30;
        static int d = 40; // Lỗi biên dịch, không thể sử dụng static để sửa đổi biến cục bộ trong phương thức
    }
}
```

### Bạn có biết về cơ chế bộ đệm của kiểu bao bọc không?

Hầu hết các kiểu bao bọc của kiểu dữ liệu cơ bản Java đều sử dụng cơ chế bộ đệm để cải thiện hiệu suất.

`Byte`,`Short`,`Integer`,`Long` - 4 lớp bao bọc này mặc định tạo dữ liệu bộ đệm cho các giá trị trong khoảng **[-128, 127]** của kiểu tương ứng. `Character` tạo dữ liệu bộ đệm cho các giá trị trong khoảng **[0, 127]**. `Boolean` trực tiếp trả về `TRUE` or `FALSE`.

Đối với `Integer`, có thể sửa đổi giới hạn trên của bộ đệm thông qua tham số JVM `-XX:AutoBoxCacheMax=<size>`, nhưng không thể sửa đổi giới hạn dưới -128. Khi sử dụng thực tế, không nên đặt giá trị quá lớn để tránh lãng phí bộ nhớ, thậm chí là OOM.

Đối với `Byte`,`Short`,`Long` ,`Character` không có tham số tương tự như `-XX:AutoBoxCacheMax` để sửa đổi, do đó phạm vi bộ đệm là cố định, không thể điều chỉnh thông qua tham số JVM. `Boolean` thì trực tiếp trả về các thể hiện `TRUE` và `FALSE` được định nghĩa trước, không có khái niệm về phạm vi bộ đệm.

**Mã nguồn bộ đệm Integer：**

```java
public static Integer valueOf(int i) {
    if (i >= IntegerCache.low && i <= IntegerCache.high)
        return IntegerCache.cache[i + (-IntegerCache.low)];
    return new Integer(i);
}
private static class IntegerCache {
    static final int low = -128;
    static final int high;
    static {
        // giá trị high có thể được cấu hình bởi thuộc tính
        int h = 127;
    }
}
```

**Mã nguồn bộ đệm `Character`:**

```java
public static Character valueOf(char c) {
    if (c <= 127) { // phải lưu vào bộ đệm
      return CharacterCache.cache[(int)c];
    }
    return new Character(c);
}

private static class CharacterCache {
    private CharacterCache(){}
    static final Character cache[] = new Character[127 + 1];
    static {
        for (int i = 0; i < cache.length; i++)
            cache[i] = new Character((char)i);
    }

}
```

**Mã nguồn bộ đệm `Boolean`：**

```java
public static Boolean valueOf(boolean b) {
    return (b ? TRUE : FALSE);
}
```

Nếu vượt quá phạm vi tương ứng, nó vẫn sẽ tạo đối tượng mới. Kích thước của phạm vi bộ đệm chỉ là sự cân bằng giữa hiệu suất và tài nguyên.

Hai lớp bao bọc kiểu số thực `Float`,`Double` không triển khai cơ chế bộ đệm.

```java
Integer i1 = 33;
Integer i2 = 33;
System.out.println(i1 == i2);// Xuất ra true

Float i11 = 333f;
Float i22 = 333f;
System.out.println(i11 == i22);// Xuất ra false

Double i3 = 1.2;
Double i4 = 1.2;
System.out.println(i3 == i4);// Xuất ra false
```

Dưới đây chúng ta hãy xem một vấn đề: Kết quả đầu ra của đoạn mã sau là `true` hay `false`?

```java
Integer i1 = 40;
Integer i2 = new Integer(40);
System.out.println(i1==i2);
```

Dòng mã `Integer i1=40` sẽ xảy ra quá trình đóng hộp, nghĩa là dòng mã này tương đương với `Integer i1=Integer.valueOf(40)` . Do đó, `i1` trực tiếp sử dụng đối tượng trong bộ đệm. Còn `Integer i2 = new Integer(40)` sẽ trực tiếp tạo đối tượng mới.

Do đó, câu trả lời là `false` . Bạn đã trả lời đúng chưa?

Hãy nhớ: **Việc so sánh giá trị giữa tất cả các đối tượng lớp bao bọc kiểu số nguyên đều sử dụng phương thức equals để so sánh**.

![](https://oss.javaguide.cn/github/javaguide/up-1ae0425ce8646adfb768b5374951eeb820d.png)

### Bạn có hiểu về tự động đóng hộp và mở hộp không? Nguyên lý là gì?

**Tự động đóng hộp và mở hộp là gì?**

-   **Đóng hộp (Boxing)**: Bao bọc kiểu cơ bản bằng kiểu tham chiếu tương ứng của chúng;
-   **Mở hộp (Unboxing)**: Chuyển đổi kiểu bao bọc thành kiểu dữ liệu cơ bản;

Ví dụ:

```java
Integer i = 10;  //Đóng hộp
int n = i;   //Mở hộp
```

Bytecode tương ứng với hai dòng mã trên là:

```java
   L1

    LINENUMBER 8 L1

    ALOAD 0

    BIPUSH 10

    INVOKESTATIC java/lang/Integer.valueOf (I)Ljava/lang/Integer;

    PUTFIELD AutoBoxTest.i : Ljava/lang/Integer;

   L2

    LINENUMBER 9 L2

    ALOAD 0

    ALOAD 0

    GETFIELD AutoBoxTest.i : Ljava/lang/Integer;

    INVOKEVIRTUAL java/lang/Integer.intValue ()I

    PUTFIELD AutoBoxTest.n : I

    RETURN
```

Từ bytecode, chúng ta thấy rằng đóng hộp thực chất là gọi phương thức `valueOf()` của lớp bao bọc, còn mở hộp thực chất là gọi phương thức `xxxValue()`.

Do đó,

-   `Integer i = 10` tương đương với `Integer i = Integer.valueOf(10)`
-   `int n = i` tương đương với `int n = i.intValue()`;

Chú ý: **Nếu thực hiện đóng hộp và mở hộp thường xuyên, nó cũng sẽ ảnh hưởng nghiêm trọng đến hiệu suất của hệ thống. Chúng ta nên cố gắng tránh các thao tác đóng hộp và mở hộp không cần thiết.**

```java
private static long sum() {
    // Nên sử dụng long thay vì Long
    Long sum = 0L;
    for (long i = 0; i <= Integer.MAX_VALUE; i++)
        sum += i;
    return sum;
}
```

### Tại sao khi tính toán số thực lại có nguy cơ mất độ chính xác?

Ví dụ mã về mất độ chính xác khi tính toán số thực:

```java
float a = 2.0f - 1.9f;
float b = 1.8f - 1.7f;
System.out.printf("%.9f",a);// 0.100000024
System.out.println(b);// 0.099999905
System.out.println(a == b);// false
```

Tại sao lại xảy ra vấn đề này?

Điều này liên quan rất nhiều đến cơ chế lưu trữ số thực của máy tính. Chúng ta biết rằng máy tính sử dụng hệ nhị phân, và khi máy tính biểu diễn một số, độ rộng là có hạn. Các số thập phân vô hạn tuần hoàn khi được lưu trữ trong máy tính chỉ có thể bị cắt bớt, do đó sẽ dẫn đến tình trạng mất độ chính xác của số thập phân. Điều này cũng giải thích tại sao số thực không thể được biểu diễn chính xác bằng hệ nhị phân.

Ví dụ, số 0.2 trong hệ thập phân không thể được chuyển đổi chính xác thành số nhị phân thập phân:

```java
// Quá trình chuyển đổi 0.2 sang số nhị phân là liên tục nhân với 2 cho đến khi không còn phần thập phân,
// Trong quá trình tính toán này, phần nguyên thu được xếp từ trên xuống dưới chính là kết quả nhị phân.
0.2 * 2 = 0.4 -> 0
0.4 * 2 = 0.8 -> 0
0.8 * 2 = 1.6 -> 1
0.6 * 2 = 1.2 -> 1
0.2 * 2 = 0.4 -> 0 (xảy ra vòng lặp)
...
```

Để biết thêm nội dung về số thực, bạn nên xem bài viết [Cơ sở hệ thống máy tính (Phần 4) Số thực](http://kaito-kidd.com/2018/08/08/computer-system-float-point/) này.

### Làm thế nào để giải quyết vấn đề mất độ chính xác khi tính toán số thực?

`BigDecimal` có thể thực hiện các phép toán trên số thực mà không gây mất độ chính xác. Thông thường, hầu hết các kịch bản nghiệp vụ yêu cầu kết quả tính toán số thực chính xác (ví dụ như các kịch bản liên quan đến tiền bạc) đều được thực hiện thông qua `BigDecimal`.

```java
BigDecimal a = new BigDecimal("1.0");
BigDecimal b = new BigDecimal("1.00");
BigDecimal c = new BigDecimal("0.8");

BigDecimal x = a.subtract(c);
BigDecimal y = b.subtract(c);

System.out.println(x); /* 0.2 */
System.out.println(y); /* 0.20 */
// So sánh nội dung, không phải so sánh giá trị
System.out.println(Objects.equals(x, y)); /* false */
// So sánh giá trị bằng nhau dùng compareTo, bằng nhau trả về 0
System.out.println(0 == x.compareTo(y)); /* true */
```

Để biết giới thiệu chi tiết về `BigDecimal`, bạn có thể xem bài viết này của tôi: [Giải thích chi tiết về BigDecimal](https://javaguide.cn/java/basis/bigdecimal.html).

### Dữ liệu vượt quá kiểu số nguyên long nên được biểu diễn như thế nào?

Các kiểu dữ liệu số cơ bản đều có một phạm vi biểu diễn, nếu vượt quá phạm vi này sẽ có nguy cơ tràn số.

Trong Java, kiểu số nguyên long 64 bit là kiểu số nguyên lớn nhất.

```java
long l = Long.MAX_VALUE;
System.out.println(l + 1); // -9223372036854775808
System.out.println(l + 1 == Long.MIN_VALUE); // true
```

`BigInteger` sử dụng mảng `int[]` bên trong để lưu trữ dữ liệu số nguyên có kích thước bất kỳ.

So với các phép toán trên kiểu số nguyên thông thường, hiệu suất của các phép toán `BigInteger` sẽ tương đối thấp hơn.

## Biến

### Sự khác biệt giữa biến thành viên và biến cục bộ?

-   **Hình thức cú pháp**: Về mặt hình thức cú pháp, biến thành viên thuộc về lớp, trong khi biến cục bộ là biến được định nghĩa trong khối mã hoặc phương thức hoặc là tham số của phương thức; biến thành viên có thể được sửa đổi bởi các từ khóa như `public`, `private`, `static`, trong khi biến cục bộ không thể được sửa đổi bởi các từ khóa kiểm soát truy cập và `static`; tuy nhiên, cả biến thành viên và biến cục bộ đều có thể được sửa đổi bởi `final`.
-   **Cách lưu trữ**: Về cách lưu trữ biến trong bộ nhớ, nếu biến thành viên được sửa đổi bằng `static`, thì biến thành viên này thuộc về lớp, nếu không được sửa đổi bằng `static`, biến thành viên này thuộc về thể hiện. Đối tượng tồn tại trong bộ nhớ heap, còn biến cục bộ tồn tại trong bộ nhớ stack.
-   **Thời gian tồn tại**: Về thời gian tồn tại của biến trong bộ nhớ, biến thành viên là một phần của đối tượng, nó tồn tại cùng với việc tạo đối tượng, trong khi biến cục bộ được tạo tự động khi phương thức được gọi và bị hủy khi phương thức kết thúc.
-   **Giá trị mặc định**: Về việc biến có giá trị mặc định hay không, biến thành viên nếu không được gán giá trị ban đầu sẽ tự động được gán giá trị mặc định của kiểu đó (một trường hợp ngoại lệ: biến thành viên được sửa đổi bằng `final` cũng phải được gán giá trị một cách tường minh), trong khi biến cục bộ sẽ không được tự động gán giá trị.

**Tại sao biến thành viên có giá trị mặc định?**

1.  Chưa xét đến kiểu biến, nếu không có giá trị mặc định thì sao? Biến sẽ lưu trữ một giá trị ngẫu nhiên bất kỳ tương ứng với địa chỉ bộ nhớ, chương trình đọc giá trị này để chạy sẽ gặp sự cố không mong muốn.
2.  Có hai cách đặt giá trị mặc định: thủ công và tự động. Dựa trên điểm đầu tiên, nếu không gán giá trị thủ công thì bắt buộc phải gán tự động. Biến thành viên có thể được gán giá trị thủ công trong thời gian chạy bằng các phương pháp như reflection, trong khi biến cục bộ thì không.
3.  Đối với trình biên dịch (javac), việc biến cục bộ chưa được gán giá trị rất dễ phát hiện và có thể báo lỗi trực tiếp. Trong khi đó, biến thành viên có thể được gán giá trị trong thời gian chạy, không thể xác định được, việc báo lỗi nhầm "không có giá trị mặc định" sẽ ảnh hưởng đến trải nghiệm người dùng, do đó áp dụng cơ chế tự động gán giá trị mặc định.

Ví dụ mã về biến thành viên và biến cục bộ:

```java
public class VariableExample {

    // Biến thành viên
    private String name;
    private int age;

    // Biến cục bộ trong phương thức
    public void method() {
        int num1 = 10; // Biến cục bộ được cấp phát trên stack
        String str = "Hello, world!"; // Biến cục bộ được cấp phát trên stack
        System.out.println(num1);
        System.out.println(str);
    }

    // Biến cục bộ trong phương thức có tham số
    public void method2(int num2) {
        int sum = num2 + 10; // Biến cục bộ được cấp phát trên stack
        System.out.println(sum);
    }

    // Biến cục bộ trong phương thức khởi tạo
    public VariableExample(String name, int age) {
        this.name = name; // Gán giá trị cho biến thành viên
        this.age = age; // Gán giá trị cho biến thành viên
        int num3 = 20; // Biến cục bộ được cấp phát trên stack
        String str2 = "Hello, " + this.name + "!"; // Biến cục bộ được cấp phát trên stack
        System.out.println(num3);
        System.out.println(str2);
    }
}

```

### Biến tĩnh có tác dụng gì?

Biến tĩnh là biến được sửa đổi bởi từ khóa `static`. Nó có thể được chia sẻ bởi tất cả các thể hiện của lớp, bất kể một lớp tạo ra bao nhiêu đối tượng, chúng đều chia sẻ cùng một biến tĩnh. Nghĩa là, biến tĩnh chỉ được cấp phát bộ nhớ một lần, ngay cả khi tạo nhiều đối tượng, điều này giúp tiết kiệm bộ nhớ.

Biến tĩnh được truy cập thông qua tên lớp, ví dụ `StaticVariableExample.staticVar` (nếu được sửa đổi bởi từ khóa `private` thì không thể truy cập theo cách này).

```java
public class StaticVariableExample {
    // Biến tĩnh
    public static int staticVar = 0;
}
```

Thông thường, biến tĩnh sẽ được sửa đổi bởi từ khóa `final` để trở thành hằng số.

```java
public class ConstantVariableExample {
    // Hằng số
    public static final int constantVar = 0;
}
```

### Sự khác biệt giữa hằng ký tự và hằng chuỗi?

-   **Hình thức** : Hằng ký tự là một ký tự được đặt trong dấu nháy đơn, hằng chuỗi là 0 hoặc nhiều ký tự được đặt trong dấu nháy kép.
-   **Ý nghĩa** : Hằng ký tự tương đương với một giá trị số nguyên (giá trị ASCII), có thể tham gia vào các phép toán biểu thức; hằng chuỗi đại diện cho một giá trị địa chỉ (vị trí lưu trữ của chuỗi đó trong bộ nhớ).
-   **Kích thước bộ nhớ chiếm dụng**: Hằng ký tự chỉ chiếm 2 byte; hằng chuỗi chiếm một số byte nhất định.

⚠️ Chú ý `char` trong Java chiếm hai byte.

Ví dụ mã về hằng ký tự và hằng chuỗi:

```java
public class StringExample {
    // Hằng ký tự
    public static final char LETTER_A = 'A';

    // Hằng chuỗi
    public static final String GREETING_MESSAGE = "Hello, world!";
    public static void main(String[] args) {
        System.out.println("Số byte mà hằng ký tự chiếm dụng là: "+Character.BYTES);
        System.out.println("Số byte mà hằng chuỗi chiếm dụng là: "+GREETING_MESSAGE.getBytes().length);
    }
}
```

Kết quả:

```plain
Số byte mà hằng ký tự chiếm dụng là: 2
Số byte mà hằng chuỗi chiếm dụng là: 13
```

## Phương thức

### Giá trị trả về của phương thức là gì? Phương thức có những loại nào?

**Giá trị trả về của phương thức** là kết quả mà chúng ta nhận được sau khi thực thi mã trong một thân phương thức nào đó! (Với điều kiện là phương thức đó có thể tạo ra kết quả). Tác dụng của giá trị trả về là nhận kết quả, để nó có thể được sử dụng cho các thao tác khác!

Chúng ta có thể chia phương thức thành các loại sau dựa trên giá trị trả về và kiểu tham số của chúng:

**1、Phương thức không có tham số và không có giá trị trả về**

```java
public void f1() {
    //......
}
// Phương thức dưới đây cũng không có giá trị trả về, mặc dù có sử dụng return
public void f(int a) {
    if (...) {
        // Biểu thị kết thúc việc thực thi phương thức, câu lệnh xuất bên dưới sẽ không được thực thi
        return;
    }
    System.out.println(a);
}
```

**2、Phương thức có tham số nhưng không có giá trị trả về**

```java
public void f2(Parameter 1, ..., Parameter n) {
    //......
}
```

**3、Phương thức có giá trị trả về nhưng không có tham số**

```java
public int f3() {
    //......
    return x;
}
```

**4、Phương thức có giá trị trả về và có tham số**

```java
public int f4(int a, int b) {
    return a * b;
}
```

### Tại sao phương thức tĩnh không thể gọi thành viên không tĩnh?

Điều này cần kết hợp với kiến thức liên quan đến JVM, nguyên nhân chính như sau:

1.  Phương thức tĩnh thuộc về lớp, sẽ được cấp phát bộ nhớ khi lớp được tải, có thể truy cập trực tiếp thông qua tên lớp. Trong khi đó, thành viên không tĩnh thuộc về thể hiện đối tượng, chỉ tồn tại sau khi đối tượng được khởi tạo, cần phải truy cập thông qua thể hiện đối tượng của lớp.
2.  Khi thành viên không tĩnh của lớp chưa tồn tại thì phương thức tĩnh đã tồn tại rồi, lúc này việc gọi thành viên không tĩnh chưa tồn tại trong bộ nhớ là một thao tác không hợp lệ.

```java
public class Example {
    // Định nghĩa một hằng ký tự
    public static final char LETTER_A = 'A';

    // Định nghĩa một hằng chuỗi
    public static final String GREETING_MESSAGE = "Hello, world!";

    public static void main(String[] args) {
        // Xuất giá trị của hằng ký tự
        System.out.println("Giá trị của hằng ký tự là: " + LETTER_A);

        // Xuất giá trị của hằng chuỗi
        System.out.println("Giá trị của hằng chuỗi là: " + GREETING_MESSAGE);
    }
}
```

### Phương thức tĩnh và phương thức thể hiện có gì khác nhau?

**1、Cách gọi**

Khi gọi phương thức tĩnh từ bên ngoài, có thể sử dụng cách `TênLớp.TênPhươngThức`, cũng có thể sử dụng cách `ĐốiTượng.TênPhươngThức`, trong khi phương thức thể hiện chỉ có cách sau. Nghĩa là, **gọi phương thức tĩnh có thể không cần tạo đối tượng** .

Tuy nhiên, cần lưu ý rằng thường không nên sử dụng cách `ĐốiTượng.TênPhươngThức` để gọi phương thức tĩnh. Cách này rất dễ gây nhầm lẫn, phương thức tĩnh không thuộc về một đối tượng cụ thể của lớp mà thuộc về chính lớp đó.

Do đó, thường khuyến nghị sử dụng cách `TênLớp.TênPhươngThức` để gọi phương thức tĩnh.

```java
public class Person {
    public void method() {
      //......
    }

    public static void staicMethod(){
      //......
    }
    public static void main(String[] args) {
        Person person = new Person();
        // Gọi phương thức thể hiện
        person.method();
        // Gọi phương thức tĩnh
        Person.staicMethod()
    }
}
```

**2、Có giới hạn nào khi truy cập thành viên của lớp không?**

Khi phương thức tĩnh truy cập các thành viên của lớp hiện tại, nó chỉ được phép truy cập các thành viên tĩnh (tức là biến thành viên tĩnh và phương thức tĩnh), không được phép truy cập các thành viên thể hiện (tức là biến thành viên thể hiện và phương thức thể hiện), trong khi phương thức thể hiện không có giới hạn này.

### Nạp chồng và ghi đè có gì khác nhau?

> Nạp chồng là cùng một phương thức có thể thực hiện các xử lý khác nhau dựa trên dữ liệu đầu vào
>
> Ghi đè là khi lớp con kế thừa một phương thức giống hệt từ lớp cha, dữ liệu đầu vào giống nhau, nhưng muốn tạo ra một phản hồi khác với lớp cha, bạn phải ghi đè phương thức của lớp cha

#### Nạp chồng (Overloading)

Xảy ra trong cùng một lớp (hoặc giữa lớp cha và lớp con), tên phương thức phải giống nhau, kiểu tham số, số lượng tham số, thứ tự tham số phải khác nhau, giá trị trả về của phương thức và từ khóa kiểm soát truy cập có thể khác nhau.

Cuốn sách "Java Core Technology" giới thiệu về nạp chồng như sau:

> Nếu nhiều phương thức (ví dụ như phương thức khởi tạo của `StringBuilder`) có cùng tên, các tham số khác nhau, thì sẽ xảy ra nạp chồng.
>
> ```java
> StringBuilder sb = new StringBuilder();
> StringBuilder sb2 = new StringBuilder("HelloWorld");
> ```
>
> Trình biên dịch phải chọn ra phương thức cụ thể nào sẽ được thực thi, nó thực hiện điều này bằng cách khớp kiểu tham số được cung cấp bởi mỗi phương thức với kiểu giá trị được sử dụng trong lệnh gọi phương thức cụ thể để chọn ra phương thức tương ứng. Nếu trình biên dịch không tìm thấy tham số khớp, nó sẽ tạo ra lỗi thời gian biên dịch, bởi vì hoàn toàn không có sự khớp nào, hoặc không có sự khớp nào tốt hơn những sự khớp khác (quá trình này được gọi là phân giải nạp chồng (overloading resolution)).
>
> Java cho phép nạp chồng bất kỳ phương thức nào, chứ không chỉ riêng phương thức khởi tạo.

Tóm lại: Nạp chồng là nhiều phương thức cùng tên trong cùng một lớp thực hiện các xử lý logic khác nhau dựa trên các tham số truyền vào khác nhau.

#### Ghi đè (Overriding)

Ghi đè xảy ra trong thời gian chạy, là quá trình lớp con viết lại việc triển khai của một phương thức được phép truy cập từ lớp cha.

1.  Tên phương thức, danh sách tham số phải giống nhau, kiểu giá trị trả về của phương thức lớp con phải nhỏ hơn hoặc bằng kiểu giá trị trả về của phương thức lớp cha, phạm vi ngoại lệ được ném ra nhỏ hơn hoặc bằng lớp cha, phạm vi từ khóa kiểm soát truy cập lớn hơn hoặc bằng lớp cha.
2.  Nếu từ khóa kiểm soát truy cập của phương thức lớp cha là `private/final/static` thì lớp con không thể ghi đè phương thức đó, nhưng phương thức được sửa đổi bằng `static` có thể được khai báo lại.
3.  Phương thức khởi tạo không thể bị ghi đè

#### Tổng kết

Tóm lại: **Ghi đè là việc lớp con sửa đổi lại phương thức của lớp cha, hình thức bên ngoài không thể thay đổi, logic bên trong có thể thay đổi.**

| Điểm khác biệt | Phương thức nạp chồng | Phương thức ghi đè                                                         |
| :------------- | :------------------- | :----------------------------------------------------------------------- |
| Phạm vi xảy ra   | Cùng một lớp         | Lớp con                                                                 |
| Danh sách tham số   | Phải sửa đổi         | Chắc chắn không được sửa đổi                                                 |
| Kiểu trả về   | Có thể sửa đổi       | Kiểu giá trị trả về của phương thức lớp con phải nhỏ hơn hoặc bằng kiểu giá trị trả về của phương thức lớp cha |
| Ngoại lệ       | Có thể sửa đổi       | Lớp ngoại lệ được khai báo ném ra bởi phương thức lớp con phải nhỏ hơn hoặc bằng lớp ngoại lệ được khai báo ném ra bởi phương thức lớp cha; |
| Từ khóa kiểm soát truy cập | Có thể sửa đổi       | Chắc chắn không được hạn chế chặt chẽ hơn (có thể nới lỏng hạn chế)               |
| Giai đoạn xảy ra   | Thời gian biên dịch   | Thời gian chạy                                                               |

**Việc ghi đè phương thức phải tuân theo "hai giống, hai nhỏ, một lớn"** (Nội dung sau được trích từ "Crazy Java Lecture Notes", [issue#892](https://github.com/Snailclimb/JavaGuide/issues/892) ):

-   "Hai giống" tức là tên phương thức giống nhau, danh sách tham số hình thức giống nhau;
-   "Hai nhỏ" có nghĩa là kiểu giá trị trả về của phương thức lớp con phải nhỏ hơn hoặc bằng kiểu giá trị trả về của phương thức lớp cha, lớp ngoại lệ được khai báo ném ra bởi phương thức lớp con phải nhỏ hơn hoặc bằng lớp ngoại lệ được khai báo ném ra bởi phương thức lớp cha;
-   "Một lớn" có nghĩa là quyền truy cập của phương thức lớp con phải lớn hơn hoặc bằng quyền truy cập của phương thức lớp cha.

⭐ Về **kiểu giá trị trả về khi ghi đè**, ở đây cần giải thích thêm một chút, cách diễn đạt ở trên chưa rõ ràng và chính xác: Nếu kiểu trả về của phương thức là void và kiểu dữ liệu cơ bản, thì giá trị trả về không thể sửa đổi khi ghi đè. Nhưng nếu phương thức có kiểu trả về là kiểu tham chiếu, khi ghi đè có thể trả về một lớp con của kiểu tham chiếu đó.

```java
public class Hero {
    public String name() {
        return "Siêu anh hùng";
    }
}
public class SuperMan extends Hero{
    @Override
    public String name() {
        return "Siêu nhân";
    }
    public Hero hero() {
        return new Hero();
    }
}

public class SuperSuperMan extends SuperMan {
    @Override
    public String name() {
        return "Siêu siêu anh hùng";
    }

    @Override
    public SuperMan hero() {
        return new SuperMan();
    }
}
```

### Tham số biến đổi độ dài là gì?

Bắt đầu từ Java 5, Java hỗ trợ định nghĩa tham số biến đổi độ dài, cái gọi là tham số biến đổi độ dài là cho phép truyền vào một số lượng tham số không xác định khi gọi phương thức. Ví dụ, phương thức dưới đây có thể chấp nhận 0 hoặc nhiều tham số.

```java
public static void method1(String... args) {
   //......
}
```

Ngoài ra, tham số biến đổi chỉ có thể là tham số cuối cùng của hàm, nhưng phía trước nó có thể có hoặc không có bất kỳ tham số nào khác.

```java
public static void method2(String arg1, String... args) {
   //......
}
```

**Gặp trường hợp nạp chồng phương thức thì làm thế nào? Sẽ ưu tiên khớp với phương thức có tham số cố định hay tham số biến đổi?**

Câu trả lời là sẽ ưu tiên khớp với phương thức có tham số cố định, bởi vì phương thức có tham số cố định có độ khớp cao hơn.

Chúng ta hãy chứng minh điều này thông qua ví dụ dưới đây.

```java
/**
 * Tìm kiếm JavaGuide trên WeChat, trả lời "面试突击" để nhận miễn phí cẩm nang phỏng vấn Java gốc của cá nhân
 *
 * @author Guide哥
 * @date 2021/12/13 16:52
 **/
public class VariableLengthArgument {

    public static void printVariable(String... args) {
        for (String s : args) {
            System.out.println(s);
        }
    }

    public static void printVariable(String arg1, String arg2) {
        System.out.println(arg1 + arg2);
    }

    public static void main(String[] args) {
        printVariable("a", "b");
        printVariable("a", "b", "c", "d");
    }
}
```

Kết quả:

```plain
ab
a
b
c
d
```

Ngoài ra, tham số biến đổi của Java sau khi biên dịch thực tế sẽ được chuyển đổi thành một mảng, chúng ta có thể thấy điều này khi xem tệp `.class` được tạo ra sau khi biên dịch.

```java
public class VariableLengthArgument {

    public static void printVariable(String... args) {
        String[] var1 = args;
        int var2 = args.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            String s = var1[var3];
            System.out.println(s);
        }

    }
    // ......
}
```