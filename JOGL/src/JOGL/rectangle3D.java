package JOGL;

import java.util.ArrayList;

import com.jogamp.opengl.GL2;

public class rectangle3D extends Cube3D {	
	
	public rectangle3D(float x, float y, float z, float size) {
	super(x, y, z, size);
	}

	public void display(GL2 gl, float angle)
	{
		
		gl.glPushMatrix();
		gl.glTranslatef(x, y, z);
		gl.glScalef(size, size, size);
		//gl.glRotated(angle, 0, 1, 0);
		gl.glBegin(GL2.GL_QUADS);
		// Front
		gl.glColor3d(0.5, 0.6, 0.9);
		gl.glVertex3d(-1, -0.5, 0.2);
		gl.glVertex3d(1, -0.5, 0.2);
		gl.glVertex3d(1, 0.5, 0.2);
		gl.glVertex3d(-1, 0.5, 0.2);
		// Rear
		gl.glColor3d(2, 2, 0);
		gl.glVertex3d(-1, -0.5, -0.2);
		gl.glVertex3d(1, -0.5, -0.2);
		gl.glVertex3d(1, 0.5, -0.2);
		gl.glVertex3d(-1, 0.5, -0.2);
		// Left
		gl.glColor3d(0, 1, 0);
		gl.glVertex3d(-1, -0.5, -0.2);
		gl.glVertex3d(-1, -0.5, 0.2);
		gl.glVertex3d(-1, 0.5,  0.2);
		gl.glVertex3d(-1, 0.5, -0.2);
		// Right
		gl.glColor3d(0, 1, 0);
		gl.glVertex3d(1, -0.5, -0.2);
		gl.glVertex3d(1, -0.5, 0.2);
		gl.glVertex3d(1, 0.5,  0.2);
		gl.glVertex3d(1, 0.5, -0.2);
		// Bottom
		gl.glColor3d(0, 0, 1);
		gl.glVertex3d(-1, -0.5, 0.2);
		gl.glVertex3d(1, -0.5, 0.2);
		gl.glVertex3d(1, -0.5, -0.2);
		gl.glVertex3d(-1, -0.5, -0.2);
		// Up
		gl.glColor3d(1, 0, 1);
		gl.glVertex3d(-1, 0.5, 0.2);
		gl.glVertex3d(1, 0.5, 0.2);
		gl.glVertex3d(1, 0.5, -0.2);
		gl.glVertex3d(-1, 0.5, -0.2);
		gl.glEnd();
		gl.glPopMatrix();
	}
	
	public float setPosition(){
		this.y += Math.random()*-0.01;
		float y = this.y;
		return y;
	}

	@Override
	public coordinates returnPositions(float pos) {
		this.points = new coordinates(this.x, pos);
		coordinates c = this.points;
		return c;
	}
	

	@Override
	protected boolean verifyCollision(coordinates points2, ArrayList<coordinates> points) {
		
		for (coordinates point : points) {
			
			if(point.y > points2.y && point.x == points2.x) {
				return true;
			}
		}
		return false;
	}

}
