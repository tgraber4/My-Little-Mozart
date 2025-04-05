package pitch;

/**
 * Interface for modifying the pitch of a MIDI note.
 */
public interface PitchStrategy {
    
	/**
     * Modifies the given MIDI note pitch.
     *
     * @param note the original MIDI note
     * @return the modified MIDI note pitch
     */
	int modifyPitch(int note);
}
