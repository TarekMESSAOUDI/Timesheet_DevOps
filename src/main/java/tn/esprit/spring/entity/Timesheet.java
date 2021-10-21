package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "T_TIMESHEET")
public class Timesheet implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1701741051604268446L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="DATE_DEBUT")
	private Date dateDebutTimesheet;
	
	@Column(name="TDATE_FIN")
	private Date dateFinTimesheet;
	
	private boolean isValide;


	@ManyToOne(cascade = CascadeType.ALL)
	private Employe employe;

	@ManyToOne(cascade = CascadeType.ALL)
	private Mission mission;


	public Date getDateDebutTimesheet() {
		return dateDebutTimesheet;
	}

	public void setDateDebutTimesheet(Date dateDebutTimesheet) {
		this.dateDebutTimesheet = dateDebutTimesheet;
	}

	public Date getDateFinTimesheet() {
		return dateFinTimesheet;
	}

	public void setDateFinTimesheet(Date dateFinTimesheet) {
		this.dateFinTimesheet = dateFinTimesheet;
	}

	public boolean isValide() {
		return isValide;
	}

	public void setValide(boolean isValide) {
		this.isValide = isValide;
	}
	

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timesheet() {
		super();
	}

	public Timesheet(Long id, Date dateDebutTimesheet, Date dateFinTimesheet, boolean isValide,
			Employe employe,Mission mission) {
		super();
		this.id = id;
		this.dateDebutTimesheet = dateDebutTimesheet;
		this.dateFinTimesheet = dateFinTimesheet;
		this.isValide = isValide;
		this.employe = employe;
		this.mission = mission;
	}

}
