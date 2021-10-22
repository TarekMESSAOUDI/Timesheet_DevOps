package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.repository.DepartementRepository;


@Service
public class DepartementServiceImpl implements IDepartementService {
	
	
	@Autowired
	DepartementRepository dr;
	
	

	private static final Logger L = LogManager.getLogger(DepartementServiceImpl.class);
		
	@Override
	public String addDepartement(Departement d){
		dr.save(d);
		return"done";
	}

	@Override
	public List<Departement> retrieveAllDepartement(){
	List<Departement> departement = (List<Departement>) dr.findAll();

	for (Departement d : departement){
		L.info("d +++ :" + d);
	}
	return departement;

	}
	
	@Override
	public void deleteDepartement(Long idDepartement) {
		dr.deleteById(idDepartement);
		
	}

	@Override
	public Departement updateDepartement(Departement d) {
		
		return dr.save(d);
	}

	@Override 
	public Departement saveDepartement(Departement d){
		return dr.save(d);
	}

	@Override
	public  Optional<Departement> findById(Long idDepartement){
		 return dr.findById(idDepartement);
		
	}



}
