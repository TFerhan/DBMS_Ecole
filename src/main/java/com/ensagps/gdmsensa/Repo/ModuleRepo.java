package com.ensagps.gdmsensa.Repo;

import com.ensagps.gdmsensa.Model.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepo extends JpaRepository<Module, Long> {
}