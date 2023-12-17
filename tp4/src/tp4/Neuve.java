package tp4;

import java.util.ArrayList;

public class Neuve extends Voiture {
	private ArrayList<Option> list;
	
	public Neuve(String numero, double prix) {
		super(numero,prix);
		this.list = new ArrayList<>();
	}
	
	public void addOption(Option o ) {
		this.list.add(o);
		
	}
	
	public double getPrix() {
		return this.prix;
	}
	
	public void printOptions() {
		
		for (Option o  : this.list) {
			System.out.println(o.getLibelle());
			}
	}
	
	public String toString() {
		
		if (this.list.isEmpty()) {
			return super.toString() + " Le prix de la voiture est de " + this.getPrix() + " euros, la voiture ne contient pas d'options";
		}
		
		if (this.list.size() == 1 ) {
			return super.toString() + " Le prix de la voiture est de " + this.getPrix() + " euros, la voiture contient également " + this.list.size() + " option";
		}
		
		return super.toString() + " Le prix de la voiture est de " + this.getPrix() + " euros, la voiture contient également " + this.list.size() + " options";
	}
}
