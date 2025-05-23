package csvParse;

public class MidiEventData {
	private int startEndTick;
	private int velocity;
	private int note;
	private int channel;
	private int noteOnOff; // 1 == on && 0 == off
	private int instrument;
	
	/**
	 * Creates a MidiEventData object using the given parameters:
	 * @param startEndTick
	 * @param velocity
	 * @param note
	 * @param channel
	 * @param noteOnOff
	 * @param instrument
	 */
	public MidiEventData(int startEndTick, int velocity, int note, int channel, int noteOnOff, int instrument) {
		this.startEndTick = startEndTick;
		this.velocity = velocity;
		this.note = note;
		this.channel = channel;
		this.noteOnOff = noteOnOff;
		this.instrument = instrument;
	}
	public int getStartEndTick() {
		return startEndTick;
	}
	public void setStartEndTick(int startEndTick) {
		this.startEndTick = startEndTick;
	}
	public int getVelocity() {
		return velocity;
	}
	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	public int getChannel() {
		return channel;
	}
	public void setChannel(int channel) {
		this.channel = channel;
	}
	public int getNoteOnOff() {
		return noteOnOff;
	}
	public void setNoteOnOff(int noteOnOff) {
		this.noteOnOff = noteOnOff;
	}
	public int getInstrument() {
		return instrument;
	}
	public void setInstrument(int instrument) {
		this.instrument = instrument;
	}
	
	
	
}
