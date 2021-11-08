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
		
		// Cr�ation monstres 
		
		Monstre n = new Monstre(0, "N", 0);
		Monstre Ombre = new Monstre(80, "ombre rapide", 4);
		Monstre chien = new Monstre(60, "chien m�chant", 3);
		Monstre chat = new Monstre (50, "chat fourbe", 2);
		Monstre spectre = new Monstre(75, "�trange lumi�re", 6);
		Monstre forme_mena�ante = new Monstre(70, "forme mena�ante", 7);
		
		//cr�ation des �venements
		
		Event Event1 = new Event(
		"Vous arrivez devant une rivi�re. Le seul moyen de la traverser est un tronc d'arbre qui ne semble pas tr�s stable.", 
		"Vous pouvez tenter de traverser la rivi�re ou bien longer la rive, ce qui rallongera votre p�riple.",
		"Vous tombez � l'eau et perdez 10pv",
		"Vous traverser fi�rement le tronc d'arbre qui vous s�pare de la rive gr�ce � votre agilit� hors pair.",
		"Vous longez la rive sans rencontrer d'obstacles",
		"Traverser",
		"Longer la rive",
		 n,
		"0",
		"pv-2"
		);
		
		Event Event2 = new Event(
		"Vous �tes sur la route en pleine nuit, et vous entendez un l�ger craquement en direction d'un petit bois situ� � votre gauche...",
		"Vous pouvez choisir d'aller voir la source du bruit ou bien continuer votre route",
		"Vous vous approchez de la source du bruit... Et vous apercevez qu'il s'agit d'un simple �cureuil ! Vous trouvez un peu d'argent laiss� sur le chemin.",
		"Vous entendez des pas qui se rapproche de vous... On vous attaque !",
		"Vous entendez des pas qui se rapprochent de vous... Et avez juste le temps de lancer un sort d'invisibilit� avant de voir passer une ombre terrifiante.",
		"Aller voir",
		"Rester sur le chemin",
		Ombre,
		"3",
		"pi�ces-2"
		);
		
		Event Event3 = new Event(
		"En vous approchant du village ou vous devez faire escale, vous croisez un immense chien � trois t�te qui garde les portes",
		"Il vous demande de lui donner votre arme la plus puissante, � cette seule condition il vous laissera passer",
		"Vous acceptez � contrecoeur et entrez dans le village sans rencontrer d'autre obstacle",
		"Vous sortez votre arme, pr�t au combat, mais celui-ci fuit devant votre intimidation",
		"Vous donnez votre arme la moins puissante au chien, malheureusement pour vous, celui-ci flaire vos autres possession et comprend que vous l'avez dup� : il vous attaque",
		"Donner une arme",
		"Combattre",
		chien,
		"4",
		"arme-2"
		);
		
		Event Event4 = new Event(
		"Vous croisez un chat �trange, celui ci s'approche de vous et vous propose de jouer � pile ou face",
		"Face : vous gagnez 3 pi�ces. Pile : vous donnez une de vos armes",
		"Vous perdez mais refusez de payer, un peu plus loin, un complice du premier vous attaque pour tenter de vous voler vos pi�ces",
		"Vous vous apercevez de la supercherie : la pi�ce n'a pas de c�t� face, vous ne pouvez que perdre. Votre adversaire vous donne 3 pi�ces en �change de votre silence",
		"Vous refusez et poursuivez votre chemin",
		"Accepter",
		"Refuser",
		chat,
		"2",
		"pi�ces-2"
		);
		
		Event Event5 = new Event(
		"Il fait nuit et vous entrez dans une dense for�t, sans aucun rep�re pour trouver votre chemin. Vous �tes perdu-e.",
		"Vous pouvez tenter de revenir sur vos pas ou marcher vers une lumi�re que vous apercevez vers le nord",
		"La lumi�re semble venir d'une petite cabane, vous vous y reposez la nuit et gagnez 3 pi�ces. Vous retrouvez votre chemin.",
		"Vous arrivez � une petite cabane, cependant en descendant dans la cave de celle-ci une �trange lumi�re blanche vous attaque.",
		"Vous tentez de revenir sur vos pas mais vous vous perdez d'avantage, vous mettez plusieurs jours � retrouver votre chemin.",
		"Continuer",
		"Tenter de revenir",
		spectre,
		"3",
		"pi�ces-2"
		);
		
		
		Event Event6 = new Event(
		"Vous arrivez dans un grand jardin contenant des esp�ces de plantes et d'animaux qui vous sont inconnues",
		"Vous pouvez d�cidez de contourner le jardin en longeant le mur qui l'entoure depuis l'ext�rieur ou tenter d'explorer le jardin par l'est.",
		"Vous poursuivez votre chemin.",
		"Vous avez la d�sagr�able sensation d'�tre suivi par quelque chose",
		"Vous trouvez une veste abandonn�e qui s'est prise dans une branche d'un arbre, dans une des poches vous ramassez quelques pi�ces.",
		"contourner",
		"explorer",
		forme_mena�ante,
		"2",
		"pi�ces-4"
		);
		
		
		// Cr�ations armes
		
		epee epee1 = new epee("morceau de bois", 1, 1, "normal");
		epee epee2 = new epee("ep�e de feu", 4, 3, "feu");
		epee epee3 = new epee("tr�s grande �p�e qui coupe presque tout", 10, 8, "normal");
		
		epee epee_longue1 = new epee("grande �p�e qui coupe bien", 6, 4, "normal");
		epee epee_longue2 = new epee("�p�e gel�e qui a une longue port�e", 8, 6, "givre");
		
		
		dagues dagues1 = new dagues("dagues qui ne font presque rien", 1, 2, "normal");
		dagues dagues2 = new dagues ("dagues coupantes et super utiles", 8, 8, "normal");
		dagues dagues3 = new dagues ("dagues design, coupe un peu", 3, 6, "normal");
		
		baton_de_sorcier baton_de_sorcier1= new baton_de_sorcier("baton de sorcier � pointe crochue", 2, 7, "normal");
		baton_de_sorcier baton_de_sorcier2 = new baton_de_sorcier("baton de sorcier qui lance des sorts glac�s", 4, 12, "givre");

		ArrayList<weapons> armestab = new ArrayList<weapons> (Arrays.asList(epee1, epee2, epee3, epee_longue1, epee_longue2, dagues1,  dagues2, dagues3, baton_de_sorcier1, baton_de_sorcier2));

		weaponstore store = new weaponstore(armestab);
		
		
		System.out.println("				-------------------------------" +"\n"
						+  "				--->   D�buter une partie  <---" +"\n"
						+  "				-------------------------------" +"\n");
		
		
		String choix1 = "A";
		String choix2 = "B";
		String choix3 = "C";
	    
	    
	    /// Choix personnage /////
		
		System.out.println(" 	 ----------------------- ");
		System.out.println("	| Cr�er votre personnage |");
		System.out.println(" 	 ----------------------- ");
		System.out.println("Quel nom souhaitez vous lui donner ? ");
		Scanner sc = new Scanner(System.in);
		String nom = sc.nextLine(); 
		System.out.println("Choisissez une classe pour votre personnage");
		System.out.println("A. guerrier / B.voleur / C.sorcier");
		
		String c = sc.nextLine();
	
		String classe = c;
		Guerrier guerrier = new Guerrier("guerrier", "epee", 150);
		Voleur voleur = new Voleur("voleur", "dagues", 120);
		Sorcier sorcier = new Sorcier("sorcier", "baton_de_sorcier", 100, "feu");
		
		heros heros;
		if(choix1.equals(c)) {
			heros = new heros(nom, guerrier.typeArme, new ArrayList<weapons>(), guerrier.pv, guerrier.nom, 1);
		}
		else if(choix2.equals(c)) {
			heros = new heros(nom, voleur.typeArme, new ArrayList<weapons>(), voleur.pv, voleur.nom, 4);
		}
		else if(choix3.equals(c)) {
			heros = new heros(nom, sorcier.typeArme, new ArrayList<weapons>(), sorcier.pv, sorcier.nom, 1);
		}
		else {
			heros = null;
			System.out.println("erreur");
		}
		
		System.out.println(" 	 -------------------------------- ");
		System.out.println("	| Vous avez cr�e votre personnage |");
		System.out.println("	 -------------------------------- "+"\n");
			

		  
		//////// Menu /////////
		
		
		String choice = null;
		while(choice == null || choix3.equals(choice) ) {
		
		
		////// Aventure ///////
			
			ArrayList<Event> events = new ArrayList<Event>(Arrays.asList(Event1, Event2, Event3, Event4, Event5, Event6));
			Events ListeEvents = new Events(events);
			heros.addWeapon(epee1);
			
			System.out.println("Vous �tes en voyage tr�s loin de chez vous, et pour pouvoir rentrer, vous entamez un p�riple qui pourrait "  +"\n"
					+ "s'av�rer assez dangereux. Afin de pouvoir vous d�fendre contre d'�ventuels danger, vous ramassez sur votre chemin "  +"\n"
					+ "un morceau de bois �pais que vous taillez � la h�te pour vous servir d'arme en cas d'attaque. Votre aventure commence ici." +"\n");
		
			while(ListeEvents.verifyEvents() && heros.VerifyTurn()) {
				
				System.out.println("\n" + "������ Que souhaitez vous faire ? ������" +"\n");
				
				System.out.println("A. Partir � l'aventure / B. Acheter des armes dans la ville la plus proche / C. Voir votre personnage");
			   
				choice = sc.nextLine();
			
				if(choix1.equals(choice)) {
				
					ListeEvents.SetNumberOfEvent();
					Event CurrentEvent = ListeEvents.chooseEvent();
					CurrentEvent.printDescription();
					CurrentEvent.printChoice();
					choice = sc.nextLine();
					
					int number = CurrentEvent.setChoiceNumber(choice);
				
					if(CurrentEvent.verifyBattle(number)) {
						Monstre monstre = CurrentEvent.returnMonstre();
						System.out.println(monstre.nom + " vous attaque !!" +"\n");
						while(monstre.verifyPv() && heros.verifyPv()) {
							System.out.println("\n" + " -----> C'est votre tour :" +"\n");
							System.out.println("Choisissez une arme :" +"\n");
							int degat = heros.displayArmes();
							System.out.println("degats de cette arme : " + degat);
							monstre.beAttacked(degat);
							System.out.println(monstre.nom + " subit des d�gats : " + degat + ". Il lui reste en pv : " + monstre.pv);
							heros.BeAttacked(monstre.degats());
							System.out.println("Vous subissez des d�gats : " + monstre.degats() + ". Il vous reste en pv : " + heros.pv);
						}
						if(heros.verifyPv()) {
							System.out.println("Vous avez battu le monstre et poursuivez votre chemin, en esp�rant arriver bient�t � votre destination." +"\n");
						}
						else {
							System.out.println("\n" + "Vous avez perdu !!");
							System.exit(0);
						}
					}
					else if(CurrentEvent.verifyEvent(number) != null) {
						if(CurrentEvent.verifyEvent(number) == "pv") {
							heros.loosePv(10);
							System.out.println("Vous avez perdu 10 pv, il vous reste : " + heros.pv + " pv." +"\n");
							
						}
						else if(CurrentEvent.verifyEvent(number) == "pi�ces") {
							heros.addMoney(3);
							System.out.println("Vous avez gagn� 3 pi�ces, total de pi�ces :" + heros.money + "pi�ces." +"\n");
						}
						else if(CurrentEvent.verifyEvent(number) == "armes") {
							//
						}
					}
				
					ListeEvents.removeEvent(CurrentEvent);
					heros.addTurn();
				}
			
				else if(choix2.equals(choice)) {
					System.out.println("Bienvenue au magasin !");
					store.propose();
					weapons achat = store.setChoice();
					int price = achat.returnprice();
					if (heros.buyWeapon(price)) {
						heros.addWeapon(achat);
						heros.looseMoney(price);
						store.buy(achat);
						System.out.println("Il vous reste :" + heros.money + "pi�ces.");
					}
					else {
						System.out.println("Vous ne pouvez pas acheter cette arme car vous n'avez pas assez d'argent" +"\n");
					}
				}
			
				else if (choix3.equals(choice)) {
					heros.afficheNom();
					heros.afficheClasse();
					heros.afficheArmes();
					heros.afficheMoney();
				}
				
			}
			System.out.println("   ^   ");
			System.out.println(" //_\\\\");
			System.out.println(" ||-||  Vous �tes arriv� � destination sain et sauf, vous avez gagn� !!");
			System.out.println(" ����� " + "\n");
			
		}
		
		
	   }

	




	



	
	 
	}


