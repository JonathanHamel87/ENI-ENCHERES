package fr.eni.encheres.dal;

import fr.eni.encheres.bo.Retrait;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RetraitDAO extends JpaRepository<Retrait, Integer> {

    @Query("SELECT r FROM Retrait r " +
            "INNER JOIN r.noArticle a " +
            "WHERE a.noArticle = ?1")
    Retrait findByIdArticle(Integer id);
}
