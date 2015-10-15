package hivolts;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This class is designed to generate the random fences
 * @author Alina
 *
 */
public class HivoltsMho extends HivoltsBox {
	private boolean alive; //status of a Mho object
	final static Color BURGUNDY = new Color(121, 30, 29);
	private static final long serialVersionUID = 1L; //to get rid of bug while extending JFrame 
	private static int WIDTH;
	
	public HivoltsMho(int x, int y, int index, int width) {
		super (x, y, index);
		WIDTH = width;
		setAlive(true);
	}
	
	
	/**
	 * Draws frowny face for a Mho
	 * Alina
	 * @param g Graphics object
	 * @param x X coordinate for Mho
	 * @param y Y coordinate for Mho
	 */
	public void drawMho(Graphics g, int x, int y){
		int radius = WIDTH - 10; //radius of face circle
		g.setColor(BURGUNDY);
		g.fillOval(x, y, radius, radius);
		
		
		g.setColor(Color.BLACK);
		int yEye = y + 10; //y coordinate for eyes
		int eyeRadius = 5; //radius of the eye circles
		g.fillOval(x + 7, yEye, eyeRadius, eyeRadius); //left eye
		g.fillOval(x + 18, yEye, eyeRadius, eyeRadius); //right eye
		g.drawArc(x + 6, y + 19, 18, 10, 0, 180); //mouth arc
		
	}
	
	/**
	 * Checks to see if a Mho is alive or dead
	 * Alina
	 * @param check Boolean value of Mho object
	 */
	public void setAlive(boolean check) {
		alive = check;
	}
	
	/**
	 * Returns the status of a Mho
	 * @param check Boolean value of Mho object
	 * @return Mho status
	 */
	public boolean getAlive(boolean check) {
		return alive;
	}

}
	

