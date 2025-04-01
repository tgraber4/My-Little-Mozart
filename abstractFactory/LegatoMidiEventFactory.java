package abstractFactory;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

public class LegatoMidiEventFactory implements MidiEventFactory {
	
	private static int noteOnCounter = 0;
	private static int noteOffCounter = 0;
	
	/**
	 * Creates a MIDI Node On event with 80 ticks longer duration
	 */
	@Override
	public MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
		ShortMessage message = new ShortMessage();
	    try {
			message.setMessage(ShortMessage.NOTE_ON, channel, note, velocity);
		} catch (javax.sound.midi.InvalidMidiDataException e) {
			e.printStackTrace();
		}
	    int newTickAmount = tick + this.getNoteOnCounter() * 80;
	    this.addNoteOnCounter();
	    return new MidiEvent(message, newTickAmount);
	}

	/**
	 * Creates a MIDI Node Off event with 80 ticks longer duration
	 */
	@Override
	public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
		ShortMessage message = new ShortMessage();
	    try {
			message.setMessage(ShortMessage.NOTE_OFF, channel, note, 0);
		} catch (javax.sound.midi.InvalidMidiDataException e) {
			e.printStackTrace();
		}
	    int newTickAmount = tick + (this.getNoteOffCounter() + 1) * 80;
	    this.addNoteOffCounter();
	    return new MidiEvent(message, newTickAmount);
	}
	
	/**
	 * Returns the amount of Note On MIDI Events that have been created so far
	 * @return
	 */
	private int getNoteOnCounter () {
		return noteOnCounter;
	}
	/**
	 * Adds 1 to the Note On counter
	 */
	private void addNoteOnCounter () {
		noteOnCounter++;
	}
	
	/**
	 * Returns the amount of Note Off MIDI Events that have been created so far
	 * @return
	 */
	private int getNoteOffCounter () {
		return noteOffCounter;
	}
	
	/**
	 * Adds 1 to the Note Off counter
	 */
	private void addNoteOffCounter () {
		noteOffCounter++;
	}

}
