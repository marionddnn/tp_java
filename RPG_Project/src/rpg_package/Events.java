package rpg_package;

	import java.util.ArrayList;

	public class Events {
		
		private ArrayList<Event> events = new ArrayList<Event>();
		private ArrayList<Monstre> monstres = new ArrayList<Monstre>();
		private int eventNumber;
		private Event currentEvent;
		
		
		public Events(ArrayList<Event> events2) {
			this.events = events2;
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
		
		void SetNumberOfEvent() {
			
			int number = (int) Math.round((this.events.size()-1)*Math.random());
			System.out.println(number);
			this.eventNumber = number;
		}
		
		boolean verifyEvents() {
			if(events.size()> 0) {
				return true;
			}
			else {
				return false;
			}
		}
		
		Event chooseEvent() {
			return this.events.get(this.eventNumber);
		}
		
		Event getEvent() {
			return this.currentEvent;
		}

		public void removeEvent(Event currentEvent2) {
			this.events.remove(currentEvent2);
		}
		
		
		
	}

