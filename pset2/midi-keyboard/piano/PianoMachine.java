package piano;

import javax.sound.midi.MidiUnavailableException;
import java.util.*;

import midi.Instrument;
import midi.Midi;
import music.Pitch;
import music.NoteEvent;

public class PianoMachine {

    private Midi midi;
    private Instrument DEFAULT_INSTRUMENT = Instrument.PIANO;
    public HashMap<String, Instrument> instrumentMap = new HashMap<>();
    public ArrayList<NoteEvent> note_event_arr = new ArrayList<>();
    public ArrayList<Pitch> onNote = new ArrayList<>();
    public int octShift = 0;
    public boolean record = false;
    public Instrument instrument = DEFAULT_INSTRUMENT;

    /**
     * constructor for PianoMachine.
     *
     * initialize midi device and any other state that we're storing.
     */
    public PianoMachine() {
        try {
            midi = Midi.getInstance();
            instrumentMap.put("PIANO", Instrument.PIANO);
        } catch (MidiUnavailableException e1) {
            System.err.println("Could not initialize midi device");
            e1.printStackTrace();
            return;
        }
    }

    public void beginNote(Pitch rawPitch) {
        if (onNote.contains(rawPitch) == false) {
            midi.beginNote(rawPitch.transpose(12 * octShift).toMidiFrequency(), instrument);
            onNote.add(rawPitch);
            note_event_arr.add(new NoteEvent(rawPitch.transpose(12 * octShift), System.currentTimeMillis(), instrument,
                    NoteEvent.Kind.start));
        }

    }

    public void endNote(Pitch rawPitch) {
        if (onNote.contains(rawPitch)) {
            midi.endNote(rawPitch.transpose(12 * octShift).toMidiFrequency(), instrument);
            onNote.remove(rawPitch);
            note_event_arr.add(new NoteEvent(rawPitch.transpose(12 * octShift), System.currentTimeMillis(), instrument,
                    NoteEvent.Kind.stop));
        }

    }

    public void changeInstrument() {
        instrument = instrument.next();
        instrumentMap.put(instrument.toString(), instrument);

    }

    public void shiftUp() {
        if (octShift < 2) {
            octShift++;
        }

    }

    public void shiftDown() {
        if (octShift > -2) {
            octShift--;
        }
    }

    public boolean toggleRecording() {
        if (record) {
            record = false;
            return false;
        } else {
            note_event_arr.clear();
            record = true;
            return true;
        }
    }

    public void playback() {
        long start_time = note_event_arr.get(0).getTime();
        for (NoteEvent note : note_event_arr) {
            if (note.getKind().equals(NoteEvent.Kind.start)) {
                Midi.rest((int) (note.getTime() - start_time) / 10);
                midi.beginNote(note.getPitch().toMidiFrequency(), note.getInstr());
                start_time = note.getTime();
            } else if (note.getKind().equals(NoteEvent.Kind.stop)) {
                Midi.rest((int) (note.getTime() - start_time) / 10);
                midi.endNote(note.getPitch().toMidiFrequency(), note.getInstr());
                start_time = note.getTime();
            }
        }
    }

}
