package tn.esprit.spring.service;

import tn.esprit.spring.entity.Entreprise;

public interface IEntrepriseService {
	
	public int ajouterEntreprise(Entreprise entreprise);
	public void deleteEntrepriseById(int entrepriseId);
	public Entreprise getEntrepriseById(int entrepriseId);
	public Entreprise updateEntreprise(int id,Entreprise e);
}
