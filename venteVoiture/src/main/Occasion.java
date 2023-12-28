package main;

public class Occasion extends Voiture {
	private int nbKms;
	private int age;
	
	public Occasion(String numero, double prix, int nbKms, int age) {
		super(numero, prix);
		this.nbKms = nbKms;
		this.age = age;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public int getNbKms() {
		return this.nbKms;
	}

	public double getPrix() {
		return this.prix;
	}
	
	public String toString() {
		return super.toString() + "\t Nb de km : " + this.getNbKms() + "\t anciennete : " + this.getAge() + "\t Prix de vente: " + this.getPrix()  + "\n";
	}
}
