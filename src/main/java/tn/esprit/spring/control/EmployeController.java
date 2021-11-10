package tn.esprit.spring.control;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Employe;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.service.IEmployeService;

@Scope(value = "session")
@Controller(value = "employeController")
@ELBeanName(value = "employeController")
@Join(path = "/", to = "/login.jsf")
public class EmployeController {

//	@Autowired
//	IEmployeService es;
//	
//	private String nomEmploye;
//	private String prenomEmploye;
//	private String emailEmploye;
//	private boolean actif;
//	private String login; 
//	private String password; 
//	private Employe employe;
//	Boolean loggedIn;
//	Employe authenticatedUser;
//	private Role role; 
//	private List<Employe> employes;
//	private long employeIdToBeUpdated;
//	
//	public Role[] getRoles() { 
//		return Role.values(); 
//	}
//	
//	public String doLogin() {
//		String navigateTo = "null";
//		authenticatedUser=es.authenticate(login, password);
//		if (authenticatedUser != null && authenticatedUser.getRoleEmploye() == Role.ADMINISTRATEUR) { 
//		navigateTo = "/pages/admin/welcome.xhtml?faces-redirect=true";
//		loggedIn = true; }
//		else {
//		FacesMessage facesMessage =
//		new FacesMessage("Login Failed: please check your username/password and try again.");
//		FacesContext.getCurrentInstance().addMessage("form:btn",facesMessage);
//		}
//		return navigateTo;
//		}
//		public String doLogout() {
//		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
//		return "/login.xhtml?faces-redirect=true";
//		}
//		
//		public String addEmploye() {
//			if (authenticatedUser==null || !loggedIn) 
//				return "/login.xhtml";
//			es.ajouterEmploye(new Employe(nomEmploye,prenomEmploye,emailEmploye,actif,role,password));
//			return "null";
//			}
//		
//		public List<Employe> getEmployes() {
//			employes = es.getEmployes();
//			return employes;
//			} 
//		
//		public void removeEmploye(int employeId)
//		{
//		es.deleteEmployeById(employeId);
//		}
//
//		public void displayEmploye(Employe empl)
//		{
//			this.setPrenomEmploye(empl.getPrenomEmploye());
//			this.setNomEmploye(empl.getNomEmploye());
//			this.setActif(empl.getActif());
//			this.setEmailEmploye(empl.getEmailEmploye());
//			this.setRole(empl.getRoleEmploye());
//			this.setPassword(empl.getPassword());
//			this.setEmployeIdToBeUpdated(empl.getIdEmploye());
//		}
//		
//		public void updateEmploye(){ 
//			es.ajouterEmploye(new Employe(employeIdToBeUpdated, nomEmploye,prenomEmploye, emailEmploye, actif, role, password)); }
//		
//	public Employe getAuthenticatedUser() {
//		return authenticatedUser;
//	}
//
//	public void setAuthenticatedUser(Employe authenticatedUser) {
//		this.authenticatedUser = authenticatedUser;
//	}
//		
//	public String getLogin() {
//		return login;
//	}
//
//	public String getNomEmploye() {
//		return nomEmploye;
//	}
//
//	public void setNomEmploye(String nomEmploye) {
//		this.nomEmploye = nomEmploye;
//	}
//
//	public String getPrenomEmploye() {
//		return prenomEmploye;
//	}
//
//	public void setPrenomEmploye(String prenomEmploye) {
//		this.prenomEmploye = prenomEmploye;
//	}
//
//	public String getEmailEmploye() {
//		return emailEmploye;
//	}
//
//	public void setEmailEmploye(String emailEmploye) {
//		this.emailEmploye = emailEmploye;
//	}
//
//	public boolean isActif() {
//		return actif;
//	}
//
//	public void setActif(boolean actif) {
//		this.actif = actif;
//	}
//
//	public void setLogin(String login) {
//		this.login = login;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public Employe getEmploye1() {
//		return employe;
//	}
//
//	public void setEmploye(Employe employe) {
//		this.employe = employe;
//	}
//	
//
//	public Boolean getLoggedIn() {
//		return loggedIn;
//	}
//
//	public void setLoggedIn(Boolean loggedIn) {
//		this.loggedIn = loggedIn;
//	}
//
//	public Role getRole() {
//		return role;
//	}
//	public void setRole(Role role) {
//		this.role = role;
//	}
//
//	public List<Employe> getEmployes1() {
//		return employes;
//	}
//
//	public void setEmployes(List<Employe> employes) {
//		this.employes = employes;
//	}
//
//	public Long getEmployeIdToBeUpdated() {
//		return employeIdToBeUpdated;
//	}
//
//	public void setEmployeIdToBeUpdated(Long employeIdToBeUpdated) {
//		this.employeIdToBeUpdated = employeIdToBeUpdated;
//	}
}
