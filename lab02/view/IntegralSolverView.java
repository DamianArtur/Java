import functions.Function;
import integrals.IntegralAlgorithm;

public interface IntegralSolverView {

    public void View();
    public void Init(IntegralAlgorithm algorithm1, IntegralAlgorithm algorithm2, Function givenExample);
}
