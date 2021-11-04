package tn.esprit.spring.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.TimesheetDevOpsApplication;
import tn.esprit.spring.entity.Entreprise;
import tn.esprit.spring.repository.EntrepriseRepository;
import tn.esprit.spring.service.IEntrepriseService;

@ContextConfiguration(classes = TimesheetDevOpsApplication.class)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = EntreriseServiceImplTests.class)
public class EntreriseServiceImplTests {
	
	private static final long DEFAULT_TIMEOUT = 10000;
	private static final Logger l = LogManager.getLogger(EntreriseServiceImplTests.class);

	@Autowired
	IEntrepriseService es;
	
	@Autowired
	 EntrepriseRepository er;
	
	//test de la methode ajout
	@Test(timeout = DEFAULT_TIMEOUT)
	public void testaddemploye() {
		Entreprise entreprise = new Entreprise("Moneim Entrepsie","Raison Social");
	es.ajouterEntreprise(entreprise);
	assertNotNull(entreprise.getIdEntreprise());
	l.info("Entreprise added successfuly ");
	//er.deleteById(entreprise.getId());
	}
	

	
	//test du nombre des lignes dans la base il doit etre sup à 0
	@Test
	public void testListEntreprises() {
	List<Entreprise> e = (List<Entreprise>) er.findAll();
	assertThat(e).size().isGreaterThan(0);
	}
	
	//test de la methode count "le retour de la methode ne doit pas etre null".
	@Test
	public void testcountEntreprises() {
	long nbrEm = er.count();
	assertNotNull(nbrEm);
	}
	
	//test que le nom n'est pas null
	@Test
	public void testNomEnttreprise(){
		Entreprise e = er.findByNameEntreprsie("Moneim Entrepsie");
		assertNotNull(e.getNameEntreprise());
	}
	
	// test du suppression de l'entreprise
	@Test(timeout = 5000) 
	public void testDeleteEmploye() {
	es.deleteEntrepriseById(1);
	l.info("deleted successfuly" );
	}

}
