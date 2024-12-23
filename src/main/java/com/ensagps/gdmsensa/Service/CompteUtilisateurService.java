package com.ensagps.gdmsensa.Service;

import com.ensagps.gdmsensa.Model.CompteUtilisateur;
import com.ensagps.gdmsensa.Model.Utilisateur;
import com.ensagps.gdmsensa.Repo.CompteUtilisateurRepo;
import com.ensagps.gdmsensa.Repo.UtilisateurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompteUtilisateurService {

    @Autowired
    private CompteUtilisateurRepo compteUtilisateurRepo;

    @Autowired
    private UtilisateurRepo utilisateurRepo;

    // Create a new CompteUtilisateur
    public CompteUtilisateur createCompteUtilisateur(String nomUtilisateur, String motDePasse, String role, Long utilisateurId) {
        Optional<Utilisateur> utilisateurOpt = utilisateurRepo.findById(utilisateurId);
        if (!utilisateurOpt.isPresent()) {
            throw new IllegalArgumentException("Utilisateur not found");
        }
        Utilisateur utilisateur = utilisateurOpt.get();

        CompteUtilisateur compteUtilisateur = new CompteUtilisateur(nomUtilisateur, motDePasse, role, utilisateur);
        return compteUtilisateurRepo.save(compteUtilisateur);
    }

    // Get a CompteUtilisateur by ID
    public CompteUtilisateur getCompteUtilisateurById(Long id) {
        return compteUtilisateurRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("CompteUtilisateur not found"));
    }

    // Get all CompteUtilisateurs
    public List<CompteUtilisateur> getAllCompteUtilisateurs() {
        return compteUtilisateurRepo.findAll();
    }

    // Update a CompteUtilisateur
    public CompteUtilisateur updateCompteUtilisateur(Long id, String nomUtilisateur, String motDePasse, String role, Long utilisateurId) {
        CompteUtilisateur compteUtilisateur = getCompteUtilisateurById(id);

        Optional<Utilisateur> utilisateurOpt = utilisateurRepo.findById(utilisateurId);
        if (!utilisateurOpt.isPresent()) {
            throw new IllegalArgumentException("Utilisateur not found");
        }
        Utilisateur utilisateur = utilisateurOpt.get();

        compteUtilisateur.setNomUtilisateur(nomUtilisateur);
        compteUtilisateur.setMotDePasse(motDePasse);
        compteUtilisateur.setRole(role);
        compteUtilisateur.setUtilisateur(utilisateur);

        return compteUtilisateurRepo.save(compteUtilisateur);
    }

    // Delete a CompteUtilisateur
    public void deleteCompteUtilisateur(Long id) {
        CompteUtilisateur compteUtilisateur = getCompteUtilisateurById(id);
        compteUtilisateurRepo.delete(compteUtilisateur);
    }
}