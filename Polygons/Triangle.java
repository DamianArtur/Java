import java.util.Arrays;

public class Triangle extends Polygon {

    public Triangle(int a, int b, int c) {
        super(Arrays.asList(a, b, c));
    }

    public double surface() {
        double halfOfPerimeter = this.perimeter() / 2;
        return Math.sqrt(halfOfPerimeter*(halfOfPerimeter-sides.get(0))*(halfOfPerimeter-sides.get(1))*(halfOfPerimeter-sides.get(2)));
    }
}
