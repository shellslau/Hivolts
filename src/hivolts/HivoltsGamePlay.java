package hivolts;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

/**
 * This class is designed to create the very initial JFrame of the Hivolts game 
 * draws the Grid, fence border, initial fences, mhos, and smile
 * 
 * @author Alina, Michelle
 *
 */
public class HivoltsGamePlay extends JFrame{
	private static final long serialVersionUID = 1L; //to get rid of bug while extending JFrame
	public final static int WIDTH = 40;
	public final int ROWS = 12;
	public final int COLUMNS = 12;
	public final int SIZE = ROWS * COLUMNS;
	public final int NUM_FENCES = 20;
	public final int NUM_MHOS = 12;
	public HivoltsBox[] BOXES = new HivoltsBox[SIZE];
	public ArrayList<HivoltsBox> OCCUPIED_BOXES = new ArrayList<HivoltsBox>();
	public ArrayList<HivoltsBox> EMPTY_BOXES = new ArrayList<HivoltsBox>();
	public ArrayList<HivoltsFences> FENCES = new ArrayList<HivoltsFences>();
	public ArrayList<HivoltsMho> MHOS = new ArrayList<HivoltsMho>();
	public HivoltsPlayer PLAYER;
//	public HivoltsInitializer INITIALIZER;
	
	public HivoltsGamePlay() {
		makeAllArrays();
		draw();
	}
	
	public void draw(){
		setBackground(Color.BLACK);
		repaint();
		setSize(575, 675); //initialize jFrame window at 849 by 840
//		setResizable(false);
	}

	
	public void paint(Graphics g) {
		grid(g);
		for (int i = 0; i < FENCES.size() - 1; ++i){
			HivoltsFences fence = FENCES.get(i);
			int[] coords = fence.returnCoordinates();
			int x = coords[0];
			int y = coords[1];
			fence.drawFence(g, x, y);
//			System.out.println("I hate this");
		}
		
		for (int i = 0; i < MHOS.size() - 1; ++i){
			HivoltsMho mho = MHOS.get(i);
			
			int[] coords = mho.returnCoordinates();
			int x = coords[0];
			int y = coords[1];
			mho.drawMho(g, x + 5, y + 5);
		}
		int[] coords = PLAYER.returnCoordinates();
		int x = coords[0];
		int y = coords[1];
		PLAYER.drawPlayer(g, x + 5, y + 5);
	}

	
	public void makeAllArrays(){
		boxes();
		
		fenceBorder();
		
		setFences(NUM_FENCES);
		
		setMhos(NUM_MHOS);
		
		setFirstPlayer();
	}

	public int randomInteger(int min, int max) {

	    Random rand = new Random();

 	   // nextInt excludes the top value so we have to add 1 to include the top value
 	   int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	
	public void boxes(){
		int index = 0;
		for(int y = 1; y < COLUMNS + 1; ++y){
			int ycoord = WIDTH * y;
			
			for(int x = 1; x < ROWS + 1; ++x){
				int xcoord = WIDTH * x;
				
				BOXES[index] = (new HivoltsBox(xcoord, ycoord, index));
				EMPTY_BOXES.add(BOXES[index]);
				
				
				++index; //increases the index number for making the next box
			}
		}
	}
	
	
	public void makeFence(int index){
		HivoltsBox box = BOXES[index];
		
		int[] coords = box.returnCoordinates();
		int xcoord = coords[0];
		int ycoord = coords[1];
		box.setFence(true);
		FENCES.add(new HivoltsFences(xcoord, ycoord, index));
		OCCUPIED_BOXES.add(box);
		BOXES[index] = box;
	}
	
	
	public void makeMho(int index){
		HivoltsBox box = BOXES[index]; //creates variable with the box that is being changed
		
		box.setMho(true);
		int[] coords = box.returnCoordinates();
		int x = coords[0];
		int y = coords[1];
		
		MHOS.add(new HivoltsMho(x, y, index, WIDTH));
		BOXES[index] = box;
		OCCUPIED_BOXES.add(box); //adds the removed box to the list of boxes that are occupied
	}
	
	
	public void makePlayer(int index){
		HivoltsBox box = BOXES[index];
		
		box.setPlayer(true);
		int[] coords = box.returnCoordinates();
		int x = coords[0];
		int y = coords[1];
		
		PLAYER = new HivoltsPlayer(x, y, index);
		BOXES[index] = box;
		OCCUPIED_BOXES.add(box);
	}
	
	public void movePlayer(Graphics g, int newIndex){
		
		HivoltsBox box = BOXES[newIndex];
		box.setPlayer(true);
		int[] coords = box.returnCoordinates();
		int x = coords[0];
		int y = coords[1];
		
		PLAYER.setIndexNum(newIndex);
		PLAYER.drawPlayer(g, x, y);
	}
	
	public void setFences(int numFences){
		while (numFences > 0){
			int max = EMPTY_BOXES.size() - 1; //gets max for random number generator
			int random = randomInteger(0, max); //makes a random number for index of box to get fence
			HivoltsBox box = EMPTY_BOXES.get(random);;
			int index = box.indexNum();
			
			EMPTY_BOXES.remove(BOXES[index]); //removes box from empty_box list
			makeFence(index);
			
			
			numFences = numFences - 1;
		}
	}
	
	
	public void setMhos(int numMhos){
		while (numMhos > 0){
			int max = EMPTY_BOXES.size() - 1; //gets max for random number generator
			int random = randomInteger(0, max); //makes a random number for index of box to get mho
			HivoltsBox box = EMPTY_BOXES.get(random);
			int index = box.indexNum();
			
			EMPTY_BOXES.remove(BOXES[index]);
			makeMho(index);
			
			numMhos = numMhos - 1;
		}
	}
	
	
	public void setFirstPlayer(){
		int max = EMPTY_BOXES.size() - 1;
		int random = randomInteger(0, max);
		HivoltsBox box = EMPTY_BOXES.get(random);
		EMPTY_BOXES.remove(random);
		
		int index = box.indexNum();
		
		makePlayer(index);
	}
	
	
	/** 
	 * Draws the grid using Graphics
	 * @param g
	 */
	public void grid(Graphics g) {
		g.setColor(Color.WHITE); // 13 vertical lines of grid
		for(int i = 1; i < 14; i++) {
			g.drawLine(WIDTH*i, WIDTH, WIDTH * i, 13*WIDTH);
		}
		for(int j = 1; j < 14; j++) { //13 horizontal lines of grid
			g.drawLine(WIDTH, WIDTH * j, 13 * WIDTH, WIDTH* j);
		}
	}
	
	
	public void fenceBorder(){
		for (int i = 0; i < 12; ++i){	//makes top line of fences
			EMPTY_BOXES.remove(BOXES[i]);
			makeFence(i);
		}
		
		for (int i = 133; i < 144; ++i){ //makes bottom line of fences
			EMPTY_BOXES.remove(BOXES[i]);
			makeFence(i);
		}
		
		for (int i = 12; i < 133; i = i + 12){ //makes sides
			EMPTY_BOXES.remove(BOXES[i]);
			EMPTY_BOXES.remove(BOXES[i - 1]);
			
			makeFence(i);
			makeFence((i - 1));
		}
	}
	
}

