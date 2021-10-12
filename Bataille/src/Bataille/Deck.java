package Bataille;

import java.util.ArrayList;
import java.util.Collection;

public class Deck {
	protected ArrayList<Carte> Deck = new ArrayList<Carte>();
	
	public Deck(ArrayList<Carte> tableau) {
		this.Deck = tableau;
	}
	
	public void addCard(Carte rCarte){
		this.Deck.add(rCarte);
	}
	
	public void removeCard(Carte rCarte) {
		this.Deck.remove(rCarte);
	}
	
	public int getNumberOfCards() {
		return this.Deck.size();
	}
	
	public Carte getFirstCard() {
		return this.Deck.get(0);
	}

	public void removeCard() {
		this.Deck.remove(0);
	}

	public void addAll(ArrayList<Carte> pile) {
		this.Deck.addAll(pile);
		
	}

}
	
	

