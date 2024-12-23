package com.ensagps.gdmsensa.Service;

import com.ensagps.gdmsensa.Model.ElementModule;
import com.ensagps.gdmsensa.Model.Element;
import com.ensagps.gdmsensa.Model.Module;
import com.ensagps.gdmsensa.Repo.ElementModuleRepo;
import com.ensagps.gdmsensa.Repo.ElementRepo;
import com.ensagps.gdmsensa.Repo.ModuleRepo;
import com.ensagps.gdmsensa.Repo.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ElementModuleService {

    @Autowired
    private ElementModuleRepo elementModuleRepo;

    @Autowired
    private ElementRepo elementRepo;

    @Autowired
    private NoteRepo noteRepo;

    @Autowired
    private ModuleRepo moduleRepo;

    // Create a new ElementModule
    public ElementModule createElementModule(double coefficient, Long elementId, Long moduleId) {
        Optional<Element> elementOpt = elementRepo.findById(elementId);
        if (!elementOpt.isPresent()) {
            throw new IllegalArgumentException("Element not found");
        }
        Element element = elementOpt.get();

        Optional<Module> moduleOpt = moduleRepo.findById(moduleId);
        if (!moduleOpt.isPresent()) {
            throw new IllegalArgumentException("Module not found");
        }
        Module module = moduleOpt.get();

        ElementModule elementModule = new ElementModule(coefficient, element, module);
        return elementModuleRepo.save(elementModule);
    }

    // Get an ElementModule by ID
    public ElementModule getElementModuleById(Long id) {
        return elementModuleRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("ElementModule not found"));
    }

    // Get all ElementModules
    public List<ElementModule> getAllElementModules() {
        return elementModuleRepo.findAll();
    }

    // Update an ElementModule
    public ElementModule updateElementModule(Long id, double coefficient, Long elementId, Long moduleId) {
        ElementModule elementModule = getElementModuleById(id);

        Optional<Element> elementOpt = elementRepo.findById(elementId);
        if (!elementOpt.isPresent()) {
            throw new IllegalArgumentException("Element not found");
        }
        Element element = elementOpt.get();

        Optional<Module> moduleOpt = moduleRepo.findById(moduleId);
        if (!moduleOpt.isPresent()) {
            throw new IllegalArgumentException("Module not found");
        }
        Module module = moduleOpt.get();

        elementModule.setCoefficient(coefficient);
        elementModule.setElement(element);
        elementModule.setModule(module);

        return elementModuleRepo.save(elementModule);
    }

    // Delete an ElementModule
    public void deleteElementModule(Long id) {
        ElementModule elementModule = getElementModuleById(id);
        elementModuleRepo.delete(elementModule);
    }
}