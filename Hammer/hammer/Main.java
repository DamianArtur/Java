import hammer.items.Nail;
import hammer.items.Wall;
import zad0.tools.Hammer;

public class Main {

    public static void main(String[] args) {
        Nail nail1 = new Nail();
        Nail nail2 = new Nail();
        Nail nail3 = new Nail();
        Nail nail4 = new Nail();

        Hammer hammer1 = new Hammer("World of Hammers");
        Hammer hammer2 = new Hammer("Best Hammers");

        Wall wall1 = new Wall("zielona");
        Wall wall2 = new Wall("niebieska");

        hammer1.hammerNail(nail1, wall1);
        hammer2.hammerNail(nail2, wall2);
        hammer1.hammerNail(nail1, wall2);
        hammer2.hammerNail(nail2, wall1);

        wall1.setColour("czerwona");
        hammer1.hammerNail(nail3, wall1);
        hammer2.hammerNail(nail3, wall1);

        wall2.setColour("czarna");
        hammer1.hammerNail(nail4, wall2);
        hammer1.hammerNail(nail4, wall2);

    }
}
