import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Results results = new Results(10000000000L);
        Observer observer = new Observer(2000, results);

        List<Shot> shots = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            shots.add(new Shot(results, i * 50 + 50));
        }

        Thread threadObserver = new Thread(observer);
        threadObserver.start();

        for(Shot shot : shots) {
            Thread threadShot = new Thread(shot);
            threadShot.start();
        }
    }
}
