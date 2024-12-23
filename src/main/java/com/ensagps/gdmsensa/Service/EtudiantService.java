package com.ensagps.gdmsensa.Service;

import com.ensagps.gdmsensa.Model.Etudiant;
import com.ensagps.gdmsensa.Repo.EtudiantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantService {

    @Autowired
    private EtudiantRepo etudiantRepo;

    // Create a new Etudiant
    public Etudiant createEtudiant(String nom, String prenom, String cne, Integer semestre, String filiere) {
        Etudiant etudiant = new Etudiant(nom, prenom, cne, semestre, filiere);
        return etudiantRepo.save(etudiant);
    }

    // Get an Etudiant by ID
    public Etudiant getEtudiantById(Long id) {
        return etudiantRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Etudiant not found"));
    }

    // Get all Etudiants
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepo.findAll();
    }

    // Update an Etudiant
    public Etudiant updateEtudiant(Long id, String nom, String prenom, String cne, Integer semestre, String filiere) {
        Etudiant etudiant = getEtudiantById(id);
        etudiant.setNom(nom);
        etudiant.setPrenom(prenom);
        etudiant.setCne(cne);
        etudiant.setSemestre(semestre);
        etudiant.setFiliere(filiere);
        return etudiantRepo.save(etudiant);
    }

    // Delete an Etudiant
    public void deleteEtudiant(Long id) {
        Etudiant etudiant = getEtudiantById(id);
        etudiantRepo.delete(etudiant);
    }
}