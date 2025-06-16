package com.hemza.rental_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Point d’entrée principal de l'application Spring Boot.
 * L'annotation @SpringBootApplication combine :
 * - @Configuration : définit des beans de configuration
 * - @EnableAutoConfiguration : active la configuration automatique
 * - @ComponentScan : scanne les packages pour détecter les composants Spring
 * (contrôleurs, services, etc.)
 */
@SpringBootApplication
public class RentalBackendApplication {

  /**
   * La méthode main() démarre l'application.
   * Elle utilise SpringApplication.run() pour lancer le contexte Spring et
   * démarrer le serveur intégré (Tomcat par défaut).
   *
   * @param args arguments de la ligne de commande (non utilisés ici)
   */
  public static void main(String[] args) {
    SpringApplication.run(RentalBackendApplication.class, args);
  }

}
