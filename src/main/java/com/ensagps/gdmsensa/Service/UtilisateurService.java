package com.ensagps.gdmsensa.Service;

import com.ensagps.gdmsensa.Model.CompteUtilisateur;
import com.ensagps.gdmsensa.Repo.CompteUtilisateurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurService {

    @Autowired
    private CompteUtilisateurRepo compteUtilisateurRepo;

    public CompteUtilisateur login(String nomUtilisateur, String motDePasse) {
        CompteUtilisateur compteUtilisateur = compteUtilisateurRepo.findByNomUtilisateur(nomUtilisateur);
        if (compteUtilisateur != null && compteUtilisateur.getMotDePasse().equals(motDePasse)) {
            return compteUtilisateur;
        }
        return null;
    }
}