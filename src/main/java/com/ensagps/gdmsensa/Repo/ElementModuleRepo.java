package com.ensagps.gdmsensa.Repo;

import com.ensagps.gdmsensa.Model.ElementModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElementModuleRepo extends JpaRepository<ElementModule, Long> {
}