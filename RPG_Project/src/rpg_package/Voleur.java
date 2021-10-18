package rpg_package;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Voleur extends Caste {
	String url = "./src/images/chat3.jpg";
	private ImageIcon imgIcon = new ImageIcon(url);
	JButton img = new JButton(imgIcon);
	private JButton image;

	Voleur(String n, String t, int p) {
		
		super(n, t, p);
	}
	

}
