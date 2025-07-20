package com.hemza.rental_backend.controller;

import com.hemza.rental_backend.dto.MessageRequestDTO;
import com.hemza.rental_backend.dto.MessageResponseDTO;
import com.hemza.rental_backend.model.Message;
import com.hemza.rental_backend.service.MessageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

  @Autowired
  private MessageService messageService;

  @PostMapping
  public ResponseEntity<MessageResponseDTO> createMessage(@RequestBody MessageRequestDTO dto) {
    Message message = messageService.createMessage(dto);
    MessageResponseDTO response = new MessageResponseDTO();
    response.setMessage("Message envoyé avec succès (ID: " + message.getId() + ")");
    return ResponseEntity.ok(response);
  }

}
