package tn.esprit.spring.service;

import tn.esprit.spring.entity.Mission;

public interface IMissionService {

	long ajouterMission(Mission mission);

	void deleteMission(int id);
	
}
