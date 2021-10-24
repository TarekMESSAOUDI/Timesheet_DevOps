package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "T_DEPARTEMENT")
public class Departement implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7049001702100456716L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private long idDepartement;
	
	@Column(name="NAME")
	private String nameDepartement;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="departement")
	private Set<Mission> mission;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="departement")
	private Set<Projet> projets;
	
	@ManyToOne
	Entreprise entreprise;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Employe> employe;
	
	


	public Long getIdDepartement() {
		return idDepartement;
	}

	public void setIdDepartement(Long idDepartement) {
		this.idDepartement = idDepartement;
	}

	public String getNameDepartement() {
		return nameDepartement;
	}

	public void setNameDepartement(String nameDepartement) {
		this.nameDepartement = nameDepartement;
	}

	public Set<Mission> getMission() {
		return mission;
	}

	public void setMission(Set<Mission> mission) {
		this.mission = mission;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}



	public Set<Employe> getEmploye() {
		return employe;
	}

	public void setEmploye(Set<Employe> employe) {
		this.employe = employe;
	}

	public void setIdDepartement(long idDepartement) {
		this.idDepartement = idDepartement;
	}

	public Departement() {
		super();
	}

	public Departement(Long idDepartement, String nameDepartement, Set<Mission> mission,
			Entreprise entreprise, Set<Employe> employe) {
		super();
		this.idDepartement = idDepartement;
		this.nameDepartement = nameDepartement;
		this.mission = mission;
		this.entreprise = entreprise;
		this.employe = employe;
	}

	public Departement(String nameDepartement) {
		super();
		this.nameDepartement = nameDepartement;
	}
	
	

	public Departement(long idDepartement, String nameDepartement, Entreprise entreprise) {
		super();
		this.idDepartement = idDepartement;
		this.nameDepartement = nameDepartement;
		this.entreprise = entreprise;
	}

	public Object getId() {
	
		return null;
	} 
	
	
	
}
