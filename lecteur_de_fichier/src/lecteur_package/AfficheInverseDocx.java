package lecteur_package;

import java.io.BufferedReader;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

public class AfficheInverseDocx extends AbsAfficheDocx {
	
	String s;

	AfficheInverseDocx(int val, JFileChooser choix, BufferedReader Lecteur, Fichier file, XWPFDocument doc) {
		super(val, choix, Lecteur, file, doc);
	}
	
	public void Afficher(fenetre fenetre) {
		super.Ouvrir();
		super.Lire();
		fenetre.removeText();
		
		
		for (int i = 0 ; i < super.paragraphs.size(); i++) 
		{
			XWPFParagraph paragraph = super.paragraphs.get(i);
			String line = paragraph.getText();
			
			ArrayList<Character> chars = new ArrayList<Character>();
			char[] c = new char[line.length()];
			
			for(int j = line.length() - 1; j >= 0 ; j-- ) {
				
				char ch = line.charAt(j);
				chars.add(ch);
				int index = chars.size() - 1;
				c[index] = chars.get(index);
				this.s = String.valueOf(c);
			}
			
			if(line != "") {
				fenetre.addText(this.s);
				
			}
		
		 }
	}

}
