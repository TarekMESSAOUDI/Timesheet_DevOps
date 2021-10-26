package tn.esprit.spring.service;

import java.util.List;


import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Projet;

public interface IProjetService {
	public int ajouterProjet(Projet projet);

	/*
	 * public int ajouterDepartement(Departement departement); void
	 * affecterEmployeAProjet(int empId, int projId); void
	 * affecterProjetADepartement(int projId,int depId); List<String>
	 * getAllEmployeNameByProject(int projId); List<String>
	 * getAllProjectNameByDepartement(int depId);
	 */
	public void deleteProjectById(int projId);
	/*
	 * public void deleteDepartementById(int depId); public Projet getProjetById(int
	 * projId);
	 */
}
