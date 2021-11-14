package tn.esprit.spring.service;





import tn.esprit.spring.entity.Projet;

public interface IProjetService {
	public int ajouterProjet(Projet projet);

	public void deleteProjectById(int projId);
	
}
