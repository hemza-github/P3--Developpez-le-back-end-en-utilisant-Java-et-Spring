package com.hemza.rental_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import org.springframework.lang.NonNull;

@Configuration
public class CorsConfig {

  /**
   * Ce bean retourne une instance de WebMvcConfigurer personnalisée
   * pour configurer les règles CORS de l'application.
   */
  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {

      /**
       * Cette méthode permet de définir les règles de partage des ressources entre
       * origines différentes (CORS).
       * Elle est automatiquement appelée par Spring au démarrage.
       */
      @Override
      public void addCorsMappings(@NonNull CorsRegistry registry) {
        registry.addMapping("/**") // autorise tous les endpoints
            .allowedOrigins("http://localhost:4200") // autorise Angular en local
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
            .allowedHeaders("*")
            .allowCredentials(true); // utile si tu utilises les cookies / sessions
      }
    };
  }
}
