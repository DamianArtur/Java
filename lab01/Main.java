import solver.QFormulaSolver;
import solver.QuadraticFormulaSolver;
import view.QuadraticEquationSolverView;
import view.QuadraticEquationSolverConsoleView;

public class Main {

    static QFormulaSolver solver;
    static QuadraticEquationSolverView view;
    public static void main(String[] args) {
        solver = new QuadraticFormulaSolver();
        view = new QuadraticEquationSolverConsoleView();
        view.Init(solver);
        view.View();
    }
}
