package site.autoever.orderservice.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KafkaConsumer {
    @KafkaListener(topics = "order", groupId = "dev")
    public void consume(String message) {
        log.info("수신: {}", message);
    }
}