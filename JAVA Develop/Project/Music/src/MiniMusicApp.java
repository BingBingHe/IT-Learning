import javax.sound.midi.*; // The midi package is necessary

public class MiniMusicApp {
    public static void main(String[] args) {
        MiniMusicApp mini = new MiniMusicApp();
        mini.play();
    }

    public void play() {
        try {
            // Get a sequencer and open it
            Sequencer player = MidiSystem.getSequencer();
            player.open();

            Sequence seq = new Sequence(Sequence.PPQ, 4); //Treat the arguments as Ready-bake arguments
           
            
            Track track = seq.createTrack(); // Ask the sequence for a track

            // Put some MidiEvents into the Track, the setMessage() method is what we should really care
            ShortMessage a = new ShortMessage();
            a.setMessage(144, 1, 44, 100);
            MidiEvent noteOn = new MidiEvent(a, 8);
            track.add(noteOn);

            ShortMessage b = new ShortMessage();
            b.setMessage(128, 1, 44, 100);
            MidiEvent noteOff = new MidiEvent(b, 32);
            track.add(noteOff); 

            player.setSequence(seq); // Give the sequence to the Sequencer
                                     // like pushing a CD to a CD player

            player.start();  // Start the sequencer like pushing PLAY
        }

        catch(Exception ex) {
            ex.printStackTrace();
        }
    }  // Close play
} // Close class