package tn.esprit.spring.test;


import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
public class DepartementServiceImplTest {
	
	@Autowired
	DepartementRepository dr;
	
	@Autowired
	DepartementServiceImpl ds;
	
	private static final Logger L =  LogManager.getLogger(DepartementServiceImplTest.class);
	
	@Test
	public void addDepartementTest()throws ParseException{
			
		
	Departement d = new Departement("Dep M");
	
	ds.addDepartement(d);

    L.log(Level.INFO, () ->"le departement est ajouté : " +d);

	}
	
	@Test
	public void testdeleteDepartement(){
		ds.deleteDepartement((long) 5);
		}
	

	
	

	

		
	}
	



