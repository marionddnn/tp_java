package rpg_package;

import java.util.ArrayList;
import java.util.Scanner;

public class heros extends Caste {
	int xp;
	int exp = 0;
	ArrayList<weapons> armes = new ArrayList<weapons>();
	private String classe;
	protected ArrayList<weapons> weapons;
	int money = 20;

	heros(String n, String t, ArrayList<weapons> armes, int p, String classe, int money) {
		super(n, t, p);
		this.xp = exp;
		this.weapons = armes;
		this.classe = classe;
		this.money = money;
	}
	
	void setClass(String classe){
		this.classe = classe;
	}
	
	void addXp(int xp) {
		this.exp += xp;
	}
	
	void loosePv(int attack) {
		this.pv = this.pv - attack;
	}
	
	void addMoney(int nbre) {
		this.money += nbre;
	}
	
	void looseMoney(int nbre) {
		this.money -= nbre;
	}

	public void addWeapon(weapons weapon) {
		this.weapons.add(weapon);
	}
	
	public String afficheNom() {
		return "Voici votre nom : " + this.nom;
	}

	public String afficheClasse() {
		return "Voici votre classe : " + this.classe;
		
	}

	public int displayArmes() {
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < this.weapons.size(); i++) {
			System.out.println(i + " / " + this.weapons.get(i).nom);
		}
		
		System.out.println("choix d'une arme");
		String nbarme = sc.nextLine();
		
		return SetDegats(nbarme);
	}

	int SetDegats(String nbarme) {
		return this.weapons.get(Integer.parseInt(nbarme)).degats;
	}
		
	public boolean verifyPv() {
		if(this.pv > 0) {
			return true;
		}
		else {
			return false;
		}
	}
		
		
	}
	
	
	
	
	
	


