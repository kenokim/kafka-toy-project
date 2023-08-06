package com.example.consumerwebapp.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.util.List;

@Slf4j
@EnableScheduling
@Component
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class EventConsumerV1 {
    private final ConsumerFactory<String, WebItemEventDto> consumerFactory;
    private Consumer<String, WebItemEventDto> consumer;

    @Transactional
    @Scheduled(cron = "*/3 * * * * ?")
    public void poll() {
        log.info("polling ...");
        if (consumer == null) {
            consumer = consumerFactory.createConsumer();
            consumer.subscribe(List.of("kafka-toy-item-v1"));
        }
        ConsumerRecords<String, WebItemEventDto> records = consumer.poll(Duration.ofSeconds(3));
        records.forEach(record -> System.out.println(record));
    }
}
