package com.example.producerwebapp.web.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class WebItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String itemId;

    private String attributes;

    private boolean isActive;

    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;
    private LocalDateTime deleteDateTime;

    public static WebItem create(String itemId, String attributes) {
        WebItem item = new WebItem();
        item.itemId = itemId;
        item.attributes = attributes;
        item.isActive = true;
        item.createDateTime = LocalDateTime.now();
        return item;
    }

    public void update(String attributes) {
        this.attributes = attributes;
        this.updateDateTime = LocalDateTime.now();
    }

    public void delete() {
        this.isActive = false;
        this.deleteDateTime = LocalDateTime.now();
    }
}
