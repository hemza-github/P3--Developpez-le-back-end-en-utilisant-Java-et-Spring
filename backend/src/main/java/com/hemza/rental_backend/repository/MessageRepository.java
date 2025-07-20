package com.hemza.rental_backend.repository;

import com.hemza.rental_backend.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
