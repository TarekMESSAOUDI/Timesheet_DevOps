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
	
	private static long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private long idDepartement;
	
	@Column(name="NAME")
	private String nameDepartement;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="Departement")
	private Set<Mission> Mission;

	@ManyToOne
	Entreprise Entreprise;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Employe> Employe;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}

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
		return Mission;
	}

	public void setMission(Set<Mission> mission) {
		Mission = mission;
	}

	public Entreprise getEntreprise() {
		return Entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		Entreprise = entreprise;
	}



	public Set<Employe> getEmploye() {
		return Employe;
	}

	public void setEmploye(Set<Employe> employe) {
		Employe = employe;
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
		Mission = mission;
		Entreprise = entreprise;
		Employe = employe;
	}

	public Departement(String nameDepartement) {
		super();
		this.nameDepartement = nameDepartement;
	} 
	
	
	
}
