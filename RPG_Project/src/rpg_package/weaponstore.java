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
			System.out.println(i + "/" + this.armes.get(i).nom + ":" + this.armes.get(i).prix + "pi�ces");
		}
		
	}
	
	
	public weapons setChoice() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Quelle arme choisissez-vous ?");
		String choice = sc.nextLine();
		for(int i=0; i< this.armes.size(); i++) {
			weapons arme = this.armes.get(Integer.parseInt(choice));
			return arme;
		}
		return null;
	}

	public void buy(weapons achat) {
		this.armes.remove(achat);
		System.out.println("Vous avez achet� cette arme :" + achat.nom + "   ");
	}

}
