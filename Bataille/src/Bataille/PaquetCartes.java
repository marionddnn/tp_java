package Bataille;

import java.util.ArrayList;

public class PaquetCartes {
	protected ArrayList<Carte> paquet = new ArrayList<Carte>();
	
	public void addCard(Carte rCarte){
		this.paquet.add(rCarte);
	}
	
	public void removeCard(Carte rCarte) {
		this.paquet.remove(rCarte);
	}
	
	public void creerPaquet() {
		int i = 0;
		for(i=0; i<Carte.colors.length; i++) {
			String color = Carte.colors[i];
			int j=0;
			for(j=0; j<Carte.valeurs.length; j++) {
				int valeur = Carte.valeurs[j];
				Carte newCarte = new Carte(color, valeur);
				addCard(newCarte);
			}
		}
	}
	
	public void setDecks(Deck Deck1, Deck Deck2) {
		while(this.paquet.size()>0) {
			var t = this.paquet.size() - 1;
			int indexCarte = (int) Math.round(t*Math.random());
				if(Deck1.getNumberOfCards()<this.paquet.size()) {
					var rCarte = this.paquet.get(indexCarte);
					Deck1.addCard(rCarte);
					paquet.remove(rCarte);
				}
				else {
					var rCarte = this.paquet.get(indexCarte);
					Deck2.addCard(rCarte);
					paquet.remove(rCarte);
				}
			}
	}

}
