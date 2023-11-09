public class Trapezoids extends IntegralAlgorithm {

    public Trapezoids() {
        this.sum = 0;
    }

    @Override
    public void calculateIntegral() {
        double side_a = function.getValue(a);
        double side_b;

        double m = (double) n;
        double h = (b - a) / m;

        for (int i = 0; i < n; i++) {
            side_b = function.getValue(a + i * h);
            sum += (side_a + side_b);
            side_a = side_b;
        }

        sum *= (0.5 * h);
    }
}
