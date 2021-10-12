package tn.esprit.spring.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Contrat;
import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Employe;
import tn.esprit.spring.entity.Entreprise;
import tn.esprit.spring.repository.IEmployeRepository;

@Service
public class EmployeServiceImpl implements IEmployeService{

	@Autowired
	IEmployeRepository empR;

	@Override
	public int ajouterEmploye(Employe employe) {
		// TODO Auto-generated method stub
		return Integer.valueOf(empR.save(employe).getIdEmploye().toString());
	}

	@Override
	public String getEmployePrenomById(int employeId) {
		// TODO Auto-generated method stub
		return String.valueOf( empR.findById(Long.valueOf(employeId)).get().getNomEmploye().toString());
	}

	@Override
	public long getNombreEmploye() {
		// TODO Auto-generated method stub
		return empR.count();
	}
	
	@Override
	public Employe authenticate(String login, String password) {
	return empR.getEmployeByEmailAndPassword(login, password);
	}

	@Override
	public List<Employe> getEmployes() {
		// TODO Auto-generated method stub
		return (List<Employe>) empR.findAll();
	}

	@Override
	public void deleteEmployeById(int employeId) {
		// TODO Auto-generated method stub
		empR.deleteById((long) employeId);
	}

	
}
