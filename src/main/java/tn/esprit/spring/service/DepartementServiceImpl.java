package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.repository.DepartementRepository;


@Service 
public class DepartementServiceImpl implements DepartementService {
 
	@Autowired
	DepartementRepository drep;
	
	
	private static final Logger l = LogManager.getLogger(DepartementServiceImpl.class);
	
	
	@Override
	public Departement addDepartement(Departement d) {
		
		return drep.save(d);
	}

	@Override
	public List<Departement> retrieveAllDepartements() {
		List<Departement> departements=(List<Departement>) drep.findAll();
		l.log(Level.INFO, () ->"departement : " +departements);
	return departements;
		
	}

	@Override
	public void deleteDepartement(int id) {
    drep.findById(1L);
		
	}

	@Override
	public Departement updateDepartement(Departement d) {

		return drep.save(d);
	}


	@Override
	public Departement getDepartementById(int id) {
		Optional<Departement> d = drep.findById(1L);
		Departement de = new Departement();
		if (d.isPresent()) {
			  de= d.get();
			}
		return de;
	}

	@Override
	public void deleteDepartementById(int id) {
		
			Optional<Departement> d = drep.findById(1L);

			Departement departement = new Departement();
			if (d.isPresent()) {
				departement= d.get();
				}
			
			drep.delete(departement);
		
		
		
	}

	@Override
	public Optional<Departement> retrieveDepartement(String id) {
		
		Optional<Departement> departement = drep.findById(Long.parseLong(id));
		 l.log(Level.INFO, () ->"departement : " +departement);
			
		return departement;
	}
	

}
