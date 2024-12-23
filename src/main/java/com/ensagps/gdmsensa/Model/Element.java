package com.ensagps.gdmsensa.Model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Element {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom; // Name of the element (e.g., "Examen Final", "Devoir 1")

    private double coefficient; // Coefficient of the element in the module

    @ManyToOne
    @JoinColumn(name = "module_id", nullable = false)
    private Module module; // The module this element belongs to

    //@ManyToMany
    //@JoinTable(
            //name = "element_module_mapping",
            //joinColumns = @JoinColumn(name = "element_id"),
            //inverseJoinColumns = @JoinColumn(name = "module_id"))
    //private List<Module> modules;

    @ManyToMany
    @JoinTable(
            name = "element_evaluation_mode",
            joinColumns = @JoinColumn(name = "element_id"),
            inverseJoinColumns = @JoinColumn(name = "evaluation_mode_id")
    )
    private List<EvaluationMode> evaluationModes; // Evaluation modes (e.g., CC, TP, Projet)

    @OneToMany(mappedBy = "element", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Note> notes; // List of notes for the element, associated with students

    // Default constructor
    public Element() {
    }

    // Constructor to initialize all fields
    public Element(String nom, double coefficient, Module module, List<EvaluationMode> evaluationModes) {
        this.nom = nom;
        this.coefficient = coefficient;
        this.module = module;
        this.evaluationModes = evaluationModes;
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

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public List<EvaluationMode> getEvaluationModes() {
        return evaluationModes;
    }

    public void setEvaluationModes(List<EvaluationMode> evaluationModes) {
        this.evaluationModes = evaluationModes;
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
        Element element = (Element) o;
        return id != null && id.equals(element.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Element{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", coefficient=" + coefficient +
                '}';
    }
}
