package com.inti.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name = "discriminator", discriminatorType = DiscriminatorType.INTEGER)
//@DiscriminatorValue("0")
public class Utilisateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String login;
	private String mdp;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idUD", nullable = false)
//	@JoinTable(name = "Utilisateur_UD",
//				joinColumns = @JoinColumn(name = "idU"),
//				inverseJoinColumns = @JoinColumn(name = "idUD"))
	private UtilisateurDetails utilisateurDetails;
	
	@OneToMany(mappedBy = "utilisateur", targetEntity = Commande.class)
	private List<Commande> listeCommande;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Utilisateur_Role",
		joinColumns = @JoinColumn(name = "idU"),
		inverseJoinColumns = @JoinColumn(name = "idR"))
	private List<Role> listeRole;
	
	public List<Commande> getListeCommande() {
		return listeCommande;
	}

	public List<Role> getListeRole() {
		return listeRole;
	}

	public void setListeRole(List<Role> listeRole) {
		this.listeRole = listeRole;
	}

	public void setListeCommande(List<Commande> listeCommande) {
		this.listeCommande = listeCommande;
	}

	public UtilisateurDetails getUtilisateurDetails() {
		return utilisateurDetails;
	}

	public void setUtilisateurDetails(UtilisateurDetails utilisateurDetails) {
		this.utilisateurDetails = utilisateurDetails;
	}

	public Utilisateur() {
		super();
	}

	public Utilisateur(String login, String mdp) {
		super();
		this.login = login;
		this.mdp = mdp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", login=" + login + ", mdp=" + mdp + "]";
	}
	
	

}
