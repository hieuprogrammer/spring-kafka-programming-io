package ai.tech.service.infrastructure.consumer;

import ai.tech.service.infrastructure.util.KafkaConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SpringKafkaConsumer {
    @KafkaListener(topics = KafkaConstants.TOPIC_NAME, groupId = "spring-kafka")
    public void consume(final String message) {
        log.info("Message: \"{}\", received from topic: \"{}\"", message, KafkaConstants.TOPIC_NAME);
    }
}
