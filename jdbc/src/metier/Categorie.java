package metier;

import java.util.ArrayList;
import java.util.List;

public class Categorie {
	private int idCategorie;
	private String nomCategorie;
	private List<Produit> listeProduits;
	
	/*
	 * Constructeur
	 */
	public Categorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
		this.listeProduits = new ArrayList<>();
	}
	
	public Categorie() {
		
	}
	/*
	 * getters et setters
	 */
	public int getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	public String getNomCategorie() {
		return nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	public List<Produit> getListeProduits() {
		return listeProduits;
	}

	public void setListeProduits(List<Produit> listeProduits) {
		this.listeProduits = listeProduits;
	}

	@Override
	public String toString() {
		return "Categorie [idCategorie=" + idCategorie + ", nomCategorie=" + nomCategorie + ", listeProduits="
				+ listeProduits + "]";
	}
	
	
}
