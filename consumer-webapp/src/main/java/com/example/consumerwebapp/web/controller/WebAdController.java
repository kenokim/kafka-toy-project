package com.example.consumerwebapp.web.controller;

import com.example.consumerwebapp.web.entity.WebAd;
import com.example.consumerwebapp.web.service.AdService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/ads")
@RequiredArgsConstructor
public class WebAdController {
    private final AdService adService;

    @GetMapping
    public List<WebAd> getAll() {
        log.info("get all");
        return adService.getAll();
    }
}
