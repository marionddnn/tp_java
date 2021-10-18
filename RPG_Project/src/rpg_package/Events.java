package rpg_package;

	import java.util.ArrayList;

	public class Events {
		
		private ArrayList<ArrayList> events = new ArrayList<ArrayList>();
		private ArrayList<Monstre> monstres = new ArrayList<Monstre>();
		private int eventNumber;
		private ArrayList currentEvent;
		
		
		public Events() {
			this.events = events;
		}

		public void Event1(){
			String s1 = "Vous arrivez devant une rivière. Le seul moyen de la traverser est un tronc d'arbre qui ne semble pas très stable.";
			String s2 = "Vous pouvez tenter de traverser la rivière ou bien longer la rive, ce qui rallongera votre périple.";
			String p1 = "Vous tombez à l'eau et perdez 10pv";
			String p2 = "Vous traverser fièrement le tronc d'arbre qui vous sépare de la rive grâce à votre agilité hors pair.";
			String p3 = "Vous longez la rive sans rencontrer d'obstacles";
			String op1 = "Traverser";
			String op2 = "Longer la rive";
			int c1 = 1;
			int c2 = 0;
			int c3 = 0;
			Monstre n = new Monstre(0, "N", 0);
			monstres.add(n);
			createArray("1", s1, s2, p1, p2, p3, op1, op2, "0"); 
		}
		
		public void Event2(){
			String s1 = "Vous êtes sur la route en pleine nuit, et vous entendez un léger craquement en direction d'un petit bois situé à votre gauche...";
			String s2 = "Vous pouvez choisir d'aller voir la source du bruit ou bien continuer votre route";
			String p1 = "Vous vous approchez de la source du bruit... Et vous apercevez qu'il s'agit d'un simple écureuil ! Vous trouvez un peu d'argent laissé sur le chemin.";
			String p2 = "Vous entendez des pas qui se rapproche de vous... On vous attaque !";
			String p3 = "Vous entendez des pas qui se rapprochent de vous... Et avez juste le temps de lancer un sort d'invisibilité avant de voir passer une ombre terrifiante.";
			String op1 = "Aller voir";
			String op2 = "Rester sur le chemin";
			Monstre Ombre = new Monstre(80, "ombre rapide", 20);
			monstres.add(Ombre);
			createArray("2", s1, s2, p1, p2, p3, op1, op2, "3");
			
		}
		
		public void Event3() {
			String s1 = "En vous approchant du village ou vous devez faire escale, vous croisez un immense chien à trois tête qui garde les portes";
			String s2 = "Il vous demande de lui donner votre arme la plus puissante, à cette seule condition il vous laissera passer";
			String p1 = "Vous acceptez à contrecoeur et entrez dans le village sans rencontrer d'autre obstacle";
			String p2 = "Vous donnez votre arme la moins puissante au chien, malheureusement pour vous, celui-ci flaire vos autres possession et comprend que vous l'avez dupé : il vous attaque";
			String p3 = "Vous combattez le chien sans hésiter";
			String op1 = "Donner une arme";
			String op2 = "Combattre";
			Monstre chien = new Monstre(60, "chien méchant", 15);
			monstres.add(chien);
			createArray("3", s1, s2, p1, p2, p3, op1, op2, "4");
		}
		
		public void Event4() {
			String s1 = "Vous croisez un autre chat, celui ci s'approche de vous et vous propose de jouer à pile ou face";
			String s2 = "Face : vous gagnez 10 pièces. Pile : vous donnez une de vos armes";
			String p1 = "Vous vous apercevez de la supercherie : la pièce n'a pas de côté face, vous ne pouvez que perdre. Votre adversaire vous donne 10 pièces en échange de votre silence";
			String p2 = "Vous perdez et devez donner une de vos armes";
			String p3 = "Vous refuser et poursuivez votre chemin, un peu plus loin, un complice du premier vous attaque pour tenter de vous voler vos pièces";
			String op1 = "Accepter";
			String op2 = "Refuser";
			Monstre chat = new Monstre (50, "chat fourbe", 17);
			monstres.add(chat);
			createArray("4", s1, s2, p1, p2, p3, op1, op2, "4");
		}
		
		public void Event5() {
			String s1 = "Il fait nuit et vous entrez dans une dense forêt, sans aucun repère pour trouver votre chemin. Vous êtes perdu-e.";
			String s2 = "Vous pouvez tenter de revenir sur vos pas ou marcher vers une lumière que vous apercevez vers le nord";
			String p1 = "La lumière semble venir d'une petite cabane, vous vous y reposez la nuit et gagner 10 pièces. Vous retrouvez votre chemin.";
			String p2 = "Vous arrivez à une petite cabane, cependant en descendant dans la cave de celle-ci une étrange lumière blanche vous attaque.";
			String p3 = "Vous tentez de revenir sur vos pas mais vous vous perdez d'avantage, vous mettez plusieurs jours à retrouver votre chemin.";
			String op1 = "Continuer";
			String op2 = "Tenter de revenir";
			Monstre spectre = new Monstre(75, "étrange lumière", 26);
			monstres.add(spectre);
			createArray("5", s1, s2, p1, p2, p3, op1, op2, "3");
		}
		
		public void createArray(String ev, String s1, String s2, String p1, String p2, String p3, String op1, String op2, String combat) {
			ArrayList<String> e = new ArrayList<String>();
			e.add(s1);
			e.add(s2);
			e.add(p1);
			e.add(p2);
			e.add(p3);
			e.add(op1);
			e.add(op2);
			e.add(combat);
			this.events.add(e);
		}
		
		public void tEvent() {
		
			int x = 0;
			int y = 0;
			float a = 0;
			
			/* for (int i=0; i<events.size(); i++) {
			
			
			x = x + Math.round(a);
			a = (float) (a + 0.5);
			y = y + Math.round(a);
			System.out.println("coordonnées : " + x + " " + y);
			
			} */
		}
		
		public void createEvents() {
			Event1();
			Event2();
			Event3();
			Event4();
			Event5();
		}
		
		void SetNumberOfEvent() {
			int number = (int) Math.round(events.size()*Math.random());
			this.eventNumber = number;
		}
		
		void chooseEvent() {
			this.currentEvent = this.events.get(this.eventNumber);
		}
		
		ArrayList getEvent() {
			return this.currentEvent;
		}
		
		void printDescription() {
			System.out.println(this.currentEvent.get(0));
			System.out.println(this.currentEvent.get(1));
		}
		
		void printChoice() {
			System.out.println("--- Que souhaitez vous faire ? ---");
			System.out.println("1/" + this.currentEvent.get(5));
			System.out.println("2/" + this.currentEvent.get(6));
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
			System.out.println(this.currentEvent.get(i));
		}

		public void removeEvent() {
			this.events.remove(this.eventNumber);
		}
		
		public boolean verifyBattle(int number) {
			System.out.println(number + " " + Integer.parseInt((String) this.currentEvent.get(7)));
			if(number == Integer.parseInt((String) this.currentEvent.get(7))) {
				return true;
			}
			else {
				return false;
			}
		}

		
		public Monstre returnMonstre() {
			Monstre monstre = this.monstres.get(this.eventNumber);
			return monstre;
		}
		
	}

