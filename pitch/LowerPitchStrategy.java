package pitch;

public class LowerPitchStrategy implements PitchStrategy {
    public int modifyPitch(int note) {
        return note - 2;
    }
}