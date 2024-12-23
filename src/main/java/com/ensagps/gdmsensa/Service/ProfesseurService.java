package com.ensagps.gdmsensa.Service;

import com.ensagps.gdmsensa.Model.Note;
import com.ensagps.gdmsensa.Model.Professeur;
import com.ensagps.gdmsensa.Repo.ElementModuleRepo;
import com.ensagps.gdmsensa.Repo.NoteRepo;
import com.ensagps.gdmsensa.Repo.ProfesseurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesseurService {

    @Autowired
    private ProfesseurRepo professeurRepo;

    @Autowired
    private ElementModuleRepo elementModuleRepo;

    @Autowired
    private NoteRepo noteRepo;

    public List<Professeur> getAllProfesseurs() {
        return professeurRepo.findAll();
    }

    public Professeur getProfesseurById(String id) {
        return professeurRepo.findById(id).orElse(null);
    }

    public void saveProfesseur(Professeur professeur) {
        professeurRepo.save(professeur);
    }

    public void deleteProfesseur(String id) {
        professeurRepo.deleteById(id);
    }

    public void enterNotes(Long elementModuleId, List<Note> notes){
        notes.forEach(note -> {
            note.setElement(elementModuleRepo.findById(elementModuleId).orElseThrow(() -> new IllegalArgumentException("ElementModule not found")).getElement());
            noteRepo.save(note);

        });
    }

    public void modifyNotes(Long elementModuleId, List<Note> notes) {
        notes.forEach(note -> {
            Note existingNote = noteRepo.findById(note.getId()).orElseThrow(() -> new IllegalArgumentException("Note not found"));
            existingNote.setValeur(note.getValeur());
            existingNote.setAbsent(note.isAbsent());
            noteRepo.save(existingNote);
        });
    }

    public void deleteNotes(List<Long> noteIds) {
        noteIds.forEach(noteId -> {
            Note note = noteRepo.findById(noteId).orElseThrow(() -> new IllegalArgumentException("Note not found"));
            noteRepo.delete(note);
        });
    }

    public void validateNotes(Long elementModuleId) {
        List<Note> notes = noteRepo.findByElementId(elementModuleId);
        if (notes.stream().anyMatch(note -> note.getValeur() < 0 || note.getValeur() > 20)) {
            throw new IllegalArgumentException("All notes must be between 0 and 20");
        }
        if (notes.stream().anyMatch(note -> note.getValeur() == 0 || note.getValeur() == 20)) {
            // Confirm with the professor before validating
            // This can be implemented as a separate confirmation step in the application
        }
        notes.forEach(note -> {
            note.setValidated(true);
            noteRepo.save(note);
        });
    }

    public void saveDraftNotes(Long elementModuleId, List<Note> notes) {
        notes.forEach(note -> {
            note.setElement(elementModuleRepo.findById(elementModuleId).orElseThrow(() -> new IllegalArgumentException("ElementModule not found")).getElement());
            note.setDraft(true);
            noteRepo.save(note);
        });
    }

    public void cancelNoteEntry(Long elementModuleId) {
        List<Note> notes = noteRepo.findByElementId(elementModuleId);
        notes.forEach(note -> {
            if (note.isDraft()) {
                noteRepo.delete(note);
            }
        });
    }

    public double calculateElementAverage(Long elementModuleId) {
        List<Note> notes = noteRepo.findByElementId(elementModuleId);
        return notes.stream().mapToDouble(Note::getValeur).average().orElse(0.0);
    }
}
