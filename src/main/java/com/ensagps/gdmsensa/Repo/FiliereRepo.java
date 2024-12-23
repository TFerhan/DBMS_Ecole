package com.ensagps.gdmsensa.Repo;

import com.ensagps.gdmsensa.Model.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FiliereRepo extends JpaRepository<Filiere, Long> {
}