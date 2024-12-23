package com.ensagps.gdmsensa.Model;

import jakarta.persistence.*;

@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double valeur; // The grade of the student (0-20)

    private boolean isAbsent; // Indicates if the student was absent for the evaluation

    @ManyToOne
    @JoinColumn(name = "element_id", nullable = false)
    private Element element; // The element this note is related to

    @ManyToOne
    @JoinColumn(name = "etudiant_id", nullable = false)
    private Etudiant etudiant; // The student this note belongs to

    // Default constructor
    public Note() {
    }

    // Constructor to initialize the grade, absence, element, and student
    public Note(double valeur, boolean isAbsent, Element element, Etudiant etudiant) {
        this.valeur = valeur;
        this.isAbsent = isAbsent;
        this.element = element;
        this.etudiant = etudiant;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

    public boolean isAbsent() {
        return isAbsent;
    }

    public void setAbsent(boolean absent) {
        isAbsent = absent;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return id != null && id.equals(note.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", valeur=" + valeur +
                ", isAbsent=" + isAbsent +
                '}';
    }

    public void setValidated(boolean b) {
    }

    public void setDraft(boolean b) {
    }

    public boolean isDraft() {
        return true;
    }
}
