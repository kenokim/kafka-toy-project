package com.example.producerwebapp.web.controller;

import com.example.producerwebapp.web.domain.WebItem;
import com.example.producerwebapp.web.service.ItemService;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class WebItemController {
    private final ItemService itemService;

    @PostMapping
    public String create(@Nullable String attributes) {
        return itemService.create(attributes).getItemId();
    }

    @GetMapping
    public List<WebItem> read() {
        return itemService.readAll();
    }

    @PutMapping
    public void update(String itemId, @Nullable String attributes) {
        itemService.update(itemId, attributes);
    }

    @DeleteMapping
    public void delete(String itemId) {
        itemService.delete(itemId);
    }
}
