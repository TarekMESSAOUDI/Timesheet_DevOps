package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "T_ENTREPRISE")
public class Entreprise implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3009482349808085736L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private long idEntreprise;
	
	@Column(name="NAME")
	private String nameEntreprise;
	
	private String raisonSocial;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="entreprise")
	private Set<Departement> departement;


	public Long getIdEntreprise() {
		return idEntreprise;
	}


	public void setIdEntreprise(Long idEntreprise) {
		this.idEntreprise = idEntreprise;
	}


	public String getNameEntreprise() {
		return nameEntreprise;
	}


	public void setNameEntreprise(String nameEntreprise) {
		this.nameEntreprise = nameEntreprise;
	}


	public String getRaisonSocial() {
		return raisonSocial;
	}


	public void setRaisonSocial(String raisonSocial) {
		this.raisonSocial = raisonSocial;
	}


	public Set<Departement> getDepartement() {
		return departement;
	}


	public void setDepartement(Set<Departement> departement) {
		this.departement = departement;
	}


	public Entreprise() {
		super();
	}


	public Entreprise(Long idEntreprise, String nameEntreprise, String raisonSocial,
			Set<tn.esprit.spring.entity.Departement> departement) {
		super();
		this.idEntreprise = idEntreprise;
		this.nameEntreprise = nameEntreprise;
		this.raisonSocial = raisonSocial;
		this.departement = departement;
	}
}
