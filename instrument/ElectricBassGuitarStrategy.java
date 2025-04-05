package instrument;

import javax.sound.midi.*;

/**
 * Instrument strategy that applies the Electric Bass Guitar sound.
 * Uses MIDI instrument number 33.
 */
public class ElectricBassGuitarStrategy implements InstrumentStrategy {
	
	/**
     * Applies the Electric Bass Guitar instrument to the specified track and channel.
     *
     * @param track   the MIDI track to which the instrument is applied
     * @param channel the MIDI channel number
     * @throws InvalidMidiDataException if there is an error setting the instrument
     */
	@Override
	  public void applyInstrument(Track track, int channel) {
	        try {
	            ShortMessage changeInstrument = new ShortMessage();
	            changeInstrument.setMessage(ShortMessage.PROGRAM_CHANGE, channel, 33, 0);
	            track.add(new MidiEvent(changeInstrument, 0));
	        } catch (InvalidMidiDataException e) {
	            e.printStackTrace();
	        }
	    }
}