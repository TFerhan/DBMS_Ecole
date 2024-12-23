package com.ensagps.gdmsensa.Controller;

import com.ensagps.gdmsensa.Model.Element;
import com.ensagps.gdmsensa.Model.Filiere;
import com.ensagps.gdmsensa.Model.Module;
import com.ensagps.gdmsensa.Model.Professeur;
import com.ensagps.gdmsensa.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    ProfesseurService professeurService;

    @Autowired
    FiliereService filiereService;

    @Autowired
    ModuleService moduleService;

    @Autowired
    ElementService elementService;

    @Autowired
    EvaluationModeService evaluationModeService;

    @GetMapping("/admin")
    public String showAdminPanel() {
        return "admin";
    }

    @GetMapping("/admin/professors")
    public String listProfessors(Model model) {
        List<Professeur> professors = professeurService.getAllProfesseurs();
        model.addAttribute("professors", professors);
        return "professorList";
    }



    @GetMapping("/admin/filieres")
    public String manageFilieres(Model model) {
        // Add logic to fetch and display filieres
        List<Filiere> filieres = filiereService.getAllFilieres();
        model.addAttribute("filieres", filieres);
        return "manageFilieres";
    }

    @PostMapping("/admin/filiere/add")
    public void addFiliere(Filiere filiere) {
        filiereService.createFiliere(filiere.getNom(), filiere.getCode());
    }

    @GetMapping("/admin/modules")
    public String listModules(Model model) {
        List<Module> modules = moduleService.getAllModules();
        model.addAttribute("modules", modules);
        return "moduleList";
    }

    @GetMapping("/admin/modules/add")
    public String showAddModuleForm(Model model) {
        // Add necessary attributes to the model for the form
        return "addModule";
    }

    @PostMapping("/admin/modules/add")
    public String addModule(@RequestParam String code, @RequestParam String nom, @RequestParam Long filiereId, @RequestParam Integer semestre) {
        moduleService.createModule(nom, code, filiereId, semestre);
        return "redirect:/admin/modules";
    }





    @GetMapping("/admin/elements")
    public String manageElements(Model model) {
        // Add logic to fetch and display elements
        List<Element> elements = elementService.getAllElements();
        model.addAttribute("elements", elements);
        return "manageElements";
    }

    @GetMapping("/admin/elements/add")
    public String showAddElementForm(Model model) {
        model.addAttribute("evaluationModes", evaluationModeService.getAllEvaluationModes());
        return "addElement";
    }

    @PostMapping("/admin/elements/add")
    public String addElement(@RequestParam String nom, @RequestParam double coefficient, @RequestParam Long moduleId, @RequestParam List<Long> evaluationModeIds) {
        elementService.createElement(nom, coefficient, moduleId, evaluationModeIds);
        return "redirect:/admin/elements";
    }

    @GetMapping("/admin/evaluation-modes")
    public String manageEvaluationModes(Model model) {
        // Add logic to fetch and display evaluation modes
        return "manageEvaluationModes";
    }

    @GetMapping("/admin/evaluation-modes/add")
    public String showAddEvaluationModeForm(Model model) {
        // Add necessary attributes to the model for the form
        return "addEvaluationMode";
    }

    @PostMapping("/admin/evaluation-modes/add")
    public String addEvaluationMode(@RequestParam String mode) {
        evaluationModeService.createEvaluationMode(mode);

        // Add logic to create a new evaluation mode
        return "redirect:/admin/evaluation-modes";
    }

    @GetMapping("/admin/user-accounts")
    public String manageUserAccounts(Model model) {
        // Add logic to fetch and display user accounts
        return "manageUserAccounts";
    }
}