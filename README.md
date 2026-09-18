# 🎯 Palindrome Checker Pro

![Java](https://img.shields.io/badge/Java-17+-orange?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?logo=springboot)
![MySQL](https://img.shields.io/badge/MySQL-8.x-blue?logo=mysql)
![Maven](https://img.shields.io/badge/Maven-3.9+-red?logo=apachemaven)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

> Application web full-stack permettant de vérifier si un mot ou une phrase est un **palindrome**, avec un **historique persistant** des recherches.

---

## 🔍 Aperçu

**Palindrome Checker Pro** détecte les palindromes en ignorant la casse, les espaces, la ponctuation et les accents. Chaque vérification est sauvegardée en base de données et affichée en temps réel dans un historique élégant au design *Glassmorphism*.

**Exemples reconnus :**
- `Été`
- `Élu par cette crapule`
- `A man, a plan, a canal: Panama`

---

## ✨ Fonctionnalités

- **Vérification en temps réel** — prise en charge des majuscules, espaces, ponctuation et caractères accentués.
- **Historique dynamique** — affichage instantané des dernières recherches, triées de la plus récente à la plus ancienne.
- **Interface moderne** — design épuré en mode sombre (*Glassmorphism*), responsive et adaptatif.
- **Persistance des données** — sauvegarde automatique de chaque test dans une base MySQL via Spring Data JPA.

---

## 🛠 Technologies utilisées

| Couche | Technologies |
|---|---|
| **Backend** | Java 17+, Spring Boot (Spring Web, Spring Data JPA) |
| **Base de données** | MySQL 8 |
| **Frontend** | HTML5, CSS3 (*Glassmorphism*), JavaScript ES6 (Fetch API) |
| **Build** | Apache Maven |

---

## ✅ Prérequis

Avant de commencer, assurez-vous de disposer des éléments suivants :

- [Java JDK 17+](https://www.oracle.com/java/technologies/downloads/)
- [Apache Maven](https://maven.apache.org/) *(optionnel si vous utilisez le wrapper `mvnw`)*
- [MySQL Server](https://dev.mysql.com/downloads/mysql/) actif sur le port `3306`
- Un navigateur web moderne (Chrome, Firefox, Edge)

---

## ⚙️ Configuration de la base de données

### 1. Démarrer MySQL

Lancez votre serveur MySQL (MySQL Workbench, phpMyAdmin ou en ligne de commande).

### 2. Créer la base de données

```sql
CREATE DATABASE IF NOT EXISTS palindrome_db;
```

### 3. Configurer la connexion

Ouvrez `src/main/resources/application.properties` et mettez à jour les identifiants MySQL :

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/palindrome_db?useSSL=false&serverTimezone=UTC
spring.datasource.username=VOTRE_NOM_DUTILISATEUR
spring.datasource.password=VOTRE_MOT_DE_PASSE
```

### 4. Configurer JPA / Hibernate

Toujours dans `application.properties` :

```properties
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 🚀 Installation et lancement

### 1. Cloner le dépôt

```bash
git clone https://github.com/votre-compte/palindrome-checker.git
cd palindrome-checker
```

### 2. Compiler et installer le projet

Cette commande nettoie l'ancien build, compile, exécute les tests, crée le JAR Spring Boot et l'installe dans votre dépôt Maven local :

```bash
mvn clean install
```

### 3. Lancer l'application

```bash
mvn spring-boot:run
```

### 4. Accéder à l'interface

Ouvrez votre navigateur à l'adresse :

```
http://localhost:8080
```

---

## 📁 Structure du projet

```
palindrome-checker/
├── src/
│   ├── main/
│   │   ├── java/com/.../
│   │   │   ├── controller/     # Endpoints REST
│   │   │   ├── service/        # Logique métier
│   │   │   ├── repository/     # Accès aux données (JPA)
│   │   │   └── model/          # Entités
│   │   └── resources/
│   │       ├── application.properties
│   │       └── static/         # Frontend (HTML/CSS/JS)
│   └── test/                   # Tests unitaires
├── pom.xml
└── README.md
```

---

## 👤 Auteur

**Votre Nom**
- GitHub : [@romeolyams383](https://github.com/votre-compte)
- Email : votre.email@example.com

---

## 📄 Licence

Ce projet est sous licence **MIT**. Voir le fichier [LICENSE](LICENSE) pour plus de détails.
