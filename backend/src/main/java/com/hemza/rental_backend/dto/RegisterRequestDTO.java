package com.hemza.rental_backend.dto;

/**
 * DTO (Data Transfer Object) utilisé pour transporter les données
 * nécessaires à l'inscription d'un utilisateur (name, email, password).
 *
 * Ce type d'objet permet de séparer les données entrantes (du frontend)
 * de l'entité réelle persistée en base de données.
 */
public class RegisterRequestDTO {

  // Le nom de l'utilisateur (ex. : "Hemza")
  private String name;

  // L'email de l'utilisateur (doit être unique dans le système)
  private String email;

  // Le mot de passe brut (sera encodé avant d'être stocké)
  private String password;

  ////////////////////////////
  //// Getters & Setters /////
  ////////////////////////////

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

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
