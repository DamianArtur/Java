import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Stick> stickList = new ArrayList<>();
        List<Drummer> drummerList = new ArrayList<>();

        for(int i = 0; i < 5; i++) {
            stickList.add(new Stick());
        }

        for(int i = 0; i < 5; i++) {
            drummerList.add(new Drummer(Integer.toString(i+1), stickList.get(i), stickList.get((i+1) % 5)));
        }

        for(Drummer drummer : drummerList) {
            Thread drummerThread = new Thread(drummer);
            drummerThread.start();
        }
    }
}
