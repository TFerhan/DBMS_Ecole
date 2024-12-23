package com.ensagps.gdmsensa.Model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class EvaluationMode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mode; // CC, TP, Projet

    @ManyToMany(mappedBy = "evaluationModes")
    private List<Element> elements;

    // Default constructor
    public EvaluationMode() {
    }

    // Constructor to initialize the mode
    public EvaluationMode(String mode) {
        this.mode = mode;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EvaluationMode that = (EvaluationMode) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "EvaluationMode{" +
                "id=" + id +
                ", mode='" + mode + '\'' +
                '}';
    }
}
