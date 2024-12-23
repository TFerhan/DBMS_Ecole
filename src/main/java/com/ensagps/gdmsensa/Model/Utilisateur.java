package com.ensagps.gdmsensa.Model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "type_utilisateur", discriminatorType = DiscriminatorType.STRING)
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    private String nom;
    private String prenom;
    @OneToOne(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private CompteUtilisateur compteUtilisateur;

    public Utilisateur(Long code, String nom, String prenom, CompteUtilisateur compteUtilisateur) {
        this.code = code;
        this.nom = nom;
        this.prenom = prenom;
        this.compteUtilisateur = compteUtilisateur;
    }

    public Utilisateur() {
    }



    public Long getCode() {
        return this.code;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public CompteUtilisateur getCompteUtilisateur() {
        return compteUtilisateur;
    }

    public void setCompteUtilisateur(CompteUtilisateur compteUtilisateur) {
        this.compteUtilisateur = compteUtilisateur;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utilisateur that = (Utilisateur) o;
        return code != null && code.equals(that.code);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    public String toString() {
        return "Utilisateur{" +
                "code=" + code +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
}
