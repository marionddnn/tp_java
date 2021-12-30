package JOGL;
import java.util.ArrayList;

import com.jogamp.opengl.GL2;

import JOGL.Cube3D.coordinates;

public class Face3D extends Shape3D
{

	@Override
	public void display(GL2 gl, float angle) 
	{
		gl.glBegin(GL2.GL_QUADS);
			gl.glVertex3d(-1, -1, 0);
			gl.glVertex3d(1, -1, 0);
			gl.glVertex3d(1, 1, 0);
			gl.glVertex3d(-1, 1, 0);
		gl.glEnd();
	}

	@Override
	public float setPosition() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public coordinates returnPositions(float pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean verifyCollision(coordinates points2, ArrayList<coordinates> points) {
		return false;
		// TODO Auto-generated method stub
		
	}

	

}
