import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Orchestra implements Instrument {

    private final List<Instrument> instruments = new LinkedList<>();

    public void addInstrument(Instrument instrument) {
        instruments.add(instrument);
    }

    @Override
    public void play() {
        List<Thread> threads = new ArrayList<>();
        for(Instrument instrument : instruments) {
            Thread instrumentThread = new Thread(instrument);
            threads.add(instrumentThread);
            instrumentThread.start();
        }
        for(Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("Dziekujemy za uwage.");
    }

    public static void main(String[] args) {
        Orchestra orchestra = new Orchestra();
        orchestra.addInstrument(new Flute(10, 100));
        orchestra.addInstrument(new Trombone(10, 50));
        orchestra.addInstrument(new Guitar(10, 200));
        orchestra.addInstrument(new BrokenPiano(10, 100));
        orchestra.play();
    }

    @Override
    public void run() {
        play();
    }
}
