package fr.eni.encheres.controller;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.UtilisateurDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/profil")
public class ProfilController {
    @Autowired
    UtilisateurDAO utilisateurDAO;

    @PostMapping(value = "/update")
    public String saveProfil(HttpSession session,
                             @RequestParam(value = "pseudo") String pseudo,
                             @RequestParam(value = "nom") String nom,
                             @RequestParam(value = "prenom") String prenom,
                             @RequestParam(value = "email") String email,
                             @RequestParam(value = "telephone") String telephone,
                             @RequestParam(value = "codePostal") String codePostal,
                             @RequestParam(value = "ville") String ville){
        String password;
        String newPassword;
        String newPassword2;
        System.out.println(pseudo);
        System.out.println(codePostal);

        Utilisateur utilisateur = (Utilisateur) session.getAttribute("userActif");

        utilisateur.setPseudo(pseudo);
        utilisateur.setNom(nom);
        utilisateur.setPrenom(prenom);
        utilisateur.setEmail(email);
        utilisateur.setTelephone(telephone);
        utilisateur.setCodePostal(codePostal);
        utilisateur.setVille(ville);

        utilisateurDAO.save(utilisateur);
        return "redirect:/profil";
    }

    @GetMapping(value = "/delete")
    public String deleteProfil(HttpSession session){
        utilisateurDAO.delete((Utilisateur) session.getAttribute("userActif"));
        session.setAttribute("userActif", null);
        return "home";
    }

    @GetMapping(value = "/")
    public String showProfil(Model model, HttpSession session){
        model.addAttribute("user", session.getAttribute("userActif"));
        return "/profil/ShowProfil";
    }

    @GetMapping(value = "/modification")
    public String modificationProfil(Model model, HttpSession session){
        model.addAttribute("user", session.getAttribute("userActif"));
        return "profil/UpdateProfil";
    }
}
