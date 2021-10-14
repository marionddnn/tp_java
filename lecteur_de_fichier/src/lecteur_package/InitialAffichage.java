package lecteur_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;

public class InitialAffichage {
	protected static String choix;
	protected JFileChooser choice =  new JFileChooser();
	protected int value = choice.showOpenDialog(choice);
	protected String path = choice.getSelectedFile().getPath();
	protected String name = choice.getSelectedFile().getName();
	protected String ext = choice.getTypeDescription(choice.getSelectedFile());
	
	private fenetre fenetre = new fenetre();
	
	public void propose() {
		JButton button1 = new JButton("Afficher");
		createAlert(button1);
		fenetre.addButton(button1);
		JButton button2 = new JButton("Afficher inverse");
		createAlert(button2);
		fenetre.addButton(button2);
		JButton button3 = new JButton("Afficher palindrome");
		createAlert(button3);
		fenetre.addButton(button3);
		fenetre.addToolbar();
		fenetre.voirFenetre();
		
	}
	
	public void createAlert(JButton button) {
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		      InitialAffichage.choix = button.getText();
		      switch(ext) {
				case "Document texte" : 
					ChoisirTxt(InitialAffichage.choix);
				break;
				case "Document Microsoft Word" : 
					ChoisirDocx(InitialAffichage.choix);
				break;
			}  
		      
		    }
		});
	}
	
	public void ChoisirTxt(String choix) {
		 switch(choix) {
			case "Afficher" : 
			AffichageTxt();
			break;
			case "Afficher inverse" : 
			AffichageInvTxt();
			break;
			case "Afficher palindrome" : 
			AffichagePalTxt();
			}
	}
	
	public void AffichageTxt() {
		AfficheTxt affiche = new AfficheTxt(value, choice, ext, null, null);
		affiche.setFile(name, path);
		affiche.Afficher(fenetre);
	}
	
	public void AffichageInvTxt() {
		AfficheInverseTxt afficheInv = new AfficheInverseTxt(value, choice, ext, null, null);
		afficheInv.setFile(name, path);
		afficheInv.Afficher(fenetre);
	}
	
	public void AffichagePalTxt() {
		AffichePalindromeTxt affichePal = new AffichePalindromeTxt(value, choice, ext, null, null);
		affichePal.setFile(name, path);
		affichePal.Afficher(fenetre);
	}
	
	public void ChoisirDocx(String choix) {
		switch(choix) {
		case "Afficher" : 
			AffichageDocx();
		break;
		case "Afficher inverse" : 
			AffichageInvDocx();
		break;
		case "Afficher palindrome" : 
			AffichagePalDocx();
		break;
		}
	}
	
	public void AffichageDocx() {
		AfficheDocx affiche = new AfficheDocx(value, choice, null, null, null);
		affiche.setFile(name, path);
		affiche.Afficher(fenetre);
	}
	
	public void AffichageInvDocx() {
		AfficheInverseDocx afficheInv = new AfficheInverseDocx(value, choice, null, null, null);
		afficheInv.setFile(name, path);
		afficheInv.Afficher(fenetre);
	}
	
	public void AffichagePalDocx() {
		AffichePalindromeDocx affiche = new AffichePalindromeDocx(value, choice, null, null, null);
		affiche.setFile(name, path);
		affiche.Afficher(fenetre);
	}
	
	
	
}
