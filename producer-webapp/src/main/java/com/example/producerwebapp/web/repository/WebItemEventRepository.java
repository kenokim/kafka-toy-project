package com.example.producerwebapp.web.repository;

import com.example.producerwebapp.web.domain.WebItemEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebItemEventRepository extends JpaRepository<WebItemEvent, Long> {
}
