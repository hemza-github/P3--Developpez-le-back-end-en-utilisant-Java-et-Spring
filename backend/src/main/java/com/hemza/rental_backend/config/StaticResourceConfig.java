package com.hemza.rental_backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class StaticResourceConfig implements WebMvcConfigurer {

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    // Autorise l'accès aux fichiers dans le dossier "uploads" à la racine du projet
    registry.addResourceHandler("/uploads/**")
            .addResourceLocations("file:uploads/");
  }
}
