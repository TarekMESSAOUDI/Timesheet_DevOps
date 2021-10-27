package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Projet;
import tn.esprit.spring.repository.IEmployeRepository;
import tn.esprit.spring.repository.IProjetRepository;

/**
 * @author rached
 *
 */
@Service
public class ProjetServiceImpl implements IProjetService {
	@Autowired
	IEmployeRepository emprep;
	@Autowired
	IProjetRepository prorep;

	@Override
	public int ajouterProjet(Projet projet) {
		prorep.save(projet);
		return projet.getId();
	}

	@Override
	public void deleteProjectById(int projId) {
	prorep.delete(prorep.findById(projId).get());
	}


}
