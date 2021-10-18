package rpg_package;

public class destructible {
	protected int pv;
	destructible(int p){
		pv = p;
	}
	
	public void hit_me(double damage) {
		this.pv -= damage;
	}

}
