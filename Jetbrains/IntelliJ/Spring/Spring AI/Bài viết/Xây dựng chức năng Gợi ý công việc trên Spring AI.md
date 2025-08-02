Nguồn : [Xây dựng chức năng Gợi ý công việc trên Spring AI - Khoa's TechBlog](https://koder.vn/2025/07/28/xay-dung-chuc-nang-goi-y-cong-viec-tren-spring-ai/?fbclid=IwY2xjawL0UU9leHRuA2FlbQIxMABicmlkETExRmJyUXlnYURaQWF2MUR1AR5ul18siH1atsqDm58OMPJvSZj9kKvBLJBmMrV56coe5CF7IaEsWUUHPqvilQ_aem_cRLDw02WM9ArsYTwKLC6QQ)

[![](https://koder.vn/wp-content/uploads/2025/07/ai-cover.png)](https://koder.vn/2025/07/28/xay-dung-chuc-nang-goi-y-cong-viec-tren-spring-ai/)
Spring AI tại thời điểm bài viết này mới ra mắt phiên bản chính thức đầu tiên Spring AI 1.0, anh em lưu ý có thay đổi nhiều về các package so với các phiên bản GA trước đó.

Đây là một định nghĩa official về Spring AI

> Spring AI addresses ‘Connecting your enterprise Data and APIs with AI Models’

### Cơ bản về Spring AI[](https://github.com/DogooTech/blogs/tree/master/9_Spring_AI/9_1_AI_Model#c%C6%A1-b%E1%BA%A3n-v%E1%BB%81-spring-ai)

Spring AI là một framework trong hệ sinh thái Spring, cung cấp các APIs hỗ trợ cho việc kết nối đến các AI Model để xử lý các yêu cầu nghiệp vụ của ứng dụng.

Spring AI sẽ cover một số vấn đề sau:

- Quản lý kết nối đến các AI model qua khai báo thư viện `starter` và cấu hình trong file application
- Cung cấp lớp ChatClient làm việc với các Model
- Hỗ trợ template cho câu lệnh `prompt`
- Hỗ trợ mapping dữ liệu đầu ra JSON -> POJO object trong Java
- Có cơ chế xác thực độ liên quan của câu trả lời `RelevancyEvaluator`
- Cho phép lưu trữ lịch sử Chat tại tầng app
- Có khả năng embedding dữ liệu bằng vector database (RAG)
- Hỗ trợ Tooling và MCP cung cấp thêm ngữ cảnh cho AI Model
- Hỗ trợ các cơ chế làm việc với Media: Image, Audio, Video, Text

### Phương án xây dựng chức năng ‘dùng AI tạo danh sách công việc từ biên bản họp’[](https://github.com/DogooTech/blogs/tree/master/9_Spring_AI/9_1_AI_Model#ph%C6%B0%C6%A1ng-%C3%A1n-x%C3%A2y-d%E1%BB%B1ng-ch%E1%BB%A9c-n%C4%83ng-d%C3%B9ng-ai-t%E1%BA%A1o-danh-s%C3%A1ch-c%C3%B4ng-vi%E1%BB%87c-t%E1%BB%AB-bi%C3%AAn-b%E1%BA%A3n-h%E1%BB%8Dp)

Giả sử trong ứng dụng quản lý công việc, sau khi lưu biên bản họp lên ứng dụng, end-user có yêu cầu nhờ AI phân tích các công việc có trong biên bản họp và tạo công việc trên ứng dụng.

Phương án ta có thể dùng cửa sổ Chat để hỏi AI, sau đó nó sẽ đưa ra các đầu việc và end-user có thể nhập vào trên hệ thống, như vậy tính tích hợp chưa được cao. Ta có thể sử dụng Spring AI để tích hợp sâu hơn để backend có thể xử lý giúp người dùng nhiều công đoạn hơn thay vì copy và tạo thủ công từng công việc. Ý tưởng như sau:

- Spring AI cần kết nối đến một AI Model: OpenAI, Mistral, Deepseek AI thông qua Ollama….
- Tạo một template trong Spring AI để yêu cầu AI Model phân tích biên bản họp và tạo danh mục đầu việc
- Chuyển danh mục đầu việc đã tạo bởi AI Model sang một danh sách có cấu trúc của Java
- Backend xử lý nghiệp vụ sẽ tạo công việc dựa trên danh sách

_Lưu ý_ trong phần demo này ta sẽ yêu cầu AI Model tạo giúp một biên bản họp, sau đó dùng chính biên bản đấy làm đầu vào để tạo danh sách công việc.

### Tạo một dự án đơn giản để kết nối với AI Model

Mã nguồn dự án các bạn có thể tham khảo [tại đây](https://github.com/DogooTech/pub-tuts-repos/tree/master/ai-service)

Trong phần này mình sẽ giới thiệu cách kết nối đến một AI Model, tương tác với AI Model, convert giá trị trả về sang POJO, kiểm chứng sự liên quan của câu trả lời và cách dùng một số Advisor cơ bản trong Spring AI. Đây là ứng dụng cơ bản giúp các bạn mới làm quen thực hành với Spring AI trước khi đi vào triển khai xây dựng ứng dụng thực tế.

Để thực hành được phần này mọi người đăng ký một API Key trên OpenAI hoặc bất kỳ AI Model nào nằm trong [danh sách](https://docs.spring.io/spring-ai/reference/api/chatmodel.html) hỗ trợ của Spring AI.

Nếu muốn chạy AI Model tại local, mọi người có thể thử với Ollama, sau khi cài đặt và tiến hành pull AI Model mong muốn sẽ tiến hành cấu hình như những AI Model trên cloud.

Lưu ý: Ollama chạy khá chậm trên môi trường Laptop, đã test với máy Utral 7 có NPU và 64GB Ram, không card đồ họa. Anh em nào biết cách cấu hình sử dụng được NPU trong Utral 7 thì comment nhé, mình thấy NPU này không hoạt động với Ollama

Trong bài này mình sẽ sử dụng OpenAI là AI Model, các model khác bạn có thể xem tại [Reference documents](https://docs.spring.io/spring-ai/reference/api/chatmodel.html) để biết thông số cấu hình.

Trong OpenAI cũng có nhiều loại Model để ta có thể lựa chọn, trong quá trình test nếu các bạn dùng OpenAI để tiết kiệm chi phí có thể sử dụng `gpt-4o-mini`.

#### Cấu hình thư viện[](https://github.com/DogooTech/blogs/tree/master/9_Spring_AI/9_1_AI_Model#c%E1%BA%A5u-h%C3%ACnh-th%C6%B0-vi%E1%BB%87n)

Đây là một số thông tin version cho Spring Boot và Spring AI,

ta cần 2 thư viện `spring-ai-starter-model-openai` và `spring-ai-autoconfigure-model-openai` để hệ thống tự động cấu hình

```
plugins {
    id 'java'
    id 'org.springframework.boot' version '3.5.3'
    id 'io.spring.dependency-management' version '1.1.7'
}

group = 'com.koder.course'
version = '0.0.1-SNAPSHOT'

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

configurations {
    compileOnly {
        extendsFrom annotationProcessor
    }
}

repositories {
    mavenCentral()
}

ext {
    set('springAiVersion', "1.0.0")
}


dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-webflux'
    implementation 'org.springframework.ai:spring-ai-starter-model-openai'
    implementation 'org.springframework.ai:spring-ai-autoconfigure-model-openai'
    implementation 'org.springframework.boot:spring-boot-starter-actuator'
}

dependencyManagement {
    imports {
        mavenBom "org.springframework.ai:spring-ai-bom:${springAiVersion}"
    }
}

```

#### Cấu hình application.properties/yaml[](https://github.com/DogooTech/blogs/tree/master/9_Spring_AI/9_1_AI_Model#c%E1%BA%A5u-h%C3%ACnh-applicationpropertiesyaml)

Lựa chọn mô hình AI và Token

```
spring.ai.openai.api-key: ${OPEN_AI_TOKEN:change-me}
spring.ai.openai.chat.options.model: gpt-4o-mini
```

#### Cấu hình ChatClient[](https://github.com/DogooTech/blogs/tree/master/9_Spring_AI/9_1_AI_Model#c%E1%BA%A5u-h%C3%ACnh-chatclient)

Là một interface, là công cụ giao tiếp Spring AI đến các AI Model, trong interface này ta có cấu hình, để sử dụng ChatClient ta thiết lập một số cấu hình cơ bản sau

```java
public class SpringAIChatService implements AIChatService {

    private final ChatClient chatClient;

    public SpringAIChatService(ChatClient.Builder chatClientBuilder,
                               ChatMemory chatMemory) {
        this.chatClient = chatClientBuilder
                .defaultAdvisors(
                        PromptChatMemoryAdvisor.builder(chatMemory).build(),
                        new SimpleLoggerAdvisor())
                .build();
    }

}
```

`.defaultAdvisors()` như trong cấu hình trên ta sử dụng `PromptChatMemoryAdvisor` để lưu lịch sử Chat với AI, ngoài ra còn có một số cách lưu như `MessageChatMemoryAdvisor` hay `VectorStoreChatMemoryAdvisor`

Mỗi loại có một số cách lưu lịch sử và truyền lại ngữ cảnh(context) khác nhau đến AI Model, phần này mình sẽ giới thiệu chi tiết hơn trong bài về cách lưu lịch sử Chat.

`SimpleLoggerAdvisor()` dùng để xem log của app khi tương tác với AI Model, kết hợp với khai báo trong `application.yml` sẽ hiển thị được các thông tin chi tiết, như nội dung gửi đến, nhận về khi làm việc với AI Model.

```
logging.level.org.springframework.ai: DEBUG
```

Ngoài cách cấu hình trên ta có thể khai báo một Bean cho ChatClient để có thể dùng toàn bộ project

```java
public class ChatClientConfig {

    @Bean
    ChatMemory chatMemory(ConversationRepository conversationRepository) {
        return new MongoChatMemory(conversationRepository);
    }

    @Bean
    ChatClient chatClient(ChatClient.Builder chatClientBuilder,
                          VectorStore vectorStore,
                          ChatMemory chatMemory) {

        return chatClientBuilder
                .defaultAdvisors(
                        PromptChatMemoryAdvisor.builder(chatMemory).build(),
                        //MessageChatMemoryAdvisor.builder(chatMemory).build(),
                        //VectorStoreChatMemoryAdvisor.builder(vectorStore).build(),
                        new SimpleLoggerAdvisor(),
                        new QuestionAnswerAdvisor(vectorStore))
                .build();
    }

}
```

#### Sử dụng ChatClient[](https://github.com/DogooTech/blogs/tree/master/9_Spring_AI/9_1_AI_Model#s%E1%BB%AD-d%E1%BB%A5ng-chatclient)

Sau khi ChatClient được cấu hình ta có thể sử dụng được, Spring AI hỗ trợ 2 kiểu trả về là reactive và non-reactive.

Các bài viết vể Reactive các bạn có thể tìm [tại đây](https://koder.vn/2025/07/27/cac-thu-vien-ho-tro-reactive-postgres-mongo-elasticseach-redis-v-v/)

Với kiểu Reactive hiện tại Spring AI 1.0 chưa hỗ trợ convert ra POJO Object tự động, ta phải thực hiện manual, theo tài liệu họ sẽ cập nhật vào thời gian sớm nhất. Đây là đoạn nói về reactive trong [tài liệu reference](https://docs.spring.io/spring-ai/reference/api/chatclient.html#_working_with_multiple_chat_models)

> In the future, we will offer a convenience method that will let you return a Java entity with the reactive stream() method. In the meantime, you should use the Structured Output Converter to convert the aggregated response explicity as shown below. This also demonstrates the use of parameters in the fluent API that will be discussed in more detail in a later section of the documentation.

_Gọi ChatClient theo kiểu reactive_

Các toán tử trong reactive khi họi chatClient

`user` là một trong 3 loại role khi tương tác với AI ta có thể thêm prompt cho loại này, hai loại còn lại là `system` và `assistant`. `system` ta có thể thêm `prompt` để tăng thêm ngữ cảnh, `assistant` là role cho câu trả lời từ AI do vậy không cần thêm prompt.

`stream().content()` để yêu cầu dữ liệu trả ra dạng stream.

`doOnNext` do dữ liệu trả dạng stream, nó sẽ trả về một Flux, ở đây mục đích in log trả về của app, nó thường có dạng như sau

```
c.k.c.ai.service.SpringAIChatService     : Received AI chunk: Vi
c.k.c.ai.service.SpringAIChatService     : Received AI chunk: ệt
c.k.c.ai.service.SpringAIChatService     : Received AI chunk:  Nam
c.k.c.ai.service.SpringAIChatService     : Received AI chunk:  hiện
c.k.c.ai.service.SpringAIChatService     : Received AI chunk:  có
```

`reduce` toán tử cho phép ta cộng dồn các phần câu trả lời nhận được

`map` chuyển câu trả lời vào một POJO object

```
public Mono<Answer> askQuestion(Question question, Locale locale) {
    return chatClient.prompt()
            .user(question.question())
            .stream()
            .content()
            .doOnNext(chunk -> log.info("Received AI chunk: {}", chunk))
            .reduce((accumulated, newContent) -> accumulated + newContent)
            .map(aws -> new Answer(question.question(), aws));
}
```

_Gọi ChatClient theo kiểu non-reactive_

Trong phần này ta thấy sẽ sử dụng toán tử

`call()` để sử dụng kiểu là non-reactive

`entity()` để map kết quả ra POJO object, ở đây là Answer, đây chính là cách Spring AI convert dữ liệu đầu ra, ngoài cách này ta còn có thể sử dụng `.entity(new ParameterizedTypeReference<List<String>>() {})` khi muốn convert sang dạng List.

```java
public Answer question(Question question, String conversationId) {
        return chatClient.prompt()
                .system(sysSpec -> sysSpec
                        .text(systemPromptTemplate)
                        .param("gameTitle", question.title())
                        .param("rules", gameRulesService.getRulesFor(question.title(), question.question()))
                )
                .user(question.question())
                .call()
                .entity(Answer.class);
 }
```

#### Đánh giá câu trả lời[](https://github.com/DogooTech/blogs/tree/master/9_Spring_AI/9_1_AI_Model#%C4%91%C3%A1nh-gi%C3%A1-c%C3%A2u-tr%E1%BA%A3-l%E1%BB%9Di)

Đoạn code dưới đây là một implement khác cho interface AIChatService

Ở đây ta sử dụng `RelevancyEvaluator` với mục đích cung cấp câu hỏi và câu trả lời của AI Model cho AI Model đánh giá xem mức độ liên quan của câu hỏi và câu trả lời, nếu AI đánh giá không liên quan, ta sẽ thực hiện lại.

`.doOnNext(answer -> evaluateRelevancy(question, answer))` đánh giá độ liên quan

`.retryWhen(Retry.max(3).filter(throwable -> throwable instanceof AnswerNotRelevantException)` nếu không liên quan, sẽ tiến hành hỏi lại AI

_Lưu ý_ mỗi lần đánh giá được tính là một lần gọi API tới AI, do vậy token request/response đếu được tính phí, do vậy cũng cần cân nhắc ảnh hưởng đến chi phí sử dụng.

```java
@Slf4j
@Service("selfEvaluating")
public class SelfEvaluatingSpringAIChatService implements AIChatService {

    @Value("classpath:/promptTemplates/taskQuestionPromptTemplate.st")
    Resource questionPromptTemplate;

    @Value("classpath:/promptTemplates/taskQuestionPromptTemplate_lang_vi.st")
    Resource questionPromptTemplateVi;

    private final ChatClient chatClient;
    private final RelevancyEvaluator evaluator;

    public SelfEvaluatingSpringAIChatService(ChatClient.Builder chatClientBuilder,
                                             ChatMemory chatMemory) {
        this.chatClient = chatClientBuilder
                .defaultAdvisors(
                        PromptChatMemoryAdvisor.builder(chatMemory).build(),
                        new SimpleLoggerAdvisor())
                .build();
        this.evaluator = new RelevancyEvaluator(chatClientBuilder); // #1
    }

    @Override
    public Mono<Answer> askQuestion(Question question, Locale locale) {
        return chatClient.prompt()
                .user(usrSpec -> usrSpec
                        .text(locale.getLanguage().equals("vi") ? questionPromptTemplateVi : questionPromptTemplate)
                        .param(TaskConstants.TASK_TITLE, question.taskTitle())
                        .param(TaskConstants.TASK_DESCRIPTION, question.taskDescription())
                        .param(TaskConstants.QUESTION, question.question()))
                .stream()
                .content()
                .doOnNext(chunk -> log.info("Received AI chunk: {}", chunk))
                .reduce((accumulated, newContent) -> accumulated + newContent)
                .doOnNext(answer -> evaluateRelevancy(question, answer))
                .map(asw -> new Answer(question.taskTitle(), asw)) // #2
                .timeout(Duration.ofSeconds(60))
                .onErrorResume(TimeoutException.class, ex ->
                        Mono.just(new Answer(question.taskTitle(), "Sorry, the request timed out."))
                ).retryWhen(Retry
                        .max(3)
                        .filter(throwable -> throwable instanceof AnswerNotRelevantException)
                ).onErrorResume(AnswerNotRelevantException.class, ex ->
                        Mono.just(new Answer(question.taskTitle(), "Sorry, I couldn't find a relevant answer."))
                );
    }

    private void evaluateRelevancy(Question question, String answer) {
        EvaluationRequest evaluationRequest =
                new EvaluationRequest(question.question(), List.of(), answer);

        EvaluationResponse evaluationResponse = evaluator.evaluate(evaluationRequest);

        if (!evaluationResponse.isPass()) {
            throw new AnswerNotRelevantException(question.question() + answer); // #4
        }
    }
}
```

#### Xây dựng Controller[](https://github.com/DogooTech/blogs/tree/master/9_Spring_AI/9_1_AI_Model#x%C3%A2y-d%E1%BB%B1ng-controller)

Ta tạo RESTful API cho người dùng tương tác với Spring AI, Controller này sẽ gọi đến ChatService để kết nối đến AI Model

```java
// DTO sử dụng record

public record Answer(String taskTile, String answer) {}

public record Question(@NotBlank(message = "Question is required") String question) {}

@RestController
public class AskController {

    private final AIChatService chatService;

    public AskController(@Qualifier("simpleAsk") AIChatService chatService,
                         AiTaskSuggestionService taskSuggestionService) {
        this.chatService = chatService;
    }

    @PostMapping(value = "/ask", produces = "application/json")
    public  Mono<ResponseEntity<Answer>> askQuestion(@RequestBody @Valid Question question, ServerWebExchange exchange) {

        String acceptLanguage = exchange.getRequest().getHeaders().getFirst("Accept-Language");
        Locale locale = (acceptLanguage != null && !acceptLanguage.isBlank())
                ? Locale.forLanguageTag(acceptLanguage)
                : Locale.ENGLISH;

        return chatService.askQuestion(question, locale)
                .map(ResponseEntity::ok)
                .onErrorReturn(ResponseEntity.badRequest().build());
    }

}
```

#### Test API

Ta thấy AI Model ở đây là OpenAI trả lời với thông tin cũ, đây cũng là điều dễ hiểu bởi vì dữ liệu của một AI Model được giới hạn trong khoảng thời gian nó công bố.

Dù rất thông minh nhưng AI Model sẽ không trả lời được những câu hỏi như Bây giờ là mấy giờ? Hay là thông tin bị out-date như ta đã thấy, do vậy để làm việc với AI với những thông tin cập nhật ra cần cung cấp thêm các thông tin từ RAG, Tooling hay từ các MPC Server.

![](https://koder.vn/wp-content/uploads/2025/07/insomina-test-1-1024x500.png)

### [Hands-on] Thực hành Xây dựng chức năng gợi ý công việc[](https://github.com/DogooTech/blogs/tree/master/9_Spring_AI/9_1_AI_Model#hands-on-th%E1%BB%B1c-h%C3%A0nh-x%C3%A2y-d%E1%BB%B1ng-ch%E1%BB%A9c-n%C4%83ng-g%E1%BB%A3i-%C3%BD-c%C3%B4ng-vi%E1%BB%87c)

Luồng của chương trình, ta tạo một RESTful API với đầu vào là một lĩnh vực bất kỳ, sau đó ta sẽ yêu cầu AI Model tạo cho ta một biên bản họp, ta dùng biên bản này yêu cầu AI tạo ra danh sách công việc cần thực hiện (tạo sinh của tạo sinh :))

Các thông tin cài đặt cấu hình thư viện được cấu hình như trong mục trên.

#### Controller[](https://github.com/DogooTech/blogs/tree/master/9_Spring_AI/9_1_AI_Model#controller)

Đầu vào của API này là một lĩnh vực công việc, ta sẽ yêu cầu API tạo ta cho ta

```java
@PostMapping(value = "/suggest-task/{category}", produces = "application/json")
    public Mono<ResponseEntity<?>> suggestTasks(@PathVariable String category, ServerWebExchange exchange) {

        return taskSuggestionService.suggestTasks(category)
                .map(suggestions -> {
                    if (suggestions.isEmpty()) {
                        return ResponseEntity.noContent().build();
                    }
                    return ResponseEntity.ok(suggestions);
                })
                .onErrorReturn(ResponseEntity.badRequest().build());
}
```

#### Service[](https://github.com/DogooTech/blogs/tree/master/9_Spring_AI/9_1_AI_Model#service)

Trong phần này ta sẽ sử dụng `prompt` template để yêu cầu AI tạo mẫu biên bản họp theo loại hình công ty mà ta truyền vào, sau đó dùng mẫu template khác để tạo danh sách công việc

`.text(randomMeetingNoteTemplateVi)` -> đọc dữ liệu từ template

`.param(TaskConstants.CATEGORY, category)` -> điền từ khóa vào cho template

đây là ví dụ một template, trong template này có từ khóa {category} và nó sẽ được điền vào bằng câu lệnh trên.

```
Giúp tôi tạo ra biên bản của một cuộc với dữ liệu giả lập của một công ty trong ở lĩnh vực {category}. 

Cuộc họp này sẽ bao gồm các thông tin sau:

- **Tên cuộc họp**: Tên của cuộc họp.
- **Mô tả**: Mô tả ngắn gọn về nội dung của cuộc họp.
- **Ngày giờ**: Ngày và giờ diễn ra cuộc họp.
- **Địa điểm**: Địa điểm diễn ra cuộc họp.
- **Người chủ trì**: Tên người chủ trì cuộc họp.
- **Thành viên**: Danh sách các thành viên tham gia cuộc họp.
- **Chủ đề**: Danh sách các chủ đề sẽ được thảo luận trong cuộc họp.
- **Kế hoạch**: Kế hoạch của cuộc họp, bao gồm các mục tiêu và nhiệm vụ cần giải quyết.
- **Tài liệu**: Danh sách các tài liệu cần thiết cho cuộc họp.
- **Kết quả**: Kết quả của cuộc họp, bao gồm các quyết định và hành động cần thực hiện.
- **Ghi chú**: Bất kỳ ghi chú nào cần thiết cho cuộc họp.
- **Liên hệ**: Thông tin liên hệ của người chủ trì hoặc người phụ trách cuộc họp.
- **Mã cuộc họp**: Mã duy nhất cho cuộc họp.
- **Mã định danh**: Mã định danh duy nhất cho cuộc họp.

Do not include any explanations or additional text. Just provide the structured information as specified above.
```

Đây là đoạn implement cho service

```java
public class SpringAiTaskSuggestionService implements AiTaskSuggestionService {

    @Value("classpath:/promptTemplates/meetingNotesRandomPromptTemplate_vi.st")
    Resource randomMeetingNoteTemplateVi;

    @Value("classpath:/promptTemplates/tasksSuggestionPromptTemplate_vi.st")
    Resource tasksSuggestionPromptTemplateVi;

    private final ChatClient chatClient;

    public SpringAiTaskSuggestionService(ChatClient.Builder chatClientBuilder,
                                         ChatMemory chatMemory) {
        this.chatClient = chatClientBuilder
                .defaultAdvisors(
                        PromptChatMemoryAdvisor.builder(chatMemory).build(),
                        new SimpleLoggerAdvisor())
                .build();
    }

    @Override
    public Mono<List<TaskSuggestion>> suggestTasks(String category) {
        return chatClient.prompt()
                .user(promptUserSpec -> promptUserSpec
                        .text(randomMeetingNoteTemplateVi)
                        .param(TaskConstants.CATEGORY, category))
                .stream()
                .content()
                .reduce((accumulated, newContent) -> accumulated + newContent)
                .timeout(Duration.ofSeconds(120))
                .flatMap(content -> { // #1
                    log.info("Received content: {}", content);

                    var responseData = chatClient.prompt() // #2
                            .user(promptUserSpec -> promptUserSpec
                                    .text(tasksSuggestionPromptTemplateVi)
                                    .param(TaskConstants.MEETING_NOTE, content))
                            .call()
                            .responseEntity(new ParameterizedTypeReference<List<TaskSuggestion>>() {}); // #3

                    ChatResponse response = responseData.response();

                    assert response != null;
                    ChatResponseMetadata metadata = response.getMetadata(); // #4

                    logUsage(metadata.getUsage());

                    return Mono.justOrEmpty(
                            responseData.entity()
                    );

                });

    }

    private void logUsage(Usage usage) {
        log.info("Token usage: prompt={}, generation={}, total={}",
                usage.getPromptTokens(),
                usage.getCompletionTokens(),
                usage.getTotalTokens());

    }

}
```

`#1` là dữ liệu biên bản họp được tạo giả định được sử dụng để làm đầu vào cho yêu cầu thứ 2 là biên bản họp 

`#2` gọi đến AI Model để tạo danh sách công việc mong muốn 

`#3` ép kiểu dữ liệu được tạo ra về một danh sách 

`#4` lấy thông tin metadata của gọi AI, thông tin này bao gồm số token gửi đi, số token nhận về và tổng số token cho việc gọi, ta có thể lưu thông tin token này trong trường hợp cần thiết để tính tiền khác hàng. AI Model tính tiền dựa trên token.

#### Mapping được thông tin ra POJO của Java là rất quan trọng[](https://github.com/DogooTech/blogs/tree/master/9_Spring_AI/9_1_AI_Model#mapping-%C4%91%C6%B0%E1%BB%A3c-th%C3%B4ng-tin-ra-pojo-c%E1%BB%A7a-java-l%C3%A0-r%E1%BA%A5t-quan-tr%E1%BB%8Dng)

Ta giả sử màn hình phần mềm quản lý công việc sau khi khách hàng ghi gâm cuộc họp và đưa lên phầm mềm, hệ thống AI sẽ phần tích file ngôn ngữ thành biên bản họp, sau đó phần mềm sẽ tạo ra các công việc liên quan. Nếu AI Model trả về giá trị là mỗi chuỗi String thì phần mềm nghiệp vụ (quản lý công việc) không thể tạo công việc từ chuỗi String đó, nhưng nếu ta convert ra một `List<TaskSuggestion>` => đây là đầu vào của phần quản lý nghiệp vụ, và nó sẽ tạo cho người dùng một danh sách công việc tương ứng.

Như vậy qua Spring AI ta tích hợp sâu được OpenAI với người dùng, khi họ chỉ cần nhấn nút trên giao diện web/mobile là tạo danh sách công việc từ biên bản, thay vì upload file đó lên ChatGTP (sử dụng OpenAI) sau đó copy lần lượt từng công việc về lại giao diện nghiệp vụ.

#### Test APP[](https://github.com/DogooTech/blogs/tree/master/9_Spring_AI/9_1_AI_Model#test-app)

Khi ta gọi API, ta muốn AI Model tạo ra một biên bản họp của một công ty hoạt động trong lĩnh vực `gia công phần mềm`

```
POST http://localhost:8080/suggest-task/gia công phần mềm
```

Ta thấy trong log hệ thống sẽ tạo ra biên bản như sau

```
- **Tên cuộc họp**: Cuộc họp định hướng phát triển sản phẩm mới
- **Mô tả**: Thảo luận về kế hoạch phát triển và triển khai sản phẩm phần mềm mới
- **Ngày giờ**: 15/11/2023, 14:00
- **Địa điểm**: Phòng họp lớn, Tầng 3, Tòa nhà Công ty XYZ
- **Người chủ trì**: Nguyễn Văn A
- **Thành viên**: 
  1. Trần Thị B
  2. Lê Văn C
  3. Phạm Minh D
  4. Nguyễn Thị E
- **Chủ đề**: 
  1. Phân tích thị trường
  2. Đề xuất tính năng sản phẩm
  3. Kế hoạch phát triển và thời gian biểu
- **Kế hoạch**: 
  - Mục tiêu: Xác định các tính năng chính của sản phẩm và lộ trình phát triển
  - Nhiệm vụ: 
    1. Nghiên cứu thị trường
    2. Thu thập ý kiến từ khách hàng
    3. Lập kế hoạch phát triển chi tiết
- **Tài liệu**: 
  1. Báo cáo nghiên cứu thị trường
  2. Danh sách các tính năng đề xuất
  3. Thời gian biểu dự kiến
- **Kết quả**: 
  - Quyết định các tính năng chính
  - Lập kế hoạch phát triển chi tiết
  - Phân công nhiệm vụ cho từng thành viên
- **Ghi chú**: Cần chuẩn bị thêm thông tin về đối thủ cạnh tranh
- **Liên hệ**: Nguyễn Văn A - Email: a.nguyen@xyz.com, Điện thoại: 0123 456 789
- **Mã cuộc họp**: HOP-20231115-001
- **Mã định danh**: ID-XYZ-20231115-001
```

Đây là danh sách các công việc do AI tạo ra, cấu trúc đúng như ta yêu cầu trong file template `tasksSuggestionPromptTemplate_vi.st` và được mapping vào model `TaskSuggestion`

```json
[
	{
		"title": "Nghiên cứu thị trường",
		"description": "Tiến hành nghiên cứu để thu thập thông tin về nhu cầu và xu hướng của thị trường.",
		"startDate": "2023-11-16T09:00:00",
		"endDate": "2023-11-30T17:00:00",
		"priority": 1,
		"assignedTo": "Trần Thị B",
		"approvalUser": "Nguyễn Văn A"
	},
	{
		"title": "Thu thập ý kiến từ khách hàng",
		"description": "Tổ chức khảo sát và phỏng vấn khách hàng để hiểu rõ hơn về yêu cầu và mong muốn của họ.",
		"startDate": "2023-12-01T09:00:00",
		"endDate": "2023-12-15T17:00:00",
		"priority": 2,
		"assignedTo": "Lê Văn C",
		"approvalUser": "Nguyễn Văn A"
	},
	{
		"title": "Lập kế hoạch phát triển chi tiết",
		"description": "Xây dựng kế hoạch chi tiết cho việc phát triển sản phẩm dựa trên các dữ liệu thu thập được.",
		"startDate": "2023-12-16T09:00:00",
		"endDate": "2023-12-31T17:00:00",
		"priority": 3,
		"assignedTo": "Phạm Minh D",
		"approvalUser": "Nguyễn Văn A"
	},
	{
		"title": "Đề xuất tính năng sản phẩm",
		"description": "Dựa trên thông tin thu thập được để đề xuất các tính năng chính cho sản phẩm.",
		"startDate": "2024-01-01T09:00:00",
		"endDate": "2024-01-10T17:00:00",
		"priority": 4,
		"assignedTo": "Nguyễn Thị E",
		"approvalUser": "Nguyễn Văn A"
	}
]
```

### Tổng kết[](https://github.com/DogooTech/blogs/tree/master/9_Spring_AI/9_1_AI_Model#t%E1%BB%95ng-k%E1%BA%BFt)

Chúng ta đã tìm hiểu khái niệm cơ bản về Spring AI, các mảng mà Spring AI hỗ trợ connect đến AI Model.

Có rất nhiều AI Model khác nhau, cần lưu ý không phải AI Model nào cũng hỗ trợ tốt việc convert data sang POJO Java, khi làm việc tích hợp sâu AI và phần mềm nghiệp vụ ta cần để ý đến chi tiết này.

AI Model tính tiền trên token, vậy cần tối ưu câu lệnh truy vấn đến AI.

Viết template cho prompt là một công việc được miêu tả như viết SQL query trong DB, nó cũng cần tối ưu, có những hội nhóm chia sẻ những câu prompt tối ưu mọi người cần tham khảo thêm.

AI tạo sinh đưa ra câu trả lời rất thông minh, hầu hết là đúng, nhưng khi xây dựng App cũng cần có chức năng confirm cho người dùng xem có dùng kết quả này không. Ví dụ `Đề xuất tính năng sản phẩm` không phải là công việc thực tế, trên giao diện ứng dụng cần cho phép end-user bỏ tùy chọn tạo cho task này.