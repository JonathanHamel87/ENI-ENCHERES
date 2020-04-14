package fr.eni.encheres.bo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "RETRAITS")
public class Retrait implements Serializable {
    ////////////////////////////// ATTRIBUTES //////////////////////////////
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "no_article", foreignKey = @ForeignKey(name = "FK_retraits_articlesVendus"), referencedColumnName = "no_article", nullable = false)
    private ArticleVendu noArticle;

    @Column(name = "rue", nullable = false)
    private String rue;

    @Column(name = "code_postal", nullable = false)
    private String codePostal;

    @Column(name = "ville", nullable = false)
    private String ville;

    ////////////////////////////// CONSTRUCTORS //////////////////////////////
    public Retrait(){}

    ////////////////////////////// GETTERS AND SETTERS //////////////////////////////
    public ArticleVendu getNoArticle() {
        return noArticle;
    }

    public void setNoArticle(ArticleVendu noArticle) {
        this.noArticle = noArticle;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    ////////////////////////////// OVERRIDE METHODS //////////////////////////////
    @Override
    public String toString() {
        return "Retrait{" +
                "noArticle=" + noArticle +
                ", rue='" + rue + '\'' +
                ", codePostal='" + codePostal + '\'' +
                ", ville='" + ville + '\'' +
                '}';
    }
}
