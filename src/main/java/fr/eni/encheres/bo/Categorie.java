package fr.eni.encheres.bo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CATEGORIES")
public class Categorie implements Serializable {
    ////////////////////////////// ATTRIBUTES //////////////////////////////
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no_categorie")
    private Integer noCategorie;

    @Column(name = "libelle")
    private String libelle;

    ////////////////////////////// CONSTRUCTORS //////////////////////////////
    public Categorie(){}

    ////////////////////////////// GETTERS AND SETTERS //////////////////////////////
    public Integer getNoCategorie() {
        return noCategorie;
    }

    public void setNoCategorie(Integer noCategorie) {
        this.noCategorie = noCategorie;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }


    ////////////////////////////// OVERRIDE METHODS //////////////////////////////
    @Override
    public String toString() {
        return "Categorie{" +
                "noCategorie=" + noCategorie +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
