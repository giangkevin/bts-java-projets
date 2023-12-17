package tp5;

import java.time.LocalDate;


public class Emis extends Appel{
	public Emis(String numero, LocalDate date, int duree) {
		super(numero, date, duree);
		this.cout = 1;
		 
	}
	

	public String toString() {
		return super.toString() + "et cout total = " + this.getCout();
	}
}