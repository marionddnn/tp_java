package rpg_package;

public class epee extends weapons {
	String typeDegats;
	epee(String nom, int prix, int degats, String td){
		super(nom, "epee", prix, degats);
		this.typeDegats = td;
		
	}
	
	public String ascii_art() {
		return  
"			_____ \n"+
"          	_____ \n"+
"         	|   |	\n"+
"           |   | \n"+
".__.       |   |______________________________________________\\n"+
"|  |_______|   | 	                                         	\\n"+ 
"|  |       |   |________________________________________________\\n"+
"|  |_______|   |                                                /\n"+
"|__|       |   |______________________________________________ /\n"+
"           |   |\n"+
"           |   |\n"+
"           |___|\n"+
"           _____\n";
	}
}
