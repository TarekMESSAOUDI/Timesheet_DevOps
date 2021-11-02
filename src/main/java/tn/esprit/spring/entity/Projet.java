package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Projet implements Serializable {

	private static final long serialVersionUID = -5369734855993305723L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nameproject;

	private String descriptionproject;

	@ManyToOne
	private Departement departement;

	@OneToMany(mappedBy = "projet")
	private List<Employe> employes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameproject() {
		return nameproject;
	}

	public void setNameproject(String nameproject) {
		this.nameproject = nameproject;
	}

	public String getDescriptionproject() {
		return descriptionproject;
	}

	public void setDescriptionproject(String descriptionproject) {
		this.descriptionproject = descriptionproject;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public List<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(departement, descriptionproject, employes, id, nameproject);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Projet other = (Projet) obj;
		return Objects.equals(departement, other.departement)
				&& Objects.equals(descriptionproject, other.descriptionproject)
				&& Objects.equals(employes, other.employes) && id == other.id
				&& Objects.equals(nameproject, other.nameproject);
	}

	@Override
	public String toString() {
		return "Projet [id=" + id + ", nameproject=" + nameproject + ", descriptionproject=" + descriptionproject
				+ ", departement=" + departement + ", employes=" + employes + "]";
	}

	public Projet(String nameproject, String descriptionproject) {
		super();
		this.nameproject = nameproject;
		this.descriptionproject = descriptionproject;
	}

	public Projet() {
		super();

	}


}
