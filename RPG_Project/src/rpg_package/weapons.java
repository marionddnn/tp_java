package rpg_package;

public class weapons {
	public String nom;
	String type;
	public int degats;
	public int prix;
	
	weapons(String a, String b, int c, int d) {
		this.nom = a;
		this.type = b;
		this.degats = c;
		this.prix = d;
	} 
	
	boolean compareType(String type){
		if(this.type == type) {
			
			return true;
		}
		else {
			return false;
		}
	}

	public int returnprice() {
		int price = this.prix;
		return price;
	}

	

}
