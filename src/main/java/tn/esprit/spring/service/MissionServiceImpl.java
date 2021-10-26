package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Mission;
import tn.esprit.spring.repository.IMissionRepository;

@Service
public class MissionServiceImpl implements IMissionService {
	

	
	@Autowired
	IMissionRepository mr ;
	
	
	
	
	
	@Override
	public List<Mission> getMissions() {
		return (List<Mission>) mr.findAll();
	}
	
	@Override
	public long ajouterMission(Mission mission) {
		mr.save(mission);
		return (mission).getIdMission();
	}
	
	
	@Override
	public long getMissionNumber() {
		return mr.count();
	}
	
	
	
	@Override
	public Mission MissionUpadate(Mission Miss) {
		
		Mission existingMiss=mr.findById(Miss.getIdMission()).orElse(null);
		
		mr.findById(Miss.getIdMission());
		existingMiss.setNameMission(Miss.getNameMission());
		existingMiss.setDescriptionMission(Miss.getDescriptionMission());
		
		return mr.save(existingMiss);
	}
	

	@Override
	public void deleteMission(int id) {
		mr.deleteById((long)id);

	}
	
	
	
	

}
