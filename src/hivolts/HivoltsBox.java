package hivolts;

import javax.swing.JFrame;

/**
 * Class to create objects with attributes for specific boxes within hivolts game
 * descended from game play class
 * @author Alina Drebin, Michelle Slaughter
 *
 */
public class HivoltsBox extends JFrame{

	private static final long serialVersionUID = 1L; //to get rid of bug while extending JFrame
	private int X_COORDINATE;
	private int Y_COORDINATE;
	private boolean FENCE;
	private boolean MHO;
	private boolean PLAYER;
	private int INDEX;

	/**
	 * initializes the box object
	 * @param original x-coordinate
	 * @param original y-coordinate
	 */
	public HivoltsBox(int x, int y, int index){
		init(x, y, index);
	}

	/**
	 * sets fence, mho and player to false to start off when creating the object
	 * sets the coordinates of the object
	 * @param original x-coordinate (upper left corner)
	 * @param original y-coordinate (upper left corner)
	 */
	public void init(int xcoord, int ycoord, int index){
		FENCE = false;
		MHO = false;
		PLAYER = false;
		setCoordinates(xcoord, ycoord);
		setIndexNum(index);
	}
	
	/**
	 * sets FENCE to the boolean passed in so that we know whether there is a fence in the box or not
	 * @param whether or not there is a fence
	 */
	public void setFence(boolean yes){
		FENCE = yes;
	}
	
	/**
	 * sets MHO to boolean value given to know whether there is a mho in the box or not
	 * @param whether or not there is a mho
	 */
	public void setMho(boolean yes){
		MHO = yes;
	}
	
	/**
	 * sets player to boolean value given to know whether the player is in the box or not
	 * @param whether or not the player is in the box
	 */
	public void setPlayer(boolean yes){
		PLAYER = yes;
	}
	
	/**
	 * Returns true or false depending on status of PLAYER in box
	 * @return true or false
	 */
	public boolean isPlayer(){
		if (PLAYER){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * Returns true or false depending on status of FENCE in box
	 * @return true or false
	 */
	public boolean isFence(){
		if (FENCE){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * Returns true or false depending on status of MHO in box
	 * @return true or false
	 */
	public boolean isMho(){
		if (MHO) {
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * returns true or false depending on if there is a fence OR player OR mho in the box
	 * @return true or false
	 */
	public boolean isOccupied(){
		if (PLAYER | FENCE | MHO){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * sets an index number for the box in the overall list of boxes
	 * @param x index number
	 */
	public void setIndexNum(int x){
		INDEX = x;
	}
	
	/**
	 * returns the index number of the box in the list
	 * @return index number
	 */
	public int indexNum(){
		return INDEX;
	}
	
	/**
	 * sets coordinates of box to variables give
	 * @param upper left x coordinate
	 * @param upper left y coordinate
	 */
	public void setCoordinates(int xcoord, int ycoord){
		X_COORDINATE = xcoord;
		Y_COORDINATE = ycoord;
	}
	
	/**
	 * Returns coordinates of box in an array of integers
	 * @return coordinates in array of integers
	 */
	public int[] returnCoordinates(){
		return new int[] {X_COORDINATE, Y_COORDINATE};
	}

}