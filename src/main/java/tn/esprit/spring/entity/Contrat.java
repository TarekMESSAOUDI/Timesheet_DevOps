package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name = "T_CONTRAT")
public class Contrat implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="REFERENCE")
	private Long referenceContrat;
	
	@Temporal (TemporalType.DATE)
	@Column(name="DATE_DEBUT")
	private Date dateDebutContrat;
	
	
	private String typeContrat;
	
	private float salaire;

	
	@OneToOne(mappedBy="contrat")
	private Employe employe;


	public Long getReferenceContrat() {
		return referenceContrat;
	}


	public void setReferenceContrat(Long referenceContrat) {
		this.referenceContrat = referenceContrat;
	}


	public Date getDateDebutContrat() {
		return dateDebutContrat;
	}


	public void setDateDebutContrat(Date dateDebutContrat) {
		this.dateDebutContrat = dateDebutContrat;
	}


	public String getTypeContrat() {
		return typeContrat;
	}


	public void setTypeContrat(String typeContrat) {
		this.typeContrat = typeContrat;
	}


	public float getSalaire() {
		return salaire;
	}


	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}


	public Employe getEmploye() {
		return employe;
	}


	public void setEmploye(Employe employe) {
		this.employe = employe;
	}


	public Contrat() {
		super();
	}


	public Contrat(Long referenceContrat, Date dateDebutContrat, String typeContrat, float salaire
			) {
		super();
		this.referenceContrat = referenceContrat;
		this.dateDebutContrat = dateDebutContrat;
		this.typeContrat = typeContrat;
		this.salaire = salaire;
	}
	
	
	
	
}
