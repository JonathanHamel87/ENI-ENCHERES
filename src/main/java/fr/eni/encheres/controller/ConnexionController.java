package fr.eni.encheres.controller;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.UtilisateurDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/connexion")
public class ConnexionController {
    @Autowired
    UtilisateurDAO utilisateurDAO;

    @GetMapping(value = "/")
    public String connexionUtilisateur(HttpServletRequest request, HttpSession session, Model model){
        String pseudo = request.getParameter("identifiant");
        String password = request.getParameter("password");
        String message = "Identifiant ou mot de passe incorrect !";
        Boolean bUtilisateurExist = false;

        List<Utilisateur> utilisateurs = utilisateurDAO.findAll();

        for (Utilisateur utilisateur : utilisateurs){
            if ((utilisateur.getPseudo().equals(pseudo) || utilisateur.getEmail().equals(pseudo)) && utilisateur.getMotDePasse().equals(password)){
                session.setAttribute("userActif", utilisateur);
                bUtilisateurExist = true;
            }
        }
        if (!bUtilisateurExist){
            session.setAttribute("messageError", message);
            return "redirect:/connexion";
        }else{
            return "redirect:/";
        }
    }
}
