package rpg_package;

public class baton_de_sorcier extends weapons {
	String typeDegats;
	baton_de_sorcier(String nom, int prix, int degats, String td){
		super(nom, "baton_de_sorcier", prix, degats);
		this.typeDegats = td;
	}
}
