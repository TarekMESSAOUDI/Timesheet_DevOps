package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;

@Entity
public class MissionExterne extends Mission implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 5352957947600081675L;

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
