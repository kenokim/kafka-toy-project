package com.example.consumerwebapp.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class EventConsumer {
    /*@KafkaListener(topics = "kafka-toy-item-v1", groupId = "kafka-toy-ad-v1")
    public void listenItemEvents(ConsumerRecord<String, WebItemEventDto> record) {
        log.info("item event...");
        System.out.println(record.key() + " : " + record.value());
    }*/
}
