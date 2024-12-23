package com.ensagps.gdmsensa.Repo;

import com.ensagps.gdmsensa.Model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UtilisateurRepo extends JpaRepository<Utilisateur, Long> {

}