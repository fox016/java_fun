/**
 * @(#)FoxPiano.java
 *
 * FoxPiano application
 *
 * @author Nate Fox
 * @version 1.00 2010/12/11
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Sequence;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.Instrument;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Soundbank;
import javax.sound.midi.MidiChannel;
import java.util.HashMap;

public class FoxPiano extends JPanel implements KeyListener, ActionListener{

	// Musical Objects
    private Sequence sequence;
    private Synthesizer synthesizer;
    private Instrument[] instruments;
    private ChannelData[] channels;
    private ChannelData current;

    // GUI Objects
    private JFrame tableFrame;  // Frame that holds table of instruments to select
    private JPanel instrumentPanel; // Panel at south end to hold change instrument button
    private JButton changeInstrument; // Button that pulls up table frame

    // Booleans, values can be toggled by user during runtime
    private boolean hiOctave = true; // If true, plays in higher octave
    private boolean pedal = false;   // If true, can play chords and notes are held out

    // PianoKey arrays holding piano keys
    private PianoKey[] whiteKeys;
    private PianoKey[] blackKeys;
    private PianoKey lastKey;

    // Arrays holding integer values of notes for keys, integers holding starting notes
    private int[] whiteNotes;
    private int[] blackNotes;
    private int whiteNote = 43; // Holds starting white note (low g)
    private int blackNote = 44; // Holds starting black note (low a sharp)

    // Maps pairing values of keys typed to a PianoKey Object
    private HashMap<Integer, PianoKey> highKeyMap;
    private HashMap<Integer, PianoKey> lowKeyMap;
    private final int[] whiteMapKeys = {KeyEvent.VK_A, KeyEvent.VK_S, KeyEvent.VK_D, KeyEvent.VK_F,
    							KeyEvent.VK_G, KeyEvent.VK_H, KeyEvent.VK_J, KeyEvent.VK_K,
    							KeyEvent.VK_L, KeyEvent.VK_SEMICOLON};
    private final int[] lowBlackMapKeys = {KeyEvent.VK_W, KeyEvent.VK_E, KeyEvent.VK_T, KeyEvent.VK_Y,
    							KeyEvent.VK_I, KeyEvent.VK_O, KeyEvent.VK_P};
    private final int[] highBlackMapKeys = {KeyEvent.VK_W, KeyEvent.VK_E, KeyEvent.VK_T, KeyEvent.VK_Y,
    							KeyEvent.VK_U, KeyEvent.VK_O, KeyEvent.VK_P};

    // Final integers defining sizes of keys
    private final int pianoXCoor = 80; // Upper left corner of piano, x-coor
    private final int pianoYCoor = 140; // Upper left corner of piano, y-coor
    private final int blackStart = pianoXCoor + 10; // Upper left corner of first black key, x-coor
    private final int whiteWidth = 15;  // Width of white keys
    private final int blackWidth = 12;  // Width of black keys
    private final int blackSpace = 4;   // Space between black keys
    private final int whiteCount = 20;  // Number of white keys on screen
    private final int blackCount = 14;  // Number of black keys on screen
    private final int frameDif   = 50;  // Just don't worry about it

    // Final integers defining which black keys to skip on keyboard
    private final int blackSkipOne = 2;
    private final int blackSkipTwo = 5;
    private final int blackSkipThree = 9;
    private final int blackSkipFour = 12;
    private final int blackSkipFive = 16;

    // Final integer to define resolution (ticks per quarter note)
    private final int resolution = 10;

    // Final static integers determining size of frame
    private static final int WIDTH = 500;
    private static final int HEIGHT = 300;

	// Constructor
	public FoxPiano() {

		// Create green panel
		super();
		this.setBackground(Color.green);

		// Add instrument panel to bottom
		this.setLayout(new BorderLayout()); // Set layout of main panel
		instrumentPanel = new JPanel();
		changeInstrument = new JButton("Change Instrument"); // Create change instrument button
		instrumentPanel.add(changeInstrument);  // Add button to panel
		this.add(instrumentPanel, BorderLayout.SOUTH); // Add panel to south end of main panel

		// Add listeners
		changeInstrument.addKeyListener(this);
		changeInstrument.addActionListener(this);

		// Create keys
		createKeys();

    	// Run music setup
    	runMusicSetup();
	}

	// Paints piano
	public void paintComponent(Graphics graphics) {

		super.paintComponent(graphics);

		// Paint keys
		drawWhiteKeys(graphics);
		drawBlackKeys(graphics);

		// Fill in last key played
		if(lastKey != null) {
			lastKey.fill(graphics);
			// If last key played was white, redraw blacks on top
				if(lastKey.getColor().equals(Color.white))
					drawBlackKeys(graphics);
		}
	}

	// Draws all white keys
	private void drawWhiteKeys(Graphics g) {

    	for(int i = 0; i < whiteKeys.length; i++)
    		whiteKeys[i].drawKey(g);
	}

	// Draws all black keys
	private void drawBlackKeys(Graphics g) {

		for(int i = 0; i < blackKeys.length; i++)
			blackKeys[i].drawKey(g);
	}

	// Defines where piano keys are placed, what notes they represent,
	// and what key on the keyboard triggers each key
	private void createKeys() {

		// Define notes that each key will play
		// Store in whiteNotes[] and blackNotes[]
		whiteNotes = new int[whiteCount];
		blackNotes = new int[blackCount];

		// Set up white notes
		for(int x = 0; x < whiteCount; x++) {
			whiteNotes[x] = whiteNote;
    		if (x == blackSkipOne ||
    			x == blackSkipTwo ||
    			x == blackSkipThree ||
    			x == blackSkipFour ||
    			x == blackSkipFive)
    				whiteNote++;
    		else whiteNote +=2;
		}

		// Set up black notes
		for(int x = 0; x < blackCount; x++) {
			blackNotes[x] = blackNote;
    		if (x == blackSkipOne - 1 ||
    			x == blackSkipTwo - 2 ||
    			x == blackSkipThree - 3 ||
    			x == blackSkipFour - 4 ||
    			x == blackSkipFive - 5)
    				blackNote+=3;
    		else blackNote +=2;
		}

		// Define coordinates for keys to exist at (upper left x-coordinate)
		// Store in whiteKeys[] and blackKeys[]
    	whiteKeys = new PianoKey[whiteCount];
    	blackKeys = new PianoKey[blackCount];

    	// Set up whiteKeys[]
    	for(int x = pianoXCoor, i = 0; i < whiteCount; x += whiteWidth + 1, i++)
    		whiteKeys[i] = new PianoKey(Color.white, x, whiteNotes[i]);

    	// Set up blackKeys[]
    	for(int x = blackStart, i = 0; i < blackCount; x += blackWidth + blackSpace) {

    		// For black keys, skip in 5 different places where black keys don't exist
    		if (x == blackStart + (blackWidth + blackSpace) * blackSkipOne ||
    			x == blackStart + (blackWidth + blackSpace) * blackSkipTwo ||
    			x == blackStart + (blackWidth + blackSpace) * blackSkipThree ||
    			x == blackStart + (blackWidth + blackSpace) * blackSkipFour ||
    			x == blackStart + (blackWidth + blackSpace) * blackSkipFive)
    			continue;

    		// Else, add coordinates to blackKeys[]
    		else {
    			blackKeys[i] = new PianoKey(Color.black, x, blackNotes[i]);
    			i++;
    		}
    	}

    	// Pair up values of keys typed to PianoKey Objects
    	lowKeyMap = new HashMap<Integer, PianoKey>();
    	highKeyMap = new HashMap<Integer, PianoKey>();
    	for(int x = 0; x < whiteMapKeys.length; x++) {
    		lowKeyMap.put(whiteMapKeys[x], whiteKeys[x]);
    		highKeyMap.put(whiteMapKeys[x], whiteKeys[x + (whiteCount/2)]);
    	}
    	for(int x = 0; x < lowBlackMapKeys.length; x++) {
    		lowKeyMap.put(lowBlackMapKeys[x], blackKeys[x]);
    		highKeyMap.put(highBlackMapKeys[x], blackKeys[x + (blackCount/2)]);
    	}
	}

	// Sets up midi objects
	private void runMusicSetup() {

    	// Create Synthesizer and Sequence
        try {
            if (synthesizer == null) {
                if ((synthesizer = MidiSystem.getSynthesizer()) == null) { // If can't get synthesizer, print error
                    System.err.println("getSynthesizer() failed!");
                    return;
                }
            }
            synthesizer.open(); // Open synthesizer
            sequence = new Sequence(Sequence.PPQ, resolution);  // Create new sequence using tempo-based timing
        }catch (Exception ex) {
        	ex.printStackTrace(); // If any exceptions, print stack
        	return;
        }

		// Load instrument
        Soundbank soundbank = synthesizer.getDefaultSoundbank(); // Get default soundbank
		if (soundbank != null) {
            instruments = soundbank.getInstruments(); // If no default, load instruments from soundbank
            synthesizer.loadAllInstruments(soundbank); // Load all instruments from soundbank to synthesizer
        }

        // Create channels
        MidiChannel midiChannels[] = synthesizer.getChannels(); // Get midi channels from synthesizer
        channels = new ChannelData[midiChannels.length];        // Initialize channels[]
        for (int i = 0; i < channels.length; i++) {
            channels[i] = new ChannelData(midiChannels[i]);  // Put all midi channels from synthesizer into channels[]
            											     // by creating new ChannelData objects
        }
        current = channels[0];  // Set current channel to first channel in array
	}

	// Responds to key pressed
	//  Up and down keys change octaves
	//  V toggles pedal
	//  Esc terminates program
	//  Home row keys and choice upper row keys play notes
	public void keyPressed(KeyEvent event) {

		// If pedal is off, kill all other notes playing
		if(!pedal)
			current.getChannel().allNotesOff();

		// Up and down keys change octaves
		if(event.getKeyCode() == KeyEvent.VK_DOWN)
			hiOctave = false;
		else if(event.getKeyCode() == KeyEvent.VK_UP)
			hiOctave = true;

		// V key toggles pedal
		else if(event.getKeyCode() == KeyEvent.VK_V)
			pedal = !pedal;

		// Escape exits
		else if(event.getKeyCode() == KeyEvent.VK_ESCAPE)
			System.exit(0);

		// Test and see if maps contain key pressed
		else if(highKeyMap.containsKey((Object)event.getKeyCode()) || lowKeyMap.containsKey((Object)event.getKeyCode())) {
			// Store whichever key was pressed as lastKey
			if(hiOctave)
				lastKey = highKeyMap.get(event.getKeyCode());
			else
				lastKey = lowKeyMap.get(event.getKeyCode());
			// Play key and repaint
			lastKey.playKey(current.getChannel(), getGraphics());
			repaint();
		}
	}

	// Responds to change instrument button being clicked
	public void actionPerformed(ActionEvent event) {

		// When button is pressed, bring up instrument table in new frame (tableFrame)
		tableFrame = new JFrame();
		tableFrame.add(new InstrumentsTable(current, instruments, synthesizer));
		tableFrame.pack();
		tableFrame.setResizable(false);

		// Set location of frame
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		tableFrame.setLocation(dim.width/2 - tableFrame.getWidth()/2, dim.height/2 + frameDif);
		tableFrame.setVisible(true);
	}

	// Needed to satisfy demands of KeyListener interface
	public void keyReleased(KeyEvent event) {
	}

	// Needed to satisfy demands of KeyListener interface
	public void keyTyped(KeyEvent event) {
	}

	// Sets up frame
    public static void main(String[] args) {

    	FoxPiano foxPiano = new FoxPiano();

    	// Create frame
    	JFrame frame = new JFrame("FoxPiano 7.9");
    	frame.setSize(WIDTH, HEIGHT);
    	frame.setResizable(false);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.add(foxPiano);  // Add FoxPiano panel to frame

    	// Set frame location and set visble
    	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    	frame.setLocation(dim.width/2 - WIDTH/2, dim.height/2 - HEIGHT);
    	frame.setVisible(true);
    }
}
