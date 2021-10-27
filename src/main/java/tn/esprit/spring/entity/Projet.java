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

	private String name_project;

	private String description_project;

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

	public String getName_project() {
		return name_project;
	}

	public void setName_project(String name_project) {
		this.name_project = name_project;
	}

	public String getDescription_project() {
		return description_project;
	}

	public void setDescription_project(String description_project) {
		this.description_project = description_project;
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
		return Objects.hash(departement, description_project, employes, id, name_project);
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
				&& Objects.equals(description_project, other.description_project)
				&& Objects.equals(employes, other.employes) && id == other.id
				&& Objects.equals(name_project, other.name_project);
	}

	@Override
	public String toString() {
		return "Projet [id=" + id + ", name_project=" + name_project + ", description_project=" + description_project
				+ ", departement=" + departement + ", employes=" + employes + "]";
	}

	public Projet(String name_project, String description_project, Departement departement, List<Employe> employes) {
		super();
		this.name_project = name_project;
		this.description_project = description_project;
		this.departement = departement;
		this.employes = employes;
	}

	public Projet(String name_project, String description_project) {
		super();
		this.name_project = name_project;
		this.description_project = description_project;
	}

	public Projet() {
		super();
		// TODO Auto-generated constructor stub
	}

}
