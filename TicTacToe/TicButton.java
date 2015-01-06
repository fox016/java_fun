/**
 * @(#)TicButton.java
 *
 *
 * @author
 * @version 1.00 2010/10/27
 */

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class TicButton extends JButton {

	private boolean isClicked; // Keeps track if button has been clicked or not
	private boolean isX; // Keeps track if button is X
	private boolean isO; // Keeps track if button is O

	private static final ImageIcon xIcon = new ImageIcon("C:/Users/Public/Pictures/Sample Pictures/X.jpg");  // "X" that appears as human player selects buttons
	private static final ImageIcon oIcon = new ImageIcon("C:/Users/Public/Pictures/Sample Pictures/O.jpg");  // "O" that appears as computer selects buttons
	private static final ImageIcon blank = new ImageIcon("C:/Users/Public/Pictures/Sample Pictures/blankTic.jpg"); // Blank icon to clear X's and O's

    public TicButton(ImageIcon image) {

    	// Run JButton constructor
    	super(image);

    	// Initialize booleans to false
    	isClicked = false;
    	isX = false;
    	isO = false;
    }

	// Sets square to X
    public void setX() {
    	setIcon(xIcon); // Change to X icon
    	setEnabled(false); // Disable square
    	isClicked = true; // Square has been selected
    	isX = true; // Square is an X
    }

	// Sets square to O
    public void setO() {
    	setIcon(oIcon); // Change to O icon
    	setEnabled(false); // Disable square
    	isClicked = true; // Square has been selected
    	isO = true; // Square is an O
    }

    // Clears square
    public void clear() {
    	setIcon(blank); // Change to blank
    	setEnabled(true); // Enable square
    	isClicked = false; // Set to unclicked
    	isO = false; // Square is not O
    	isX = false; // Square is not X
    }

	// Returns whether or not this square is an X
    public boolean isX() {
    	return isX;
    }

	// Returns whether or not this square is an O
    public boolean isO() {
    	return isO;
    }

    // Returns whether or not this square has been selected
    public boolean isClicked() {
    	return isClicked;
    }
}