package ai.tech.config;

import ai.tech.service.infrastructure.util.KafkaConstants;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic createSpringKafkaTopic() {
        return TopicBuilder.name(KafkaConstants.SPRING_KAFKA_TOPIC_NAME).build();
    }

    @Bean
    public NewTopic createSpringKafkaTodoTopic() {
        return TopicBuilder.name(KafkaConstants.SPRING_KAFKA_TODO_TOPIC_NAME).build();
    }
}
