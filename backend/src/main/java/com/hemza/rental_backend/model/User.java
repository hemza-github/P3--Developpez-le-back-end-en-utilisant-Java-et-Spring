package com.hemza.rental_backend.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

/**
 * Entité représentant un utilisateur dans la base de données.
 * Cette classe est mappée à la table "users" avec une contrainte d'unicité sur l'email.
 */
@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {

  /**
   * Identifiant unique auto-généré pour chaque utilisateur.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * Nom de l'utilisateur.
   */
  private String name;

  /**
   * Email de l'utilisateur, qui doit être unique et non null.
   */
  @Column(nullable = false, unique = true)
  private String email;

   /**
   * Mot de passe encodé de l'utilisateur, stocké en base.
   */
  @Column(nullable = false)
  private String password;

   /**
   * Date de création automatique de l’enregistrement en base.
   * Cette valeur est renseignée automatiquement à l'insertion.
   */
  @CreationTimestamp
  @Column(name = "created_at", updatable = false)
  private LocalDateTime createdAt;

  /**
   * Date de dernière mise à jour automatique de l’enregistrement.
   * Cette valeur est mise à jour automatiquement à chaque modification.
   */
  @UpdateTimestamp
  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  //////////////////////////
  //// Getters & Setters////
  //////////////////////////

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

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
