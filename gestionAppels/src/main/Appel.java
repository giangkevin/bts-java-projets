package main;

import java.time.LocalDate;


public abstract class Appel {
	private String numero;
	private LocalDate date;
	private int duree;
	protected int cout;
	
	public Appel(String numero, LocalDate date, int duree) {
		this.numero = numero;
		this.date = date;
		this.duree = duree;
		this.cout = 0;
	}
	
	public String getNumero() {
		return this.numero;
	}
	
	public int getDuree() {
		return this.duree;
	}
	
	public LocalDate getDate() {
		return this.date;
	}
	
	public int getCout() {
		return this.cout;
	}

	@Override
	public String toString() {
		return "Appel [numero=" + numero + ", date=" + date + ", duree=" + duree + "]";
	}
}
