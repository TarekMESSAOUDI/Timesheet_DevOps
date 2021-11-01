package tn.esprit.spring.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.TimesheetDevOpsApplication;
import tn.esprit.spring.entity.Contrat;
import tn.esprit.spring.service.ContratServiceImpl;
import tn.esprit.spring.service.IContratService;

@ContextConfiguration(classes = TimesheetDevOpsApplication.class)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ContratServiceImpl.class)
public class ContratServiceImplTest {
	private static final long DEFAULT_TIMEOUT = 10000;
	private static final Logger L = LogManager.getLogger(ContratServiceImplTest.class);
	@Autowired
	IContratService c;
	
	@Test(timeout = DEFAULT_TIMEOUT )
	public void TestAjouterContrat() {
		Contrat contrat = new Contrat() ;
		contrat.setReferenceContrat((long) 1);
		contrat.setDateDebutContrat(null);
		contrat.setTypeContrat("CDI");
		contrat.setSalaire(1500);
		contrat = c.ajouterContrat(contrat);
		//test
		
	}
	
	@Test(timeout = DEFAULT_TIMEOUT)
	public void deleteContrat() {
		Contrat contrat = new Contrat();
		int id = 4 ;
		c.deleteContratById(id);
		
		}
	
	public void updateContrat()  {
		
		
	}
	
	

}
