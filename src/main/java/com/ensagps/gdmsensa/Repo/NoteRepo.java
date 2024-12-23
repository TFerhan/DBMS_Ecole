package com.ensagps.gdmsensa.Repo;

import com.ensagps.gdmsensa.Model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepo extends JpaRepository<Note, Long> {
    List<Note> findByElementId(Long elementModuleId);
}