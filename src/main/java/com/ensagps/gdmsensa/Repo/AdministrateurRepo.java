package com.ensagps.gdmsensa.Repo;

import com.ensagps.gdmsensa.Model.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministrateurRepo extends JpaRepository<Administrateur, Long> {
}