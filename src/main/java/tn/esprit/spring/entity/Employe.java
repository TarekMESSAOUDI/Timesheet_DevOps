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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	private Contrat Contrat; 
	
	@OneToMany (mappedBy="Employe", cascade = CascadeType.ALL)
	private Set<Timesheet> Timesheet;
	
	@ManyToMany(mappedBy="Employe", cascade = CascadeType.ALL)
	private Set<Departement> Departement;

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
		return Contrat;
	}

	public void setContrat(Contrat contrat) {
		Contrat = contrat;
	}


	public Set<Departement> getDepartement() {
		return Departement;
	}

	public void setDepartement(Set<Departement> departement) {
		this.Departement = departement;
	}

	public Set<Timesheet> getTimesheet() {
		return Timesheet;
	}

	public void setTimesheet(Set<Timesheet> timesheet) {
		Timesheet = timesheet;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Employe(Long idEmploye, String nomEmploye, String prenomEmploye, String emailEmploye, boolean isActif,
			Role roleEmploye, Contrat contrat, Set<Timesheet> timesheet,
			Set<Departement> departement) {
		super();
		this.idEmploye = idEmploye;
		this.nomEmploye = nomEmploye;
		this.prenomEmploye = prenomEmploye;
		this.emailEmploye = emailEmploye;
		this.actif = isActif;
		this.roleEmploye = roleEmploye;
		Contrat = contrat;
		Timesheet = timesheet;
		Departement = departement;
	}
	
	public Employe() {
		super();
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
	
	
	
}
