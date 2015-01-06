/**
 * @(#)WinGroup.java
 *
 *
 * @author
 * @version 1.00 2010/10/30
 */

public class WinGroup {

	private TicButton[] row;

    public WinGroup(TicButton one, TicButton two, TicButton three) {
    	row = new TicButton[3];
    	row[0] = one;
    	row[1] = two;
    	row[2] = three;
    }

    // Returns square that needs to be picked in order for X to win or that
    //   needs to be blocked to prevent X from winning
    public TicButton XCanWin() {
    	if(row[0].isX() && row[1].isX() && !row[2].isO())
    		return row[2];
    	if(row[0].isX() && !row[1].isO() && row[2].isX())
    		return row[1];
    	if(!row[0].isO() && row[1].isX() && row[2].isX())
    		return row[0];
    	return null;
    }

    // Returns square that needs to be picked in order for O to win or that
    //   needs to be blocked to prevent O from winning
    public TicButton OCanWin() {
    	if(row[0].isO() && row[1].isO() && !row[2].isX())
    		return row[2];
    	if(row[0].isO() && !row[1].isX() && row[2].isO())
    		return row[1];
    	if(!row[0].isX() && row[1].isO() && row[2].isO())
    		return row[0];
    	return null;
    }

	// Test to see if X or O have three in a row
    public boolean gameOver() {
    	if(row[0].isO() && row[1].isO() && row[2].isO())
    		return true;
    	if(row[0].isX() && row[1].isX() && row[2].isX())
    		return true;
    	return false;
    }

    // Test to see if given button will help computer come closer
    //   to winning whichever win group invokes the call
    public boolean helpWin(TicButton button) {

    	// If one of the buttons besides the parameter is X and the other is
    	//   blank, return true
    	if(row[0] == button) {
    		if(row[1].isX()) {
    			if(!row[2].isO()) {
    				return true;
    			}
    		}
    		if(row[2].isX()) {
    			if(!row[1].isO()) {
    				return true;
    			}
    		}
    	}
    	if(row[1] == button) {
    		if(row[0].isX()) {
    			if(!row[2].isO()) {
    				return true;
    			}
    		}
    		if(row[2].isX()) {
    			if(!row[0].isO()) {
    				return true;
    			}
    		}
    	}
    	if(row[2] == button) {
    		if(row[1].isX()) {
    			if(!row[0].isO()) {
    				return true;
    			}
    		}
    		if(row[0].isX()) {
    			if(!row[1].isO()) {
    				return true;
    			}
    		}
    	}

    	// Else return false
    	return false;
    }
}