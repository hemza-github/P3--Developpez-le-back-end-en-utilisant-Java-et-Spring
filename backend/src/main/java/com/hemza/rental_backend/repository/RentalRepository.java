package com.hemza.rental_backend.repository;


import com.hemza.rental_backend.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {
    // Tu peux ajouter ici des méthodes de recherche personnalisées si besoin, par exemple :
    // List<Rental> findByOwnerId(Long ownerId);
}
