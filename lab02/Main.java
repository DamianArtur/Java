import functions.Function;
import functions.examples.builder.ExampleBuilder;
import functions.examples.cosineexample.CosineExampleBuilder;
import integrals.IntegralAlgorithm;
import integrals.MonteCarlo;
import integrals.Trapezoids;
import view.IntegralSolverConsoleView;
import view.IntegralSolverView;

public class Main {

    protected static ExampleBuilder functionBuilder;
    protected static Function givenExample;
    protected static IntegralAlgorithm algorithmMonteCarlo;
    protected static IntegralAlgorithm algorithmTrapezoids;
    protected static IntegralSolverView view;

    public static void main(String[] args) {

        functionBuilder = new CosineExampleBuilder();
        givenExample = functionBuilder.build();

        algorithmMonteCarlo = new MonteCarlo();
        algorithmTrapezoids = new Trapezoids();
        algorithmMonteCarlo.setFunction(givenExample);
        algorithmTrapezoids.setFunction(givenExample);

        view = new IntegralSolverConsoleView();
        view.Init(algorithmMonteCarlo, algorithmTrapezoids, givenExample);
        view.View();
    }
}
