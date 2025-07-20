package com.hemza.rental_backend.controller;

import com.hemza.rental_backend.dto.RentalRequestDTO;
import com.hemza.rental_backend.model.Rental;
import com.hemza.rental_backend.service.RentalService;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rentals")
public class RentalController {

    @Autowired
    private RentalService rentalService;

    /**
     * Endpoint POST pour créer un nouveau bien de location.
     * Consomme multipart/form-data pour gérer l'upload de fichier.
     *
     * @param dto DTO contenant les données du formulaire + fichier image
     * @return le bien créé avec son ID et autres infos
     */
    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<Rental> createRental(@ModelAttribute RentalRequestDTO dto) {
        Rental created = rentalService.createRental(dto);
        return ResponseEntity.ok(created);
    }

    /**
     * Endpoint GET pour récupérer la liste complète des biens,
     * enveloppée dans un objet JSON avec la clé "rentals".
     *
     * @return objet contenant la liste des locations sous la clé "rentals"
     */
    @GetMapping
    public Map<String, List<Rental>> getAllRentals() {
        List<Rental> rentals = rentalService.getAllRentals();
        return Collections.singletonMap("rentals", rentals);
    }

    @GetMapping("/{id}")
public ResponseEntity<Rental> getRentalById(@PathVariable Long id) {
    return rentalService.getRentalById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
}
}
