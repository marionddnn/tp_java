package rpg_package;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Sorcier extends Caste {
	String pouvoir;
	
	Sorcier(String n, String tA, int p, String po){
		super(n, tA, p);
		this.pouvoir = po;
	}
	
	
}
