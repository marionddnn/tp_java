package rpg_package;
import java.util.ArrayList;
import java.util.Scanner;

public class weaponstore {
	ArrayList <weapons> armes = new ArrayList<weapons>();
	weaponstore(ArrayList<weapons> w){
		this.armes = w;
	}
	
	public void propose() {
		System.out.println("Quelle arme souhaitez vous acheter ?");
		for(int i=0; i< this.armes.size(); i++) {
			System.out.println(i + "/" + this.armes.get(i).nom + ":" + this.armes.get(i).prix + "pièces");
		}
		
	}
	
	
	public String setChoice() {
		Scanner sc = new Scanner(System.in);
		String choice = sc.nextLine();
		for(int i=0; i< this.armes.size(); i++) {
			weapons arme = this.armes.get(Integer.parseInt(choice));
			return arme.nom;
		}
		return "erreur";
	}

}
