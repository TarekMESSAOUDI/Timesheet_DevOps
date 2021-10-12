package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name = "T_USER")
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static long serialVersionUID1 = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id ;
	private String firstName ;
	private String lastName;
	@Temporal (TemporalType.DATE)
	private Date date;
	@Enumerated(EnumType.ORDINAL)
	private Role role ;
	
	public static long getSerialversionuid() {
		return serialVersionUID1;
	}
	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID1 = serialversionuid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String firstName, String lastName, Date date, Role role) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.date = date;
		this.role = role;
	}
	public User(String firstName, String lastName, Date date, Role role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.date = date;
		this.role = role;
	}	
}
