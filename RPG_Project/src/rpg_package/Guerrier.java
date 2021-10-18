package rpg_package;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;



public class Guerrier extends Caste {
	String url = "./src/images/chat2.jpg";
	private ImageIcon imgIcon = new ImageIcon(url);
	JButton img = new JButton(imgIcon);
	private JButton image;

	Guerrier(String n, String t, int p) {
		super(n, t, p); 
		this.image = img;
	}
	
	

}
