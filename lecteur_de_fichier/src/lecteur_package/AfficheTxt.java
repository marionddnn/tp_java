package lecteur_package;

import java.io.BufferedReader;

import javax.swing.JFileChooser;

public class AfficheTxt extends AbsAfficheTxt implements LecteurFichier {

	AfficheTxt(int val, JFileChooser choix, String ligne, BufferedReader Lecteur, lecteur_package.Fichier fichier) {
		super(val, choix, ligne, Lecteur, fichier);
	}
	
	public void Afficher(fenetre fenetre){
		super.Ouvrir();
		super.Lire();
		fenetre.removeText();
		
		for(int i = 0; i < super.lignes.size(); i++) {
			String line = super.lignes.get(i);
			fenetre.addText(line);
		}
		
	
	}

}
