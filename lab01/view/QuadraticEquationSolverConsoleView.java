import solver.QFormulaSolver;
import solver.exceptions.SolverException;
import java.util.Scanner;

public class QuadraticEquationSolverConsoleView implements QuadraticEquationSolverView {
    private QFormulaSolver solver;
    private Scanner sc;

    protected double parseWithMessage(String message) {
        System.out.println(message);
        String line;
        double res;
        try {
            line = sc.nextLine();
            res=Double.parseDouble(line);
        } catch (Exception ex) {
            System.err.println("Wprowadzono niepoprawne dane!");
            res= parseWithMessage(message);
        }
        return res;
    }

    protected void parseFactors() {
        double a, b, c;
        a = parseWithMessage("Wprowadź współczynnik a: ");
        b = parseWithMessage("Wprowadź współczynnik b: ");
        c = parseWithMessage("Wprowadź współczynnik c: ");
        this.solver.setInitialParameters(a,b,c);
    }

    protected void displaySolutions(double [] res) {
        String label = "Podane równanie posiada następujące rozwiązania w dziedzinie liczb: ";
        if (solver.IsComplex())label += "zespolonych:\n";
        else label += "rzeczywistych: \n";
        for(int i =0; i < res.length; i++) label+= "x"+i+"="+res[i]+";\t";
        System.out.println(label);
    }

    protected void getSolution() {
        double [] res;
        try {
            res = solver.solve();
            displaySolutions(res);
        } catch (SolverException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void View() {
        while(true) {
            parseFactors();
            getSolution();
        }
    }

    @Override
    public void Init(QFormulaSolver solver) {
        this.solver = solver;
        this.sc = new Scanner(System.in);
    }
}
