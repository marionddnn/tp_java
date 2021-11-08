package rpg_package;

import java.util.ArrayList;
import java.util.Arrays;

public class Event{
	private ArrayList<Monstre> monstres = new ArrayList<Monstre>();
	private ArrayList<Object> event;

	public Event(String s1, String s2, String p1, String p2, String p3, String op1, String op2, Monstre monstre, String combat, String string) {
		this.event = new ArrayList<>(Arrays.asList(s1,s2,p1,p2,p3,op1,op2,monstre,combat,string));
	}
	
	void printDescription() {
		System.out.println(this.event.get(0));
		System.out.println(this.event.get(1));
	}
	
	void printChoice() {
		System.out.println("--- Que souhaitez vous faire ? ---");
		System.out.println("1/" + this.event.get(5));
		System.out.println("2/" + this.event.get(6));
	}
	
	
	int setChoiceNumber(String choice) {
		int number = 0;
		if (choice.equals("1")) {
			number = (int) Math.round(1*Math.random())+2;
		}
		else if (choice.equals("2")){
			number = 4;
		}
		printResponse(number);
		return number;
	}
	
	private void printResponse(int i) {
		System.out.println(this.event.get(i));
	}
	
	public boolean verifyBattle(int number) {
		if(number == Integer.parseInt((String) this.event.get(8))) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public Monstre returnMonstre() {
		Monstre monstre = (Monstre) this.event.get(7);
		return monstre;
	}
	
	public String verifyEvent(int number) {
		String[] lines = ((String) this.event.get(9)).split("-");
		if(number == Integer.parseInt((String) lines[1])){
			if(lines[0].equals("pv")) {
				return "pv";
			}
			else if(lines[0].equals("pièces")) {
				return "pièces";
			}
			else if(lines[0].equals("armes")) {
				return "armes";
			}
			else {
				return null;
			}
		}
		return null;
	}
}
