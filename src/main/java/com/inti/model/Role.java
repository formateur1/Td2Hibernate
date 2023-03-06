package com.inti.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Utilisateur_Role",
			joinColumns = @JoinColumn(name = "idR"),
			inverseJoinColumns = @JoinColumn(name = "idU"))
	List<Utilisateur> listeU;
	
	
	
	public List<Utilisateur> getListeU() {
		return listeU;
	}

	public void setListeU(List<Utilisateur> listeU) {
		this.listeU = listeU;
	}

	public Role() {
		super();
	}

	public Role(String nom) {
		super();
		this.nom = nom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", nom=" + nom + "]";
	}
	
	

}
