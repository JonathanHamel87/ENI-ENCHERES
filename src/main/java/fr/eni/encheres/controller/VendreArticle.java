package fr.eni.encheres.controller;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.ArticleVenduDAO;
import fr.eni.encheres.dal.CategorieDAO;
import fr.eni.encheres.dal.RetraitDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Date;


@Controller
@RequestMapping(value = "/vendreArticle")
public class VendreArticle {
    @Autowired
    ArticleVenduDAO articleVenduDAO;
    @Autowired
    CategorieDAO categorieDAO;
    @Autowired
    RetraitDAO retraitDAO;

    @PostMapping(value = "/")
    public String vendreArticle(HttpSession session,
                                @RequestParam String nomCategorie,
                                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateDebutEnchere,
                                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateFinEnchere,
                                @RequestParam String nomArticle,
                                @RequestParam String description,
                                @RequestParam Integer prixInitial,
                                @RequestParam String rue,
                                @RequestParam String codePostal,
                                @RequestParam String ville) {
        ArticleVendu article = new ArticleVendu();
        Retrait retrait = new Retrait();

        Utilisateur auteur = (Utilisateur) session.getAttribute("userActif");
        Categorie categorie = categorieDAO.findByName(nomCategorie);


        /* Initialisation des différents attributs utilisateur */
        article.setNomArticle(nomArticle);
        article.setDescription(description);
        article.setNoCategorie(categorie);
        article.setNoUtilisateur(auteur);
        article.setDateDebutEncheres(dateDebutEnchere);
        article.setDateFinEncheres(dateFinEnchere);
        article.setPrixInitial(prixInitial);

        /* Initialisation des différents attributs retrait */
        retrait.setNoArticle(article);
        retrait.setRue(rue);
        retrait.setCodePostal(codePostal);
        retrait.setVille(ville);


        /* Création de la vente */
        articleVenduDAO.save(article);
        retraitDAO.save(retrait);


        return "redirect:/";
    }
}
