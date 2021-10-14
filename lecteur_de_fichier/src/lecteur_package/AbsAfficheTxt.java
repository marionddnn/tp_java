package lecteur_package;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import javax.swing.JFileChooser;


public abstract class AbsAfficheTxt extends AfficheFichier implements LecteurFichier {
	protected String line;
	protected BufferedReader Lecteur;
	protected ArrayList<String> lignes;
	
	AbsAfficheTxt(int val, JFileChooser choix, String ligne, BufferedReader Lecteur, Fichier file) {
		super(file);
		this.line = ligne;
		this.Lecteur = Lecteur;
	}
	
	public void Ouvrir() { 
		
		try {
			this.Lecteur = new BufferedReader(new InputStreamReader(new FileInputStream(super.file.path), StandardCharsets.UTF_8));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
	
	public void Lire() {
		String ligne;
		this.lignes = new ArrayList<String>();
		 try {
				for (ligne = this.Lecteur.readLine(); ligne != null; ligne = this.Lecteur.readLine()) {
					this.lignes.add(ligne);
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
