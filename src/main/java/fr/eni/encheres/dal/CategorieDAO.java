package fr.eni.encheres.dal;

import fr.eni.encheres.bo.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategorieDAO extends JpaRepository<Categorie, Integer> {
}
