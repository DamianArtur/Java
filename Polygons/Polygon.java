import java.util.List;

public abstract class Polygon {

    protected List<Integer> sides;

    public Polygon(List<Integer> sides) {
        this.sides = sides;
    }

    public double perimeter() {
        int result = 0;
        for(int side : sides) {
            result += side;
        }
        return result;
    }

    public abstract double surface();
}
