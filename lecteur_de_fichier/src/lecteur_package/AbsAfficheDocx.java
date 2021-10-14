package lecteur_package;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;


public abstract class AbsAfficheDocx extends AfficheFichier implements LecteurFichier {
	BufferedReader Lecteur = null;
	String ligne;
	XWPFDocument document;
	ArrayList<XWPFParagraph> paragraphs;
	
	AbsAfficheDocx(int val, JFileChooser choix, BufferedReader Lecteur, Fichier file, XWPFDocument doc) {
	super(file);
	this.Lecteur = Lecteur;
	this.document = doc;
	}
	
	public void Ouvrir() {
		
		 try {
				FileInputStream InputStreamF = new FileInputStream(super.file.path);
				 this.document = new XWPFDocument(InputStreamF);
				 
				
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public void Lire() {
		
		this.paragraphs = new ArrayList<XWPFParagraph>(this.document.getParagraphs());
	}
	
}
