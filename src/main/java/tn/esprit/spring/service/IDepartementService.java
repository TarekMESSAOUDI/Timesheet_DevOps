package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entity.Departement;


public interface IDepartementService {

	public String addDepartement(Departement d);
	public List<Departement> retrieveAllDepartement();
	void deleteDepartement(Long idDepartement);
	Departement updateDepartement(Departement d);
	Departement saveDepartement(Departement d);
	Optional<Departement> findById(Long idDepartement);
	

}
