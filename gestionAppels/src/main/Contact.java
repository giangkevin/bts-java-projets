package main;

public class Contact {
	private int numero;
	private String nom;
	private String numeroTelephone;
	
	public Contact(int numero, String nom, String numeroT) {
		this.numero = numero;
		this.nom = nom;
		this.numeroTelephone = numeroT;
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public String getNumeroTelephone() {
		return this.numeroTelephone;
	}
	
	
}
