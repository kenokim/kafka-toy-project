package com.example.producerwebapp.web.repository;

import com.example.producerwebapp.web.domain.WebItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WebItemRepository extends JpaRepository<WebItem, Long> {
    Optional<WebItem> findByItemId(String itemId);
}
