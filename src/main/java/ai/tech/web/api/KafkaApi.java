package ai.tech.web.api;

import ai.tech.service.infrastructure.consumer.SpringKafkaConsumer;
import ai.tech.service.infrastructure.producer.SpringKafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/kafka")
public class KafkaApi {
    private final SpringKafkaProducer kafkaProducer;

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") final String message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent.");
    }

    @GetMapping("/publish/hello-world")
    public ResponseEntity<String> publishHelloWorld() {
        kafkaProducer.sendHelloWorldMessage();
        return ResponseEntity.ok("Message sent.");
    }
}
