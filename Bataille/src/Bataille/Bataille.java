package Bataille;

import java.util.ArrayList;
import java.util.Scanner;


public class Bataille {
	
	public static void main (String[] args) {
		ArrayList <Carte> paquetCarte = new ArrayList<Carte>();
		int i = 0;
			for(i=0; i<Carte.colors.length; i++) {
				String color = Carte.colors[i];
				int j=0;
				for(j=0; j<Carte.valeurs.length; j++) {
					int valeur = Carte.valeurs[j];
					Carte newCarte = new Carte(color, valeur);
					paquetCarte.add(newCarte);
				}
			}
			
			ArrayList <Carte> paquetJeu = new ArrayList<Carte>(); 
			ArrayList <Carte> paquetJeu2 = new ArrayList<Carte>(); 
			ArrayList <Carte> pile = new ArrayList<Carte>();
			
			while(paquetCarte.size()>0) {
				var t = paquetCarte.size() - 1;
				int indexCarte = (int) Math.round(t*Math.random());
					if(paquetJeu.size()<paquetCarte.size()) {
						var rCarte = paquetCarte.get(indexCarte);
						paquetJeu.add(rCarte);
						paquetCarte.remove(rCarte);
					}
					else {
						var rCarte = paquetCarte.get(indexCarte);
						paquetJeu2.add(rCarte);
						paquetCarte.remove(rCarte);
					}
				}
				
				Scanner sc = new Scanner(System.in);
				System.out.println("Entrez un nom de joueur 1");
				String nom1 = sc.nextLine();
				System.out.println("Entrez un nom de joueur 2");
				String nom2 = sc.nextLine();
				
				Joueur Joueur1 = new Joueur(nom1, paquetJeu);
				Joueur Joueur2 = new Joueur(nom2, paquetJeu2);
				
				
				
				while(Joueur1.Main.size() > 0 && Joueur2.Main.size()> 0){
					
							
			
				System.out.println("--" + Joueur1.nom + " pioche une carte --");
				
				var j1Carte = Joueur1.Main.get(0);
				var CarteName = Carte.nomCartes[j1Carte.value];
				System.out.println("Carte de " + Joueur1.nom + " : " + CarteName + " de " + j1Carte.getColor());
				pile.add(j1Carte);
				
				System.out.println("--" + Joueur2.nom + " pioche une carte --");
				var j2Carte = Joueur2.Main.get(0);
				var CarteName2 = Carte.nomCartes[j2Carte.value];
				System.out.println("Carte de " + Joueur2.nom + " : " + CarteName2 + " de " + j2Carte.getColor());
				pile.add(j2Carte);
				
				Joueur1.Main.remove(j1Carte);
				Joueur2.Main.remove(j2Carte);
				
				if(j1Carte.value > j2Carte.value) {
					System.out.println("pile :" + pile.size());
					Joueur1.Main.addAll(pile);
					System.out.println("Main joueur 2 :" + Joueur2.Main.size());
					System.out.println("Main joueur 1 :" + Joueur1.Main.size());
					String efzf = sc.nextLine();
					pile.clear();
					System.out.println(Joueur1.nom + " gagne cette manche et remporte les cartes");
				}
				else if (j2Carte.value > j1Carte.value) {
					System.out.println("pile :" + pile.size());
					Joueur2.Main.addAll(pile);
					pile.clear();
					System.out.println("Main joueur 1 :" + Joueur1.Main.size());
					System.out.println("Main joueur 2 :" + Joueur2.Main.size());
					System.out.println(Joueur2.nom + " gagne cette manche et remporte les cartes");
				}
				else {
					System.out.println("Bataille !");
					pile.add(Joueur1.Main.get(0));
					pile.add(Joueur2.Main.get(0));
					Joueur1.Main.remove(Joueur1.Main.get(0));
					Joueur2.Main.remove(Joueur2.Main.get(0));
					System.out.println("Chaque joueur pose une seconde carte face cachée et en pioche une troisième");
					}
				}
		
			if(Joueur1.Main.size()>0) {
				System.out.println(Joueur1.nom + " a gagné !!!");
			}
			else {
				System.out.println(Joueur2.nom + " a gagné !!!");
			}
		}
}
