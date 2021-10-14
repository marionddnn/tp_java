package lecteur_package;

import java.io.BufferedReader;
import java.util.ArrayList;

import javax.swing.JFileChooser;

public class AffichePalindromeTxt extends AbsAfficheTxt {
	protected String s;

	AffichePalindromeTxt(int val, JFileChooser choix, String ligne, BufferedReader Lecteur, Fichier file) {
		super(val, choix, ligne, Lecteur, file);
	}

	
	public void Afficher(fenetre fenetre) {
		super.Ouvrir();
		super.Lire();
		fenetre.removeText();
		
		for(int i = 0; i < super.lignes.size(); i++) {
			
			line = super.lignes.get(i);
			ArrayList<Character> chars = new ArrayList<Character>();
			char[] c = new char[line.length()];
			
			for(int j = line.length() - 1; j >= 0 ; j-- ) {
				char ch = line.charAt(j);
				chars.add(ch);
				int index = chars.size() - 1;
				c[index] = chars.get(index);
				this.s = String.valueOf(c);
			}
			
			fenetre.addText(line + this.s);
		}
		
	}

}
	
	
	
