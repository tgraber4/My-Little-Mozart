import java.io.IOException;
import java.util.List;

import javax.sound.midi.InvalidMidiDataException;

import abstractFactory.LegatoMidiEventFactoryAbstract;
import abstractFactory.MidiEventFactory;
import abstractFactory.MidiEventFactoryAbstract;
import abstractFactory.StaccatoMidiEventFactoryAbstract;
import csvParse.MidiCsvParser;
import csvParse.MidiEventData;

public class Main {

	public static void main(String[] args) throws InvalidMidiDataException {
		MidiCsvParser test = new MidiCsvParser();
		List <MidiEventData> resultList = test.parseCsv("src\\files\\mystery_song.csv");
		for (MidiEventData temp : resultList) {
			// System.out.println("" + temp.getNoteOnOff() + "");
		}
		
		MidiEventFactoryAbstract factoryAbstract = null;
		factoryAbstract = new LegatoMidiEventFactoryAbstract();
		MidiEventFactory factory = factoryAbstract.createFactory();
		
	}

}
