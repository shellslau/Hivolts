package hivolts;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This class is designed to generate the random fences
 * @author Alina
 *
 */
public class HivoltsFences extends HivoltsBox {
	final static Color AMBER = new Color(255, 194, 0);
	private static final long serialVersionUID = 1L; //to get rid of bug while extending JFrame 
	/**
	 * HivoltsFences constructor
	 * @param x X coordinate of box
	 * @param y Y coordinate of box
	 */
	public HivoltsFences(int x, int y, int index) {
		super(x, y, index);
	}
	
	
	/**
	 * Draws a single fence
	 * Alina
	 * @param g Graphics object
	 * @param x X coordinate of fence location
	 * @param y Y coordinate of fence location
	 */
	public void drawFence(Graphics g, int x, int y) {
		g.setColor(AMBER);
		x = x + 5;
		y = y + 5;
		g.fillRoundRect(x, y, 5, 30, 50, 50); //left post
		g.fillRoundRect(x + 25, y, 5, 30, 50, 50); //right post
		
		//makes the top, middle, and bottom lines
		for(int i = 1; i < 4; i++) {
			int lineX = x + 5; //x coordinate of lines
			int lineY = y + 7 * i; //y coordinate of lines
			g.fillRect(lineX, lineY, 21, 3); //width 21, height 3
		}
	}
}

