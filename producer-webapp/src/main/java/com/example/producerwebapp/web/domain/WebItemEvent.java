package com.example.producerwebapp.web.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class WebItemEvent {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemId;

    @Enumerated(EnumType.STRING)
    private EventType eventType;

    private LocalDateTime createDateTime;
    private LocalDateTime publishDateTime;
    private boolean isPublished;

    public static WebItemEvent create(WebItem item, EventType eventType) {
        return WebItemEvent.create(item.getItemId(), eventType);
    }

    public static WebItemEvent create(String itemId, EventType eventType) {
        WebItemEvent event = new WebItemEvent();
        event.itemId = itemId;
        event.eventType = eventType;
        event.createDateTime = LocalDateTime.now();
        event.isPublished = false;
        return event;
    }

    public void publish() {
        this.isPublished = true;
        this.publishDateTime = LocalDateTime.now();
    }
}
