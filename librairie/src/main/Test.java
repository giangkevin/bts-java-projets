package main;

import java.util.ArrayList;

public class Test {
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		Livre a = new Livre("Voltaire","128",156);
		Livre b = new Livre("Baudelaire","185",157);
		Livre c = new Livre("Zola","test",122);
		Livre d = new Livre("Zola", "gtr");
		Livre e = new Livre("masashi","naruto",11);
		Etagere un = new Etagere(4);
		Etagere deux = new Etagere(5);
		
		try {
			un.ajouterLivres(a);
			un.ajouterLivres(b);
			un.ajouterLivres(c);
			un.ajouterLivres(d);
			un.ajouterLivres(e);
			
		}catch (EtagerePleineException s) {
			System.out.println(s.getMessage());
		}
		
		System.out.println(un);
		
		System.out.println("La position du livre est en " +un.chercher("Zola", "test"));
		
		ArrayList<Livre> listAuteur = un.chercherAuteurLivres("Zola");
		
		for(Livre livres : listAuteur) {
			System.out.println(livres);
		}
		
		System.out.println("Le livre " +un.enleverLivre(4) + " a été retiré");
		
		System.out.println(un);
		
	}
	
	
}
