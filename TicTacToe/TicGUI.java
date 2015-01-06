/**
 * @(#)TicGUI.java
 *
 *
 * @author
 * @version 1.00 2010/10/27
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Cursor;

public class TicGUI extends JFrame implements ActionListener {

	private int width; // Width of frame
	private int height; // Height of frame
	private final int buttonCount = 3; // Width and height of button square
	private boolean gameOver;

	private JPanel mainPanel; // Panel holding panels
	private JPanel panel; // Panel holding playing buttons
	private JPanel newGamePanel; // Panel holding new game button

	private ImageIcon blank; // initial buttons appear blank

	private TicButton[][] buttons; // Two-dimensional array of playing buttons
	private JButton choosePlayer; // Choose player button
	private JButton startButton; // Start button

	private ComputerAI comp; // ComputerAI to play against

	private ChoiceBox choiceBox; // Lets user choose X or O

	// Sets up GUI Objects
    public TicGUI(int frameWidth, int frameHeight, String frameName) {

		// Name TicGUI based on paramater frameName
    	super(frameName);

    	// Change cursor to hand
    	Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
    	this.setCursor(cursor);

    	// Instantiate blank icon
    	blank = new ImageIcon("C:/Users/Public/Pictures/Sample Pictures/blankTic.jpg");

    	// Set size of TicGUI based on paramaters
    	width = frameWidth;
    	height = frameHeight;
    	setSize(width, height);

    	// Set various frame options
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Set to exit program when window is closed
    	setResizable(false); // Set window so size cannot be altered

    	// Create game panel
    	mainPanel = new JPanel();
    	panel = new JPanel();
    	panel.setLayout(new GridLayout(buttonCount,buttonCount));

    	// Add square buttons to panel
    	buttons = new TicButton[buttonCount][buttonCount];
    	for(int x = 0; x < buttons.length; x++) {
    		for(int y = 0; y < buttons[x].length; y++) {
    			buttons[x][y] = new TicButton(blank); // Instantiate blank buttons
    			panel.add(buttons[x][y]); // Add to panel
    			buttons[x][y].addActionListener(this); // Add action listener to each button
    			buttons[x][y].setEnabled(false); // All buttons disabled until new game
    		}
    	}
    	mainPanel.add(panel);

    	// Create panel for new game button
    	newGamePanel = new JPanel();
    	newGamePanel.setVisible(true);

    	// Add new game button and start button to new game panel
    	choosePlayer = new JButton("Choose Player");
    	startButton = new JButton("Start!");
    	newGamePanel.add(startButton);
    	newGamePanel.add(choosePlayer);
    	choosePlayer.addActionListener(this);
    	startButton.addActionListener(this);
    	startButton.setEnabled(false);

    	// Add panels to frame and set visible
    	mainPanel.add(newGamePanel);
    	this.add(mainPanel);
    	setVisible(true);

    	// Initialize game over boolean to false
    	gameOver = false;
    }

	// Responds to any TicButton being clicked
	// Responds to New Game button
	// Responds to Start button
    public void actionPerformed(ActionEvent event) {

    	// If New Game is clicked
    	if(event.getSource() == choosePlayer) {
    		setUpNewGame();
    		return;
    	}

    	// If Start is clicked
    	if(event.getSource() == startButton) {
    		startGame();
    		return;
    	}

    	// When a button is clicked, make it "X" or "O" depending
    	if(comp.isX())
    		((TicButton) event.getSource()).setO();
    	else
    		((TicButton) event.getSource()).setX();

    	// Test for game over
    	//  If so, disable all buttons
    	WinGroup[] wingroups = comp.getWinGroups();
    	for(int x = 0; x < wingroups.length; x++) {
    		if(wingroups[x].gameOver()) {
    			gameOver = true;
    			gameOver();
    		}
    	}

    	// Computer takes turn
    	if(!gameOver) {
    		if(comp.isX())
    			comp.takeTurnX(buttons);
    		else
    			comp.takeTurnO(buttons);
    	}

    	// Test for game over
    	//  If so, disable all buttons
    	WinGroup[] wingroups2 = comp.getWinGroups();
    	for(int x = 0; x < wingroups2.length; x++) {
    		if(wingroups2[x].gameOver()) {
    			gameOver = true;
    			gameOver();
    		}
    	}

    	return;
    }

    // Sets up new game when new game is clicked
    private void setUpNewGame() {

    	// Bring up choice box
    	choiceBox = new ChoiceBox();

    	// Enable start button
    	startButton.setEnabled(true);

    	return;
    }

    private void startGame() {

    	// All buttons cleared and enabled
    	for(int x = 0; x < buttons.length; x++)
    		for(int y = 0; y < buttons[x].length; y++)
    			buttons[x][y].clear();

    	// Initialize computer player
    	comp = new ComputerAI(buttons, choiceBox.selectedO());
    	gameOver = false;

    	// If comp is X, take turn
    	// Else, wait for user to take turn
    	if(comp.isX())
    		comp.takeTurnX(buttons);
    }

    private void gameOver() {
    	for(int x = 0; x < buttons.length; x++)
    		for(int y = 0; y < buttons[x].length; y++)
    			buttons[x][y].setEnabled(false);
    }
}