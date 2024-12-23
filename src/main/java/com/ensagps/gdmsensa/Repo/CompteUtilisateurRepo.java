package com.ensagps.gdmsensa.Repo;

import com.ensagps.gdmsensa.Model.CompteUtilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteUtilisateurRepo extends JpaRepository<CompteUtilisateur, Long> {
    CompteUtilisateur findByNomUtilisateur(String nomUtilisateur);
}