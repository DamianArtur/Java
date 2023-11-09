public class Point {

    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void setX(double newX) {
        this.x = newX;
    }

    public void setY(double newY) {
        this.y = newY;
    }

    public double getDistance(Point point) {
        return Math.sqrt(Math.pow(this.x - point.x, 2) + Math.pow(this.y - point.y, 2));
    }

    public void replace(Point point) {
        this.x = point.x;
        this.y = point.y;
    }

    public boolean equals(Point point) {
        return this.x == point.x && this.y == point.y;
    }

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
}