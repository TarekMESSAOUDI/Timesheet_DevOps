package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Mission;
import tn.esprit.spring.repository.IMissionRepository;

@Service
public class MissionServiceImpl implements IMissionService {
	

	
	@Autowired
	IMissionRepository Mr ;
	
	
	
	
	@Override
	public long ajouterMission(Mission mission) {
		Mr.save(mission);
		return (mission).getIdMission();
	}

	@Override
	public void deleteMission(int id) {
		Mr.deleteById((long)id);

	}
	

}
