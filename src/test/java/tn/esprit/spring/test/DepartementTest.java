package tn.esprit.spring.test;

import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.ParseException;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.service.DepartementServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest

public class DepartementTest {
	
	private static final Logger L = LogManager.getLogger();
	
	
	  @Autowired
	  DepartementRepository drep;
	  @Autowired
	  DepartementServiceImpl depService ;
	  
	  @Test
	  public void testAddDepartement()throws ParseException {

	 Departement d = new Departement("BLOC A");
	  
	 depService.addDepartement(d);
		L.log(Level.INFO, () ->"Ajouter departement : " +d);
	  }
	  
	  @Test
		public void testRetrieveDepartement() {
			List<Departement> d = depService.retrieveAllDepartements();
			
			L.log(Level.INFO, () ->"retrieve departement : " +d);
		}
	
	  
	  @Test
	  public void testUpdate () {
		  Departement d=depService.getDepartementById(14);
			d.setNameDepartement("Meissa"+" ");
			Departement dm= depService.updateDepartement(d);
			Assert.assertEquals(d.getNameDepartement(), dm.getNameDepartement());
	  	
	  }
	  
	  @Test
	  public void testDelete() {
      depService.deleteDepartementById(27);
	  }
	 
	  
}