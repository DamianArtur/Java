public class Square extends Rectangle {

    public Square(int a) {
        super(a, a);
    }

    public static void main(String[] args) {
        Square square = new Square(2);
        System.out.println(square.perimeter());
        System.out.println(square.surface());
    }
}
