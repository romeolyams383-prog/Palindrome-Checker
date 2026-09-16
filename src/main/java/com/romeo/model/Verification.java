package com.romeo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "verifications")
public class Verification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String mot;

    @Column(nullable = false)
    private boolean estPalindrome;

    @Column(nullable = false)
    private LocalDateTime dateVerification;

    // Constructeur vide requis par JPA
    public Verification() {}

    // Constructeur pratique pour instancier une nouvelle vérification
    public Verification(String mot, boolean estPalindrome) {
        this.mot = mot;
        this.estPalindrome = estPalindrome;
        this.dateVerification = LocalDateTime.now();
    }

    // Getters et Setters
    public Long getId() { 
        return id; 
    }

    public String getMot() { 
        return mot; 
    }

    public void setMot(String mot) { 
        this.mot = mot; 
    }

    public boolean isEstPalindrome() { 
        return estPalindrome; 
    }

    public void setEstPalindrome(boolean estPalindrome) { 
        this.estPalindrome = estPalindrome; 
    }

    public LocalDateTime getDateVerification() { 
        return dateVerification; 
    }

    public void setDateVerification(LocalDateTime dateVerification) { 
        this.dateVerification = dateVerification; 
    }
}