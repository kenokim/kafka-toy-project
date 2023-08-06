package com.example.consumerwebapp.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class EventConsumer {
    @KafkaListener(topics = "kafka-toy-item-v1", groupId = "kafka-toy-ad-v1")
    public void listenItemEvents(@Payload WebItemEventDto dto) {
        log.info("item event...");
        System.out.println(dto);
    }
}
