// src/main/java/com/hemza/rental_backend/controller/AuthController.java
package com.hemza.rental_backend.controller;

import com.hemza.rental_backend.dto.AuthSuccess;
import com.hemza.rental_backend.dto.RegisterRequestDTO;
import com.hemza.rental_backend.repository.UserRepository;
import com.hemza.rental_backend.security.JwtService;
import com.hemza.rental_backend.dto.LoginRequestDTO;
import com.hemza.rental_backend.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Contrôleur REST responsable des opérations d'authentification.
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

  @Autowired
  private UserService userService;
  @Autowired
  private JwtService jwtService;

  @Autowired
  private UserRepository userRepository;

  /**
   * Enregistre un nouvel utilisateur et retourne un token JWT.
   */
  @PostMapping("/register")
  public ResponseEntity<?> register(@RequestBody RegisterRequestDTO request) {
    try {
      String token = userService.register(request);
      return ResponseEntity.ok(new AuthSuccess(token));
    } catch (IllegalArgumentException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @GetMapping("/me")
  public ResponseEntity<?> me(@RequestHeader("Authorization") String authHeader) {
    if (authHeader == null || !authHeader.startsWith("Bearer ")) {
      return ResponseEntity.badRequest().body("Token manquant ou mal formé.");
    }

    String token = authHeader.substring(7);
    String email;

    try {
      email = jwtService.extractUsername(token);
    } catch (Exception e) {
      return ResponseEntity.status(401).body("Token invalide.");
    }

    if (!jwtService.isTokenValid(token, email)) {
      return ResponseEntity.status(401).body("Token expiré ou invalide.");
    }

    return userRepository.findByEmail(email)
        .<ResponseEntity<?>>map(user -> {
          user.setPassword(null); // Ne jamais retourner le mot de passe
          return ResponseEntity.ok(user);
        })
        .orElseGet(() -> ResponseEntity.status(404).body("Utilisateur non trouvé."));
  }

  /**
   * Connecte un utilisateur et retourne un token JWT.
   */
  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody LoginRequestDTO request) {
    try {
      String token = userService.login(request);
      return ResponseEntity.ok(new AuthSuccess(token));
    } catch (IllegalArgumentException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
