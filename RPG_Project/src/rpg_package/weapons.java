package rpg_package;

public class weapons {
	public String nom;
	public static String type;
	public int degats;
	public int prix;
	
	weapons(String a, String b, int c, int d) {
		this.nom = a;
		weapons.type = b;
		this.degats = c;
		this.prix = d;
	} 

}
