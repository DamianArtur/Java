public class Figures {

    public static void main(String[] args) {

        Point P1 = new Point(1.0, 2.0);
        Point P2 = new Point(2.0, -3.0);

        System.out.print("P1=" + P1 + "\t");
        System.out.println("P2=" + P2);

        System.out.println("Coordinate y of the point P1: " + P1.getY());

        P2.setY(-3.0);
        System.out.println("P2 after changed y:" + P2);

        System.out.println("The distance between P1 and P2: " + P1.getDistance(P2));

        P1.replace(P2);
        System.out.println("P1 after update to P2:" + P1);

        Point A = new Point(0.0, 0.0);
        Point B = new Point(4.0, 0.0);
        Point C = new Point(4.0, 3.0);
        Point D = new Point(0.0, 5.0);

        Triangle triangle = new Triangle(A, B, C);
        System.out.println(triangle);

        System.out.println("Perimeter= " + triangle.getPerimeter() + "\tArea= " + triangle.getArea() + "\tHeight from coordinate A= " + triangle.getHeight(A));
        System.out.println("Coordinate0" + triangle.getVertex(0) + "\tCoordinate1"  + triangle.getVertex(1) + "\tCoordinate2" + triangle.getVertex(2));

        triangle.replaceVertex(A, new Point(2.0, -3.0));
        System.out.println("Triangle after update coordinate A:" + triangle.getVertex(0) + ", " + triangle.getVertex(1) + ", " + triangle.getVertex(2));

        Quadrangle quadrangle = new Quadrangle(A, B, C, D);
        System.out.println(quadrangle);

        System.out.println("Perimeter= " + quadrangle.getPerimeter() + "\tDiagonal from coordinate A to C: " + quadrangle.getDiagonals()[0]);
        System.out.println("Area= " + quadrangle.getArea());

        System.out.println("Coordinate0" + quadrangle.getVertex(0) + "\tCoordinate1"  + quadrangle.getVertex(1) + "\tCoordinate2" + quadrangle.getVertex(2) + "\tCoordinate3" + quadrangle.getVertex(3));

        quadrangle.replaceVertex(A, new Point(2.0, -3.0));
        System.out.println("Quadrangle after update coordinate A:" + quadrangle);

        TriangleArray triangleArray = new TriangleArray();
        triangleArray.add(triangle);
        triangleArray.add(new Triangle(new Point(0,0), new Point(0,-1), new Point(-1,-1)));
        triangleArray.add(new Triangle(new Point(0,0), new Point(10,0), new Point(10,20)));
        System.out.print("An array of triangles:\n" + triangleArray);
        triangleArray.sort();
        System.out.print("An array after sorting triangles according to area:\n" + triangleArray);

        QuadrangleArray quadrangleArray = new QuadrangleArray();
        quadrangleArray.add(quadrangle);
        quadrangleArray.add(new Quadrangle(new Point(0,0), new Point(0,-1), new Point(-1,-1), new Point(-1,0)));
        quadrangleArray.add(new Quadrangle(new Point(0,0), new Point(10,0), new Point(10,20), new Point(5,20)));
        System.out.print("An array of quadrangles:\n" + quadrangleArray);
        quadrangleArray.sort();
        System.out.print("An array after sorting quadrangles according to area:\n" + quadrangleArray);
    }
}
