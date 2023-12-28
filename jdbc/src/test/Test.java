package test;

import java.util.List;
import metier.Categorie;
import metier.MetierCatalogueImpl;
import metier.Produit;

public class Test {

	public static void main(String[] args) {


		MetierCatalogueImpl metier = new MetierCatalogueImpl(); 

		//		Categorie cat = new Categorie("Clavier");
		//		Categorie cat2 = new Categorie("Souris");
		//		Categorie cat3 = new Categorie("Ecran");
		//		
		//		metier.addCategorie(cat);
		//		metier.addCategorie(cat2);
		//		metier.addCategorie(cat3);

		//		metier.addProduit(new Produit("Viper Mini", "Razer", 35, 1), 2);
		//		metier.addProduit(new Produit("G502", "Logitech",35 , 1), 2);
		//		metier.addProduit(new Produit("TUF","Asus", 150, 1), 3);
		//		metier.addProduit(new Produit("27gn950-b","LG", 500 ,1), 3);
		//		metier.addProduit(new Produit("G915", "Logitech", 120, 1), 1);
		//		metier.addProduit(new Produit("K70", "Corsair", 140, 1 ), 1);

//		List<Categorie> listeCategorie = metier.getAllCategorie();
//		for(Categorie cat : listeCategorie) {
//			System.out.println(cat.getNomCategorie());
//		}
		
		List<Produit> listeProduit = metier.getProduitParIDCategorie(2);
		for(Produit prod : listeProduit) {
			System.out.println(prod.getDesignationProduit());
		}
		
//		listeProduit = metier.getProduiParMotCle("razer");
//		for(Produit prod : listeProduit) {
//			System.out.println(prod);
//		}
	}

}