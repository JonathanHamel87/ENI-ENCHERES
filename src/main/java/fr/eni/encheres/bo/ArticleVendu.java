package fr.eni.encheres.bo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Embeddable
@Table(name = "ARTICLES_VENDUS")
public class ArticleVendu implements Serializable {
    ////////////////////////////// ATTRIBUTES //////////////////////////////
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no_article", nullable = false)
    private Integer noArticle;

    @Column(name = "nom_article", nullable = false)
    private String nomArticle;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "date_debut_encheres", nullable = false)
    private Date dateDebutEncheres;

    @Column(name = "date_fin_encheres", nullable = false)
    private Date dateFinEncheres;

    @Column(name = "prix_initial")
    private Integer prixInitial;

    @Column(name = "prix_vente")
    private Integer prixVente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "no_utilisateur", foreignKey = @ForeignKey(name = "FK_articlesVendus_utilisateurs"), referencedColumnName = "no_utilisateur", nullable = false)
    private Utilisateur noUtilisateur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "no_categorie", foreignKey = @ForeignKey(name = "FK_articlesVendus_categories"), referencedColumnName = "no_categorie", nullable = false)
    private Categorie noCategorie;

    ////////////////////////////// CONSTRUCTORS //////////////////////////////
    public ArticleVendu(){}

    ////////////////////////////// GETTERS AND SETTERS //////////////////////////////
    public Integer getNoArticle() {
        return noArticle;
    }

    public void setNoArticle(Integer noArticle) {
        this.noArticle = noArticle;
    }

    public String getNomArticle() {
        return nomArticle;
    }

    public void setNomArticle(String nomArticle) {
        this.nomArticle = nomArticle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateDebutEncheres() {
        return dateDebutEncheres;
    }

    public void setDateDebutEncheres(Date dateDebutEncheres) {
        this.dateDebutEncheres = dateDebutEncheres;
    }

    public Date getDateFinEncheres() {
        return dateFinEncheres;
    }

    public void setDateFinEncheres(Date dateFinEncheres) {
        this.dateFinEncheres = dateFinEncheres;
    }

    public Integer getPrixInitial() {
        return prixInitial;
    }

    public void setPrixInitial(Integer prixInitial) {
        this.prixInitial = prixInitial;
    }

    public Integer getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(Integer prixVente) {
        this.prixVente = prixVente;
    }

    public Utilisateur getNoUtilisateur() {
        return noUtilisateur;
    }

    public void setNoUtilisateur(Utilisateur noUtilisateur) {
        this.noUtilisateur = noUtilisateur;
    }

    public Categorie getNoCategorie() {
        return noCategorie;
    }

    public void setNoCategorie(Categorie noCategorie) {
        this.noCategorie = noCategorie;
    }

    ////////////////////////////// OVERRIDE METHODS //////////////////////////////
    @Override
    public String toString() {
        return "ArticleVendu{" +
                "noArticle=" + noArticle +
                ", nomArticle='" + nomArticle + '\'' +
                ", description='" + description + '\'' +
                ", dateDebutEncheres=" + dateDebutEncheres +
                ", dateFinEncheres=" + dateFinEncheres +
                ", prixInitial=" + prixInitial +
                ", prixVente=" + prixVente +
                ", noUtilisateur=" + noUtilisateur +
                ", noCategorie=" + noCategorie +
                '}'+'\n';
    }
}
