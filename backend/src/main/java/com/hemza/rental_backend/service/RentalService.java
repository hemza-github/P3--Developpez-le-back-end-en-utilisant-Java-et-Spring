package com.hemza.rental_backend.service;

import com.hemza.rental_backend.dto.RentalRequestDTO;
import com.hemza.rental_backend.model.Rental;
import com.hemza.rental_backend.model.User;
import com.hemza.rental_backend.repository.RentalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RentalService {

  @Autowired
  private RentalRepository rentalRepository;

  @Autowired
  private UserService userService;

  /**
   * Crée une nouvelle location à partir des données du formulaire (DTO).
   * Cette location est automatiquement liée à l'utilisateur actuellement
   * authentifié.
   *
   * @param dto Données du formulaire envoyé par le frontend
   * @return Rental persisté en base
   */
  public Rental createRental(RentalRequestDTO dto) {
    // 🔐 Récupération de l'utilisateur actuellement connecté
    User currentUser = userService.getCurrentUser();

    // 🏠 Création de l'objet Rental à persister
    Rental rental = new Rental();
    rental.setName(dto.getName());
    rental.setSurface(dto.getSurface());
    rental.setPrice(dto.getPrice());
    rental.setDescription(dto.getDescription());
    rental.setOwner(currentUser); // 🔗 Association au user connecté
    rental.setCreatedAt(LocalDateTime.now());
    rental.setUpdatedAt(LocalDateTime.now());

    // 🖼️ Gestion de l'upload d'image si présente
    MultipartFile pictureFile = dto.getPicture();
    if (pictureFile != null && !pictureFile.isEmpty()) {
      try {
        String uploadDir = "uploads"; // 📂 Dossier racine du projet
        Path uploadPath = Paths.get(uploadDir);

        // Création du dossier s’il n’existe pas
        if (!Files.exists(uploadPath)) {
          Files.createDirectories(uploadPath);
        }

        // 🧾 Nom de fichier unique
        String fileName = System.currentTimeMillis() + "_" + pictureFile.getOriginalFilename();
        Path filePath = uploadPath.resolve(fileName);

        // 📥 Sauvegarde du fichier
        Files.write(filePath, pictureFile.getBytes());

        // 📌 Enregistrement du chemin dans la base
        rental.setPicture("http://localhost:8080/uploads/" + fileName);

      } catch (IOException e) {
        throw new RuntimeException("Erreur lors de l'enregistrement de l'image", e);
      }
    }

    // 💾 Sauvegarde en base de données
    return rentalRepository.save(rental);
  }

  /**
   * Récupère toutes les locations disponibles.
   *
   * @return Liste complète des rentals
   */
  public List<Rental> getAllRentals() {
    List<Rental> rentals = rentalRepository.findAll();



    return rentals;
  }

  public Optional<Rental> getRentalById(Long id) {
    return rentalRepository.findById(id);
}

}
