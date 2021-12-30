package JOGL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;

import JOGL.Cube3D.coordinates;

public class GLHandler implements GLEventListener
{
	private GLU glu;
	private float angle;
	private float posX = 0, posY = 0;
	private float x = 0, y = 0;
	private ArrayList<Shape3D> items3D;
	private rectangle3D cubeUser;
	private ArrayList<Shape3D> objects3D;
	ArrayList<coordinates> points = new ArrayList<coordinates>();
	private ArrayList<Shape3D> deleteArray = new ArrayList<Shape3D>();
	
	public GLHandler()
	{
		this.glu = new GLU();
		this.angle = 0;
		this.items3D = new ArrayList<Shape3D>();
		this.objects3D = new ArrayList<Shape3D>();
		this.cubeUser = new rectangle3D(0, 0, -5, 0.2f);
		this.points = new ArrayList<coordinates>();
	}

	@Override
	public void init(GLAutoDrawable draw) {
		GL2 gl = draw.getGL().getGL2();
		gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		//gl.glClearDepth(0.0f);
		gl.glEnable(GL2.GL_DEPTH_TEST);
		createACube();
		
	}
	
	@Override
	public void reshape(GLAutoDrawable draw, int x, int y, int width, int height) {
		GL2 gl = draw.getGL().getGL2();
		// -- SCREEN
		float aspect = (float)width / height;
		gl.glViewport(0, 0, width, height);
		// -- CAMERA
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		// FOCAL, ASPECT, Zmin, Zmax
		this.glu.gluPerspective(45.0, aspect, 0.1, 100);
		// -- OBJECTS ?
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();
	}

	@Override
	public void display(GLAutoDrawable draw) 
	{
		// DESSIN ???
		GL2 gl = draw.getGL().getGL2();
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
		gl.glLoadIdentity();
		
		//this.posX += Math.random()*0.01;
		this.angle += 0.5 - Math.random() * 0.5;
		gl.glTranslatef(this.posX, -1, -0.01f);
		this.cubeUser.display(gl, this.angle);

		//gl.glRotatef(angle, 1.0f, 2.0f, 3.0f);
		
		for (Shape3D s : this.items3D) {
			gl.glLoadIdentity();
			y = s.setPosition();
			gl.glTranslatef(0, y, -0.01f);
			s.display(gl, this.angle);
			coordinates points2 = s.returnPositions(y);
			if(s.verifyCollision(points2, this.points) == true) {
				this.deleteArray.add(s);
			};
			if(y < -5) {
				this.deleteArray.add(s);
			}
		}
		
		
		deleteCube(this.deleteArray, gl);
		
		for(Shape3D c : this.objects3D) {
			if(this.points.size()>this.objects3D.size()) {
				this.points.remove(0);
			}
			gl.glLoadIdentity();
			float pos = c.setPosition();
			gl.glTranslatef(0, pos, -0.01f);
			c.display(gl, this.angle);
			this.points.add(c.returnPositions(pos));
			if(pos > 5) {
				this.deleteArray.add(c);
			}
		}
		// Update properties
		
	}
	
	private void deleteCube(ArrayList<Shape3D> deleteArray, GL2 gl) {
		for(Shape3D d : this.deleteArray) {
			if(this.items3D.contains(d)) {
				this.items3D.remove(d);
			}
			else if(this.objects3D.contains(d)) {
				this.objects3D.remove(d);
			}
		}
	}

	public void createACube() {
		Timer timeWait = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				setCube();
			}
		});
		timeWait.setRepeats(true);
		timeWait.start();
			
	}
	
	public void setCube(){
		float cubePosX = (float) ((Math.random()*8) - 4);
		this.items3D.add(new Cube3D(cubePosX, 4, -5, 0.15f));
	}
	
	
	public void goRight() { 
		this.posX += 0.1f; 	
	}
	public void goLeft() { 
		this.posX -= 0.1f; 
	}
	public void goDown() { 
		this.posY -= 0.1f; 
	}
	public void goUp() { 
		this.posY += 0.1f; 
	}

	@Override
	public void dispose(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
	}

	public void launchCube() {
		this.objects3D.add(new cubeProjectiles(this.posX, -0.5f, -5, 0.05f));
	}

}
