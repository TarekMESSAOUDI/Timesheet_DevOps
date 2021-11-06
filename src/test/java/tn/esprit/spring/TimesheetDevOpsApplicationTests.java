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

	
	
}
