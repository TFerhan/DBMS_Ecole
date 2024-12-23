package com.ensagps.gdmsensa.Service;

import com.ensagps.gdmsensa.Model.Module;
import com.ensagps.gdmsensa.Model.Filiere;
import com.ensagps.gdmsensa.Repo.ModuleRepo;
import com.ensagps.gdmsensa.Repo.FiliereRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModuleService {

    @Autowired
    private ModuleRepo moduleRepo;

    @Autowired
    private FiliereRepo filiereRepo;

    // Create a new Module
    public Module createModule(String code, String nom, Long filiereId, Integer semestre) {
        Optional<Filiere> filiereOpt = filiereRepo.findById(filiereId);
        if (!filiereOpt.isPresent()) {
            throw new IllegalArgumentException("Filiere not found");
        }
        Filiere filiere = filiereOpt.get();

        Module module = new Module(code, nom, filiere, semestre, null, null);
        return moduleRepo.save(module);
    }

    // Get a Module by ID
    public Module getModuleById(Long id) {
        return moduleRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Module not found"));
    }

    // Get all Modules
    public List<Module> getAllModules() {
        return moduleRepo.findAll();
    }

    // Update a Module
    public Module updateModule(Long id, String code, String nom, Long filiereId, Integer semestre) {
        Module module = getModuleById(id);

        Optional<Filiere> filiereOpt = filiereRepo.findById(filiereId);
        if (!filiereOpt.isPresent()) {
            throw new IllegalArgumentException("Filiere not found");
        }
        Filiere filiere = filiereOpt.get();

        module.setCode(code);
        module.setNom(nom);
        module.setFiliere(filiere);
        module.setSemestre(semestre);

        return moduleRepo.save(module);
    }

    // Delete a Module
    public void deleteModule(Long id) {
        Module module = getModuleById(id);
        moduleRepo.delete(module);
    }
}