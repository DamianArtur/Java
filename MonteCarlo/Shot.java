import java.util.Random;

public class Shot implements Runnable {

    private Results results;
    private int seriesSize;

    Shot(Results results, int seriesSize) {
        this.results = results;
        this.seriesSize = seriesSize;
    }

    public void run() {
        Random random = new Random();

        while(results.notAllShotsTaken()) {
            int shotsInCircle = 0;

            for(int i = 0; i < seriesSize; i++) {
                double x = random.nextDouble();
                double y = random.nextDouble();

                if(Math.pow(x, 2.0) + Math.pow(y, 2.0) < 1) {
                    shotsInCircle++;
                }
            }

            synchronized (this) {
                results.setShotsInCircle(results.getShotsInCircle() + shotsInCircle);
                results.setAllShots(results.getAllShots() + seriesSize);
            }
        }
    }
}
