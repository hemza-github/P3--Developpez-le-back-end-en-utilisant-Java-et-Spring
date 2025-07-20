package com.hemza.rental_backend.service;

import com.hemza.rental_backend.dto.MessageRequestDTO;
import com.hemza.rental_backend.model.Message;
import com.hemza.rental_backend.model.Rental;
import com.hemza.rental_backend.model.User;
import com.hemza.rental_backend.repository.MessageRepository;
import com.hemza.rental_backend.repository.RentalRepository;
import com.hemza.rental_backend.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private UserRepository userRepository;

    public Message sendMessage(MessageRequestDTO dto) {
        Rental rental = rentalRepository.findById(dto.getRental_id())
                .orElseThrow(() -> new IllegalArgumentException("Location introuvable"));

        User user = userRepository.findById(dto.getUser_id())
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur introuvable"));

        Message message = new Message();
        message.setRental(rental);
        message.setUser(user);
        message.setMessage(dto.getMessage());
        message.setCreatedAt(LocalDateTime.now());

        return messageRepository.save(message);
    }

    public Message createMessage(MessageRequestDTO dto) {
        Message message = new Message();

        // Récupérer le rental depuis la BDD
        Optional<Rental> rentalOpt = rentalRepository.findById(dto.getRental_id());
        if (rentalOpt.isEmpty()) {
            throw new RuntimeException("Rental not found");
        }

        // Récupérer l'user depuis la BDD
        Optional<User> userOpt = userRepository.findById(dto.getUser_id());
        if (userOpt.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        message.setRental(rentalOpt.get());
        message.setUser(userOpt.get());

        // Contenu du message
        message.setMessage(dto.getMessage());

        // Date de création
        message.setCreatedAt(LocalDateTime.now());

        return messageRepository.save(message);
    }
}
