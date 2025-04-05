package pitch;

public class HigherPitchStrategy implements PitchStrategy {
    public int modifyPitch(int note) {
        return note + 2;
    }
}