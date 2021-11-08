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
	private int turn = 0;

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
	
	public void afficheNom() {
		System.out.println("Voici votre nom : " + this.nom);
	}

	public void afficheClasse() {
		System.out.println("Voici votre classe : " + this.classe);
		
	}
	
	public void afficheArmes() {
		System.out.println("Voici la liste de vos armes : ");
		for(int i = 0; i < this.weapons.size(); i++) {
			System.out.println(i + " / " + this.weapons.get(i).nom);
		}
	}

	public int displayArmes() {
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < this.weapons.size(); i++) {
			System.out.println(i + " / " + this.weapons.get(i).nom);
		}
		
		String nbarme = sc.nextLine();
		
		return SetDegats(nbarme);
	}

	int SetDegats(String nbarme) {
		weapons armeChoisie = this.weapons.get(Integer.parseInt(nbarme));
		boolean condition = armeChoisie.compareType(this.typeArme);
		if(condition) {
			return armeChoisie.degats * 2;
		}
		else {
			return armeChoisie.degats;
		}
	}
		
	public boolean verifyPv() {
		if(this.pv > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean buyWeapon(int price) {
		if(this.money >= price) {
			return true;
		}
		else {
			return false;
		}
	}

	public void addTurn() {
		this.turn ++;
	}	
	
	public boolean VerifyTurn() {
		if(this.turn < 5) {
			return true;
		}
		else {
			return false;
		}
	}

	public void afficheMoney() {
		System.out.println("Voici votre argent : " + this.money);
		
	}
}
	
	
	
	
	
	


