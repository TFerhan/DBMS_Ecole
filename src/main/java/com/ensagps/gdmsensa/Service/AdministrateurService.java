package com.ensagps.gdmsensa.Service;

import com.ensagps.gdmsensa.Model.*;
import com.ensagps.gdmsensa.Repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ensagps.gdmsensa.Model.Module;
import java.util.List;

@Service
public class AdministrateurService {

    @Autowired
    private AdministrateurRepo administrateurRepo;

    @Autowired
    private ProfesseurRepo professeurRepo;

    @Autowired
    private FiliereRepo filiereRepo;

    @Autowired
    private ModuleRepo moduleRepo;

    @Autowired
    private ElementModuleRepo elementModuleRepo;

    @Autowired
    private EvaluationModeRepo evaluationModeRepo;

    @Autowired
    private UtilisateurRepo utilisateurRepo;

    @Autowired
    private ElementRepo elementRepo;

    // Create a new Administrateur
    public Administrateur createAdministrateur(Long code, String nom, String prenom, CompteUtilisateur compteUtilisateur) {
        Administrateur administrateur = new Administrateur(code, nom, prenom, compteUtilisateur);
        return administrateurRepo.save(administrateur);
    }

    // Get an Administrateur by ID
    public Administrateur getAdministrateurById(Long id) {
        return administrateurRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Administrateur not found"));
    }

    // Get all Administrateurs
    public List<Administrateur> getAllAdministrateurs() {
        return administrateurRepo.findAll();
    }

    // Update an Administrateur
    public Administrateur updateAdministrateur(Long id, Long code, String nom, String prenom, CompteUtilisateur compteUtilisateur) {
        Administrateur administrateur = getAdministrateurById(id);
        administrateur.setCode(code);
        administrateur.setNom(nom);
        administrateur.setPrenom(prenom);
        administrateur.setCompteUtilisateur(compteUtilisateur);
        return administrateurRepo.save(administrateur);
    }

    // Delete an Administrateur
    public void deleteAdministrateur(Long id) {
        Administrateur administrateur = getAdministrateurById(id);
        administrateurRepo.delete(administrateur);
    }

    // Manage Professeurs
    public Professeur createProfesseur(Long code, String nom, String prenom, CompteUtilisateur compteUtilisateur, String specialite) {
        Professeur professeur = new Professeur(code, nom, prenom, compteUtilisateur, specialite);
        return professeurRepo.save(professeur);
    }

    public List<Professeur> getAllProfesseurs() {
        return professeurRepo.findAll();
    }

    public Professeur updateProfesseur(Long id, Long code, String nom, String prenom, CompteUtilisateur compteUtilisateur, String specialite) {
        Professeur professeur = professeurRepo.findById(String.valueOf(id)).orElseThrow(() -> new IllegalArgumentException("Professeur not found"));
        professeur.setCode(code);
        professeur.setNom(nom);
        professeur.setPrenom(prenom);
        professeur.setCompteUtilisateur(compteUtilisateur);
        professeur.setSpecialite(specialite);
        return professeurRepo.save(professeur);
    }

    public void deleteProfesseur(Long id) {
        Professeur professeur = professeurRepo.findById(String.valueOf(id)).orElseThrow(() -> new IllegalArgumentException("Professeur not found"));
        professeurRepo.delete(professeur);
    }

    // Manage Filieres
    public Filiere createFiliere(String nom, String code) {
        Filiere filiere = new Filiere(nom, code, null);
        return filiereRepo.save(filiere);
    }

    public List<Filiere> getAllFilieres() {
        return filiereRepo.findAll();
    }

    public Filiere updateFiliere(Long id, String nom, String code) {
        Filiere filiere = filiereRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Filiere not found"));
        filiere.setNom(nom);
        filiere.setCode(code);
        return filiereRepo.save(filiere);
    }

    public void deleteFiliere(Long id) {
        Filiere filiere = filiereRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Filiere not found"));
        filiereRepo.delete(filiere);
    }

    // Manage Modules and Elements
    public Module createModule(String code, String nom, Long filiereId, Integer semestre) {
        Filiere filiere = filiereRepo.findById(filiereId).orElseThrow(() -> new IllegalArgumentException("Filiere not found"));
        Module module = new Module(code, nom, filiere, semestre, null, null);
        return moduleRepo.save(module);
    }

    public List<Module> getAllModules() {
        return moduleRepo.findAll();
    }

    public Module updateModule(Long id, String code, String nom, Long filiereId, Integer semestre) {
        Module module = moduleRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Module not found"));
        Filiere filiere = filiereRepo.findById(filiereId).orElseThrow(() -> new IllegalArgumentException("Filiere not found"));
        module.setCode(code);
        module.setNom(nom);
        module.setFiliere(filiere);
        module.setSemestre(semestre);
        return moduleRepo.save(module);
    }

    public void deleteModule(Long id) {
        Module module = moduleRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Module not found"));
        moduleRepo.delete(module);
    }

    public ElementModule createElementModule(double coefficient, Long elementId, Long moduleId) {
        Element element = elementRepo.findById(elementId).orElseThrow(() -> new IllegalArgumentException("Element not found"));
        Module module = moduleRepo.findById(moduleId).orElseThrow(() -> new IllegalArgumentException("Module not found"));
        ElementModule elementModule = new ElementModule(coefficient, element, module);
        return elementModuleRepo.save(elementModule);
    }

    public List<ElementModule> getAllElementModules() {
        return elementModuleRepo.findAll();
    }

    public ElementModule updateElementModule(Long id, double coefficient, Long elementId, Long moduleId) {
        ElementModule elementModule = elementModuleRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("ElementModule not found"));
        Element element = elementRepo.findById(elementId).orElseThrow(() -> new IllegalArgumentException("Element not found"));
        Module module = moduleRepo.findById(moduleId).orElseThrow(() -> new IllegalArgumentException("Module not found"));
        elementModule.setCoefficient(coefficient);
        elementModule.setElement(element);
        elementModule.setModule(module);
        return elementModuleRepo.save(elementModule);
    }

    public void deleteElementModule(Long id) {
        ElementModule elementModule = elementModuleRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("ElementModule not found"));
        elementModuleRepo.delete(elementModule);
    }

    // Manage Evaluation Modes
    public EvaluationMode createEvaluationMode(String mode) {
        EvaluationMode evaluationMode = new EvaluationMode(mode);
        return evaluationModeRepo.save(evaluationMode);
    }

    public List<EvaluationMode> getAllEvaluationModes() {
        return evaluationModeRepo.findAll();
    }

    public EvaluationMode updateEvaluationMode(Long id, String mode) {
        EvaluationMode evaluationMode = evaluationModeRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("EvaluationMode not found"));
        evaluationMode.setMode(mode);
        return evaluationModeRepo.save(evaluationMode);
    }

    public void deleteEvaluationMode(Long id) {
        EvaluationMode evaluationMode = evaluationModeRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("EvaluationMode not found"));
        evaluationModeRepo.delete(evaluationMode);
    }

    // Assign Elements to Professors
    public void assignElementToProfesseur(Long elementModuleId, Long professeurId) {
        ElementModule elementModule = elementModuleRepo.findById(elementModuleId).orElseThrow(() -> new IllegalArgumentException("ElementModule not found"));
        Professeur professeur = professeurRepo.findById(String.valueOf(professeurId)).orElseThrow(() -> new IllegalArgumentException("Professeur not found"));
        elementModule.setProfesseur(professeur);
        elementModuleRepo.save(elementModule);
    }

    // Manage User Accounts
    public Utilisateur createUtilisateur(Long code, String nom, String prenom, String motDePasse, CompteUtilisateur compteUtilisateur) {
        Utilisateur utilisateur = new Utilisateur(code, nom, prenom, compteUtilisateur);
        return utilisateurRepo.save(utilisateur);
    }

    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepo.findAll();
    }

    public Utilisateur updateUtilisateur(Long id, Long code, String nom, String prenom, CompteUtilisateur compteUtilisateur) {
        Utilisateur utilisateur = utilisateurRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Utilisateur not found"));
        utilisateur.setCode(code);
        utilisateur.setNom(nom);
        utilisateur.setPrenom(prenom);
        utilisateur.setCompteUtilisateur(compteUtilisateur);
        return utilisateurRepo.save(utilisateur);
    }

    public void deleteUtilisateur(Long id) {
        Utilisateur utilisateur = utilisateurRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Utilisateur not found"));
        utilisateurRepo.delete(utilisateur);
    }
}