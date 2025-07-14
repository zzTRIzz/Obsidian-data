---
title: Hướng dẫn chi tiết về Serialization trong Java
category: Java
tags:
  - Java
  - cơ
  - bản
---

## Serialization và Deserialization là gì?

Nếu chúng ta cần lưu trữ lâu dài các đối tượng Java, chẳng hạn như lưu đối tượng Java vào file, hoặc truyền đối tượng Java qua mạng, thì các tình huống này đều cần sử dụng serialization.

Nói một cách đơn giản:

- **Serialization**: Quá trình chuyển đổi cấu trúc dữ liệu hoặc đối tượng thành dạng có thể lưu trữ hoặc truyền tải, thường là dòng byte nhị phân, cũng có thể là định dạng văn bản như JSON, XML
- **Deserialization**: Quá trình chuyển đổi dữ liệu được tạo ra trong quá trình serialization trở lại thành cấu trúc dữ liệu hoặc đối tượng ban đầu

Đối với ngôn ngữ lập trình hướng đối tượng như Java, những gì chúng ta serialize đều là các đối tượng (Object), tức là các lớp (Class) đã được khởi tạo. Nhưng trong ngôn ngữ bán hướng đối tượng như C++, struct (cấu trúc) định nghĩa kiểu cấu trúc dữ liệu, trong khi class tương ứng với kiểu đối tượng.

Dưới đây là các tình huống ứng dụng phổ biến của serialization và deserialization:

- Đối tượng cần được serialize trước khi truyền qua mạng (như khi gọi phương thức từ xa RPC), sau khi nhận được đối tượng đã serialize cần thực hiện deserialization;
- Cần serialize trước khi lưu đối tượng vào file, cần deserialization khi đọc đối tượng từ file;
- Cần serialize trước khi lưu đối tượng vào cơ sở dữ liệu (như Redis), cần deserialization khi đọc đối tượng từ cơ sở dữ liệu cache;
- Cần serialize trước khi lưu đối tượng vào bộ nhớ, cần deserialization sau khi đọc từ bộ nhớ.

Wikipedia giới thiệu về serialization như sau:

> **Serialization** trong xử lý dữ liệu khoa học máy tính, là quá trình chuyển đổi cấu trúc dữ liệu hoặc trạng thái đối tượng thành định dạng có thể sử dụng (ví dụ lưu thành file, lưu trong buffer, hoặc gửi qua mạng), để có thể khôi phục lại trạng thái ban đầu trong cùng một môi trường máy tính hoặc môi trường máy tính khác. Khi lấy lại kết quả byte theo định dạng serialization, có thể sử dụng nó để tạo ra bản sao có ngữ nghĩa giống với đối tượng ban đầu. Đối với nhiều đối tượng, như các đối tượng phức tạp sử dụng nhiều tham chiếu, quá trình tái tạo serialization này không dễ dàng. Serialization đối tượng trong lập trình hướng đối tượng không bao gồm các hàm liên quan đến đối tượng ban đầu. Quá trình này còn được gọi là object marshalling. Thao tác ngược lại để trích xuất cấu trúc dữ liệu từ một chuỗi byte là deserialization (còn gọi là unmarshalling, deserialization, unmarshalling).

Tóm lại: **Mục đích chính của serialization là truyền đối tượng qua mạng hoặc lưu trữ đối tượng vào hệ thống file, cơ sở dữ liệu, bộ nhớ.**

![](https://oss.javaguide.cn/github/javaguide/a478c74d-2c48-40ae-9374-87aacf05188c.png)

<p style="text-align:right;font-size:13px;color:gray">https://www.corejavaguru.com/java/serialization/interview-questions-1</p>

**Giao thức serialization tương ứng với tầng nào trong mô hình TCP/IP 4 tầng?**

Chúng ta biết rằng hai bên giao tiếp mạng phải sử dụng và tuân thủ cùng một giao thức. Mô hình TCP/IP bốn tầng như dưới đây, vậy giao thức serialization thuộc tầng nào?

1. Tầng ứng dụng
2. Tầng vận chuyển
3. Tầng mạng
4. Tầng giao diện mạng

![Mô hình TCP/IP 4 tầng](https://oss.javaguide.cn/github/javaguide/cs-basics/network/tcp-ip-4-model.png)

Như hình trên cho thấy, trong mô hình giao thức OSI bảy tầng, tầng trình bày chủ yếu xử lý dữ liệu người dùng từ tầng ứng dụng và chuyển đổi thành dòng nhị phân. Ngược lại, nó chuyển đổi dòng nhị phân thành dữ liệu người dùng của tầng ứng dụng. Điều này không chính là serialization và deserialization sao?

Vì tầng ứng dụng, tầng trình bày và tầng phiên trong mô hình giao thức OSI bảy tầng đều tương ứng với tầng ứng dụng trong mô hình TCP/IP bốn tầng, nên giao thức serialization thuộc một phần của tầng ứng dụng giao thức TCP/IP.

## Các giao thức serialization phổ biến có những gì?

Cách serialization tích hợp của JDK thường không được sử dụng vì hiệu suất serialization thấp và tồn tại vấn đề bảo mật. Các giao thức serialization thường dùng có Hessian, Kryo, Protobuf, ProtoStuff, tất cả đều là giao thức serialization dựa trên nhị phân.

Như JSON và XML thuộc cách serialization dạng văn bản. Mặc dù có tính đọc hiểu tốt nhưng hiệu suất kém, thường không được chọn.

### Cách serialization tích hợp của JDK

Serialization tích hợp của JDK chỉ cần implement interface `java.io.Serializable`.

```java
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@ToString
public class RpcRequest implements Serializable {
    private static final long serialVersionUID = 1905122041950251207L;
    private String requestId;
    private String interfaceName;
    private String methodName;
    private Object[] parameters;
    private Class<?>[] paramTypes;
    private RpcMessageTypeEnum rpcMessageTypeEnum;
}
```

**serialVersionUID có tác dụng gì?**

Số serialization `serialVersionUID` có tác dụng kiểm soát phiên bản. Khi deserialization, sẽ kiểm tra xem `serialVersionUID` có trùng với `serialVersionUID` của lớp hiện tại hay không. Nếu `serialVersionUID` không khớp sẽ ném ra exception `InvalidClassException`. Rất khuyến khích mỗi lớp serialization đều chỉ định thủ công `serialVersionUID` của nó, nếu không chỉ định thủ công, compiler sẽ tự động tạo ra `serialVersionUID` mặc định.

**serialVersionUID không phải được modify bởi biến static sao? Tại sao vẫn bị "serialize"?**

~~Biến được modify bởi `static` là biến tĩnh, nằm trong method area, bản thân không bị serialize. Biến `static` thuộc về lớp chứ không phải đối tượng. Sau khi bạn deserialization, giá trị của biến `static` giống như được gán mặc định cho đối tượng, trông như biến `static` bị serialize, thực tế chỉ là ảo tượng thôi.~~

**🐛 Sửa lại (tham khảo: [issue#2174](https://github.com/Snailclimb/JavaGuide/issues/2174))**:

Thông thường, biến `static` thuộc về lớp, không thuộc về bất kỳ instance đối tượng đơn lẻ nào, nên chúng không được bao gồm trong dòng dữ liệu serialization đối tượng. Serialization lưu trữ trạng thái của đối tượng (tức là giá trị của các biến instance). Tuy nhiên, `serialVersionUID` là một trường hợp đặc biệt, việc serialization `serialVersionUID` được xử lý đặc biệt. Điểm mấu chốt là `serialVersionUID` không được serialize như một phần của trạng thái đối tượng, mà được cơ chế serialization sử dụng như một "dấu vân tay" hoặc "số phiên bản" đặc biệt.

Khi một đối tượng được serialize, `serialVersionUID` sẽ được ghi vào dòng nhị phân serialization (như lưu một số phiên bản, chứ không phải lưu trạng thái của chính biến `static`); khi deserialization, nó cũng sẽ được phân tích và thực hiện kiểm tra tính nhất quán, để xác minh tính nhất quán phiên bản của đối tượng serialization. Nếu hai bên không khớp, quá trình deserialization sẽ ném ra `InvalidClassException`, vì điều này thường có nghĩa là định nghĩa của lớp serialization đã thay đổi, có thể không còn tương thích.

Giải thích chính thức như sau:

> A serializable class can declare its own serialVersionUID explicitly by declaring a field named `"serialVersionUID"` that must be `static`, `final`, and of type `long`;
>
> Nếu muốn chỉ định rõ ràng `serialVersionUID`, cần sử dụng từ khóa `static` và `final` trong lớp để modify một biến kiểu `long`, tên biến phải là `"serialVersionUID"`.

Có nghĩa là `serialVersionUID` bản thân (như biến static) thực sự không được serialize như trạng thái đối tượng. Nhưng giá trị của nó được cơ chế serialization Java xử lý đặc biệt - được đọc và ghi vào dòng serialization như một định danh phiên bản, dùng để kiểm tra tính tương thích phiên bản khi deserialization.

**Nếu có một số trường không muốn serialize thì làm sao?**

Đối với các biến không muốn serialize, có thể sử dụng từ khóa `transient` để modify.

Tác dụng của từ khóa `transient` là: ngăn chặn việc serialize các biến trong instance được modify bởi từ khóa này; khi đối tượng được deserialization, giá trị của biến được modify bởi `transient` sẽ không được lưu trữ lâu dài và khôi phục.

Về `transient` còn có một số điểm cần lưu ý:

- `transient` chỉ có thể modify biến, không thể modify lớp và phương thức.
- Biến được modify bởi `transient`, sau deserialization giá trị biến sẽ được đặt thành giá trị mặc định của kiểu. Ví dụ, nếu modify kiểu `int`, thì kết quả sau deserialization sẽ là `0`.
- Biến `static` vì không thuộc về bất kỳ đối tượng (Object) nào, nên dù có hay không có từ khóa `transient` modify, đều sẽ không bị serialize.

**Tại sao không khuyến khích sử dụng serialization tích hợp của JDK?**

Chúng ta rất ít hoặc có thể nói là hầu như không trực tiếp sử dụng cách serialization tích hợp của JDK, lý do chính có những điểm sau:

- **Không hỗ trợ gọi đa ngôn ngữ**: Nếu gọi các dịch vụ được phát triển bằng ngôn ngữ khác thì không hỗ trợ.
- **Hiệu suất kém**: So với các framework serialization khác, hiệu suất thấp hơn, lý do chính là mảng byte sau serialization có kích thước lớn, dẫn đến chi phí truyền tải tăng cao.
- **Tồn tại vấn đề bảo mật**: Serialization và deserialization bản thân không có vấn đề gì. Nhưng khi dữ liệu deserialization đầu vào có thể được người dùng kiểm soát, thì kẻ tấn công có thể thông qua việc tạo ra đầu vào độc hại, khiến deserialization tạo ra đối tượng không mong muốn, trong quá trình này thực thi mã tùy ý được tạo ra. Đọc thêm: [Bảo mật ứng dụng: Lỗ hổng deserialization JAVA - Cryin](https://cryin.github.io/blog/secure-development-java-deserialization-vulnerability/)、[Lỗ hổng bảo mật deserialization Java là gì? - Monica](https://www.zhihu.com/question/37562657/answer/1916596031).

### Kryo

Kryo là một công cụ serialization/deserialization hiệu suất cao, do đặc tính lưu trữ độ dài biến và sử dụng cơ chế tạo bytecode, có tốc độ chạy cao và kích thước bytecode nhỏ.

Ngoài ra, Kryo đã là một implementation serialization rất trưởng thành, đã được sử dụng rộng rãi tại Twitter, Groupon, Yahoo cũng như nhiều dự án mã nguồn mở nổi tiếng (như Hive, Storm).

[guide-rpc-framework](https://github.com/Snailclimb/guide-rpc-framework) sử dụng kryo để serialization, code liên quan đến serialization và deserialization như sau:

```java
/**
 * Kryo serialization class, Kryo serialization efficiency is very high, but only compatible with Java language
 *
 * @author shuang.kou
 * @createTime 2020年05月13日 19:29:00
 */
@Slf4j
public class KryoSerializer implements Serializer {

    /**
     * Because Kryo is not thread safe. So, use ThreadLocal to store Kryo objects
     */
    private final ThreadLocal<Kryo> kryoThreadLocal = ThreadLocal.withInitial(() -> {
        Kryo kryo = new Kryo();
        kryo.register(RpcResponse.class);
        kryo.register(RpcRequest.class);
        return kryo;
    });

    @Override
    public byte[] serialize(Object obj) {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             Output output = new Output(byteArrayOutputStream)) {
            Kryo kryo = kryoThreadLocal.get();
            // Object->byte:serialize đối tượng thành mảng byte
            kryo.writeObject(output, obj);
            kryoThreadLocal.remove();
            return output.toBytes();
        } catch (Exception e) {
            throw new SerializeException("Serialization failed");
        }
    }

    @Override
    public <T> T deserialize(byte[] bytes, Class<T> clazz) {
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
             Input input = new Input(byteArrayInputStream)) {
            Kryo kryo = kryoThreadLocal.get();
            // byte->Object:deserialization đối tượng từ mảng byte
            Object o = kryo.readObject(input, clazz);
            kryoThreadLocal.remove();
            return clazz.cast(o);
        } catch (Exception e) {
            throw new SerializeException("Deserialization failed");
        }
    }

}
```

Địa chỉ GitHub: [https://github.com/EsotericSoftware/kryo](https://github.com/EsotericSoftware/kryo).

### Protobuf

Protobuf đến từ Google, hiệu suất khá tốt, cũng hỗ trợ nhiều ngôn ngữ, đồng thời còn đa nền tảng. Chỉ là trong sử dụng khá rườm rà, vì bạn cần tự định nghĩa file IDL và tạo ra code serialization tương ứng. Mặc dù không linh hoạt, nhưng mặt khác dẫn đến protobuf không có rủi ro lỗ hổng serialization.

> Protobuf bao gồm định nghĩa định dạng serialization, thư viện của các ngôn ngữ khác nhau và một compiler IDL. Trong tình huống bình thường bạn cần định nghĩa file proto, sau đó sử dụng compiler IDL để compile thành ngôn ngữ bạn cần

Một file proto đơn giản như sau:

```protobuf
// phiên bản của protobuf
syntax = "proto3";
// SearchRequest sẽ được compile thành đối tượng tương ứng của các ngôn ngữ lập trình khác nhau, như class trong Java, struct trong Go
message Person {
  //trường kiểu string
  string name = 1;
  // trường kiểu int
  int32 age = 2;
}
```

Địa chỉ GitHub: [https://github.com/protocolbuffers/protobuf](https://github.com/protocolbuffers/protobuf).

### ProtoStuff

Do tính dễ sử dụng của Protobuf khá kém, anh em của nó là Protostuff ra đời.

protostuff dựa trên Google protobuf, nhưng cung cấp nhiều tính năng hơn và cách sử dụng đơn giản hơn. Mặc dù dễ sử dụng hơn, nhưng không có nghĩa là hiệu suất của ProtoStuff kém hơn.

Địa chỉ GitHub: [https://github.com/protostuff/protostuff](https://github.com/protostuff/protostuff).

### Hessian

Hessian là một giao thức RPC nhị phân nhẹ, tự mô tả. Hessian là một implementation serialization khá cũ, và cũng đa ngôn ngữ.

![](https://oss.javaguide.cn/github/javaguide/8613ec4c-bde5-47bf-897e-99e0f90b9fa3.png)

Cách serialization mặc định của Dubbo2.x là Hessian2, nhưng Dubbo đã sửa đổi Hessian2, tuy nhiên cấu trúc tổng thể vẫn tương tự.

### Tóm tắt

Kryo là cách serialization chuyên dành cho ngôn ngữ Java và có hiệu suất rất tốt, nếu ứng dụng của bạn chuyên dành cho ngôn ngữ Java thì có thể cân nhắc sử dụng, và trong một bài viết trên trang web chính thức của Dubbo có đề cập rằng khuyến khích sử dụng Kryo làm cách serialization cho môi trường sản xuất. (Địa chỉ bài viết: <https://cn.dubbo.apache.org/zh-cn/docsv2.7/user/serialization/>).

![](https://oss.javaguide.cn/github/javaguide/java/569e541a-22b2-4846-aa07-0ad479f07440-20230814090158124.png)

Như Protobuf, ProtoStuff, hessian đều là cách serialization đa ngôn ngữ, nếu có nhu cầu đa ngôn ngữ thì có thể cân nhắc sử dụng.

Ngoài các cách serialization tôi giới thiệu ở trên, còn có như Thrift, Avro.

<!-- @include: @article-footer.snippet.md -->
