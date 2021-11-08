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
		
		// Création monstres 
		
		Monstre n = new Monstre(0, "N", 0);
		Monstre Ombre = new Monstre(80, "ombre rapide", 4);
		Monstre chien = new Monstre(60, "chien méchant", 3);
		Monstre chat = new Monstre (50, "chat fourbe", 2);
		Monstre spectre = new Monstre(75, "étrange lumière", 6);
		Monstre forme_menaçante = new Monstre(70, "forme menaçante", 7);
		
		//création des évenements
		
		Event Event1 = new Event(
		"Vous arrivez devant une rivière. Le seul moyen de la traverser est un tronc d'arbre qui ne semble pas très stable.", 
		"Vous pouvez tenter de traverser la rivière ou bien longer la rive, ce qui rallongera votre périple.",
		"Vous tombez à l'eau et perdez 10pv",
		"Vous traverser fièrement le tronc d'arbre qui vous sépare de la rive grâce à votre agilité hors pair.",
		"Vous longez la rive sans rencontrer d'obstacles",
		"Traverser",
		"Longer la rive",
		 n,
		"0",
		"pv-2"
		);
		
		Event Event2 = new Event(
		"Vous êtes sur la route en pleine nuit, et vous entendez un léger craquement en direction d'un petit bois situé à votre gauche...",
		"Vous pouvez choisir d'aller voir la source du bruit ou bien continuer votre route",
		"Vous vous approchez de la source du bruit... Et vous apercevez qu'il s'agit d'un simple écureuil ! Vous trouvez un peu d'argent laissé sur le chemin.",
		"Vous entendez des pas qui se rapproche de vous... On vous attaque !",
		"Vous entendez des pas qui se rapprochent de vous... Et avez juste le temps de lancer un sort d'invisibilité avant de voir passer une ombre terrifiante.",
		"Aller voir",
		"Rester sur le chemin",
		Ombre,
		"3",
		"pièces-2"
		);
		
		Event Event3 = new Event(
		"En vous approchant du village ou vous devez faire escale, vous croisez un immense chien à trois tête qui garde les portes",
		"Il vous demande de lui donner votre arme la plus puissante, à cette seule condition il vous laissera passer",
		"Vous acceptez à contrecoeur et entrez dans le village sans rencontrer d'autre obstacle",
		"Vous sortez votre arme, prêt au combat, mais celui-ci fuit devant votre intimidation",
		"Vous donnez votre arme la moins puissante au chien, malheureusement pour vous, celui-ci flaire vos autres possession et comprend que vous l'avez dupé : il vous attaque",
		"Donner une arme",
		"Combattre",
		chien,
		"4",
		"arme-2"
		);
		
		Event Event4 = new Event(
		"Vous croisez un chat étrange, celui ci s'approche de vous et vous propose de jouer à pile ou face",
		"Face : vous gagnez 3 pièces. Pile : vous donnez une de vos armes",
		"Vous perdez mais refusez de payer, un peu plus loin, un complice du premier vous attaque pour tenter de vous voler vos pièces",
		"Vous vous apercevez de la supercherie : la pièce n'a pas de côté face, vous ne pouvez que perdre. Votre adversaire vous donne 3 pièces en échange de votre silence",
		"Vous refusez et poursuivez votre chemin",
		"Accepter",
		"Refuser",
		chat,
		"2",
		"pièces-2"
		);
		
		Event Event5 = new Event(
		"Il fait nuit et vous entrez dans une dense forêt, sans aucun repère pour trouver votre chemin. Vous êtes perdu-e.",
		"Vous pouvez tenter de revenir sur vos pas ou marcher vers une lumière que vous apercevez vers le nord",
		"La lumière semble venir d'une petite cabane, vous vous y reposez la nuit et gagnez 3 pièces. Vous retrouvez votre chemin.",
		"Vous arrivez à une petite cabane, cependant en descendant dans la cave de celle-ci une étrange lumière blanche vous attaque.",
		"Vous tentez de revenir sur vos pas mais vous vous perdez d'avantage, vous mettez plusieurs jours à retrouver votre chemin.",
		"Continuer",
		"Tenter de revenir",
		spectre,
		"3",
		"pièces-2"
		);
		
		
		Event Event6 = new Event(
		"Vous arrivez dans un grand jardin contenant des espèces de plantes et d'animaux qui vous sont inconnues",
		"Vous pouvez décidez de contourner le jardin en longeant le mur qui l'entoure depuis l'extérieur ou tenter d'explorer le jardin par l'est.",
		"Vous poursuivez votre chemin.",
		"Vous avez la désagréable sensation d'être suivi par quelque chose",
		"Vous trouvez une veste abandonnée qui s'est prise dans une branche d'un arbre, dans une des poches vous ramassez quelques pièces.",
		"contourner",
		"explorer",
		forme_menaçante,
		"2",
		"pièces-4"
		);
		
		
		// Créations armes
		
		epee epee1 = new epee("morceau de bois", 1, 1, "normal");
		epee epee2 = new epee("epée de feu", 4, 3, "feu");
		epee epee3 = new epee("très grande épée qui coupe presque tout", 10, 8, "normal");
		
		epee epee_longue1 = new epee("grande épée qui coupe bien", 6, 4, "normal");
		epee epee_longue2 = new epee("épée gelée qui a une longue portée", 8, 6, "givre");
		
		
		dagues dagues1 = new dagues("dagues qui ne font presque rien", 1, 2, "normal");
		dagues dagues2 = new dagues ("dagues coupantes et super utiles", 8, 8, "normal");
		dagues dagues3 = new dagues ("dagues design, coupe un peu", 3, 6, "normal");
		
		baton_de_sorcier baton_de_sorcier1= new baton_de_sorcier("baton de sorcier à pointe crochue", 2, 7, "normal");
		baton_de_sorcier baton_de_sorcier2 = new baton_de_sorcier("baton de sorcier qui lance des sorts glacés", 4, 12, "givre");

		ArrayList<weapons> armestab = new ArrayList<weapons> (Arrays.asList(epee1, epee2, epee3, epee_longue1, epee_longue2, dagues1,  dagues2, dagues3, baton_de_sorcier1, baton_de_sorcier2));

		weaponstore store = new weaponstore(armestab);
		
		
		System.out.println("				-------------------------------" +"\n"
						+  "				--->   Débuter une partie  <---" +"\n"
						+  "				-------------------------------" +"\n");
		
		
		String choix1 = "A";
		String choix2 = "B";
		String choix3 = "C";
	    
	    
	    /// Choix personnage /////
		
		System.out.println(" 	 ----------------------- ");
		System.out.println("	| Créer votre personnage |");
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
		System.out.println("	| Vous avez crée votre personnage |");
		System.out.println("	 -------------------------------- "+"\n");
			

		  
		//////// Menu /////////
		
		
		String choice = null;
		while(choice == null || choix3.equals(choice) ) {
		
		
		////// Aventure ///////
			
			ArrayList<Event> events = new ArrayList<Event>(Arrays.asList(Event1, Event2, Event3, Event4, Event5, Event6));
			Events ListeEvents = new Events(events);
			heros.addWeapon(epee1);
			
			System.out.println("Vous êtes en voyage très loin de chez vous, et pour pouvoir rentrer, vous entamez un périple qui pourrait "  +"\n"
					+ "s'avérer assez dangereux. Afin de pouvoir vous défendre contre d'éventuels danger, vous ramassez sur votre chemin "  +"\n"
					+ "un morceau de bois épais que vous taillez à la hâte pour vous servir d'arme en cas d'attaque. Votre aventure commence ici." +"\n");
		
			while(ListeEvents.verifyEvents() && heros.VerifyTurn()) {
				
				System.out.println("\n" + "°°°°°° Que souhaitez vous faire ? °°°°°°" +"\n");
				
				System.out.println("A. Partir à l'aventure / B. Acheter des armes dans la ville la plus proche / C. Voir votre personnage");
			   
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
							System.out.println(monstre.nom + " subit des dégats : " + degat + ". Il lui reste en pv : " + monstre.pv);
							heros.BeAttacked(monstre.degats());
							System.out.println("Vous subissez des dégats : " + monstre.degats() + ". Il vous reste en pv : " + heros.pv);
						}
						if(heros.verifyPv()) {
							System.out.println("Vous avez battu le monstre et poursuivez votre chemin, en espérant arriver bientôt à votre destination." +"\n");
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
						else if(CurrentEvent.verifyEvent(number) == "pièces") {
							heros.addMoney(3);
							System.out.println("Vous avez gagné 3 pièces, total de pièces :" + heros.money + "pièces." +"\n");
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
						System.out.println("Il vous reste :" + heros.money + "pièces.");
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
			System.out.println(" ||-||  Vous êtes arrivé à destination sain et sauf, vous avez gagné !!");
			System.out.println(" °°°°° " + "\n");
			
		}
		
		
	   }

	




	



	
	 
	}


