package fr.eni.encheres.dal;

import fr.eni.encheres.bo.ArticleVendu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleVenduDAO extends JpaRepository<ArticleVendu, Integer> {
}
