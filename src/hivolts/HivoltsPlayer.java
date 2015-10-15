package hivolts;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This class is designed to generate the random fences
 * @author Alina
 *
 */
public class HivoltsPlayer extends HivoltsBox {
	final static Color AMBER = new Color(255, 194, 0);
	private static final long serialVersionUID = 1L; //to get rid of bug while extending JFrame 
	private static final int WIDTH = 40;
	
	public HivoltsPlayer(int x, int y, int index) {
		super(x, y, index);
	}
	
	
	/**
	 * Draws smiley face for the Player
	 * Alina
	 * @param g Graphics object
	 * @param x X coordinate for player
	 * @param y Y coordinate for player
	 */
	public void drawPlayer(Graphics g, int x, int y){
		int radius = WIDTH - 10; //radius of face circle
		g.setColor(AMBER);
		//intial x and y should be 45 px
		g.fillOval(x, y, radius, radius); //draw circle for face
		g.setColor(Color.BLACK);
		int yEye = y + 10; //y coordinate for eyes
		int eyeRadius = 5; //radius of the eye circles
		g.fillOval(x + 7, yEye, eyeRadius, eyeRadius); //left eye
		g.fillOval(x + 18, yEye, eyeRadius, eyeRadius); //right eye
		g.drawArc(x + 6, y + 14, 18, 10, 180, 180); //mouth arc
	}
	
	
	
	
}


