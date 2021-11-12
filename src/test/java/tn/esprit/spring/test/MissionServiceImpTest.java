package tn.esprit.spring.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entity.Mission;
import tn.esprit.spring.repository.IMissionRepository;
import tn.esprit.spring.service.IMissionService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MissionServiceImpTest {
	
	
	private static final long DEFAULT_TIMEOUT = 10000;
	private static final Logger l = LogManager.getLogger(MissionServiceImpTest.class);

	
	
	
	@Autowired
	IMissionRepository imissionRepository ;
	
	@Autowired
	IMissionService imissionService ;
	
	
	
	//Add Mission Test ///
		@Test(timeout = DEFAULT_TIMEOUT)
		public void testaddMission() {
			Mission mission = new Mission("missionTest","missionTest");
			imissionService.ajouterMission(mission);
		assertNotNull(mission.getIdMission());
		l.info("Mission added successfuly ");
		imissionRepository.deleteById(mission.getIdMission());
		}
		
		
		
		//Count missions a make sure the return is  not null
		@Test
		public void testcountMission() {
		long nbrms = imissionRepository.count();
		assertNotNull(nbrms);
		l.info("Le Nombre des Employes est :");
		l.info(nbrms);
		}
		
		
		
		// Make sure the Database is not Nulls
		@Test
		public void testListMission() {
		List<Mission> e = (List<Mission>) imissionRepository.findAll();
		assertThat(e).size().isPositive();
		l.info( "> 0");
		}
		
		
		
		
		//delete a mission (id=2).
		
				@Test
				public void deleteMission() {
					int id = 2;
					imissionService.deleteMission(id);
				}
				

	
}
