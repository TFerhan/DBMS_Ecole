package com.ensagps.gdmsensa.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "element_module")
public class ElementModule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double coefficient; // The coefficient of the element in the module

    @ManyToOne
    @JoinColumn(name = "element_id", nullable = false)
    private Element element; // The element this relationship refers to

    @ManyToOne
    @JoinColumn(name = "module_id", nullable = false)
    private Module module; // The module this element belongs to

    @ManyToOne
    @JoinColumn(name = "professeur_id")
    private Professeur professeur;

    // Default constructor
    public ElementModule() {
    }

    // Constructor to initialize the element, module, and coefficient
    public ElementModule(double coefficient, Element element, Module module) {
        this.coefficient = coefficient;
        this.element = element;
        this.module = module;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ElementModule that = (ElementModule) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "ElementModule{" +
                "id=" + id +
                ", coefficient=" + coefficient +
                ", element=" + element.getId() +
                ", module=" + module.getId() +
                '}';
    }
}
