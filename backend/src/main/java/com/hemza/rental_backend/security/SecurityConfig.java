package com.hemza.rental_backend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

  @Autowired
  private JwtAuthenticationFilter jwtAuthenticationFilter;

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth
            // 🔓 Autoriser les endpoints d'authentification
            .requestMatchers("/api/auth/**").permitAll()

            // 🔓 Autoriser la récupération des rentals
            .requestMatchers(HttpMethod.GET, "/api/rentals").authenticated()

            .requestMatchers(HttpMethod.POST, "/api/messages").authenticated()

            // ✅ Autoriser les images dans /uploads/**
            .requestMatchers("/uploads/**").permitAll()

            // 🔓 Autoriser les requêtes OPTIONS (CORS preflight)
            .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()

            // 🔐 Tout le reste est protégé
            .anyRequest().authenticated())
        // 🛑 Désactive les sessions
        .sessionManagement(sess -> sess
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        // 🔐 Ajout du filtre JWT
        .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

    return http.build();
  }
}
