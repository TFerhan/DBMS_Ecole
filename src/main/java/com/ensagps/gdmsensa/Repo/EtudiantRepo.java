package com.ensagps.gdmsensa.Repo;

import com.ensagps.gdmsensa.Model.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepo extends JpaRepository<Etudiant, Long> {
}