<br>

## 1️⃣ Cài Đặt Dependencies

Trước tiên, bạn cần thêm dependency `spring-boot-starter-mail` vào `pom.xml`:

```maven
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-mail</artifactId>
</dependency>
```

## 2️⃣ Cấu Hình SMTP Server

Thêm cấu hình email vào `application.properties`:

```properties
spring.application.name=sendemail

spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your-email@gmail.com
spring.mail.password=your-app-password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

💡 **Lưu ý:**

- Không dùng mật khẩu Gmail cá nhân! Hãy tạo **App Password** tại Google App Password.
    
- Nếu gặp lỗi bảo mật, bạn có thể cần bật **"Less Secure Apps"** trên tài khoản Google.
    

---

## 3️⃣ Tạo Service Gửi Email

Tạo class `EmailSenderService` để thực hiện gửi email:

```java
package org.example.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String toEmail, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("your-email@gmail.com"); // Email của bạn
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);
        System.out.println(">>>>>> Email sent to " + toEmail);
    }
}
```

Đây là phương thức nâng cao bổ sung thêm HTML

```java
// Phương thức gửi email HTML với OTP  
public void sendOtpEmail(String toEmail, String otp) {  
    try {  
        MimeMessage msg = mailSender.createMimeMessage();  
        MimeMessageHelper helper = new MimeMessageHelper(msg, true, "UTF-8");  
  
        helper.setFrom("tringuyenquoc15102004@gmail.com");  
        helper.setTo(toEmail);  
        helper.setSubject(otp + " là mã khôi phục tài khoản Clotify của bạn");  
  
        String htmlContent = "<!DOCTYPE html>\n" +  
                "<html lang=\"en\">\n" +  
                "<head>\n" +  
                "  <meta charset=\"UTF-8\">\n" +  
                "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +  
                "  <title>Document</title>\n" +  
                "  <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n" +  
                "  <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n" +  
                "  <link href=\"https://fonts.googleapis.com/css2?family=Inter:wght@100..900&display=swap\" rel=\"stylesheet\">\n" +  
                "  <style>\n" +  
                "    body {\n" +  
                "      font-family: 'Inter', sans-serif;\n" +  
                "    }\n" +  
                "  </style>\n" +  
                "</head>\n" +  
                "<body>\n" +  
                "  <div style=\"min-width: 1000px; overflow: auto; line-height: 2;\">\n" +  
                "    <div style=\"margin: 50px auto; width: 70%; padding: 20px 0;\">\n" +  
                "      <div style=\"border-bottom: 1px solid #eee;\">\n" +  
                "        <a href=\"\" style=\"font-size: 1.2em; color: #2365d0; text-decoration: none; font-weight: bold;\">Quản lý tài khoản Clotify</a>\n" +  
                "      </div>\n" +  
                "      <p style=\"font-size: 1em;\">Xin chào, chúng tôi đã nhận được yêu cầu đặt lại mật khẩu.</p>\n" +  
                "      <p style=\"font-size: 1em;\"><b>Lưu ý:</b> Mã OTP này nhằm mục đích thay đổi mật khẩu của tài khoản phần mềm quản lý của hàng Clotify. Vui lòng không tiết lộ với người khác. Nhập mã dưới đây:</p>\n" +  
                "      <h2 style=\"background: #e1eefb; margin: 0 auto; width: max-content; padding: 0px 10px; color: #161616; border-radius: 5px; box-shadow: 0 0 0 1px #1877f2; font-size: 1.3em; font-weight: bold;\">" +  
                otp +  
                "      </h2>\n" +  
                "      <br>\n" +  
                "      <hr style=\"border: none; border-top: 1px solid #eee;\">\n" +  
                "      <div style=\"float: right; padding: 8px 0; color: #aaa; font-size: 0.9em; line-height: 1; font-weight: 300;\">\n" +  
                "        <p>Phần mềm quản lý cửa hàng quần áo Clotify</p>\n" +  
                "      </div>\n" +  
                "    </div>\n" +  
                "  </div>\n" +  
                "</body>\n" +  
                "</html>";  
  
        helper.setText(htmlContent, true); // true indicates HTML content  
        mailSender.send(msg);  
        System.out.println(">>>>Send OTP email successfully to " + toEmail);  
  
    } catch (Exception e) {  
        e.printStackTrace();  
        throw new RuntimeException("Failed to send OTP email", e);  
    }  
}
```
---

## 4️⃣ Tạo Ứng Dụng Spring Boot

Tạo `SendemailApplication.java` để khởi chạy ứng dụng và gửi email:

```java
package org.example.main;

import org.example.main.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SendemailApplication {
    @Autowired
    private EmailSenderService emailSenderService;

    public static void main(String[] args) {
        SpringApplication.run(SendemailApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void sendEmail() {
        emailSenderService.sendEmail(
                "receiver@example.com", // Thay bằng email người nhận
                "Test Email",
                "Hello, this is a test email"
        );
    }
}
```

---

## 5️⃣ Chạy Ứng Dụng

Chạy ứng dụng Spring Boot bằng lệnh:

```shell
mvn spring-boot:run
```

🔹 Sau khi chạy, nếu thành công bạn sẽ thấy log:

```log
>>>>>> Email sent to receiver@example.com
```

---

## 🔥 Giải Quyết Lỗi Thường Gặp

|Lỗi|Nguyên Nhân|Cách Khắc Phục|
|---|---|---|
|`535-5.7.8 Username and Password not accepted`|Sai mật khẩu hoặc chưa bật App Password|Dùng Google App Password thay vì mật khẩu Gmail|
|`MailAuthenticationException`|Xác thực SMTP thất bại|Kiểm tra `spring.mail.username` và `spring.mail.password`|
|`javax.mail.AuthenticationFailedException`|SMTP bị Google chặn|Bật **Less Secure Apps** hoặc dùng **OAuth2**|

---

📌 **Tóm lại:** Đây là hướng dẫn đầy đủ giúp bạn gửi email trong Spring Boot bằng Gmail SMTP. Nếu gặp lỗi, hãy kiểm tra lại cấu hình email hoặc sử dụng OAuth2 để đảm bảo bảo mật.