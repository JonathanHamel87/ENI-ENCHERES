package fr.eni.encheres.dal;

import fr.eni.encheres.bo.ArticleVendu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Repository
public interface ArticleVenduDAO extends JpaRepository<ArticleVendu, Integer> {
    @Query("SELECT a FROM ArticleVendu a " +
            "INNER JOIN a.noCategorie c " +
            "WHERE c.libelle = ?1 AND a.nomArticle LIKE ?2%")
    List<ArticleVendu> findMultiCritere(String noCategorie, String nomArticle);

    @Query("SELECT a FROM ArticleVendu a WHERE a.nomArticle LIKE ?1%")
    List<ArticleVendu> findSearch(String nomArticle);

    @Query("SELECT a, e FROM ArticleVendu a " +
            "INNER JOIN a.noCategorie c " +
            "LEFT OUTER JOIN Enchere e ON e.noArticle = a.noArticle " +
            "WHERE a.nomArticle LIKE '?1%' AND e.noUtilisateur = ?2")
    List<ArticleVendu> findByEnchereEnCours(String nomArticle, Integer idUser);

    @Query("SELECT a FROM ArticleVendu a " +
            "INNER JOIN a.noUtilisateur u " +
            "WHERE a.nomArticle LIKE ?1% AND u.noUtilisateur = ?2")
    List<ArticleVendu> findByVenteEnCours(String nomArticle, Integer noUtilisateur);

    @Query("SELECT a FROM ArticleVendu a " +
            "INNER JOIN a.noCategorie c " +
            "INNER JOIN a.noUtilisateur u " +
            "WHERE a.nomArticle LIKE ?1% AND u.noUtilisateur = ?2 AND c.libelle = ?3")
    List<ArticleVendu> findByVenteEnCoursWithCategorie(String nomArticle, Integer noUtilisateur, String categorie);

    @Query("SELECT a FROM ArticleVendu a " +
            "INNER JOIN a.noUtilisateur u " +
            "WHERE a.nomArticle LIKE ?1% AND u.noUtilisateur = ?2 AND a.dateDebutEncheres > ?3")
    List<ArticleVendu> findByVenteNonDebutee(String nomArticle, Integer noUtilisateur, Date now);

    @Query("SELECT a FROM ArticleVendu a " +
            "INNER JOIN a.noUtilisateur u " +
            "INNER JOIN a.noCategorie c " +
            "WHERE a.nomArticle LIKE ?1% AND u.noUtilisateur = ?2 AND a.dateDebutEncheres > ?3 AND c.libelle = ?4")
    List<ArticleVendu> findByVenteNonDebuteeWithCategorie(String nomArticle, Integer noUtilisateur, Date now, String categorie);

    @Query("SELECT a FROM ArticleVendu a " +
            "INNER JOIN a.noUtilisateur u " +
            "WHERE a.nomArticle LIKE ?1% AND u.noUtilisateur = ?2 AND a.dateFinEncheres < ?3")
    List<ArticleVendu> findByVenteTerminee(String nomArticle, Integer noUtilisateur, Date now);

    @Query("SELECT a FROM ArticleVendu a " +
            "INNER JOIN a.noUtilisateur u " +
            "INNER JOIN a.noCategorie c " +
            "WHERE a.nomArticle LIKE ?1% AND u.noUtilisateur = ?2 AND a.dateFinEncheres < ?3 AND c.libelle = ?4")
    List<ArticleVendu> findByVenteTermineeWithCategorie(String nomArticle, Integer noUtilisateur, Date now, String categorie);
}
