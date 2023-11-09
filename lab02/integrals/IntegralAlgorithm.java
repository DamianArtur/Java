import functions.Function;

public abstract class IntegralAlgorithm {
    protected double a;
    protected double b;
    protected int n;
    protected double sum;
    protected Function function;

    public double getIntegral(){
        return sum;
    }

    public double getA() { return a; }

    public double getB() { return b; }

    public void setN(int n) {
        this.n = n;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    public abstract void calculateIntegral();

    public void setInitialParameters(double a, double b, int n) { this.a = a; this.b = b; this.n = n;};
}
