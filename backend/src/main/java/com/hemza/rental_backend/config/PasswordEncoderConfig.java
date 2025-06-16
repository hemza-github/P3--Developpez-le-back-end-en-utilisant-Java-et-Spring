package com.hemza.rental_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordEncoderConfig {

  /**
   * Déclare un bean de type PasswordEncoder.
   * Il sera injecté automatiquement partout où un PasswordEncoder est requis (@Autowired).
   *
   * BCrypt est un algorithme de hachage robuste qui intègre un salage aléatoire et un facteur de travail.
   * Cela protège contre les attaques par force brute et rainbow tables.
   */
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
