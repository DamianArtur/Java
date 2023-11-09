public interface Instrument extends Runnable {
    void play() throws BrokenInstrumentException;
}
