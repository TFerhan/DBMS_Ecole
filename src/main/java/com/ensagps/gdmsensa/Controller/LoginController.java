package com.ensagps.gdmsensa.Controller;

import com.ensagps.gdmsensa.Model.CompteUtilisateur;
import com.ensagps.gdmsensa.Service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;


@Controller
public class LoginController {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/")
    public String showFirstPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("nomUtilisateur") String nomUtilisateur,
                        @RequestParam("motDePasse") String motDePasse,
                        Model model, HttpSession session) {
        CompteUtilisateur compteUtilisateur = utilisateurService.login(nomUtilisateur, motDePasse);
        if (compteUtilisateur != null) {
            session.setAttribute("user", compteUtilisateur);
            if (compteUtilisateur.getRole().equals("ADMIN")) {
                return "redirect:/admin";
            } else {
                return "redirect:/home";
            }
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }
}