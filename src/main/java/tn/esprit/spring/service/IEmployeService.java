package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Contrat;
import tn.esprit.spring.entity.Employe;

public interface IEmployeService {

	public int ajouterEmploye(Employe employe);
	
	public String getEmployePrenomById(int employeId);
	
	public long getNombreEmploye();
	
	public Employe authenticate(String login, String password) ;

	public List<Employe> getEmployes();

	public void deleteEmployeById(int employeId);

}
