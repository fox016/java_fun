/**
 * @(#)TicTacToe.java
 *
 * TicTacToe application
 *
 * @author Nate Fox :)
 * @version 1.00 2010/10/27
 */

public class TicTacToe {

    public static void main(String[] args) {

    	// Create new TicGUI
    	// Set TicGUI width to frameWidth
    	// Set TicGUI height to frameHeight
		final int frameWidth = 500; // Define width of frame to 500
		final int frameHeight = 500; // Define height of frame to 500
		String frameName = "Tic Tac Toe :)"; // Define name of TicGUI

    	TicGUI gui = new TicGUI(frameWidth, frameHeight, frameName);
    	gui.setLocation(400,150);
    }
}
