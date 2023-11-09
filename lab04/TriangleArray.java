import java.util.ArrayList;

public class TriangleArray {

    private final ArrayList<Triangle> triangleArrayList = new ArrayList<>();

    public void add(Triangle triangle) {
        this.triangleArrayList.add(triangle);
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        for(Triangle triangle : triangleArrayList) {
            ret.append(triangle.getArea()).append("\n");
        }
        return ret.toString();
    }

    public void sort() {
        triangleArrayList.sort((Triangle::compareTo));
    }
}
