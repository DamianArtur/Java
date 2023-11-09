import java.util.ArrayList;

public class Triangle {

    ArrayList<Point> vertices = new ArrayList<>();

    public Triangle(Point a, Point b, Point c) {
        vertices.add(a);
        vertices.add(b);
        vertices.add(c);
    }

    public Point getVertex(int index) {
        return vertices.get(index);
    }

    public double getPerimeter() {
        double a = this.vertices.get(0).getDistance(this.vertices.get(1));
        double b = this.vertices.get(1).getDistance(this.vertices.get(2));
        double c = this.vertices.get(2).getDistance(this.vertices.get(0));

        return a + b + c;
    }

    public double getArea() {
        double a = this.vertices.get(0).getDistance(this.vertices.get(1));
        double b = this.vertices.get(1).getDistance(this.vertices.get(2));
        double c = this.vertices.get(2).getDistance(this.vertices.get(0));

        double p = (a+b+c) / 2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }

    public double getHeight(Point point) {
        Point point1 = this.vertices.get(0);
        Point point2 = this.vertices.get(1);

        if (point1.equals(point)) {
            point1 = this.vertices.get(2);
        } else if (point2.equals(point)) {
            point2 = this.vertices.get(2);
        }

        double sideLength = point1.getDistance(point2);
        return 2 * this.getArea() / sideLength;
    }

    @Override
    public String toString() {
        return "Triangle: A" + vertices.get(0) + ", B" + vertices.get(1) + ", C" + vertices.get(2);
    }

    public int compareTo(Triangle triangle) {
        int res = 0;
        if (this.getArea() < triangle.getArea()) {
            res = -1;
        }
        if (this.getArea() > triangle.getArea()) {
            res = 1;
        }
        return res;
    }

    public void replaceVertex(Point oldPoint, Point newPoint) {
        int i = 0;
        while (!oldPoint.equals(vertices.get(i))) {
            i++;
        }

        vertices.set(i, newPoint);
    }
}
