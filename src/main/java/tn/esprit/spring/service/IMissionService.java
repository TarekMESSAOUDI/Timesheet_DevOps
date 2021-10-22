package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Mission;

public interface IMissionService {

	long ajouterMission(Mission mission);

	void deleteMission(int id);

	List<Mission> getMissions();

	long getMissionNumber();

	Mission MissionUpadate(Mission Miss);
	
}
