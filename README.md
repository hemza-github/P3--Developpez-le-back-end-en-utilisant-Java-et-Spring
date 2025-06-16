
# 🏡 ChâTop - Portail de mise en relation locataires / propriétaires

![Bannière ChâTop](https://via.placeholder.com/1200x300.png?text=Camping-car+%C3%A0+la+campagne+%7C+Ch%C3%A2Top+Logo)

---

## Contexte

Bienvenue dans le projet **ChâTop**, plateforme de location saisonnière dédiée à la côte basque et bientôt à toute la France. Ce portail permet aux locataires de trouver et contacter directement les propriétaires des logements.

---

## Technologies

- Frontend : Angular  
- Backend : Java 17 + Spring Boot  
- Base de données : PostgreSQL (conteneur Docker)  
- Conteneurisation : Docker & Docker Compose  
- Tests API : Postman  
- Mock : Mockoon  
- Documentation API : Swagger via Springdoc OpenAPI  

---

## Structure du projet

```
Projet ChâTop/
├── backend/                # Spring Boot backend
├── frontend/               # Application Angular
├── docker-compose.yml      # Docker compose pour PostgreSQL
├── README.md               # Ce fichier
├── .gitignore
└── .env                   # Variables d’environnement
```

---

## Installation & lancement

1. Cloner le dépôt

```bash
git clone https://github.com/hemza-github/TON_REPO.git
cd TON_REPO
```

2. Démarrer la base de données

```bash
docker-compose up -d
```

3. Lancer le backend (Spring Boot)

```bash
cd backend
./mvnw spring-boot:run
```

L’API sera accessible sur `http://localhost:8080`

4. Lancer le frontend (Angular)

```bash
cd frontend
npm install
npm start
```

Le frontend sera accessible sur `http://localhost:4200`

---

## Fonctionnalités clés

- Authentification sécurisée (JWT) pour locataires et propriétaires  
- Gestion des annonces immobilières  
- Mise en relation via messagerie interne  
- Documentation API interactive Swagger disponible à `http://localhost:8080/swagger-ui.html`

---

## Tests & outils

- Collection Postman fournie pour tester l’API  
- Mockoon utilisé pour les données mockées en phase de développement

---

## Notes pour les développeurs

- Branche principale : `main`  
- Branche de développement : `dev`  

Commandes utiles :

```bash
# Arrêter et supprimer les conteneurs + volumes (nettoyage)
docker-compose down -v

# Reconstruire les images Docker sans cache
docker-compose build --no-cache
```

---

## Contacts

- Marco (Responsable Tech) – marco@chatop.fr  
- Stéphanie (Développeuse Front-end) – stephanie@chatop.fr  

---

## Licence

© 2025 ChâTop – Tous droits réservés.  
Projet privé.

---
