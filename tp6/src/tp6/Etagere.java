package tp6;
import java.util.ArrayList;
public class Etagere {
	/*
	 * variables 
	 */
	private	int nbLivres;
	private ArrayList<Livre> listeLivres; 
	
	public Etagere(int nbLivres) {  // constructeur
		this.nbLivres = nbLivres;
		this.listeLivres = new ArrayList<>();	
	}
	
	public void printNbLivres() {
		System.out.println("L'etagere peut contenir " +this.nbLivres + " livres"); // le nombre total de livres que peut contenir une etagere
		System.out.println("L'etagère contient " + this.listeLivres.size() + " livres"); // le nombre de livres que contient une etagere 
	}
	
	public void ajouterLivres(Livre livre) throws EtagerePleineException { // exception si une etagere est pleine 
		if(this.listeLivres.size() == this.nbLivres) throw new EtagerePleineException("Impossible d'ajouter ce livre à cet étagère elle ne peut contenir que " + this.nbLivres + " livres");
		this.listeLivres.add(livre);
}


	public void getLivres(int i) {
		System.out.println(this.listeLivres.get(i-1)); 
	}
	
	public int chercher(String a, String t) { // recherche un livre selon son auteur et son titre
		int index = 0 ;
		for(Livre livres : this.listeLivres) { 
			if(a.equals(livres.getAuteur()) && t.equals(livres.getTitre())) {  // si le paremetre a est egale au a l'auteur du livre  parcourus dans la boucle et le paremetre t equivaut au titre du livre parcouru dans la boucle
				index = this.listeLivres.indexOf(livres)+1;
				break;
			}
		}
		return index;
	}
	
	
	public ArrayList<Integer> chercherPosition(String a, String t){
		ArrayList<Integer> list = new ArrayList<>();
		for (Livre livres : this.listeLivres) {
			if(t.equals(livres.getTitre()) && a.equals(livres.getAuteur())) {
				list.add(this.listeLivres.indexOf(livres));
			}
		}
		return list;
	}
	
	public ArrayList<Livre> chercherTitreLivres(String t){
		ArrayList<Livre> liste = new ArrayList<>();
		
		for(Livre livres : this.listeLivres) {
			if(t.equals(livres.getTitre())) {
				liste.add(livres);
			}
		}
		return liste;
	}
	
	public ArrayList<Livre> chercherAuteurLivres(String a){
		ArrayList<Livre> liste = new ArrayList<>();
		
		for(Livre livres :this.listeLivres) {
			if (a.equals(livres.getAuteur())) {
				liste.add(livres);
			}
		}
		return liste;
	}
	
	public String enleverLivre(int p) {
		String livre ="";
		if(p <= this.listeLivres.size()) {
			
			livre =  this.listeLivres.get(p-1).getTitre();
			this.listeLivres.remove(p-1);
			
		}
		
		return livre;
	}
	
	public Livre enleverLivre(String t, String a) {
			Livre livre = new Livre();								
			livre = this.listeLivres.get(chercher(t,a));		
			this.listeLivres.remove(chercher(t,a));
			return livre;
	
	}
	
	public String toString() {
		return "Voici les livres contenu dans cet étagère \n" +this.listeLivres;
	}
}
