package Bataille;

import java.util.ArrayList;
import java.util.Scanner;


public class Bataille {
	
	public static void main (String[] args) {
		PaquetCartes paquetCarte = new PaquetCartes();
		paquetCarte.creerPaquet();
			
			ArrayList <Carte> paquetJeu = new ArrayList<Carte>(); 
			Deck DeckJoueur1 = new Deck(paquetJeu);
			ArrayList <Carte> paquetJeu2 = new ArrayList<Carte>(); 
			Deck DeckJoueur2 = new Deck(paquetJeu2);
			ArrayList <Carte> pile = new ArrayList<Carte>();
			
			paquetCarte.setDecks(DeckJoueur1, DeckJoueur2);
		
			Scanner sc = new Scanner(System.in);
			System.out.println("Entrez un nom de joueur 1");
			String nom1 = sc.nextLine();
			System.out.println("Entrez un nom de joueur 2");
			String nom2 = sc.nextLine();
			
			Joueur Joueur1 = new Joueur(nom1, DeckJoueur1);
			Joueur Joueur2 = new Joueur(nom2, DeckJoueur2);
			int tour = 0;
			
			while(Joueur1.deck.getNumberOfCards() > 0 && Joueur2.deck.getNumberOfCards() > 0){
			System.out.println("tour : "+ tour);
			tour++;
						
			Joueur1.pioche();
			var j1Carte = Joueur1.deck.getFirstCard();
			Joueur1.AnnonceCarte(j1Carte);
			
			Joueur2.pioche();
			var j2Carte = Joueur2.deck.getFirstCard();
			Joueur2.AnnonceCarte(j2Carte);
			
			int pileOrder = (int) Math.round(1*Math.random());
					
			if(pileOrder == 1) {
				pile.add(j1Carte);
				pile.add(j2Carte);
			}
			else {
				pile.add(j2Carte);
				pile.add(j1Carte);
			}
			
			Joueur1.deck.removeCard(j1Carte);
			Joueur2.deck.removeCard(j2Carte);
			
			if(j1Carte.value > j2Carte.value) {
				if(Joueur1.deck.getNumberOfCards() >= 1 && Joueur2.deck.getNumberOfCards() >= 1) {
					System.out.println("pile :" + pile.size());
					Joueur1.deck.addAll(pile);
					pile.clear();
					Joueur1.afficheGagnantManche();
					System.out.println("Cartes restantes au joueur 1 :" + Joueur1.deck.getNumberOfCards());
					System.out.println("Cartes restantes au joueur 2 :" + Joueur2.deck.getNumberOfCards());
				}
			
			}
			else if (j2Carte.value > j1Carte.value) {
				System.out.println("pile :" + pile.size());
				Joueur2.deck.addAll(pile);
				pile.clear();
				Joueur2.afficheGagnantManche();
				System.out.println("Carte restante au joueur 1 :" + Joueur1.deck.getNumberOfCards());
				System.out.println("Carte restante au joueur 2 :" + Joueur2.deck.getNumberOfCards());
				
			}
			else {
				System.out.println("Bataille !");
				boolean testJ1 = Joueur1.verifyNbCards();
				boolean testJ2 = Joueur2.verifyNbCards();
				if(testJ1 && testJ2){
					pile.add(Joueur2.deck.getFirstCard());
					pile.add(Joueur1.deck.getFirstCard());
					Joueur1.deck.removeCard(Joueur1.deck.getFirstCard());
					Joueur2.deck.removeCard(Joueur2.deck.getFirstCard());
					System.out.println("Chaque joueur pose une seconde carte face cachée et en pioche une troisième");
				}

			}
		}
	
		if(Joueur1.verifyNbCards() == true) {
			Joueur1.afficheGagnant();
		}
		else {
			Joueur2.afficheGagnant();
			}
		}
}
