import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.table.TableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.AbstractTableModel;
import javax.sound.midi.Instrument;
import javax.sound.midi.Synthesizer;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class InstrumentsTable extends JPanel {

	private JTable table;  // Table that holds all possible instruments

	// Table dimensions
	//  Only show first 128 instruments from default sound bank 0
    private final int nRows = 8;
    private final int nCols = 16;

    // Panel dimensions
    private final int WIDTH = 800;
    private final int HEIGHT = 170;
    private final int colWidth = 110;

    // Midi objects needed
    private final ChannelData current;
    private final Instrument[] instruments;
    private final Synthesizer synthesizer;

    // Table column headers
    private String names[] = {
       "Piano", "Chromatic Perc.", "Organ", "Guitar",
       "Bass", "Strings", "Ensemble", "Brass",
       "Reed", "Pipe", "Synth Lead", "Synth Pad",
       "Synth Effects", "Ethnic", "Percussive", "Sound Effects" };

	// Constructor
	//  @param current -> channel data being altered to fit new instrument selected
	//  @param instrumentList -> array of instruments that will be available to user via table
	//  @param synth -> syntehsizer to load new instrument into
    public InstrumentsTable(ChannelData cc, Instrument[] instrumentList, Synthesizer synth) {

		// Store parameters in class variables
    	current = cc;
    	instruments = instrumentList;
    	synthesizer = synth;

		// Set layout
        setLayout(new BorderLayout());

		// Create a new abstract table model
        TableModel dataModel = new AbstractTableModel() {

        	// Returns column count
            public int getColumnCount() {
            	return nCols;
            }

            // Returns row count
            public int getRowCount() {
            	return nRows;
            }

            // Returns object at position row, column
            public Object getValueAt(int r, int c) {
            	if (instruments != null)
              		return instruments[c*nRows+r].getName();
              	else
                    return Integer.toString(c*nRows+r);
            }

            // Returns name of column from names[]
            public String getColumnName(int c) {
                return names[c];
            }

            // Returns class found within any given column
            public Class getColumnClass(int c) {
                return getValueAt(0, c).getClass();
            }

            // Returns false, as no cell is editable
            public boolean isCellEditable(int r, int c) {
            	return false;
            }

            // Sets value at row, column to new object
            //  No action, as no cell is editable
            public void setValueAt(Object obj, int r, int c) {
            }
        };

		// Create new table using previously defined model
        table = new JTable(dataModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Can only select one cell at a time

        // Listener for row changes
        ListSelectionModel lsm = table.getSelectionModel();

        lsm.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
            	// Set row of current channel data to selected row
                ListSelectionModel sm = (ListSelectionModel) e.getSource();
                if (!sm.isSelectionEmpty())
                    current.setRow(sm.getMinSelectionIndex());
                // Update midi objects
                programChange(current.getCol()*nRows+current.getRow());
            }
        });

        // Listener for column changes
        lsm = table.getColumnModel().getSelectionModel();

        lsm.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
            	// Set col of current channel data to selected column
                ListSelectionModel sm = (ListSelectionModel) e.getSource();
                if (!sm.isSelectionEmpty())
                    current.setCol(sm.getMinSelectionIndex());
                // Update midi objects
                programChange(current.getCol()*nRows+current.getRow());
            }
        });

		//  Set table settings
        table.setPreferredScrollableViewportSize(new Dimension(nCols*colWidth, 200)); // Set dimensions of scrollable table
        table.setCellSelectionEnabled(true); // Enable cell selection
        table.setColumnSelectionAllowed(true); // Enable user to select columns
        // Set names and widths of columns
        for (int i = 0; i < names.length; i++) {
            TableColumn column = table.getColumn(names[i]);
            column.setPreferredWidth(colWidth);
        }
        table.setAutoResizeMode(table.AUTO_RESIZE_OFF); // Do not automatically resize

		// Create Scroll Pane to make table horizontallly scrollable
        JScrollPane sp = new JScrollPane(table);
        sp.setVerticalScrollBarPolicy(sp.VERTICAL_SCROLLBAR_NEVER);
        sp.setHorizontalScrollBarPolicy(sp.HORIZONTAL_SCROLLBAR_ALWAYS);
        add(sp);
    }

    // Set dimensions of panel
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }
    public Dimension getMaximumSize() {
        return new Dimension(WIDTH, HEIGHT);
    }

	// Loads selected instrument to synthesizer
	// Changes program through midi channel in current channel data
    private void programChange(int program) {
        if (instruments != null) {
            synthesizer.loadInstrument(instruments[program]);
        }
        current.getChannel().programChange(program);
    }
}