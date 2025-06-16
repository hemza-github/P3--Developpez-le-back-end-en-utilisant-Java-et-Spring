// src/main/java/com/hemza/rental_backend/dto/LoginRequestDTO.java
package com.hemza.rental_backend.dto;

/**
 * DTO pour la requête de connexion (login).
 * Contient les informations nécessaires à l'authentification d'un utilisateur.
 */
public class LoginRequestDTO {

    private String email;
    private String password;

    // Constructeur par défaut (nécessaire pour Jackson)
    public LoginRequestDTO() {}

    // Getters et Setters

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
