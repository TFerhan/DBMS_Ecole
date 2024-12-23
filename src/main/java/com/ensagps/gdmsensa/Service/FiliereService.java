package com.ensagps.gdmsensa.Service;

import com.ensagps.gdmsensa.Model.Filiere;
import com.ensagps.gdmsensa.Repo.FiliereRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FiliereService {

    @Autowired
    private FiliereRepo filiereRepo;

    // Create a new Filiere
    public Filiere createFiliere(String nom, String code) {
        Filiere filiere = new Filiere(nom, code, null);
        return filiereRepo.save(filiere);
    }

    // Get a Filiere by ID
    public Filiere getFiliereById(Long id) {
        return filiereRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Filiere not found"));
    }

    // Get all Filieres
    public List<Filiere> getAllFilieres() {
        return filiereRepo.findAll();
    }

    // Update a Filiere
    public Filiere updateFiliere(Long id, String nom, String code) {
        Filiere filiere = getFiliereById(id);
        filiere.setNom(nom);
        filiere.setCode(code);
        return filiereRepo.save(filiere);
    }

    // Delete a Filiere
    public void deleteFiliere(Long id) {
        Filiere filiere = getFiliereById(id);
        filiereRepo.delete(filiere);
    }


}