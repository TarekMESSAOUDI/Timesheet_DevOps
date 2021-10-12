package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
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
@Table (name = "T_TIMESHEET")
public class Timesheet implements Serializable{
	
	private static long serialVersionUID = 1L;


	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="DATE_DEBUT")
	private Date dateDebutTimesheet;
	
	@Column(name="TDATE_FIN")
	private Date dateFinTimesheet;
	
	private boolean isValide;


	@ManyToOne(cascade = CascadeType.ALL)
	private Employe Employe;

	@ManyToOne(cascade = CascadeType.ALL)
	private Mission Mission;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}

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
		return Employe;
	}

	public void setEmploye(Employe employe) {
		Employe = employe;
	}

	public Mission getMission() {
		return Mission;
	}

	public void setMission(Mission mission) {
		Mission = mission;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public static void setSerialVersionUID(long serialVersionUID) {
		Timesheet.serialVersionUID = serialVersionUID;
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
		Employe = employe;
		Mission = mission;
	}

}
