package ai.tech.web.api;

import ai.tech.domain.model.Todo;
import ai.tech.service.infrastructure.producer.SpringKafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/kafka")
public class KafkaApi {
    private final SpringKafkaProducer kafkaProducer;

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") final String message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent.");
    }

    @PostMapping("/publish/hello-world")
    public ResponseEntity<String> publishHelloWorld() {
        kafkaProducer.sendHelloWorldMessage();
        return ResponseEntity.ok("Message sent.");
    }

    @PostMapping("/publish/todo")
    public ResponseEntity<String> publishTodo(@RequestBody final Todo todo) {
        kafkaProducer.sendTodoMessage(todo);
        return ResponseEntity.ok("Message sent.");
    }
}
