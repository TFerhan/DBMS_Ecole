package com.ensagps.gdmsensa.Repo;

import com.ensagps.gdmsensa.Model.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesseurRepo extends JpaRepository<Professeur, String> {
}