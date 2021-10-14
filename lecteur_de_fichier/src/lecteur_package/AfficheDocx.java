package lecteur_package;

import java.io.BufferedReader;

import javax.swing.JFileChooser;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;



public class AfficheDocx extends AbsAfficheDocx implements LecteurFichier {

		
	AfficheDocx(int val, JFileChooser choix, BufferedReader Lecteur, Fichier file, XWPFDocument doc) {
		super(val, choix, Lecteur, file, doc);
	}

	public void Afficher(fenetre fenetre){
		super.Ouvrir();
		super.Lire();
		fenetre.removeText();
		
		 for (int i = 0 ; i < super.paragraphs.size(); i++) {
			 XWPFParagraph paragraph = super.paragraphs.get(i);
			 String line = paragraph.getText();
			 fenetre.addText(line);
		 }
		 
		
	}

}
