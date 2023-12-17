package tp4;

import java.util.ArrayList;

public class Garage {
	private ArrayList<Option> collectionOption;
	private ArrayList<Voiture> collectionVoiture;
	
	public Garage(ArrayList<Voiture> collectionVoiture, ArrayList<Option> collectionOption) {
		this.collectionVoiture = collectionVoiture;
		this.collectionOption = collectionOption;
	}
	
	public Garage() {
		this.collectionVoiture = new ArrayList<>();
		this.collectionOption = new ArrayList<>();
	}
	
	public ArrayList<Voiture> getCollectionVoiture(){
		return this.collectionVoiture;
	}
	
	public ArrayList<Option> getCollectionOption(){
		return this.collectionOption;
	}
	
	public void addVoiture(Voiture v) {
		this.collectionVoiture.add(v);
	}
	
	public void addOption(Option o) {
		this.collectionOption.add(o);
	}
	
	public String afficherCollectVoiture() {
		
		if (!this.collectionVoiture.isEmpty()) {
			for(Voiture v : this.collectionVoiture) {
				return v.getNumero();
			}
		}
		
		return "";
	}
	
	public String afficherCollectOption() {
		if(!this.collectionOption.isEmpty()) {
			for (int i = 0; i < this.collectionOption.size(); i++) {
				return this.collectionOption.get(i).getLibelle();
			}
		}

		return null;
	}
	
	public String toString() {
		return "Garage \n[collectionVoiture=\n"+ afficherCollectVoiture()

		+ "]";
		}
}
