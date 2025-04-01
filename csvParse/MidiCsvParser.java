package csvParse;

import java.io.*;
import java.util.*;

public class MidiCsvParser {
	
		
	public MidiCsvParser() {
	
	}
	/**
	 * Takes in a file path to a CSV file and returns a list of MidieventDatas pulled from
	 * that CSV file. 
	 * @param filePath
	 * @return
	 */
	public List <MidiEventData> parseCsv (String filePath) {
        
		List <MidiEventData> parsedList = new ArrayList<MidiEventData>();
		
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(","); 
                // System.out.println(values[0] + " and " + values[1] + " and " + values[2] + " and " + values[3] + " and " + values[4] + " and " + values[5]);
                
                
                int startEndTick = Integer.parseInt(values[0]);
                int velocity = Integer.parseInt(values[4]);
                int note = Integer.parseInt(values[3]);
                int channel = Integer.parseInt(values[2]);
                int noteOnOff;
                if (values[1].trim().equals("Note_off_c")) {
                	noteOnOff = 0;
                } else {
                	noteOnOff = 1;
                }
                int instrument = Integer.parseInt(values[5]);
                
                parsedList.add(new MidiEventData(startEndTick, velocity, note, channel, noteOnOff, instrument));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parsedList;
    }
	
}
