package main;
public class Livre
{
	// Variables
	private String titre, auteur;
	private int nbPages;
	private double prix;
	private boolean prixfixe;
	// Constructeurs
	public Livre (){
		auteur = "";
		titre = "";
		prix = -1;
		prixfixe = false;
	}
	public Livre (String unAuteur, String unTitre){
		auteur = unAuteur;
		titre = unTitre;
		prix = -1;
		prixfixe = false;
	}
	public Livre (String unAuteur, String unTitre, int nbp){
		auteur = unAuteur;
		titre = unTitre;
		nbPages = nbp;
		prix = -1;
		prixfixe = false;
	}
	public Livre (String unAuteur, String unTitre, int nbp, double p){
		auteur = unAuteur;
		titre = unTitre;
		nbPages = nbp;
		prix = p;
		prixfixe = true;
	}
	// Accesseur
	public String getAuteur(){
		return(auteur);
	}
	public String getTitre(){
		return(titre);
	}
	public double getPrix(){
		return(prix);
	}
	public int getNbPages()
	{
		return(nbPages);
	}
	// Modificateur
	public void setNbPages(int n){
		if (n>0)
		{
			nbPages = n;
		}
		else
		{
			System.out.println("Erreur");
		}
	}
	public void setAuteur(String a){
		auteur = a;
	}
	
	public void setPrix(double p){
		if (!prixfixe){
			prix = p;
		}else{
			System.out.println("Erreur : prix déjà donné");
		}
	}
	public void setTitre(String t){
		titre = t;
	}
	public String toString(){
		String s = getAuteur() + " a écrit " + getTitre() + " qui a " + getNbPages() + " pages.";
		if (prix ==-1){
			s = s + " Prix inconnu.";
		}else{
			s = s + " Prix : " + prix;
		}
		return(s);
	}
	public boolean isPrixFixe(){
		return prixfixe;
	}
	public int compare(Livre L){
		if (this.nbPages == L.nbPages) {
			return 0;
		}else{
			if (this.nbPages > L.nbPages)
			{
				return 1;
			}
			else return -1;
		}
	}
	public int compare2(Livre L){
		if (this.nbPages > L.nbPages)
		{
			return(this.nbPages - L.nbPages);
		}
		else return(L.nbPages - this.nbPages);
	}
}//fin Livre
