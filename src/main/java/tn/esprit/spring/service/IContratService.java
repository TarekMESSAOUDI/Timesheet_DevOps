package tn.esprit.spring.service;

import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Contrat;

@Repository
public interface IContratService {

	public Contrat ajouterContrat(Contrat contrat);
	public void deleteContratById(int ContratId );
}
