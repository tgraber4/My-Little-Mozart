import java.io.IOException;

import csvParse.MidiCsvParser;

public class Main {

	public static void main(String[] args) {
		MidiCsvParser test = new MidiCsvParser();
		test.parseCsv("src\\files\\mystery_song.csv");

	}

}
