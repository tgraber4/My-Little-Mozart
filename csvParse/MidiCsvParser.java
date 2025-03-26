package csvParse;

import java.io.*;
import java.util.*;

public class MidiCsvParser {
	
		
	public MidiCsvParser() {
	
	}

	public void parseCsv (String filePath) {
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(","); 
                System.out.println(values[0] + " and " + values[1] + " and " + values[2] + " and " + values[3] + " and " + values[4] + " and " + values[5]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
}
