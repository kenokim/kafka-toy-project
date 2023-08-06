package com.example.producerwebapp.producer;

import com.example.producerwebapp.web.domain.WebItemEvent;
import com.example.producerwebapp.web.dto.WebEventDto;
import com.example.producerwebapp.web.repository.WebItemEventRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@EnableScheduling
@Component
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class EventProducer {
    private final KafkaTemplate<String, Object> template;
    private final WebItemEventRepository eventRepository;

    @Transactional
    @Scheduled(cron = "*/3 * * * * ?")
    public void poll() {
        log.info("Polling events ...");
        List<WebItemEvent> events = eventRepository.findAllByIsPublishedFalse();
        for (WebItemEvent event : events) {
            template.send("kafka-toy-item-v1", event.getItemId(), WebEventDto.of(event));
            event.publish();
            log.info("published event : {}", event.getItemId());
        }
    }
}
