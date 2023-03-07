package com.inti.model;

import javax.persistence.DiscriminatorValue;


/*  Projet Java :     */

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table
@PrimaryKeyJoinColumn(name = "idU")
//@DiscriminatorValue("1")
public class UAbonne extends Utilisateur {
	
	private int duree;
	private String categorie;
	
	public UAbonne() {
		super();
	}

	public UAbonne(String login, String mdp, int duree, String categorie) {
		super(login, mdp);
		this.duree = duree;
		this.categorie = categorie;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	@Override
	public String toString() {
		return "UAbonne [duree=" + duree + ", categorie=" + categorie + "]";
	}
	
	

}
