package com.example.producerwebapp.web.service;

import com.example.producerwebapp.web.domain.EventType;
import com.example.producerwebapp.web.domain.WebItem;
import com.example.producerwebapp.web.domain.WebItemEvent;
import com.example.producerwebapp.web.repository.WebItemEventRepository;
import com.example.producerwebapp.web.repository.WebItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {
    private final WebItemRepository itemRepository;
    private final WebItemEventRepository eventRepository;

    @Transactional
    public WebItem create(String attributes) {
        String itemId = UUID.randomUUID().toString();
        WebItem item = WebItem.create(itemId, attributes);
        eventRepository.save(WebItemEvent.create(item, EventType.CREATE));
        return itemRepository.save(item);
    }

    private WebItem read(String itemId) {
        return itemRepository.findByItemId(itemId).orElseThrow();
    }

    public List<WebItem> readAll() {
        return itemRepository.findAll().stream().filter(WebItem::isActive).toList();
    }

    @Transactional
    public void update(String itemId, String attributes) {
        WebItem item = read(itemId);
        item.update(attributes);
        eventRepository.save(WebItemEvent.create(item, EventType.UPDATE));
    }

    @Transactional
    public void delete(String itemId) {
        WebItem item = read(itemId);
        item.delete();
        eventRepository.save(WebItemEvent.create(item, EventType.DELETE));
    }
}
