package Bataille;

import java.util.ArrayList;

public class Joueur {
	Deck deck;
	String nom;
	
	Joueur(String nomJoueur, Deck Deck) {
		this.nom = nomJoueur;
		this.deck = Deck;
	}
	
	void pioche() {
		System.out.println("-----------------------------------------");
		System.out.println(this.nom + " pioche une carte");
	}
	
	void afficheGagnantManche() {
		System.out.println("-----------------------------------------------------");
		System.out.println(this.nom + " gagne cette manche et remporte les cartes");
		System.out.println("-----------------------------------------------------");
	}
	
	void afficheGagnant(){
		System.out.println("");
		System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
		System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
		System.out.println("            "+ this.nom + " a gagné !!!   		  ");
		System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
		System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
	}
	
	boolean verifyNbCards(){
		if(this.deck.getNumberOfCards() <= 0 ) {
			return false;
		}
		else {
			return true;
		}
	}

	public void AnnonceCarte(Carte carte) {
		System.out.println("Carte de " + this.nom + " : " + carte.getNom() + " de " + carte.getColor());
		
	}

}
