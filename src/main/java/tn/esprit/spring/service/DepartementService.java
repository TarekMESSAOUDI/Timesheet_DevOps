package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entity.Departement;

public interface DepartementService {
	public Departement addDepartement(Departement d);
	public List<Departement> retrieveAllDepartements();
	public void deleteDepartement(int id);
	public Departement updateDepartement(Departement d);
	public Optional<Departement> retrieveDepartement(String id);
	public Departement getDepartementById(int id);
	public void deleteDepartementById(int id);

}
