package com.ensagps.gdmsensa.Model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Professeur")
public class Professeur extends Utilisateur {
    private String specialite;

    public Professeur(Long code, String nom, String prenom, CompteUtilisateur compteUtilisateur, String specialite) {
        super(code, nom, prenom, compteUtilisateur);
        this.specialite = specialite;
    }

    public Professeur() {
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
}