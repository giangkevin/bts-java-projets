package tp6;

import java.util.ArrayList;

public class Librairie {
	ArrayList<Etagere> listeEtageres;
	
	public Librairie() {
		this.listeEtageres = new ArrayList<Etagere>();
	}
	
	public void ajouterLivres(Livre livre) throws EtagerePleineException {
		Etagere etagere = new Etagere(3);
		etagere.ajouterLivres(livre);
		System.out.println(etagere);
	}
}
