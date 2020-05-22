package fr.eni.encheres.dal;

import fr.eni.encheres.bo.Enchere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EnchereDAO extends JpaRepository<Enchere, Integer> {
    @Query("SELECT e FROM Enchere e " +
            "INNER JOIN e.noArticle a " +
            "WHERE a.noArticle = ?1")
    Enchere findByNoArticle(Integer id);
}
