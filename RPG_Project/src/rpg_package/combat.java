package rpg_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;

public class combat {
	Monstre monstre;
	ArrayList<String> event;
	private int turn;
	
	combat(ArrayList event1){
		this.monstre = monstre;
		this.event = event1;
	}

	void testMonstre(){
		this.monstre.init();
	}
	
	void SetMonstre(Monstre monstre) {
		this.monstre = monstre;
	}
	
	void setEvent(ArrayList<String> event){
		this.event = event;
	}
	
	void setMonstre(Monstre monstre) {
		this.monstre = monstre;
		System.out.println(monstre.nom + " vous attaque");
	}

	
	String SetTextHerosTurn() {
		String alert = "C'est à votre tour ! Choisissez une arme";
		return alert;
	}
	
	String SetTextHerosChoice(weapons weapon) {
		String choice = weapon.nom;
		return choice;
	}
	
	void SetTurnOptions(int turn) {
		if(turn == 1) {
			
		}
		
		else {
			
		}
	}
	
	protected void SetWeapon(String arme) {
		
		
	}

	private void MonsterAttack(int degats, heros heros) {
		heros.BeAttacked(degats);
		
	}

	

	int ChangeTurn(){
			if(this.turn == 0) {
				this.turn = 1;
				return 1;
			}
			else {
				this.turn = 0;
				return 0;
			}
	
	}
	
	
	void initBattle(){
		
	}

	

}
