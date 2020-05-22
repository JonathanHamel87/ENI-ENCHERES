package fr.eni.encheres.controller;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Controller
@SessionAttributes("userActif")
public class MainController {
    @Autowired
    CategorieDAO categorieDAO;
    @Autowired
    UtilisateurDAO utilisateurDAO;
    @Autowired
    ArticleVenduDAO articleVenduDAO;
    @Autowired
    RetraitDAO retraitDAO;
    @Autowired
    EnchereDAO enchereDAO;

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

    @GetMapping(value = "/consultationProfil")
    public String consultationProfil(HttpSession session, Model model, @RequestParam Integer noUtilisateur){
        session.setAttribute("title", "profil");
        Utilisateur utilisateur = utilisateurDAO.findById(noUtilisateur).get();
        model.addAttribute("user", utilisateur);
        return "consultationProfil";
    }

    @GetMapping(value = "/vendreArticle")
    public String vendreArticle(HttpSession session, Model model){
        model.addAttribute("categories", categorieDAO.findAll());
        Utilisateur user = (Utilisateur) session.getAttribute("userActif");
        model.addAttribute("user", user);
        return "vendreArticle";
    }

    @GetMapping(value = "/search")
    public String searchResult(Model model, HttpSession session){
        model.addAttribute("articles", articleVenduDAO.findAll());
        return "search/listeEnchere";
    }

    @GetMapping(value = "/searchFiltre")
    public String searchResultFiltre(Model model, HttpSession session,
                                     @RequestParam String categorie,
                                     @RequestParam String nomArticle,
                                     @RequestParam Boolean bEncheres,
                                     @RequestParam Boolean bVentes,
                                     @RequestParam Boolean bVenteEnCours,
                                     @RequestParam Boolean bVenteNonDebutee,
                                     @RequestParam Boolean bVenteTerminee,
                                     @RequestParam Boolean bEnchereOuverte,
                                     @RequestParam Boolean bEnchereEnCours,
                                     @RequestParam Boolean bEnchereRemportee){
        /* Utilisateur non connecté */
        Utilisateur userActif = (Utilisateur) session.getAttribute("userActif");
        if (userActif == null){
            if (categorie.equals("Toutes")){
                model.addAttribute("articles", articleVenduDAO.findSearch(nomArticle));
            }else{
                model.addAttribute("articles", articleVenduDAO.findMultiCritere(categorie, nomArticle));
            }
        }else{
            // Encheres
            if (bEncheres){
                // En cours
                if (bEnchereEnCours){
                    if (categorie.equals("Toutes")){
                        model.addAttribute("articles", articleVenduDAO.findByEnchereEnCours(nomArticle, userActif.getNoUtilisateur()));
                    }
                }
                // Ouverte
                else if (bEnchereOuverte){

                }
                // Remportee
                else if (bEnchereRemportee){

                }
            }
            // Ventes
            else if (bVentes){
                Date now = new Date();
                // Vente en cours
                if (bVenteEnCours){
                    if (categorie.equals("Toutes")){
                        model.addAttribute("articles", articleVenduDAO.findByVenteEnCours(nomArticle, userActif.getNoUtilisateur()));
                    }else{
                        model.addAttribute("articles", articleVenduDAO.findByVenteEnCoursWithCategorie(nomArticle, userActif.getNoUtilisateur(), categorie));
                    }
                }
                // Vente non débutée
                else if (bVenteNonDebutee){
                    if (categorie.equals("Toutes")){
                        model.addAttribute("articles", articleVenduDAO.findByVenteNonDebutee(nomArticle, userActif.getNoUtilisateur(), now));
                    }else{
                        model.addAttribute("articles", articleVenduDAO.findByVenteNonDebuteeWithCategorie(nomArticle, userActif.getNoUtilisateur(), now, categorie));
                    }
                }
                // Vente Terminée
                else if (bVenteTerminee){
                    if (categorie.equals("Toutes")){
                        model.addAttribute("articles", articleVenduDAO.findByVenteTerminee(nomArticle, userActif.getNoUtilisateur(), now));
                    }else{
                        model.addAttribute("articles", articleVenduDAO.findByVenteTermineeWithCategorie(nomArticle, userActif.getNoUtilisateur(), now, categorie));
                    }
                }
            }
        }

        return "search/listeEnchere";
    }

    /* Affichage details article */
    @GetMapping(value = "/detailsArticle")
    public String afficherDetailsArticle(Model model, HttpSession session, @RequestParam Integer id){
        ArticleVendu article = articleVenduDAO.findById(id).get();
        Retrait retrait = retraitDAO.findByIdArticle(article.getNoArticle());
        Utilisateur vendeur = article.getNoUtilisateur();
        Enchere enchere = enchereDAO.findByNoArticle(id);
        Utilisateur acheteur = (Utilisateur) session.getAttribute("userActif");

        model.addAttribute("article", article);
        model.addAttribute("retrait", retrait);
        model.addAttribute("acheteur", acheteur);
        model.addAttribute("vendeur", vendeur);
        model.addAttribute("enchere",enchere);
        return "/detailsArticle";
    }

    /* Affichage panel user connecté */
    @GetMapping(value = "/panelUser")
    public String panelUser(Model model, HttpSession session){
        model.addAttribute("userActif", session.getAttribute("userActif"));
        return "search/enchereConnectee";
    }

    /* Ajout d'une enchere */
    @PostMapping(value = "/addEnchere")
    public String ajoutEnchere(Model model, HttpSession session, @RequestParam Integer acheteur, @RequestParam Integer article, @RequestParam Integer proposition){
        Utilisateur acquereur = utilisateurDAO.findById(acheteur).get();
        ArticleVendu articleEnVente = articleVenduDAO.findById(article).get();
        Enchere enchere = new Enchere();
        Calendar cal = GregorianCalendar.getInstance();
        Date now = new Date();
        List<Enchere> encheres = enchereDAO.findAll();
        Boolean exist = false;

        for (Enchere test : encheres){
            if (test.getNoArticle().getNoArticle() == article){
                exist = true;
            }
        }
        if (exist){
            enchere = enchereDAO.findByNoArticle(article);
        }

        enchere.setNoArticle(articleEnVente);
        enchere.setMontantEnchere(proposition);
        enchere.setNoUtilisateur(acquereur);
        enchere.setDateEnchere(now);

        enchereDAO.save(enchere);

        String vue = accueil(model, session);
        return vue;
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
