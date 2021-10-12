package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Employe;
import tn.esprit.spring.entity.Entreprise;

@Repository
public interface IEmployeRepository  extends CrudRepository<Employe,Long>{
	
	@Query("SELECT e.nomEmploye FROM Employe e")
	List<String> getAllEmployeNamesJPQL();

	@Query("SELECT count(e) FROM Employe e")
	Long getNombreEmployeJPQL();

	@Query("Select "
			+ "DISTINCT e from Employe e "
			+ "join e.Departement dep "
			+ "join dep.Entreprise entrep "
			+ "where entrep=:entreprise")
    public List<Employe> getAllEmployeByEntreprisec(@Param("entreprise") Entreprise entreprise);
	

	@Query("SELECT e FROM Employe e WHERE e.emailEmploye=:email and e.password=:password")
	public Employe getEmployeByEmailAndPassword(
	@Param("email")String login,
	@Param("password")String password);
}
