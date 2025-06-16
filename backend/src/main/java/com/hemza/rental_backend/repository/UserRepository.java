package com.hemza.rental_backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hemza.rental_backend.model.User;

// Interface qui permet d'interagir avec la table "users" en base de données.
// Elle hérite de JpaRepository, ce qui fournit automatiquement des méthodes comme save(), findById(), delete(), etc.
public interface UserRepository extends JpaRepository<User, Long> {
    // Méthode personnalisée pour récupérer un utilisateur à partir de son email.
    // Spring Data JPA va automatiquement implémenter cette méthode grâce à la convention de nommage.
    Optional<User> findByEmail(String email);
}
