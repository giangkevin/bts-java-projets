package tp4;

public class Test {

	public static void main(String[] args) {
		Neuve v1=new Neuve("123AZE93",10000);
		Neuve v2=new Neuve("986RTY93",15000);
		Neuve v3=new Neuve("4567UI75",12000);
		Neuve v4=new Neuve("3578PO93",16000);
		Neuve v5=new Neuve("9546NB93",20000);
		Occasion o1= new Occasion("9874IY94",45000,5000,2);
		Occasion o2= new Occasion("6548SD93",25000,7000,5);
		Occasion o3= new Occasion("1232DF94",35000,6000,4);
		Occasion o4= new Occasion("951EIY94",40000,6550,3);
		Option op1 = new Option(1,"Airbag",800);
		Option op2 = new Option(2,"Fermeture centralisée",900);
		Option op3 = new Option(3,"Climatisation",1500);
		Option op4 = new Option(4,"Toit ouvrant",700);
		Option op5 = new Option(5,"Alarme",1000);
		Garage unGarage=new Garage();
		unGarage.addVoiture(v1);
		unGarage.addVoiture(o2);
		unGarage.addVoiture(v3);
		unGarage.addVoiture(v4);
		unGarage.addVoiture(v5);
		unGarage.addVoiture(o1);
		unGarage.addVoiture(v2);
		unGarage.addVoiture(o3);
		unGarage.addVoiture(o4);
		unGarage.addOption(op1);
		unGarage.addOption(op2);
		unGarage.addOption(op3);

		unGarage.addOption(op4);
		unGarage.addOption(op5);
		
		
		System.out.println(unGarage);
		
	}

}
