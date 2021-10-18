package rpg_package;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Sorcier extends Caste {
	String pouvoir;
	String url = "./src/images/chat1.jpg";
	private ImageIcon imgIcon = new ImageIcon(url);
	JButton img = new JButton(imgIcon);
	private JButton image;
	
	Sorcier(String n, String tA, int p, String po){
		super(n, tA, p);
		this.pouvoir = po;
	}
	
	
}
