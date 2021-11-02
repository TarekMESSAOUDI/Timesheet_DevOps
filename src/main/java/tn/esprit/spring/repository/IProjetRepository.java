package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Projet;


@Repository
public interface IProjetRepository extends CrudRepository<Projet, Integer> {

}
