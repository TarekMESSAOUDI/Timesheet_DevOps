package tn.esprit.spring.rest.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Employe;
import tn.esprit.spring.entity.Entreprise;
import tn.esprit.spring.repository.IEmployeRepository;
import tn.esprit.spring.service.IEmployeService;



@RestController
public class EmployeRestController {
	
	@Autowired
	IEmployeService es;
	
	@Autowired
	IEmployeRepository empR;
	
	//http://localhost:9090/SpringMVC/servlet/ajouter-employe
	@PostMapping("/ajouter-employe")
	@ResponseBody
	public Employe ajouterEmploye(@RequestBody Employe employe){
		return es.ajouterEmploye(employe);
	}
	
	@GetMapping("/count-employe")
	@ResponseBody
	public long getNombreEmploye() {
	return es.getNombreEmploye();
	}
	
	@GetMapping("/count-employe-jpql")
	@ResponseBody
	public long getNombreEmployeJPQL() {
	return empR.getNombreEmployeJPQL();
	}
	
	@GetMapping("/get-employeprenom-by-id/{idemploye}")
	@ResponseBody
	public String getEmployePrenomById(@PathVariable("idemploye") int employeId){
		return es.getEmployePrenomById(employeId);
		
	}
	
	@GetMapping("/get-all-nameemploye")
	@ResponseBody
	public List<String> getAllEmployeNamesJPQL(){
		return empR.getAllEmployeNamesJPQL();
	}
	
	@GetMapping("/get-all-employe-by-entreprise")
	@ResponseBody
	public List<Employe> getAllEmployeByEntreprise(@RequestBody Entreprise entreprise){
		return empR.getAllEmployeByEntreprise(entreprise);
	}
	
	
	@GetMapping("/get-employe-by-email-password/{email}/{password}")
	@ResponseBody
	public Employe getAllEmployeByEntreprise(
			@PathVariable ("email") String login,
			@PathVariable("password")String password){
		return empR.getEmployeByEmailAndPassword(login, password);
	}
	

}
