package com.ensagps.gdmsensa.Model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Administrateur")
public class Administrateur extends Utilisateur {

    public Administrateur(Long code, String nom, String prenom, CompteUtilisateur compteUtilisateur) {
        super(code, nom, prenom, compteUtilisateur);
    }

    public Administrateur() {
    }
}