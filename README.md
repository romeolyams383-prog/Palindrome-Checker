#  Palindrome Checker Pro

**Palindrome Checker Pro** est une application web full-stack permettant de vérifier si un mot ou une phrase est un palindrome, tout en conservant un historique persistant des recherches.
## Fonctionnalités

*  **Vérification en temps réel :** Prise en charge des majuscules, espaces, ponctuation et caractères accentués (ex: *"Été"*, *"Élu par cette crapule"*).
*  **Historique dynamique :** Affichage instantané des dernières recherches triées de la plus récente à la plus ancienne.
   **Interface moderne :** Design épuré en mode sombre (*Glassmorphism*) adaptatif et réactif.
* **Persistance des données :** Sauvegarde automatique de chaque test dans une BDD MySQL via Spring Data JPA.

* ## Structure du Projet
palindrome-checker/
├── src/
│   ├── main/
│   │   ├── java/com/romeo/
│   │   │   ├── controller/      # Contrôleurs REST API
│   │   │   ├── model/           # Entités JPA (Verification)
│   │   │   ├── repository/      # Interfaces Spring Data JPA
│   │   │   └── service/         # Logique métier (PalindromeService)
│   │   └── resources/
│   │       ├── static/          # Frontend (HTML, CSS, JavaScript)
│   │       │   ├── index.html
│   │       │   ├── style.css
│   │       │   └── app.js
│   │       └── application.properties
└── pom.xml
---

##  Technologies utilisées

* **Backend :** Java 17+, Spring Boot (Spring Web, Spring Data JPA)
* **Base de données :** MySQL
* **Frontend :** HTML5, CSS3 (Glassmorphism design), JavaScript ES6 (Fetch API)
* **Gestionnaire de dépendances :** Apache Maven

---

## Prérequis

Avant de commencer, assurez-vous de disposer des éléments suivants :
* [Java JDK 17](https://www.oracle.com/java/technologies/downloads/) ou version supérieure.
* [Apache Maven](https://maven.apache.org/) (optionnel si vous utilisez le wrapper `mvnw`).
* [MySQL Server](https://dev.mysql.com/downloads/mysql/) activé et accessible sur le port `3306`.
* Un navigateur web moderne (Chrome, Firefox, Edge).

---

## ⚙️ Configuration de la base de données

1. Lancez votre serveur MySQL (via MySQL Workbench, phpMyAdmin ou en ligne de commande).
2. Créez une nouvelle base de données :sql (CREATE DATABASE IF NOT EXISTS palindrome_db)
3. Ouvrez le fichier de configuration src/main/resources/application.properties et mettez à jour les accès MySQL :
   spring.datasource.url=jdbc:mysql://localhost:3306/palindrome_db?useSSL=false&serverTimezone=UTC
spring.datasource.username=VOTRE_NOM_DUTILISATEUR
spring.datasource.password=VOTRE_MOT_DE_PASSE

# JPA / Hibernate configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

4.Installation et Lancement
---Cloner le dépôt :

git clone [https://github.com/votre-compte/palindrome-checker.git](https://github.com/votre-compte/palindrome-checker.git)
cd palindrome-checker

--Compiler le projet :
mvn clean install

--Lancer l'application Spring Boot :

mvn spring-boot:run
Accéder à l'interface :
Ouvrez votre navigateur et rendez-vous à l'adresse :
http://localhost:8080
