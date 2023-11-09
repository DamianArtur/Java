public abstract class SingleInstrument implements Instrument {

    private final int playCount;
    private final int interval;

    public SingleInstrument(int playCount, int interval) {
        this.playCount = playCount;
        this.interval = interval;
    }

    @Override
    public void run() {
        for(int i = 0; i < playCount; i++) {
            try {
                play();
            } catch (BrokenInstrumentException e) {
                System.out.println(e.getMessage());
            }
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Guitar guitar = new Guitar(10, 100);
        Thread guitarThread = new Thread(guitar);
        guitarThread.start();
        System.out.println("Gadam w trakcie" + Thread.currentThread());
        try {
            guitarThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Koncert skonczony");
    }
}
