package com.ensagps.gdmsensa.Service;

import com.ensagps.gdmsensa.Model.Element;
import com.ensagps.gdmsensa.Model.Module;
import com.ensagps.gdmsensa.Model.EvaluationMode;
import com.ensagps.gdmsensa.Repo.ElementRepo;
import com.ensagps.gdmsensa.Repo.ModuleRepo;
import com.ensagps.gdmsensa.Repo.EvaluationModeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ElementService {

    @Autowired
    private ElementRepo elementRepo;

    @Autowired
    private ModuleRepo moduleRepo;

    @Autowired
    private EvaluationModeRepo evaluationModeRepo;

    // Create a new Element
    public Element createElement(String nom, double coefficient, Long moduleId, List<Long> evaluationModeIds) {
        Optional<Module> moduleOpt = moduleRepo.findById(moduleId);
        if (!moduleOpt.isPresent()) {
            throw new IllegalArgumentException("Module not found");
        }
        Module module = moduleOpt.get();

        List<EvaluationMode> evaluationModes = evaluationModeRepo.findAllById(evaluationModeIds);
        if (evaluationModes.isEmpty()) {
            throw new IllegalArgumentException("Evaluation modes not found");
        }

        Element element = new Element(nom, coefficient, module, evaluationModes);
        return elementRepo.save(element);
    }

    // Get an Element by ID
    public Element getElementById(Long id) {
        return elementRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Element not found"));
    }

    // Get all Elements
    public List<Element> getAllElements() {
        return elementRepo.findAll();
    }

    // Update an Element
    public Element updateElement(Long id, String nom, double coefficient, Long moduleId, List<Long> evaluationModeIds) {
        Element element = getElementById(id);

        Optional<Module> moduleOpt = moduleRepo.findById(moduleId);
        if (!moduleOpt.isPresent()) {
            throw new IllegalArgumentException("Module not found");
        }
        Module module = moduleOpt.get();

        List<EvaluationMode> evaluationModes = evaluationModeRepo.findAllById(evaluationModeIds);
        if (evaluationModes.isEmpty()) {
            throw new IllegalArgumentException("Evaluation modes not found");
        }

        element.setNom(nom);
        element.setCoefficient(coefficient);
        element.setModule(module);
        element.setEvaluationModes(evaluationModes);

        return elementRepo.save(element);
    }

    // Delete an Element
    public void deleteElement(Long id) {
        Element element = getElementById(id);
        elementRepo.delete(element);
    }
}