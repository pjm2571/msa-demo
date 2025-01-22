package site.autoever.userservice.kafa.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class KafkaProducer {
    private static final String TOPIC = "order";
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        log.info("전송: {}", message);
        this.kafkaTemplate.send(TOPIC, message);
    }
}