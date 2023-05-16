package ai.tech.service.infrastructure.consumer;

import ai.tech.domain.model.Todo;
import ai.tech.service.infrastructure.util.KafkaConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SpringKafkaConsumer {
    @KafkaListener(topics = KafkaConstants.SPRING_KAFKA_TOPIC_NAME, groupId = "spring-kafka")
    public void consumeFromSpringKafkaTopic(final String message) {
        log.info("Message: \"{}\", received from topic: \"{}\"", message, KafkaConstants.SPRING_KAFKA_TOPIC_NAME);
    }

    @KafkaListener(topics = KafkaConstants.SPRING_KAFKA_TODO_TOPIC_NAME, groupId = "spring-kafka-todo")
    public void consumeFromSpringKafkaTodoTopic(final Todo message) {
        log.info("Message: \"{}\", received from topic: \"{}\"", message.toString(), KafkaConstants.SPRING_KAFKA_TODO_TOPIC_NAME);
    }
}
