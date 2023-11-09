import java.util.ArrayList;

public class Quadrangle {

    ArrayList<Point> vertices = new ArrayList<>();

    public Quadrangle(Point a, Point b, Point c, Point d) {
        vertices.add(a);
        vertices.add(b);
        vertices.add(c);
        vertices.add(d);
    }

    public Point getVertex(int index) {
        return vertices.get(index);
    }

    public double getPerimeter() {
        double a = this.vertices.get(0).getDistance(this.vertices.get(1));
        double b = this.vertices.get(1).getDistance(this.vertices.get(2));
        double c = this.vertices.get(2).getDistance(this.vertices.get(3));
        double d = this.vertices.get(3).getDistance(this.vertices.get(0));

        return a + b + c + d;
    }

    public double getArea() {
        double a = this.vertices.get(0).getDistance(this.vertices.get(1));
        double b = this.vertices.get(1).getDistance(this.vertices.get(2));
        double c = this.vertices.get(2).getDistance(this.vertices.get(3));
        double d = this.vertices.get(3).getDistance(this.vertices.get(0));
        double diagonal = this.vertices.get(0).getDistance(this.vertices.get(2));

        double p1 = (a+b+diagonal)/2;
        double p2 = (c+d+diagonal)/2;

        double area1 = Math.sqrt(p1*(p1-a)*(p1-b)*(p1-diagonal));
        double area2 = Math.sqrt(p2*(p2-c)*(p2-d)*(p2-diagonal));
        return area1 + area2;
    }

    public double[] getDiagonals() {
        double[] ret = new double[2];
        ret[0] = this.vertices.get(0).getDistance(this.vertices.get(2));
        ret[1] = this.vertices.get(1).getDistance(this.vertices.get(3));
        return ret;
    }

    @Override
    public String toString() {
        return "Quadrangle: A" + vertices.get(0) + ", B" + vertices.get(1) + ", C" + vertices.get(2) + ", D" + vertices.get(3);
    }

    public int compareTo(Quadrangle quadrangle) {
        int res = 0;
        if (this.getArea() < quadrangle.getArea()) {
            res = -1;
        }
        if (this.getArea() > quadrangle.getArea()) {
            res = 1;
        }
        return res;
    }

    public void replaceVertex(Point oldPoint, Point newPoint) {
        int i = 0;
        while(!oldPoint.equals(vertices.get(i))) {
            i++;
        }
        vertices.set(i, newPoint);
    }

}
