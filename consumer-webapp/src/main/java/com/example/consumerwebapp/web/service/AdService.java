package com.example.consumerwebapp.web.service;

import com.example.consumerwebapp.web.entity.WebAd;
import com.example.consumerwebapp.web.repository.WebAdRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AdService {
    private final WebAdRepository adRepository;

    @Transactional
    public WebAd create(String itemId, String attributes) {
        WebAd ad = WebAd.create(itemId, attributes);
        return adRepository.save(ad);
    }

    private WebAd getByItemId(String itemId) {
        return adRepository.findByItemId(itemId).orElseThrow();
    }

    public List<WebAd> getAll() {
        return adRepository.findAll().stream().filter(WebAd::isActive).toList();
    }

    @Transactional
    public void update(String itemId, String attributes) {
        WebAd ad = getByItemId(itemId);
        ad.update(attributes);
    }

    @Transactional
    public void delete(String itemId) {
        WebAd ad = getByItemId(itemId);
        ad.delete();
    }
}
