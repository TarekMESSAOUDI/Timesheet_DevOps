package tn.esprit.spring.rest.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Contrat;
import tn.esprit.spring.service.IContratService;

@RestController
public class ContratRestController {

	@Autowired
	IContratService icontratService;

	@PostMapping("/ajouterContrat")
	@ResponseBody
	public Contrat ajouterContrat(@RequestBody Contrat contrat) {
		icontratService.ajouterContrat(contrat);
		return contrat;
	}
	@DeleteMapping("/deleteContratById/{idcontrat}") 
	@ResponseBody
	public void deleteContratById(@PathVariable("idcontrat")int contratId) {
		icontratService.deleteContratById(contratId);
	}
}
