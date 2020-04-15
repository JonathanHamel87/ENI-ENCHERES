package fr.eni.encheres.controller;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.CategorieDAO;
import fr.eni.encheres.dal.UtilisateurDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("userActif")
public class MainController {
    @Autowired
    CategorieDAO categorieDAO;
    @Autowired
    UtilisateurDAO utilisateurDAO;

    @GetMapping(value = "/")
    public String accueil(Model model, HttpSession session){
        model.addAttribute("categories", categorieDAO.findAll());
        session.setAttribute("title", "accueil");
        model.addAttribute("userActif", utilisateurDAO.findByPseudo(getLoggerInUserName()));
        return "home";
    }

    @GetMapping(value = "/accueil")
    public String reload(Model model, HttpSession session){
        return accueil(model, session);
    }

    @GetMapping(value = "/inscription")
    public String formulaireInscription(Model model, HttpSession session){
        session.setAttribute("title", "inscription");
        session.getAttribute("userActif");
        return "inscription";
    }

    @GetMapping(value = "/connexion")
    public String formulaireConnexion(Model model, HttpSession session){
        session.setAttribute("title", "connexion");
        session.setAttribute("messageError", "");
        return "connexion";
    }

    @GetMapping(value = "/deconnexion")
    public String deconnexion(HttpSession session, Model model){
        session.setAttribute("userActif", null);
        return accueil(model, session);
    }

    @GetMapping(value = "/profil")
    public String profil(HttpSession session, Model model){
        session.setAttribute("title", "profil");
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("userActif");
        model.addAttribute("user", utilisateur);
        return "profil";
    }



    /*======================================== FONCTIONS  ========================================*/
    private String getLoggerInUserName() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails){
            return ((UserDetails)principal).getUsername();
        }
        return principal.toString();
    }


}
