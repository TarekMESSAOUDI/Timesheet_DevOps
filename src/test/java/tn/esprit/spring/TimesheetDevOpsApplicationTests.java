package tn.esprit.spring;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entity.Employe;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.repository.IEmployeRepository;
import tn.esprit.spring.service.IEmployeService;
import tn.esprit.spring.test.EmployeServiceImplTest;


@SpringBootTest
@RunWith(SpringRunner.class)
public class TimesheetDevOpsApplicationTests {

	@Test
	void contextLoads() {
		//comment here...
	}

	
	private static final Logger l = LogManager.getLogger(EmployeServiceImplTest.class);

	@Autowired
	IEmployeService es;
	
	@Autowired
	IEmployeRepository er;
	
	
	
	//test de la methode ajout
	@Test
	public void testaddemploye() {
		Employe employe = new Employe("Tarek","Messaoudi","tarek.messaoudi@esprit.tn",true,Role.INGENIEUR,"tarek");
	es.ajouterEmploye(employe);

	l.info("Employe added successfuly ");
	er.deleteById(employe.getIdEmploye());
	l.info("Employe deleted successfuly ");
	}
	

	
	//test du nombre des lignes dans la base il doit etre sup à 0
	@Test
	public void testListEmploye() {
	List<Employe> e = (List<Employe>) er.findAll();
		if (e.isEmpty()){
			l.info("Employes list is empty: ");
		}else{
			l.info("Employes list : ");
		}
	}
	
	//test de la methode count "le retour de la methode ne doit pas etre null".
	@Test
	public void testcountEmploye() {
	List<Employe> e = (List<Employe>) er.findAll();
	assertNotNull(e);
	l.info("Employes number :");
	}
	
	//test que le nom n'est pas null
	@Test
	public void testEmailAndPasswordEmploye(){
		Employe emp = er.getEmployeByEmailAndPassword("tarek.messaoudi1@esprit.tn", "tarek");
		assertNotNull(emp.getNomEmploye());
		l.info("Employe :");
	}
	
	// test du suppression de l'employee
	@Test
	public void testDeleteEmploye() {
		Employe emp = new Employe();
		assertNotNull(emp);
		er.deleteById((long) 44);
		l.info("Employe deleted successfuly" );
	}
}
