/**
 * @(#)ComputerAI.java
 *
 *
 * @author
 * @version 1.00 2010/10/27
 */

import java.util.ArrayList;

public class ComputerAI {

	private int turnCount; // Holds number of turns computer has taken
	private WinGroup[] winGroup; // Holds all 8 combinations of winning rows

	private boolean isX; // True if computer is "X" player
	private boolean isO; // True if computer is "O" player

    public ComputerAI(TicButton[][] buttons, boolean x) {

    	turnCount = 0; // Initialize turn count to 0

    	// Initialize win group array
    	winGroup = new WinGroup[8];
    	winGroup[0] = new WinGroup(buttons[0][0], buttons[0][1], buttons[0][2]); // Across top row
    	winGroup[1] = new WinGroup(buttons[0][0], buttons[1][0], buttons[2][0]); // Down left side
    	winGroup[2] = new WinGroup(buttons[1][0], buttons[1][1], buttons[1][2]); // Across middle
    	winGroup[3] = new WinGroup(buttons[2][0], buttons[2][1], buttons[2][2]); // Across bottom
    	winGroup[4] = new WinGroup(buttons[0][1], buttons[1][1], buttons[2][1]); // Down middle
    	winGroup[5] = new WinGroup(buttons[0][2], buttons[1][2], buttons[2][2]); // Down right
    	winGroup[6] = new WinGroup(buttons[0][0], buttons[1][1], buttons[2][2]); // Diagonal down
    	winGroup[7] = new WinGroup(buttons[2][0], buttons[1][1], buttons[0][2]); // Diagonal up

    	// Initialize booleans
    	if(x) {
    		isX = true;
    		isO = false;
    	}
    	else {
    		isO = true;
    		isX = false;
    	}
    }

	// Artificial intelligence governing computer decisions
    public void takeTurnX(TicButton[][] buttons) {

    	// If first turn, then select upper left square
    	if(turnCount == 0)
    		buttons[0][0].setX();

    	// If second turn, find where O is and plot X accordingly
    	else if(turnCount == 1) {

    		if(buttons[0][1].isO())
    			buttons[2][0].setX();
    		else if(buttons[0][2].isO())
				buttons[2][2].setX();
			else if(buttons[1][0].isO())
				buttons[0][2].setX();
			else if(buttons[1][1].isO())
				buttons[2][2].setX();
			else if(buttons[1][2].isO())
				buttons[2][0].setX();
			else if(buttons[2][0].isO())
				buttons[2][2].setX();
			else if(buttons[2][1].isO())
				buttons[0][2].setX();
			else if(buttons[2][2].isO())
				buttons[0][2].setX();
    	}

    	// If 3rd or more turn, ask winGroup[] how to win
    	else if(turnCount > 1) {

    		TicButton buttonChoice = null; // Holds button that computer will choose

    		// Go through all groups to see if X can win
    		for(int x = 0; x < winGroup.length; x++) {
    			buttonChoice = winGroup[x].XCanWin();
    			if(buttonChoice != null && !buttonChoice.isSelected()) {
    				buttonChoice.setX();
    				return;
    			}
    		}

    		// If X cannot win, then see if X can block O
    		for(int x = 0; x < winGroup.length; x++) {
    			buttonChoice = winGroup[x].OCanWin();
    			if(buttonChoice != null && !buttonChoice.isSelected()) {
    				buttonChoice.setX();
    				return;
    			}
    		}

    		// If X cannot win and cannot block, test to see if there is an
    		//   available square that can help the computer come closer to finishing
    		//   more than one wingroup

    		// Create list to hold all buttons that haven't been clicked
    		ArrayList <TicButton> unclicked = new ArrayList();
    		ArrayList unclickedCount = new ArrayList();
    		for(int x = 0; x < buttons.length; x++) {
    			for(int y = 0; y < buttons[x].length; y++) {
    				if(!buttons[x][y].isClicked()) {
    					unclicked.add(buttons[x][y]);
    				}
    			}
    		}

    		// Iterate through list, testing each unclicked button to see how many
    		//  wingroups the button will help finish.  Keep a count for each button
			for(int x = 0; x < unclicked.size(); x++) { // Iterate through unclicked buttons
				unclickedCount.add(0);
				TicButton temp = unclicked.get(x);
				int count = 0; // Holds number of wingroups that button will help finish
				for(int i = 0; i < winGroup.length; i++) { // For each button, iterate through winGroups
					if(winGroup[i].helpWin(temp)) {
						count++; // Increment count for every wingroup that the button will help win
					}
				}
				unclickedCount.set(x, count); // Store count in unclicked count list
			}

			// If there is a way to help 2 wingroups, select that button
			if(unclickedCount.contains(2)) {
				int index = unclickedCount.indexOf(2);
				((TicButton) unclicked.get(index)).setX();
				return;
			}

    		// If X cannot win and cannot block and cannot help 2 wingroups, choose next available square
    		for(int x = 0; x < buttons.length; x++) {
    			for(int y = 0; y < buttons[x].length; y++) {
    				if(!buttons[x][y].isClicked()) {
    					buttons[x][y].setX();
    					return;
    				}
    			}
    		}
    	}

    	// Increment turn count
    	turnCount++;
    }

    public void takeTurnO(TicButton[][] buttons) {

    	// If first turn, select center UNLESS center is taken,
    	//  then take upper left corner
    	if(turnCount == 0) {
    		if(!buttons[1][1].isClicked())
    			buttons[1][1].setO();
    		else
    			buttons[0][0].setO();
    		turnCount++;
    		return;
    	}

    	// If second turn, test for special cases
    	if(turnCount == 1) {

    		TicButton buttonChoice1 = null;

    		if(buttons[2][0].isX() && buttons[0][2].isX() && buttons[1][1].isO())
    			buttonChoice1 = buttons[1][0];
    		else if(buttons[1][1].isX() && buttons[2][2].isX() && buttons[0][0].isO())
    			buttonChoice1 = buttons[0][2];
    		else if(buttons[0][0].isX() && buttons[1][2].isX() && buttons[1][1].isO())
    			buttonChoice1 = buttons[2][2];
    		else if(buttons[2][1].isX() && buttons[0][0].isX() && buttons[1][1].isO())
    			buttonChoice1 = buttons[2][0];
    		else if(buttons[1][1].isO()) {
    			if(buttons[1][2].isX() && buttons[2][1].isX())
    				buttonChoice1 = buttons[2][2];
    			if(buttons[0][2].isX() && buttons[2][1].isX())
    				buttonChoice1 = buttons[2][2];
    			if(buttons[2][0].isX() && buttons[1][2].isX())
    				buttonChoice1 = buttons[2][2];
    		}

    		if(buttonChoice1 != null) {
    			buttonChoice1.setO();
    			turnCount++;
    			return;
    		}
    	}

    	// If later turns, ask wingroup how to win
    	if(turnCount > 0 ){

    		TicButton buttonChoice = null; // Holds button that computer will choose

    		// Go through all groups to see if O can win
    		for(int x = 0; x < winGroup.length; x++) {
    			buttonChoice = winGroup[x].OCanWin();
    			if(buttonChoice != null && !buttonChoice.isClicked()) {
    				buttonChoice.setO();
    				turnCount++;
    				return;
    			}
    		}

    		// If O cannot win, then see if O can block X
    		for(int x = 0; x < winGroup.length; x++) {
    			buttonChoice = winGroup[x].XCanWin();
    			if(buttonChoice != null && !buttonChoice.isClicked()) {
    				buttonChoice.setO();
    				turnCount++;
    				return;
    			}
    		}

    		// If O cannot win and cannot block, choose next available square
    		for(int x = 0; x < buttons.length; x++) {
    			for(int y = 0; y < buttons[x].length; y++) {
    				if(!buttons[x][y].isClicked()) {
    					buttons[x][y].setO();
    					turnCount++;
    					return;
    				}
    			}
    		}
    	}
    }

    public boolean isX() {
    	return isX;
    }

    public boolean isO() {
    	return isO;
    }

    public WinGroup[] getWinGroups() {
    	return winGroup;
    }

}