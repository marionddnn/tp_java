package JOGL;
import java.util.ArrayList;

import com.jogamp.opengl.GL2;

import JOGL.Cube3D.coordinates;

public class Cube3D extends Shape3D
{
	
	protected class coordinates{
		float x;
		float y;

		public coordinates(float x, float y) {
		this.x = (float) Math.round(x*10)/10;
		this.y = (float) Math.round(y*10)/10;
		}
	}

	public coordinates points;
	
	public Cube3D(float x, float y, float z, float size)
	{
		this.x = x; this.y = y; this.z = z;
		this.size = size;
		this.points = new coordinates(this.x, this.y);
		
	}
	
	public void display(GL2 gl, float angle)
	{
		
		gl.glPushMatrix();
		gl.glTranslatef(x, y, z);
		gl.glScalef(size, size, size);
		gl.glRotated(angle, 0, 1, 0);
		gl.glBegin(GL2.GL_QUADS);
		// Front
		gl.glColor3d(1, 0, 0);
		gl.glVertex3d(-1, -1, 1);
		gl.glVertex3d(1, -1, 1);
		gl.glVertex3d(1, 1, 1);
		gl.glVertex3d(-1, 1, 1);
		// Rear
		gl.glColor3d(1, 1, 0);
		gl.glVertex3d(-1, -1, -1);
		gl.glVertex3d(1, -1, -1);
		gl.glVertex3d(1, 1, -1);
		gl.glVertex3d(-1, 1, -1);
		// Left
		gl.glColor3d(0, 1, 0);
		gl.glVertex3d(-1, -1, -1);
		gl.glVertex3d(-1, -1, 1);
		gl.glVertex3d(-1, 1,  1);
		gl.glVertex3d(-1, 1, -1);
		// Right
		gl.glColor3d(0, 1, 1);
		gl.glVertex3d(1, -1, -1);
		gl.glVertex3d(1, -1, 1);
		gl.glVertex3d(1, 1,  1);
		gl.glVertex3d(1, 1, -1);
		// Bottom
		gl.glColor3d(0, 0, 1);
		gl.glVertex3d(-1, -1, 1);
		gl.glVertex3d(1, -1, 1);
		gl.glVertex3d(1, -1, -1);
		gl.glVertex3d(-1, -1, -1);
		// Up
		gl.glColor3d(1, 0, 1);
		gl.glVertex3d(-1, 1, 1);
		gl.glVertex3d(1, 1, 1);
		gl.glVertex3d(1, 1, -1);
		gl.glVertex3d(-1, 1, -1);
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