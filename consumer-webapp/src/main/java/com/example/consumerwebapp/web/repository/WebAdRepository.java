package com.example.consumerwebapp.web.repository;

import com.example.consumerwebapp.web.entity.WebAd;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WebAdRepository extends JpaRepository<WebAd, Long> {
    Optional<WebAd> findByItemId(String itemId);
}
