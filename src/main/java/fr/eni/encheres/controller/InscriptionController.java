package fr.eni.encheres.controller;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.UtilisateurDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("userActif")
@RequestMapping(value = "/inscription")
public class InscriptionController {
    @Autowired
    UtilisateurDAO utilisateurDAO;

    @PostMapping(value = "/")
    public String ajoutUtilisateur(HttpServletRequest request, HttpSession session){
        String pseudo = request.getParameter("pseudo");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        String rue = request.getParameter("rue");
        String codePostal = request.getParameter("codePostal");
        String ville = request.getParameter("ville");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");



        if (password.equals(password2) && !password.isEmpty()){
            Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, password, 0, false);

            utilisateurDAO.save(utilisateur);
            session.setAttribute("userActif", utilisateur);

        }

        return "redirect:/";
    }
}
