import javax.sound.midi.*;
import java.util.*;
import csvParse.*;
import abstractFactory.*;
import pitch.*;
import instrument.*;

//The mystery song is Bad Guy by Billie Eilish.

/**
 * Reads CSV, applies strategies, and plays the sequence.
 */
public class Main {
    public static void main(String[] args) {
        try {
            MidiCsvParser parser = new MidiCsvParser();
            List<MidiEventData> midiEvents = parser.parseCsv("./files/mystery_song.csv");
            
            Sequence sequence = new Sequence(Sequence.PPQ, 384);
            Track track = sequence.createTrack();

            //Choose a factory
            
            MidiEventFactoryAbstract factoryAbstract = new StandardMidiEventFactoryAbstract();
            //MidiEventFactoryAbstract factoryAbstract = new LegatoMidiEventFactoryAbstract();
            //MidiEventFactoryAbstract factoryAbstract = new StaccatoMidiEventFactoryAbstract();
            
            MidiEventFactory factory = factoryAbstract.createFactory();

            //Choose an instrument strategy
            InstrumentStrategy instrumentStrategy = new ElectricBassGuitarStrategy();
            instrumentStrategy.applyInstrument(track, 0);
            instrumentStrategy = new TrumpetStrategy();
            instrumentStrategy.applyInstrument(track, 1);
            instrumentStrategy = new AcousticGrandPianoStrategy();
            instrumentStrategy.applyInstrument(track, 2);
            
            // Choose a pitch strategy
            PitchStrategy pitchStrategy = new HigherPitchStrategy();

            for (MidiEventData event : midiEvents) {
                int modifiedNote = pitchStrategy.modifyPitch(event.getNote());
                modifiedNote = pitchStrategy.modifyPitch(modifiedNote);
                
                if (event.getNoteOnOff() == 1) {
                    track.add(factory.createNoteOn(
                        event.getStartEndTick(), 
                        modifiedNote, 
                        event.getVelocity(), 
                        event.getChannel()
                    ));
                } else {
                    track.add(factory.createNoteOff(
                        event.getStartEndTick(), 
                        modifiedNote, 
                        event.getChannel()
                    ));
                }
            }

            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.setSequence(sequence);
            sequencer.start();

            while (sequencer.isRunning() || sequencer.isOpen()) {
                Thread.sleep(100);
            }
            Thread.sleep(500);
            sequencer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
