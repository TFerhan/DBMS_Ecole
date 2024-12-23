package com.ensagps.gdmsensa.Service;

import com.ensagps.gdmsensa.Model.Note;
import com.ensagps.gdmsensa.Model.Element;
import com.ensagps.gdmsensa.Model.Etudiant;
import com.ensagps.gdmsensa.Repo.NoteRepo;
import com.ensagps.gdmsensa.Repo.ElementRepo;
import com.ensagps.gdmsensa.Repo.EtudiantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    private NoteRepo noteRepo;

    @Autowired
    private ElementRepo elementRepo;

    @Autowired
    private EtudiantRepo etudiantRepo;

    // Create a new Note
    public Note createNote(double valeur, boolean isAbsent, Long elementId, Long etudiantId) {
        Optional<Element> elementOpt = elementRepo.findById(elementId);
        if (!elementOpt.isPresent()) {
            throw new IllegalArgumentException("Element not found");
        }
        Element element = elementOpt.get();

        Optional<Etudiant> etudiantOpt = etudiantRepo.findById(etudiantId);
        if (!etudiantOpt.isPresent()) {
            throw new IllegalArgumentException("Etudiant not found");
        }
        Etudiant etudiant = etudiantOpt.get();

        Note note = new Note(valeur, isAbsent, element, etudiant);
        return noteRepo.save(note);
    }

    // Get a Note by ID
    public Note getNoteById(Long id) {
        return noteRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Note not found"));
    }

    // Get all Notes
    public List<Note> getAllNotes() {
        return noteRepo.findAll();
    }

    // Update a Note
    public Note updateNote(Long id, double valeur, boolean isAbsent, Long elementId, Long etudiantId) {
        Note note = getNoteById(id);

        Optional<Element> elementOpt = elementRepo.findById(elementId);
        if (!elementOpt.isPresent()) {
            throw new IllegalArgumentException("Element not found");
        }
        Element element = elementOpt.get();

        Optional<Etudiant> etudiantOpt = etudiantRepo.findById(etudiantId);
        if (!etudiantOpt.isPresent()) {
            throw new IllegalArgumentException("Etudiant not found");
        }
        Etudiant etudiant = etudiantOpt.get();

        note.setValeur(valeur);
        note.setAbsent(isAbsent);
        note.setElement(element);
        note.setEtudiant(etudiant);

        return noteRepo.save(note);
    }

    // Delete a Note
    public void deleteNote(Long id) {
        Note note = getNoteById(id);
        noteRepo.delete(note);
    }
}