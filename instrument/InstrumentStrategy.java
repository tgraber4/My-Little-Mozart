package instrument;

import javax.sound.midi.*;

/**
 * Interface for applying an instrument change to a MIDI track on a specific channel.
 */
public interface InstrumentStrategy {
    
	/**
     * Applies the instrument to the specified MIDI track and channel.
     *
     * @param track the MIDI track to apply the instrument to
     * @param channel the MIDI channel number
     * @throws InvalidMidiDataException if an error occurs while setting the instrument
     */
	void applyInstrument(Track track, int channel) throws InvalidMidiDataException;
}