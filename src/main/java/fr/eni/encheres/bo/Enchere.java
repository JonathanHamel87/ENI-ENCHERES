package fr.eni.encheres.bo;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "ENCHERES")
public class Enchere implements Serializable {
    ////////////////////////////// ATTRIBUTES //////////////////////////////
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "no_utilisateur", foreignKey = @ForeignKey(name = "FK_encheres_utilisateurs"), referencedColumnName = "no_utilisateur", nullable = false)
    private Utilisateur noUtilisateur;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "no_article", foreignKey = @ForeignKey(name = "FK_encheres_articlesVendus"), referencedColumnName = "no_article", nullable = false)
    private ArticleVendu noArticle;

    @Column(name = "date_enchere", nullable = false)
    private Date dateEnchere;

    @Column(name = "montant_enchere", nullable = false)
    private Integer montantEnchere;

    ////////////////////////////// CONSTRUCTORS //////////////////////////////
    public Enchere(){}

    ////////////////////////////// GETTERS AND SETTERS //////////////////////////////
    public Utilisateur getNoUtilisateur() {
        return noUtilisateur;
    }

    public void setNoUtilisateur(Utilisateur noUtilisateur) {
        this.noUtilisateur = noUtilisateur;
    }

    public ArticleVendu getNoArticle() {
        return noArticle;
    }

    public void setNoArticle(ArticleVendu noArticle) {
        this.noArticle = noArticle;
    }

    public Date getDateEnchere() {
        return dateEnchere;
    }

    public void setDateEnchere(Date dateEnchere) {
        this.dateEnchere = dateEnchere;
    }

    public Integer getMontantEnchere() {
        return montantEnchere;
    }

    public void setMontantEnchere(Integer montantEnchere) {
        this.montantEnchere = montantEnchere;
    }


    ////////////////////////////// OVERRIDE METHODS //////////////////////////////
    @Override
    public String toString() {
        return "Enchere{" +
                "noUtilisateur=" + noUtilisateur +
                ", noArticle=" + noArticle +
                ", dateEnchere=" + dateEnchere +
                ", montantEnchere=" + montantEnchere +
                '}';
    }
}
