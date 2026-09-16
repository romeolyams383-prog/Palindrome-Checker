package com.romeo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.romeo.model.Verification;

public interface VerificationRepository extends JpaRepository<Verification, Long> {
    
    // Requête personnalisée générée automatiquement par Spring Data JPA
    List<Verification> findAllByOrderByDateVerificationDesc();
}
    
