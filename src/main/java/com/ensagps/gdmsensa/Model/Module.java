package com.ensagps.gdmsensa.Model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("Module")
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String nom;

    @ManyToOne
    @JoinColumn(name = "filiere_id", nullable = false)
    private Filiere filiere; // The filiere this module belongs to

    private Integer semestre; // Semestre of the module (e.g., S1 to S5)

    @OneToMany(mappedBy = "module", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ElementModule> elements; // List of elements for this module

    @ManyToMany
    @JoinTable(
            name = "professeur_module",
            joinColumns = @JoinColumn(name = "module_id"),
            inverseJoinColumns = @JoinColumn(name = "professeur_id")
    )
    private List<Professeur> professeurs; // Professors associated with this module

    // Default constructor
    public Module() {
    }

    // Constructor to initialize all fields
    public Module(String code, String nom, Filiere filiere, Integer semestre, List<ElementModule> elements, List<Professeur> professeurs) {
        this.code = code;
        this.nom = nom;
        this.filiere = filiere;
        this.semestre = semestre;
        this.elements = elements;
        this.professeurs = professeurs;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public List<ElementModule> getElements() {
        return elements;
    }

    public void setElements(List<ElementModule> elements) {
        this.elements = elements;
    }

    public List<Professeur> getProfesseurs() {
        return professeurs;
    }

    public void setProfesseurs(List<Professeur> professeurs) {
        this.professeurs = professeurs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Module module = (Module) o;
        return id != null && id.equals(module.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Module{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", nom='" + nom + '\'' +
                ", filiere=" + filiere +
                ", semestre=" + semestre +
                '}';
    }
}
