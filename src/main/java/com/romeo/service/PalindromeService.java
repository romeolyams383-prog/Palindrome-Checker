package com.romeo.service;
import java.text.Normalizer;
import java.util.List;

import org.springframework.stereotype.Service;

import com.romeo.model.Verification;
import com.romeo.repository.VerificationRepository;


@Service
public class PalindromeService {

    // Injection du repository pour interagir avec la BDD
    private final VerificationRepository repository;

    public PalindromeService(VerificationRepository repository) {
        this.repository = repository;
    }

    // Algorithme pur de vérification
    public boolean estPalindrome(String texte) {
        if (texte == null || texte.trim().isEmpty()) {
            return false;
        }

        // 1. Normalisation Unicode pour séparer les lettres des accents (ex: 'é' devient 'e' + accent)
        // 2. Retrait des marques d'accents (\\p{M})
        // 3. Retrait de tout ce qui n'est pas une lettre ou un chiffre
        // 4. Passage en minuscules
        String nettoye = Normalizer.normalize(texte, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "")
                .replaceAll("[^a-zA-Z0-9]", "")
                .toLowerCase();

        if (nettoye.isEmpty()) {
            return false;
        }

        // Inversion de la chaîne nettoyée
        String inverse = new StringBuilder(nettoye).reverse().toString();

        // Comparaison
        return nettoye.equals(inverse);
    }

    // Méthode métier : vérifie et sauvegarde dans la base de données
    public Verification verifierEtEnregistrer(String mot) {
        boolean resultat = estPalindrome(mot);
        Verification verification = new Verification(mot, resultat);
        return repository.save(verification);
    }

    // Méthode métier : récupère l'historique trié
    public List<Verification> obtenirHistorique() {
        return repository.findAllByOrderByDateVerificationDesc();
    }
}
    

