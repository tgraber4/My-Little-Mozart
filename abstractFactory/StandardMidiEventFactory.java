package abstractFactory;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

public class StandardMidiEventFactory implements MidiEventFactory {

	/**
	 * Creates a normal MIDI Node On event.
	 */
	@Override
	public MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
		ShortMessage message = new ShortMessage();
	    try {
			message.setMessage(ShortMessage.NOTE_ON, channel, note, velocity);
		} catch (javax.sound.midi.InvalidMidiDataException e) {
			e.printStackTrace();
		}
	    return new MidiEvent(message, tick);
	}

	/**
	 * Creates a normal MIDI Node Off event.
	 */
	@Override
	public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
		ShortMessage message = new ShortMessage();
	    try {
			message.setMessage(ShortMessage.NOTE_OFF, channel, note, 0);
		} catch (javax.sound.midi.InvalidMidiDataException e) {
			e.printStackTrace();
		}
	    return new MidiEvent(message, tick);
	}

}
