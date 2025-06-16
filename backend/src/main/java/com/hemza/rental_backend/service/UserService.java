package com.hemza.rental_backend.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hemza.rental_backend.dto.LoginRequestDTO;
import com.hemza.rental_backend.dto.RegisterRequestDTO;
import com.hemza.rental_backend.model.User;
import com.hemza.rental_backend.repository.UserRepository;
import com.hemza.rental_backend.security.JwtService;

// Indique à Spring que cette classe contient une logique métier et peut être injectée ailleurs
@Service
public class UserService {

  // Accès à la base de données des utilisateurs
  @Autowired
  private UserRepository userRepository;
  // Permet de hasher les mots de passe avant stockage
  @Autowired
  private PasswordEncoder passwordEncoder;
  @Autowired
  private JwtService jwtService;

  /**
   * Enregistre un nouvel utilisateur à partir d'une requête de type
   * RegisterRequestDTO.
   * Si l'email est déjà utilisé, une exception est levée.
   * Le mot de passe est automatiquement encodé avec BCrypt.
   *
   * @param request les données du nouvel utilisateur (nom, email, mot de passe)
   * @return un token (simulé ici par "token", à implémenter)
   */
  public String register(RegisterRequestDTO request) {
    // Vérifie si un utilisateur existe déjà avec le même email
    if (userRepository.findByEmail(request.getEmail()).isPresent()) {
      throw new IllegalArgumentException("Cet email est déjà utilisé.");
    }

    // Création de l'entité User à partir des données reçues
    User user = new User();
    user.setName(request.getName());
    user.setEmail(request.getEmail());
    // 🔐 Hachage du mot de passe avant enregistrement
    user.setPassword(passwordEncoder.encode(request.getPassword()));

    // Sauvegarde de l'utilisateur en base
    userRepository.save(user);

    // todo : appeler le service de creation de token et retourner le token renvoyer

    // ✅ Retourne un token JWT directement après inscription
    return jwtService.generateToken(user.getEmail());

  }

  // Nouvelle méthode login à ajouter
  public String login(LoginRequestDTO request) {
    Optional<User> userOpt = userRepository.findByEmail(request.getEmail());
    if (userOpt.isEmpty()) {
      throw new IllegalArgumentException("Utilisateur non trouvé.");
    }

    User user = userOpt.get();

    // Vérifie que le mot de passe est correct
    if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
      throw new IllegalArgumentException("Mot de passe incorrect.");
    }

    // Génère et retourne le token JWT
    return jwtService.generateToken(user.getEmail());
  }
}
