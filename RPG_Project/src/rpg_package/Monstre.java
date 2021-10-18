package rpg_package;

public class Monstre extends destructible{
	String nom;
	int attack;
	
	Monstre(int p, String n, int a) {
		super(p);
		this.nom = n;
		this.attack = a;
	}
	
	
	
	public boolean verifyPv() {
		if(this.pv > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public void beAttacked(int degats) {
		this.pv -= degats;
		
	}
	
	public void init() {
		System.out.println(this.nom + " vous attaque !!");
	}
}
