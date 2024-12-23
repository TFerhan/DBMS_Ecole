package com.ensagps.gdmsensa.Model;

import jakarta.persistence.*;
import java.util.List;
@Entity
@DiscriminatorValue("Etudiant")
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String cne; // Unique identifier (CNE) for the student
    private Integer semestre; // Semester (1 to 5)
    private String filiere; // Field of study

    @ManyToMany
    @JoinTable(
            name = "etudiant_module",
            joinColumns = @JoinColumn(name = "etudiant_id"),
            inverseJoinColumns = @JoinColumn(name = "module_id"))
    private List<Module> modules;

    @OneToMany(mappedBy = "etudiant")
    private List<Note> notes;

    // Default constructor
    public Etudiant() {
    }

    // Constructor to initialize all fields
    public Etudiant(String nom, String prenom, String cne, Integer semestre, String filiere) {
        this.nom = nom;
        this.prenom = prenom;
        this.cne = cne;
        this.semestre = semestre;
        this.filiere = filiere;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }
    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Etudiant etudiant = (Etudiant) o;
        return id != null && id.equals(etudiant.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", cne='" + cne + '\'' +
                ", semestre=" + semestre +
                ", filiere='" + filiere + '\'' +
                '}';
    }
}
