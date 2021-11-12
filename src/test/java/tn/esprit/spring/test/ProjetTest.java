package tn.esprit.spring.test;

import static org.junit.Assert.assertNotNull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entity.Projet;
import tn.esprit.spring.repository.IProjetRepository;
import tn.esprit.spring.service.IProjetService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjetTest {
	private static final long DEFAULT_TIMEOUT = 10000;
	private static final Logger l = LogManager.getLogger(ProjetTest.class);

	@Autowired
	IProjetService ps;
	@Autowired
	IProjetRepository pr;
	
	
	// test de methode d'ajout et supression
	
	
	@Test(timeout = DEFAULT_TIMEOUT)
	public void testaddprojet() {
		Projet projet = new Projet("test","testttttttest");
		ps.ajouterProjet(projet);
		assertNotNull(projet.getId());
		l.info("projet ajouter");
		pr.deleteById(projet.getId());
	}
	
	
	
	
	
	
	
}