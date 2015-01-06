import javax.sound.midi.MidiChannel;

public class ChannelData {

    private MidiChannel channel; // Holds midi channel that plays music
    private int row;	// Set and accessed only by InstrumentsTable class in order to change instrument correctly
    private int col;    // Set and accessed only by InstrumentsTable class in order to change instrument correctly

	// Constructor
	//  @param channel -> midi channel which the midi sounds will be played through (see PianoKey class)
    public ChannelData(MidiChannel channel) {
        this.channel = channel;
    }

	// Returns channel
    public MidiChannel getChannel() {
    	return channel;
    }

	// Sets row to that of the instrument selected in instrument table
    public void setRow(int row) {
    	this.row = row;
    }

	// Returns row
    public int getRow() {
    	return row;
    }

	// Sets col to that of the instrument selected in instrument table
    public void setCol(int col) {
    	this.col = col;
    }

	// Returns col
    public int getCol() {
    	return col;
    }
}