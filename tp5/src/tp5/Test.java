package tp5;

import java.time.LocalDate;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		Emis emis = new Emis("0738297687", LocalDate.of(2023, 5, 14),10);
		Emis emis2 = new Emis("0602029912",LocalDate.of(2023, 5, 15),7);
		
		
		Emis emis3 = new Emis("0602029912",LocalDate.of(2023, 5, 18),19);
		Emis emis4 = new Emis("0618259815",LocalDate.of(2023, 5, 25),5);
		Emis emis5 = new Emis("0738297687",LocalDate.of(2023, 6, 2),55);
		
		
		
		Recu recu = new Recu("0738297687", LocalDate.of(2023, 5, 19),5);
		Recu recu2 = new Recu("0602029912",LocalDate.of(2023, 5, 25),15);
		Recu recu3 = new Recu("0618259815",LocalDate.of(2023, 5, 12),8);
		
		Contact emile = new Contact(1,"Emile","0738297687");
		Contact zola = new Contact(2,"Zola","0618259815");
		Contact liest = new Contact(3,"Liest","0602029912");
		
		
		
		Appareil app = new Appareil();
		
		app.enregistrerContact(zola);
		app.enregistrerContact(emile);
		app.enregistrerContact(liest);
		
		
		app.enregistrerAppel(emis);
		app.enregistrerAppel(emis);
		app.enregistrerAppel(emis2);
		app.enregistrerAppel(emis2);
		app.enregistrerAppel(emis3);
		
		app.enregistrerAppel(emis4);
		app.enregistrerAppel(emis5);
		
		app.enregistrerAppel(recu3);
		app.enregistrerAppel(recu2);
		app.enregistrerAppel(recu);
		
		
		app.consulterCoutAppelContact();
		app.consulterCoutTotalAppel();
		app.consulterContact("0738297687");
		app.consulterCoutAppelDates(LocalDate.of(2023, 5, 14), LocalDate.of(2023, 6, 2));
		
		
		
	}

}
