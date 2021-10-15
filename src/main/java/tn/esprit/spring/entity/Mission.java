package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "T_MISSION")
public class Mission implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3537594150972176592L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	protected Long idMission;
	
	@Column(name="NAME")
	protected String nameMission;
	
	@Column(name="DESCRIPTION")
	protected String descriptionMission;

	@OneToMany (mappedBy="mission", cascade = CascadeType.ALL)
	private Set<Timesheet> timesheet;
	
	@ManyToOne
	Departement departement;

	public Long getIdMission() {
		return idMission;
	}

	public void setIdMission(Long idMission) {
		this.idMission = idMission;
	}

	public String getNameMission() {
		return nameMission;
	}

	public void setNameMission(String nameMission) {
		this.nameMission = nameMission;
	}

	public String getDescriptionMission() {
		return descriptionMission;
	}

	public void setDescriptionMission(String descriptionMission) {
		this.descriptionMission = descriptionMission;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public Mission() {
		super();
	}

	public Set<Timesheet> getTimesheet() {
		return timesheet;
	}

	public void setTimesheet(Set<Timesheet> timesheet) {
		this.timesheet = timesheet;
	}

	public Mission(Long idMission, String nameMission, String descriptionMission,
			Set<Timesheet> timesheet, Departement departement) {
		super();
		this.idMission = idMission;
		this.nameMission = nameMission;
		this.descriptionMission = descriptionMission;
		this.timesheet = timesheet;
		this.departement = departement;
	}

	public Mission(String nameMission, String descriptionMission) {
		super();
		this.nameMission = nameMission;
		this.descriptionMission = descriptionMission;
	}
	
	
}
