package tn.esprit.spring.test;

import static org.junit.Assert.assertNotNull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entity.Employe;
import tn.esprit.spring.entity.Mission;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.repository.IMissionRepository;
import tn.esprit.spring.service.IMissionService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MissionServiceImpTest {
	
	
	private static final long DEFAULT_TIMEOUT = 10000;
	private static final Logger l = LogManager.getLogger(MissionServiceImpTest.class);

	
	
	
	@Autowired
	IMissionRepository Mr ;
	
	@Autowired
	IMissionService Ms ;
	
	
	
	//Add Mission Test 
		@Test(timeout = DEFAULT_TIMEOUT)
		public void testaddMission() {
			Mission mission = new Mission("missionTest","missionTest");
		Ms.ajouterMission(mission);
		assertNotNull(mission.getIdMission());
		l.info("Mission added successfuly ");
		Mr.deleteById(mission.getIdMission());
		}
		
	
	

	
}
