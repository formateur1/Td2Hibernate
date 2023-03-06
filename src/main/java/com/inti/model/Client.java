package com.inti.model;
// Generated 6 mars 2023, 10:39:09 by Hibernate Tools 5.6.14.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Bonjour!!!
 */
public class Client implements java.io.Serializable {

	private int id;
	private String nom;
	private Set restaurants = new HashSet(0);

	public Client() {
	}

	public Client(int id) {
		this.id = id;
	}

	public Client(int id, String nom, Set restaurants) {
		this.id = id;
		this.nom = nom;
		this.restaurants = restaurants;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Set getRestaurants() {
		return this.restaurants;
	}

	public void setRestaurants(Set restaurants) {
		this.restaurants = restaurants;
	}

}
