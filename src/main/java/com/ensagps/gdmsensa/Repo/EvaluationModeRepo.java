package com.ensagps.gdmsensa.Repo;

import com.ensagps.gdmsensa.Model.EvaluationMode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluationModeRepo extends JpaRepository<EvaluationMode, Long> {
}