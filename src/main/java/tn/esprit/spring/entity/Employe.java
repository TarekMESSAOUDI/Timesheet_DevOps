package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "T_EMPLOYE")
@JsonIgnoreProperties
public class Employe implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private long idEmploye;
	
	@Column(name="NOM")
	private String nomEmploye;
	
	@Column(name="PRENOM")
	private String prenomEmploye;
	
	@Column(name="EMAIL")
	private String emailEmploye;
	
	private boolean actif;
	
	@Enumerated (EnumType.STRING)
	@Column(name="ROLE")
	private Role roleEmploye;
	
	@Column(name="PASSWORD")
	private String password;
	
	
	@OneToOne
	private Contrat contrat; 
	
	@OneToMany (mappedBy="employe", cascade = CascadeType.ALL)
	private Set<Timesheet> timesheet;
	
	@ManyToOne
	private Projet projet;
	
	@JsonIgnore
	@ManyToMany(mappedBy="employe", cascade = CascadeType.ALL)
	private Set<Departement> departement;

	public Long getIdEmploye() {
		return idEmploye;
	}

	public void setIdEmploye(Long idEmploye) {
		this.idEmploye = idEmploye;
	}

	public String getNomEmploye() {
		return nomEmploye;
	}

	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}

	public String getPrenomEmploye() {
		return prenomEmploye;
	}

	public void setPrenomEmploye(String prenomEmploye) {
		this.prenomEmploye = prenomEmploye;
	}

	public String getEmailEmploye() {
		return emailEmploye;
	}

	public void setEmailEmploye(String emailEmploye) {
		this.emailEmploye = emailEmploye;
	}

	public boolean getActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public Role getRoleEmploye() {
		return roleEmploye;
	}

	public void setRoleEmploye(Role roleEmploye) {
		this.roleEmploye = roleEmploye;
	}

	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}


	public Set<Departement> getDepartement() {
		return departement;
	}

	public void setDepartement(Set<Departement> departement) {
		this.departement = departement;
	}

	public Set<Timesheet> getTimesheet() {
		return timesheet;
	}

	public void setTimesheet(Set<Timesheet> timesheet) {
		this.timesheet = timesheet;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public Employe() {
		super();
	}

	public Employe(long idEmploye, String nomEmploye, String prenomEmploye, String emailEmploye, boolean actif,
			Role roleEmploye, String password) {
		super();
		this.idEmploye = idEmploye;
		this.nomEmploye = nomEmploye;
		this.prenomEmploye = prenomEmploye;
		this.emailEmploye = emailEmploye;
		this.actif = actif;
		this.roleEmploye = roleEmploye;
		this.password = password;
	}

	public Employe(String nomEmploye, String prenomEmploye, String emailEmploye, boolean actif, Role roleEmploye,
			String password) {
		super();
		this.nomEmploye = nomEmploye;
		this.prenomEmploye = prenomEmploye;
		this.emailEmploye = emailEmploye;
		this.actif = actif;
		this.roleEmploye = roleEmploye;
		this.password = password;
	}

}
