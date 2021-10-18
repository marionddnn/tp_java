package rpg_package;


	public class griffes extends weapons {
		String typeDegats;
		griffes(String nom, int prix, int degats, String td){
			super(nom, type="griffes", prix, degats);
			this.typeDegats = td;
			
		}
		
		public String ascii_art() {
			return  
	"			 \n"+
	"          	\n"+
	"			 ________ 	\n"+
	"        ___//  (____{~>     \n"+
	"           ````(______{~>  \n"+
	"        ___````(_____{~>  \n"+
	"			\\__(___{~>  \n"+ 
	"_______________________________________________\\n";
	}
	
	}




