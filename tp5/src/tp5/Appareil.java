package tp5;
import java.util.Scanner;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;


public class Appareil implements IAppareil {
	private ArrayList<Contact> listeContact;
	private ArrayList<Appel> listeAppel;
	
	
	public Appareil() {
		this.listeContact = new ArrayList<>();
		this.listeAppel = new ArrayList<>();
	}



	@Override
	public void consulterContact(String numero) {
		for (Contact contacts : this.listeContact) {
			if(numero.equals(contacts.getNumeroTelephone())) {
				System.out.println("Le contact avec le numéro : "+numero + " est " +contacts.getNom());
			}
		}
		
	}

	public void enregistrerContact(Contact c ) {
		this.listeContact.add(c);
	}
	@Override
	public void enregistrerAppel(Appel a) {
		this.listeAppel.add(a);
		
	}


	@Override
	public void consulterCoutTotalAppel() {
		int coutTotal = 0;
		for (Appel appels : this.listeAppel) {
			coutTotal += appels.getCout();
			
		}
		System.out.println("Le cout total pour chaque appel est de " +coutTotal+ " euros");
	}



	@Override
	public void consulterCoutAppelDates(LocalDate date1, LocalDate date2) {
		int coutTotal = 0;
		for (Appel appels : this.listeAppel) {
			if(appels.getDate().isAfter(date1) && appels.getDate().isBefore(date2)) {
				coutTotal += appels.getCout();
			}
			
			
		}
		System.out.println("Le cout d'appel entre " + date1 + " et " + date2 + " est de " +coutTotal +  " euros");
	}



	@Override
	public void consulterCoutAppelContact() {
		// TODO Auto-generated method stub
		System.out.println("Veuillez rentrez le numéro d'un contact");
		Scanner scanner = new Scanner(System.in);
		int cout = 0;
		String input = scanner.nextLine();
		
		for(Appel appels : this.listeAppel) {
			if(appels.getNumero().equals(input)) {
				cout += appels.getCout();
			}
		}
		System.out.println("Le cout total pour ce correspondant est de " +cout + " euros");
	}
}