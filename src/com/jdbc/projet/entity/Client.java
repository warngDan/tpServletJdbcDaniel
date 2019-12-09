package com.jdbc.projet.entity;

public class Client {
	
	private String nom;
	private String adresse;
	private String telephone;
	
	
	public Client() {}

	public Client(String nom, String adresse, String telephone) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "Client [nom=" + nom + ", adresse=" + adresse + ", telephone=" + telephone + "]";
	}

}
