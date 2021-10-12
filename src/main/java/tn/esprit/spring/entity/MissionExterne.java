package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;

@Entity
public class MissionExterne extends Mission implements Serializable{
	

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}

	/**
	 * 
	 */
	private static long serialVersionUID = 1L;

	private String emailFacturation;
	
	private int tauxJournalierMoyen;

	public String getEmailFacturation() {
		return emailFacturation;
	}

	public void setEmailFacturation(String emailFacturation) {
		this.emailFacturation = emailFacturation;
	}

	public int getTauxJournalierMoyen() {
		return tauxJournalierMoyen;
	}

	public void setTauxJournalierMoyen(int tauxJournalierMoyen) {
		this.tauxJournalierMoyen = tauxJournalierMoyen;
	}

	public MissionExterne() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MissionExterne(Long idMission, String nameMission, String descriptionMission,
			Set<Timesheet> timesheet, tn.esprit.spring.entity.Departement departement) {
		super(idMission, nameMission, descriptionMission, timesheet, departement);
	}

	public MissionExterne(String emailFacturation, int tauxJournalierMoyen) {
		super();
		this.emailFacturation = emailFacturation;
		this.tauxJournalierMoyen = tauxJournalierMoyen;
	}

	public MissionExterne(Long idMission,String nameMission,String descriptionMission,String emailFacturation, int tauxJournalierMoyen) {
		super();
		this.idMission = idMission;
		this.nameMission = nameMission;
		this.descriptionMission = descriptionMission;
		this.emailFacturation = emailFacturation;
		this.tauxJournalierMoyen = tauxJournalierMoyen;
	}
}
