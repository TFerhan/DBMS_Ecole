package com.ensagps.gdmsensa.Service;

import com.ensagps.gdmsensa.Model.EvaluationMode;
import com.ensagps.gdmsensa.Repo.EvaluationModeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluationModeService {

    @Autowired
    private EvaluationModeRepo evaluationModeRepo;

    // Create a new EvaluationMode
    public EvaluationMode createEvaluationMode(String mode) {
        EvaluationMode evaluationMode = new EvaluationMode(mode);
        return evaluationModeRepo.save(evaluationMode);
    }

    // Get an EvaluationMode by ID
    public EvaluationMode getEvaluationModeById(Long id) {
        return evaluationModeRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("EvaluationMode not found"));
    }

    // Get all EvaluationModes
    public List<EvaluationMode> getAllEvaluationModes() {
        return evaluationModeRepo.findAll();
    }

    // Update an EvaluationMode
    public EvaluationMode updateEvaluationMode(Long id, String mode) {
        EvaluationMode evaluationMode = getEvaluationModeById(id);
        evaluationMode.setMode(mode);
        return evaluationModeRepo.save(evaluationMode);
    }

    // Delete an EvaluationMode
    public void deleteEvaluationMode(Long id) {
        EvaluationMode evaluationMode = getEvaluationModeById(id);
        evaluationModeRepo.delete(evaluationMode);
    }
}