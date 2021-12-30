package JOGL;

public class cubeProjectiles extends Cube3D {


	public cubeProjectiles(float x, float y, float z, float size) {
		super(x, y, z, size);
		// TODO Auto-generated constructor stub
	}
	
	
	public float setPosition(){
		this.y += Math.random()*0.01;
		float y = this.y;
		return y;
	}
	
	public coordinates returnPositions() {
		coordinates c = this.points;
		return c;
	}

}
