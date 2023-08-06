package com.example.consumerwebapp.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class WebAd {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String itemId;
    private String attributes;
    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;
    private LocalDateTime deleteDateTime;
    private boolean isActive;

    public static WebAd create(String itemId, String attributes) {
        WebAd ad = new WebAd();
        ad.itemId = itemId;
        ad.attributes = attributes;
        ad.createDateTime = LocalDateTime.now();
        ad.isActive = true;
        return ad;
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
