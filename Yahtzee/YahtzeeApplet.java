/**
 * @(#)YahtzeeApplet.java
 *
 * Yahtzee applet
 *
 * @author Nate Fox
 * @version 1.00 2011/5/19
 */

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.GridLayout;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JPanel;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;

public class YahtzeeApplet extends JApplet implements ActionListener, ItemListener {

	// Create Containers
	private JPanel panel;
	private JPanel dicePanel;
	private JPanel rollPanel;
	private JPanel score1Panel;
	private JPanel score2Panel;
	private JPanel scoreLabelPanel;

	// Create GUI Objects
	private JLabel[] diceLabels;
	private JLabel rollLabel;
	private JLabel topScoreLabel;
	private JLabel bottomScoreLabel;
	private JLabel bonusLabel;
	private JLabel totalLabel;

	private JButton[] score1Buttons;
	private JButton[] score2Buttons;
	private JButton roll;

	private JTextField[] score1Fields;
	private JTextField[] score2Fields;

	private JRadioButton[] holdButtons;

	public final static int WIDTH = 300;
	public final static int HEIGHT = 620;

	// Create String arrays for score button labels
	private final String[] scores1 = {"Aces", "Twos", "Threes", "Fours", "Fives", "Sixes"};
	private final String[] scores2 = {"3 of a kind", "4 of a kind", "Full House",
									"Sm. Straight", "Lg. Straight", "Yahtzee",
										"2nd Yahtzee", "3rd Yahtzee", "Chance"};

	// Create array of image icons for dice
	private ImageIcon[] diceImages;

	// Create dice variables
	private int[] dice;
	private int rollCount;
	private ArrayList<Integer> heldDice;

	// Create score variables
	private int topScore;
	private int bonus;
	private int bottomScore;
	private int total;

	private boolean scoreClicked;

	public void init() {

		// Create main panel
		panel = new JPanel();
		this.add(panel);

		// Create array of image icons for dice
		diceImages = new ImageIcon[6];
		for(int x = 0; x < diceImages.length; x++)
			diceImages[x] = new ImageIcon("dice" + (x+1) + ".jpg");

		// Add dice
		dicePanel = new JPanel();
		dicePanel.setLayout(new GridLayout(2,5));
		diceLabels = new JLabel[5];
		for(int x = 0; x < diceLabels.length; x++) {
			diceLabels[x] = new JLabel(diceImages[x]);
			dicePanel.add(diceLabels[x]);
		}

		// Add hold buttons
		holdButtons = new JRadioButton[5];
		for(int x = 0; x < holdButtons.length; x++) {
			holdButtons[x] = new JRadioButton("Hold", false);
			dicePanel.add(holdButtons[x]);
			holdButtons[x].addItemListener(this);
			holdButtons[x].setEnabled(false);
		}

		// Add roll button and label
		GridLayout rollGrid = new GridLayout(1, 2);
		rollGrid.setHgap(60);
		rollPanel = new JPanel();
		rollPanel.setLayout(rollGrid);
		roll = new JButton("Roll!");
		rollLabel = new JLabel("Roll #: ");
		rollPanel.add(roll);
		rollPanel.add(rollLabel);

		// Add first score grid
		GridLayout scoreGrid1 = new GridLayout(6,2);
		scoreGrid1.setHgap(30);
		score1Panel = new JPanel();
		score1Panel.setLayout(scoreGrid1);
		score1Buttons = new JButton[6];
		score1Fields = new JTextField[6];
		for(int x = 0; x < score1Buttons.length; x++) {
			score1Buttons[x] = new JButton(scores1[x]);
			score1Panel.add(score1Buttons[x]);
			score1Fields[x] = new JTextField("");
			score1Panel.add(score1Fields[x]);
			score1Fields[x].setEditable(false);
			score1Buttons[x].addActionListener(this);
		}

		// Add second score grid
		GridLayout scoreGrid2 = new GridLayout(9,2);
		scoreGrid2.setHgap(30);
		score2Panel = new JPanel();
		score2Panel.setLayout(scoreGrid2);
		score2Buttons = new JButton[9];
		score2Fields = new JTextField[9];
		for(int x = 0; x < score2Buttons.length; x++) {
			score2Buttons[x] = new JButton(scores2[x]);
			score2Panel.add(score2Buttons[x]);
			score2Fields[x] = new JTextField("");
			score2Panel.add(score2Fields[x]);
			score2Fields[x].setEditable(false);
			score2Buttons[x].addActionListener(this);
		}

		// Add score labels
		scoreLabelPanel = new JPanel();
		scoreLabelPanel.setLayout(new GridLayout(5,1));
		topScoreLabel = new JLabel("Top Score: 0");
		bonusLabel = new JLabel("Bonus: 0");
		bottomScoreLabel = new JLabel("Bottom Score: 0");
		totalLabel = new JLabel("Total: 0");
		scoreLabelPanel.add(topScoreLabel);
		scoreLabelPanel.add(bonusLabel);
		scoreLabelPanel.add(bottomScoreLabel);
		scoreLabelPanel.add(totalLabel);

		// Add panels to main panel
		panel.add(dicePanel);
		panel.add(rollPanel);
		panel.add(score1Panel);
		panel.add(score2Panel);
		panel.add(scoreLabelPanel);

		// Add listeners
		roll.addActionListener(this);

		// Initialize dice array
		dice = new int[5];
		heldDice = new ArrayList<Integer>();

		// Initialize scoreClicked to false
		scoreClicked = false;

		// Initialize plural yahtzee buttons to disabled
		score2Buttons[6].setEnabled(false);
		score2Buttons[7].setEnabled(false);

		// Initialize score variables to zero
		topScore = 0;
		bottomScore = 0;
		bonus = 0;
		total = 0;
	}

	public void actionPerformed(ActionEvent event) {

		// If roll is clicked
		if(event.getSource() == roll) {

			if(!holdButtons[0].isEnabled()) {
				for(int x = 0; x < holdButtons.length; x++)
					holdButtons[x].setEnabled(true);
			}

			if(rollCount == 3 && scoreClicked || rollCount != 3) {

				// If last roll, clear holds
				if(rollCount == 3 || scoreClicked) {
					heldDice.clear();
					for(int x = 0; x < holdButtons.length; x++)
						holdButtons[x].setSelected(false);
				}

				// Set dice to 5 random integers between 1 and 6
				Random random = new Random();
				for(int x = 0; x < dice.length; x++)
					if(!heldDice.contains(x))
						dice[x] = random.nextInt(6) + 1;

				// Set dice images
				for(int x = 0; x < diceLabels.length; x++)
					diceLabels[x].setIcon(diceImages[dice[x]-1]);

				// Update roll count
				if(rollCount != 3 && !scoreClicked)
					rollCount++;
				else {
					rollCount = 1;
					scoreClicked = false;
				}
				rollLabel.setText("Roll #: " + rollCount);
			}
		}

		// If score is clicked
		else if(!scoreClicked){

			JButton button = (JButton)event.getSource();
			Arrays.sort(dice);
			int score = 0;

			// If button is in the first score set
			for(int x = 0; x < scores1.length; x++) {
				if(button.getText().equals(scores1[x])) {
					int numberClicked = x + 1;
					for(int i = 0; i < dice.length; i++) {
						if(dice[i] == numberClicked) {
							score += numberClicked;
						}
					}
					if(score1Fields[x].getText().equals(""))
						score1Fields[x].setText(score + "");
					button.setEnabled(false);
					topScore += score;
					topScoreLabel.setText("Top Score: " + topScore);
					break;
				}
			}

			// If button is 3 of a kind
			if(button.getText().equals("3 of a kind")) {
				if(dice[0] == dice[1] && dice[1] == dice[2])
					score = getTotal(dice);
				else if(dice[1] == dice[2] && dice[2] == dice[3])
					score = getTotal(dice);
				else if(dice[2] == dice[3] && dice[3] == dice[4])
					score = getTotal(dice);
				if(score2Fields[0].getText().equals(""))
					score2Fields[0].setText(score + "");
				button.setEnabled(false);
				bottomScore += score;
				bottomScoreLabel.setText("Bottom Score: " + bottomScore);
			}

			// If button is 4 of a kind
			if(button.getText().equals("4 of a kind")) {
				if(dice[0] == dice[1] && dice[1] == dice[2] &&  dice[2] == dice[3])
					score = getTotal(dice);
				if(dice[1] == dice[2] && dice[2] == dice[3] &&  dice[3] == dice[4])
					score = getTotal(dice);
				if(score2Fields[1].getText().equals(""))
					score2Fields[1].setText(score + "");
				button.setEnabled(false);
				bottomScore += score;
				bottomScoreLabel.setText("Bottom Score: " + bottomScore);
			}

			// If button is Full House
			if(button.getText().equals("Full House")) {
				if(dice[0] == dice[1] && dice[2] == dice[3] && dice[3] == dice[4])
					score = 25;
				else if(dice[3] == dice[4] && dice[0] == dice[1] && dice[1] == dice[2])
					score = 25;
				if(score2Fields[2].getText().equals(""))
					score2Fields[2].setText(score + "");
				button.setEnabled(false);
				bottomScore += score;
				bottomScoreLabel.setText("Bottom Score: " + bottomScore);
			}

			// If button is small straight
			if(button.getText().equals("Sm. Straight")) {
				if(arrayContains(dice, 1) && arrayContains(dice, 2) && arrayContains(dice, 3)
					&& arrayContains(dice, 4))
						score = 30;
				else if(arrayContains(dice, 2) && arrayContains(dice, 3) && arrayContains(dice, 4)
					&& arrayContains(dice, 5))
						score = 30;
				else if(arrayContains(dice, 3) && arrayContains(dice, 4) && arrayContains(dice, 5)
					&& arrayContains(dice, 6))
						score = 30;
				if(score2Fields[3].getText().equals(""))
					score2Fields[3].setText(score + "");
				button.setEnabled(false);
				bottomScore += score;
				bottomScoreLabel.setText("Bottom Score: " + bottomScore);
			}

			// If button is large straight
			if(button.getText().equals("Lg. Straight")) {
				if(arrayContains(dice, 1) && arrayContains(dice, 2) && arrayContains(dice, 3)
					&& arrayContains(dice, 4) && arrayContains(dice, 5))
						score = 40;
				if(arrayContains(dice, 2) && arrayContains(dice, 3) && arrayContains(dice, 4)
					&& arrayContains(dice, 5) && arrayContains(dice, 6))
						score = 40;
				if(score2Fields[4].getText().equals(""))
					score2Fields[4].setText(score + "");
				button.setEnabled(false);
				bottomScore += score;
				bottomScoreLabel.setText("Bottom Score: " + bottomScore);
			}

			// If button is Yahtzee
			if(button.getText().equals("Yahtzee")) {
				if(dice[0] == dice[1] && dice[1] == dice[2] && dice[2] == dice[3]
				&& dice[3] == dice[4])
					score = 50;
				if(score2Fields[5].getText().equals(""))
					score2Fields[5].setText(score + "");
				button.setEnabled(false);
				bottomScore += score;
				bottomScoreLabel.setText("Bottom Score: " + bottomScore);
				if(score == 50)
					score2Buttons[6].setEnabled(true);
			}

			// If button is 2nd Yahtzee
			if(button.getText().equals("2nd Yahtzee")) {
				if(dice[0] == dice[1] && dice[1] == dice[2] && dice[2] == dice[3]
				&& dice[3] == dice[4])
					score = 100;
				if(score2Fields[6].getText().equals(""))
					score2Fields[6].setText(score + "");
				button.setEnabled(false);
				bottomScore += score;
				bottomScoreLabel.setText("Bottom Score: " + bottomScore);
				if(score == 100)
					score2Buttons[7].setEnabled(true);
			}

			// If button is 3rd Yahtzee
			if(button.getText().equals("3rd Yahtzee")) {
				if(dice[0] == dice[1] && dice[1] == dice[2] && dice[2] == dice[3]
				&& dice[3] == dice[4])
					score = 100;
				if(score2Fields[7].getText().equals(""))
					score2Fields[7].setText(score + "");
				button.setEnabled(false);
				bottomScore += score;
				bottomScoreLabel.setText("Bottom Score: " + bottomScore);
			}

			// If button is Chance
			if(button.getText().equals("Chance")) {
				score = getTotal(dice);
				if(score2Fields[8].getText().equals(""))
					score2Fields[8].setText(score + "");
				button.setEnabled(false);
				bottomScore += score;
				bottomScoreLabel.setText("Bottom Score: " + bottomScore);
			}

			// Update total score
			if(topScore >= 63)
				bonus = 35;
			bonusLabel.setText("Bonus Score: " + bonus);
			total = bottomScore + topScore + bonus;
			totalLabel.setText("Total Score: " + total);

			// Update scoreClicked
			scoreClicked = true;
		}
	}

	public int getTotal(int[] nums) {
		int total = 0;
		for(int x = 0; x < nums.length; x++)
			total += nums[x];
		return total;
	}

	public boolean arrayContains(int[] nums, int a) {
		for(int x = 0; x < nums.length; x++)
			if(nums[x] == a)
				return true;
		return false;
	}

	public void itemStateChanged(ItemEvent event){

		// If button is selected, add to holdButtons list
		for(int x = 0; x < holdButtons.length; x++) {
			if(holdButtons[x].isSelected()) {
				if(!heldDice.contains(x)) {
					heldDice.add(x);
				}
			}
			// If button is unselected, remove from holdButtons list
			else {
				if(heldDice.contains(x))
					heldDice.remove((Integer)x);
			}
		}
	}
}
