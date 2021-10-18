package rpg_package;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class rpg {

	



	public static void main (String[] args) {
		
		
		epee epee1 = new epee("morceau de bois", 1, 1, "normal");
		epee epee2 = new epee("ep�e de feu", 4, 3, "feu");
		epee epee3 = new epee("tr�s grande �p�e qui coupe presque tout", 10, 8, "normal");
		
		epee epee_longue1 = new epee("grande �p�e qui coupe bien", 6, 4, "normal");
		epee epee_longue2 = new epee("�p�e gel�e qui a une longue port�e", 8, 6, "givre");
		
		
		dagues dagues1 = new dagues("dagues qui ne font presque rien", 0, 1, "normal");
		dagues dagues2 = new dagues ("dagues coupantes et super utiles", 6, 0, "normal");
		dagues dagues3 = new dagues ("dagues design, coupe un peu", 5, 0, "normal");
		
		baton_de_sorcier baton_de_sorcier1= new baton_de_sorcier("baton de sorcier � pointe crochue", 2, 3, "normal");
		baton_de_sorcier baton_de_sorcier2 = new baton_de_sorcier("baton de sorcier qui lance des sorts glac�s", 4, 5, "givre");
		
		griffes griffes1 = new griffes("griffes us�es", 2, 3, "terre");
		griffes griffes2 = new griffes("griffes ac�r�es", 4, 5, "terre");
		griffes griffes3 = new griffes("griffes effrayantes", 10, 8, "normal");

		ArrayList<weapons> armestab = new ArrayList<weapons> (Arrays.asList(griffes1, griffes2, griffes3, epee1, epee2, epee3, epee_longue1, epee_longue2, dagues1,  dagues2, dagues3, baton_de_sorcier1, baton_de_sorcier2));

		weaponstore store = new weaponstore(armestab);
		System.out.println(store.armes);
		
		
		System.out.println("D�buter une partie");
		
		String choix1 = "A";
		String choix2 = "B";
		String choix3 = "C";
	    
	    
	    /// Choix personnage /////
	    
		System.out.println("Cr�er votre personnage");
		System.out.println("----------------------");
		System.out.println("Quel nom souhaitez vous lui donner ? ");
		Scanner sc = new Scanner(System.in);
		String nom = sc.nextLine(); 
		System.out.println("Choisissez une classe pour votre personnage");
		System.out.println("A. guerrier / B.voleur / C.sorcier");
		
		String c = sc.nextLine();
	
		String classe = c;
		
		heros heros;
		if(choix1.equals(c)) {
			heros = new heros(nom, "epee", new ArrayList<weapons>(), 170, "guerrier", 20);
		}
		else if(choix2.equals(c)) {
			heros = new heros(nom, "dagues", new ArrayList<weapons>(), 150, "voleur", 20);
		}
		else if(choix3.equals(c)) {
			heros = new heros(nom, "baton_de_sorcier", new ArrayList<weapons>(), 130, "sorcier", 20);
		}
		else {
			heros = null;
			System.out.println("test");
		}
		
		
		System.out.println("Vous avez cr�e votre personnage");
			

		  
		//////// Menu /////////
		
		
		String choice = null;
		while(choice == null || choix3.equals(choice) ) {
			System.out.println("Que souhaitez vous faire ?");
			
			System.out.println("A. Partir � l'aventure / B. Acheter des armes / C. Voir votre personnage");
		    
			
			choice = sc.nextLine();
		
		
		
		////// Aventure ///////
		
			if(choix1.equals(choice)) {
				System.out.println("Vous partez � l'aventure. Sur votre chemin, vous pensez � r�cup�rer un petit bout de bois �pais qui pourrait"
						+ "vous servir � vous d�fendre, au cas o�.");
				
				heros.addWeapon(epee1);
				
				Events Event1 = new Events();
				
				Event1.createEvents();
				Event1.SetNumberOfEvent();
				Event1.chooseEvent();
				Event1.printDescription();
				Event1.printChoice();
				choice = sc.nextLine();
				int number = Event1.setChoiceNumber(choice);
				
				if(Event1.verifyBattle(number)) {
					System.out.println("battle");
					Monstre monstre = Event1.returnMonstre();
					System.out.println(monstre.nom + " vous attaque !!");
					while(monstre.verifyPv() && heros.verifyPv()) {
					System.out.println("C'est votre tour :");
					System.out.println("Choisissez une arme :");
					int degat = heros.displayArmes();
					System.out.println("degats de cette arme : " + degat);
					monstre.beAttacked(degat);
					System.out.println(monstre.nom + " subit des d�gats : " + degat + ". Il lui reste en pv : " + monstre.pv);
					heros.BeAttacked(degat);
					System.out.println("Vous subissez des d�gats : " + degat + ". Il vous reste en pv : " + heros.pv);
					}
				}
				Event1.removeEvent();
			}
			
			
			
			
			
			else if(choix2.equals(choice)) {
				System.out.println("Magasin");
				store.propose();
				store.setChoice();
				
			}
			
			else if (choix3.equals(choice)) {
				System.out.println(heros.afficheNom());
				System.out.println(heros.afficheClasse());
			}
		}
	
	    
	   
		
		
		
		
		///// Aventure : �tape 2 ///////
		
		
		
		
		

		
	
		
		
		
		
		
		
		
		
	   }

	




	



	
	 
	}


