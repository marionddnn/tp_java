package Bataille;

import java.util.ArrayList;

public class Carte {
	static String[] colors = {"carreau", "pique", "trèfle", "coeur"};
	static String[] nomCartes = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Valet", "Reine", "Roi", "as"};
	static int[] valeurs = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
	
	String color;
	int value;
	Carte(String a, int valeur){
		color = a;
		value = valeur;
	}
	
	public String getColor() {
		return color;
	}
	
	public int getValue() {
		return value;
	}
	
	public String getNom() {
		return nomCartes[this.value];
	}
	
	

}
