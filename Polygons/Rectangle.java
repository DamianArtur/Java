import java.util.Arrays;

public class Rectangle extends Polygon {

    public Rectangle(int a, int b) {
        super(Arrays.asList(a, b, a, b));
    }

    public double surface() {
        return sides.get(0) * sides.get(1);
    }
}
