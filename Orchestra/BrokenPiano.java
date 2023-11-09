public class BrokenPiano extends SingleInstrument{

    public BrokenPiano(int playCount, int interval) {
        super(playCount, interval);
    }

    @Override
    public void play() throws BrokenInstrumentException {
        throw new BrokenInstrumentException("Pianino zepsute");
    }
}
