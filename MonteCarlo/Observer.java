import static java.lang.Thread.sleep;

public class Observer implements Runnable {

    private int interval;
    private Results results;

    Observer(int interval, Results results) {
        this.interval = interval;
        this.results = results;
    }

    public void run() {
        synchronized (this) {
            while(results.notAllShotsTaken()) {
                System.out.println(results.getPiApproximation());
                try {
                    sleep(interval);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(results.getPiApproximation());
        }
    }
}
