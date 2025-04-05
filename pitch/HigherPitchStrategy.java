package pitch;

/**
 * Strategy that raises the pitch by 2 semitones.
 */
public class HigherPitchStrategy implements PitchStrategy {
    
	/**
     * Increases the note pitch by 2 semitones.
     *
     * @param note the original MIDI note
     * @return the note increased by 2 semitones
     */
    @Override
	public int modifyPitch(int note) {
        return note + 2;
    }
}