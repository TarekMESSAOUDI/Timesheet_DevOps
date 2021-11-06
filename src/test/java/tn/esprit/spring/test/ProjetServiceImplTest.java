package tn.esprit.spring.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
public class ProjetServiceImplTest {
	private static final long DEFAULT_TIMEOUT = 10000;
	private static final Logger l = LogManager.getLogger(ProjetServiceImplTest.class);

	@Autowired
	IProjetService ps;
	@Autowired
	IProjetRepository pr;
	
	
	// test de methode d'ajout
	
	
	@Test(timeout = DEFAULT_TIMEOUT)
	public void testaddprojet() {
		Projet projet = new Projet("test","testttttttest");
		assertEquals("test", projet.getNameproject());
		ps.ajouterProjet(projet);
		
		l.info("projet ajouter");
		pr.deleteById(projet.getId());
	}
	
	
	
	
	
	
	
}
