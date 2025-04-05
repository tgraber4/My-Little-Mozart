package pitch;

/**
 * Strategy that lowers the pitch by 2 semitones.
 */
public class LowerPitchStrategy implements PitchStrategy {
    
	/**
     * Decreases the note pitch by 2 semitones.
     *
     * @param note the original MIDI note
     * @return the note decreased by 2 semitones
     */
	@Override
	public int modifyPitch(int note) {
        return note - 2;
    }
}