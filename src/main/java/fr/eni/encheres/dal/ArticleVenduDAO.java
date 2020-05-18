package fr.eni.encheres.dal;

import fr.eni.encheres.bo.ArticleVendu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleVenduDAO extends JpaRepository<ArticleVendu, Integer> {
    @Query("SELECT a FROM ArticleVendu a " +
            "INNER JOIN a.noCategorie c " +
            "WHERE c.libelle = ?1 AND a.nomArticle LIKE ?2%")
    List<ArticleVendu> findMultiCritere(String noCategorie, String nomArticle);

    @Query("SELECT a FROM ArticleVendu a WHERE a.nomArticle LIKE ?1%")
    List<ArticleVendu> findSearch(String nomArticle);
}
