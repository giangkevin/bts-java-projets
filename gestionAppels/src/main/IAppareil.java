package main;

import java.time.LocalDate;


public interface IAppareil{
	void consulterContact(String numero);
	void enregistrerAppel(Appel a);
	void enregistrerContact(Contact c);
	void consulterCoutAppelDates(LocalDate date1, LocalDate date2);
	void consulterCoutTotalAppel();
	void consulterCoutAppelContact();
}