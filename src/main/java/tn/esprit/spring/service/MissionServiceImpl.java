package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Mission;
import tn.esprit.spring.repository.IMissionRepository;

@Service
public class MissionServiceImpl implements IMissionService {
	

	
	@Autowired
	IMissionRepository Mr ;
	
	
	
	
	
	@Override
	public List<Mission> getMissions() {
		return (List<Mission>) Mr.findAll();
	}
	
	@Override
	public long ajouterMission(Mission mission) {
		Mr.save(mission);
		return (mission).getIdMission();
	}
	
	
	@Override
	public long getMissionNumber() {
		return Mr.count();
	}
	
	
	
	@Override
	public Mission MissionUpadate(Mission Miss) {
		
		Mission existingMiss=Mr.findById(Miss.getIdMission()).orElse(null);
		
		Mr.findById(Miss.getIdMission());
		existingMiss.setNameMission(Miss.getNameMission());
		existingMiss.setDescriptionMission(Miss.getDescriptionMission());
		
		return Mr.save(existingMiss);
	}
	

	@Override
	public void deleteMission(int id) {
		Mr.deleteById((long)id);

	}
	
	
	
	

}
