/**
 * @(#)ChoiceBox.java
 *
 *
 * @author
 * @version 1.00 2010/11/11
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChoiceBox extends JFrame implements ActionListener {

	// GUI Objects
	private JPanel panel;             // Panel
	private JRadioButton xButton;     // Radio Button - select to play X
	private JRadioButton oButton;     // Radio Button - select to play O
	private ButtonGroup buttonGroup;  // Groups 2 buttons (can't select both)
	private JButton goButton;         // Go Button

	// Booleans - store what user selects
	private boolean selectedX;
	private boolean selectedO;

    public ChoiceBox() {

    	// Initiate booleans to false
    	selectedX = false;
    	selectedO = false;

    	// Create radio buttons
    	xButton = new JRadioButton("Be Player \"X\"");
    	oButton = new JRadioButton("Be Player \"O\"");
    	buttonGroup = new ButtonGroup();
    	buttonGroup.add(xButton);
    	buttonGroup.add(oButton);
    	xButton.setSelected(true);

    	// Create go button
    	goButton = new JButton("GO!");
    	goButton.addActionListener(this);

    	// Create panel
    	panel = new JPanel();
    	panel.add(xButton);
    	panel.add(oButton);
    	panel.add(goButton);

    	// Create frame
    	this.add(panel);
    	this.setSize(275,100);
    	this.setLocation(500, 300);
    	this.setResizable(false);
    	this.setVisible(true);
    	this.setTitle("Choose X or O");
    	this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent event) {

    	// Set booleans based on user selection
    	if(xButton.isSelected())
    		selectedX = true;
    	else
    		selectedO = true;

    	// Set invisible
    	this.setVisible(false);
    }

    public boolean selectedX() {
    	return selectedX;
    }

    public boolean selectedO() {
    	return selectedO;
    }

    public static void main(String[] args) {
    	// Test choice box
    	ChoiceBox box = new ChoiceBox();
    }
}