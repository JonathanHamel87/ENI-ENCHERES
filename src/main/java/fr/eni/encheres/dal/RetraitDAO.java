package fr.eni.encheres.dal;

import fr.eni.encheres.bo.Retrait;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetraitDAO extends JpaRepository<Retrait, Integer> {

}
