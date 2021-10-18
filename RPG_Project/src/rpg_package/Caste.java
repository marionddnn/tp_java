package rpg_package;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public abstract class Caste {
	String nom;
	String typeArme;
	int pv;
	private ImageIcon image;
	private String url;
	
	
	Caste(String n, String t, int p){
		this.nom = n;
		this.typeArme = t;
		this.pv = p;
	}
	
	void setName(String n){
		this.nom = n;
	}
	
	void BeAttacked(int attack){
		this.pv = this.pv - attack;
		System.out.println("vous avez été attaqué, nbre de pv restants : " + this.pv);
	}
	 
	
	
}
