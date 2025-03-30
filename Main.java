import java.io.IOException;
import java.util.List;

import csvParse.MidiCsvParser;
import csvParse.MidiEventData;

public class Main {

	public static void main(String[] args) {
		MidiCsvParser test = new MidiCsvParser();
		List <MidiEventData> resultList = test.parseCsv("src\\files\\mystery_song.csv");
		for (MidiEventData temp : resultList) {
			System.out.println("" + temp.getNoteOnOff() + "");
		}
	}

}
