import java.awt.Color;
import java.awt.Graphics;
import javax.sound.midi.MidiChannel;

public class PianoKey {

	private Color color; // Color of key (black or white)
	private int xCoor; // Upper left corner x coordinate
	private int width; // Width of key
	private int height; // Height of key
	private int noteNumber; // Note number needed by midi channel to play correct note
	private final int velocity = 64;

	// Static final integers defining width and height of keys depending on color
	private static final int whiteWidth = 15;
	private static final int whiteHeight = 60;
	private static final int blackWidth = 12;
	private static final int blackHeight = 35;
	private static final int yCoor = 140;

	// Constructor
	//  @param color -> color of key (Color.black or Color.white)
	//  @param xCoor -> x-coordinate of upper-left corner
	//  @param note  -> integer value of note given by MidiChannel class
	public PianoKey(Color color, int xCoor, int note) {

		this.color = color;
		this.xCoor = xCoor;
		noteNumber = note;

		if(color.equals(Color.black)) {
			width = blackWidth;
			height = blackHeight;
		}

		else {
			width = whiteWidth;
			height = whiteHeight;
		}
	}

	// Draws key on panel
	public void drawKey(Graphics graphics) {

		// If a white key, draw black outline around it
		if(color.equals(Color.white)) {
			graphics.setColor(Color.black);
			graphics.drawRect(xCoor-1, yCoor-1, width+1, height+1);
		}

		// Draw key
		graphics.setColor(color);
		graphics.fillRect(xCoor, yCoor, width, height);
	}

	// Plays note that key represents
	public void playKey(MidiChannel channel, Graphics graphics) {
		channel.noteOn(noteNumber, velocity);
	}

	// Colors the key a light blue color, represents last key played
	public void fill(Graphics graphics) {
		graphics.setColor(Color.cyan);
		graphics.fillRect(xCoor, yCoor, width, height);
	}

	// Returns color of key, either Color.white or Color.black
	public Color getColor() {
		return color;
	}
}