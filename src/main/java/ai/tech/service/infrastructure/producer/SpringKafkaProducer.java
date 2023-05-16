package ai.tech.service.infrastructure.producer;

import ai.tech.domain.model.Todo;
import ai.tech.service.infrastructure.util.KafkaConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class SpringKafkaProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final KafkaTemplate<String, Todo> todoKafkaTemplate;

    public void sendHelloWorldMessage() {
        kafkaTemplate.send(KafkaConstants.SPRING_KAFKA_TOPIC_NAME, KafkaConstants.HELLO_WORLD_MESSAGE);
        log.info("Message: \"{}\", sent to topic: \"{}\"", KafkaConstants.HELLO_WORLD_MESSAGE, KafkaConstants.SPRING_KAFKA_TOPIC_NAME);
    }

    public void sendMessage(final String message) {
        kafkaTemplate.send(KafkaConstants.SPRING_KAFKA_TOPIC_NAME, message);
        log.info("Message: \"{}\", sent to topic: \"{}\"", KafkaConstants.HELLO_WORLD_MESSAGE, KafkaConstants.SPRING_KAFKA_TOPIC_NAME);
    }

    public void sendTodoMessage(final Todo todo) {
        final Message<Todo> message = MessageBuilder.withPayload(todo).setHeader(KafkaHeaders.TOPIC, KafkaConstants.SPRING_KAFKA_TODO_TOPIC_NAME).build();
        todoKafkaTemplate.send(message);
    }
}
