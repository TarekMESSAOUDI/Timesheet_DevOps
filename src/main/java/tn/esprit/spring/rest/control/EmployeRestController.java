package tn.esprit.spring.rest.control;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.websocket.server.PathParam;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Contrat;
import tn.esprit.spring.entity.Employe;
import tn.esprit.spring.entity.Entreprise;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.repository.IEmployeRepository;
import tn.esprit.spring.service.IEmployeService;



@RestController
public class EmployeRestController {
	
	@Autowired
	IEmployeService es;
	
	@Autowired
	IEmployeRepository empR;
	
	@PostMapping("/ajouter-employe")
	@ResponseBody
	public int ajouterEmploye(@RequestBody Employe employe){
		return Integer.valueOf(es.ajouterEmploye(employe)).intValue();
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
		return empR.getAllEmployeByEntreprisec(entreprise);
	}
	
	
	@GetMapping("/get-employe-by-email-password/{email}/{password}")
	@ResponseBody
	public Employe getAllEmployeByEntreprise(
			@PathVariable ("email") String login,
			@PathVariable("password")String password){
		return empR.getEmployeByEmailAndPassword(login, password);
	}
	

}
