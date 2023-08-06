package com.example.producerwebapp.web.dto;

import com.example.producerwebapp.web.domain.WebItemEvent;
import lombok.Data;

@Data
public class WebEventDto {
    private String itemId;
    private String eventType;

    public static WebEventDto of(WebItemEvent event) {
        WebEventDto dto = new WebEventDto();
        dto.itemId = event.getItemId();
        dto.eventType = event.getEventType().name();
        return dto;
    }
}
