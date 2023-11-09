import static java.lang.Thread.sleep;

public class Drummer implements Runnable {

    private String name;
    private Stick left;
    private Stick right;

    Drummer(String name, Stick left, Stick right) {
        this.name = name;
        this.left = left;
        this.right = right;
    }

    @Override
    public void run() {
        while(true) {

            synchronized (this) {
                while(left.getInUse()) {
                    try {
                        this.wait(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                left.setInUse(true);
                System.out.println(name + ": Podnioslem lewa paleczke.");
            }

            synchronized (this) {
                while(right.getInUse()) {
                    try {
                        this.wait(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                right.setInUse(true);
                System.out.println(name + ": Podnioslem prawa paleczke.");
            }

            try {
                System.out.println("Gram na bebnie.");
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (this) {
                left.setInUse(false);
                System.out.println(name + ": Oddalem lewa paleczke.");
                this.notify();
                right.setInUse(false);
                System.out.println(name + ": Oddalem prawa paleczke.");
                this.notify();
            }
        }
    }
}
