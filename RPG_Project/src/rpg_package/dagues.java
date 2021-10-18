package rpg_package;

public class dagues extends weapons {
	String typeDegats;
	
	dagues(String nom, int prix, int degats, String td){
		super(nom, type="dagues", prix, degats);
		this.typeDegats = td;
	}
}
