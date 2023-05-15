package ai.tech.service.infrastructure.producer;

import ai.tech.service.infrastructure.util.KafkaConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class SpringKafkaProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendHelloWorldMessage() {
        kafkaTemplate.send(KafkaConstants.TOPIC_NAME, KafkaConstants.HELLO_WORLD_MESSAGE);
        log.info("Message: \"{}\", sent to topic: \"{}\"", KafkaConstants.HELLO_WORLD_MESSAGE, KafkaConstants.TOPIC_NAME);
    }

    public void sendMessage(final String message) {
        kafkaTemplate.send(KafkaConstants.TOPIC_NAME, message);
        log.info("Message: \"{}\", sent to topic: \"{}\"", KafkaConstants.HELLO_WORLD_MESSAGE, KafkaConstants.TOPIC_NAME);
    }
}
