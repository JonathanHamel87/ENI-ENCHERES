package fr.eni.encheres.controller;

import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.dal.CategorieDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    CategorieDAO categorieDAO;

    @GetMapping(name = "/")
    public String accueil(Model model){
        model.addAttribute("categories", categorieDAO.findAll());
        return "home";
    }

}
