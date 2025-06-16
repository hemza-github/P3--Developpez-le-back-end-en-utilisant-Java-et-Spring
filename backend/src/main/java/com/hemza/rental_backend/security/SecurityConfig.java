package com.hemza.rental_backend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

// Indique que cette classe contient des configurations Spring (équivalent à un fichier XML de config)
@Configuration
public class SecurityConfig {

  // Définit le bean de configuration de la chaîne de filtres de sécurité Spring
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        // 🔐 Désactive la protection CSRF (utile pour les API REST qui ne sont pas
        // exposées à un navigateur)
        .csrf(csrf -> csrf.disable())
        // 🔓 Autorise toutes les requêtes HTTP sans authentification
        .authorizeHttpRequests(auth -> auth
            .anyRequest().permitAll())
        // 🧾 Active le mode HTTP Basic (ici, vide car aucun endpoint n’est sécurisé)
        .httpBasic(basic -> {
        });

        
    // 🔄 Retourne l’objet de configuration construit
    return http.build();
  }

}
