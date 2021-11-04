package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Employe;
import tn.esprit.spring.entity.Entreprise;

public interface EntrepriseRepository extends CrudRepository<Entreprise, Integer>  {

	@Query("SELECT e FROM Entreprise e WHERE e.nameEntreprise=:nameEntreprise")
Entreprise findByNameEntreprsie(@Param("name")String nameEntreprise);
	
	@Query("SELECT count(e) FROM Entreprise e")
	int getNombreEntreprise();
	
}