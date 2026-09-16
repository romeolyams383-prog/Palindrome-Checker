package com.romeo.controller;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.romeo.model.Verification;
import com.romeo.service.PalindromeService;

@RestController
@RequestMapping("/api/palindromes")
@CrossOrigin(origins = "*")

public class PalindromeController {
    

    private final PalindromeService service;

    public PalindromeController(PalindromeService service) {
        this.service = service;
    }

    // Endpoint pour vérifier un mot ou une phrase
    @PostMapping("/check")
    public ResponseEntity<Verification> verifierMot(@RequestParam String mot) {
        Verification resultat = service.verifierEtEnregistrer(mot);
        return ResponseEntity.ok(resultat);
    }

    // Endpoint pour récupérer l'historique complet
    @GetMapping("/historique")
    public ResponseEntity<List<Verification>> obtenirHistorique() {
        return ResponseEntity.ok(service.obtenirHistorique());
    }
}
    
