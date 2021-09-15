package Bataille;

import java.util.ArrayList;

public class Joueur {
	ArrayList<Carte> Main = new ArrayList<Carte>() ;
	String nom;
	
	Joueur(String nomJoueur, ArrayList<Carte> cartes) {
		nom = nomJoueur;
		Main = cartes;
	}
}
