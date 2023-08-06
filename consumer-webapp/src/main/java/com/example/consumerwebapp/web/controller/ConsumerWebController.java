package com.example.consumerwebapp.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/consumer")
public class ConsumerWebController {
    @GetMapping("all")
    public void getAll() {
        log.info("get all");

    }
}
