
package tn.esprit.spring.test;

import static org.junit.Assert.*;

import java.text.ParseException;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.TimesheetDevOpsApplication;
import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.service.ContratServiceImpl;
import tn.esprit.spring.service.IDepartementService;

@ContextConfiguration(classes = TimesheetDevOpsApplication.class)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ContratServiceImpl.class)
public class DepartementTest {
	

	  @Autowired
	  DepartementRepository dr;
	  
	  @Autowired
	  IDepartementService ds;
	  
	
	  
	  
	  @Test
	  public void testAddDepartement() throws ParseException {
	  Departement d = new Departement("DEP B");
	  Departement savedDepartement = dr.save(d);
	  assertNotNull(savedDepartement.getId());
	  dr.delete(savedDepartement);
	  }
	 
	  
	  
		
		@Test
		public void testretrieveAllDepartement(){
			ds.retrieveAllDepartement();
		}
		
		@Test
		public void testDeleteDepartement(){
			ds.deleteDepartement((long) 4);
		}
		
		@Test
		public void testUpdateDepartement(){
			Departement d = ds.findById((long) 3).get();
			d.setNameDepartement("Dep A");
			ds.saveDepartement(d);
		}
		
	  
} 
