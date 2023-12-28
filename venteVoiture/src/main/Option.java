package main;

public class Option {
	private int numero;
	private String libelle;
	private double prix;
	
	public Option(int numero, String libelle, double prix) {
		this.numero = numero;
		this.libelle = libelle;
		this.prix = prix;
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public String getLibelle() {
		return this.libelle;
	}
	
	public double getPrix() {
		return this.prix;
	}
	
	public String toString() {
		return "Numero:"+this.getNumero() + "\tLibelle:"  +this.getLibelle()+ "\tPrix:"+ this.getPrix();
	}
}
