import functions.Function;
import integrals.IntegralAlgorithm;

import java.util.Scanner;

public class IntegralSolverConsoleView implements IntegralSolverView {

    private IntegralAlgorithm algorithm1;
    private IntegralAlgorithm algorithm2;
    private Scanner sc;
    private Function givenExample;

    protected double parseWithMessageDouble(String message) {
        System.out.println(message);
        String line;
        double res;
        try {
            line = sc.nextLine();
            res=Double.parseDouble(line);
        } catch (Exception ex) {
            System.err.println("Wprowadzono niepoprawne dane!");
            res= parseWithMessageDouble(message);
        }
        return res;
    }

    protected int parseWithMessageInt(String message) {
        System.out.println(message);
        String line;
        int res;
        try {
            line = sc.nextLine();
            res=Integer.parseInt(line);
        } catch (Exception ex) {
            System.err.println("Wprowadzono niepoprawne dane!");
            res= parseWithMessageInt(message);
        }
        return res;
    }

    protected void parseFactors() {
        double a, b;
        int n;
        a = parseWithMessageDouble("Wprowadź początek przedziału całkowania: ");
        b = parseWithMessageDouble("Wprowadź koniec przedziału całkowania: ");
        n = parseWithMessageInt("Wprowadź liczbę podziałów / prób: ");
        this.algorithm1.setInitialParameters(a,b,n);
        this.algorithm2.setInitialParameters(a,b,n);
    }

    protected void displaySolutions(double [] res) {
        System.out.println("Obliczona wartość: " + res[0]);
        System.out.println("Dokładna wartość: " + res[1]);
        System.out.println("Błąd metody: " + res[2]);
        System.out.println("\n");
    }

    protected void getSolution() {
        double [] res  = new double[3];

        algorithm1.calculateIntegral();
        res[0] = algorithm1.getIntegral();
        res[1] = givenExample.getExactIntegralValue(algorithm1.getB()) - givenExample.getExactIntegralValue(algorithm1.getA());
        res[2] = Math.abs(res[0] - res[1]);
        System.out.println("Metoda Monte Carlo");
        displaySolutions(res);

        algorithm2.calculateIntegral();
        res[0] = algorithm2.getIntegral();
        res[1] = givenExample.getExactIntegralValue(algorithm2.getB()) - givenExample.getExactIntegralValue(algorithm2.getA());
        res[2] = Math.abs(res[0] - res[1]);
        System.out.println("Metoda Trapezów");
        displaySolutions(res);
    }

    @Override
    public void View() {
        getSolution();
    }

    @Override
    public void Init(IntegralAlgorithm algorithm1, IntegralAlgorithm algorithm2, Function givenExample) {
        this.algorithm1 = algorithm1;
        this.algorithm2 = algorithm2;
        this.sc = new Scanner(System.in);
        this.givenExample = givenExample;
        parseFactors();
    }
}
