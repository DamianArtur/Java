import matrix.IMatrix;
import matrix.InvalidMatrixSizeException;
import matrix.generators.DefaultGenerator;

import java.util.Date;

public class Main {
    static IMatrix a;
    static IMatrix b;
    static IMatrix c;
    static IMatrix d;
    public static void main(String[] args) {

        int n=3000,m=3000;
        System.out.println("Generuję macierze...");
        a= DefaultGenerator.generateRandomMatrix(m,n,0,3);
        b= DefaultGenerator.generateRandomMatrix(m,n,0,3);

        try {
            System.out.println("Mnożę macierze klasycznie...");
            Date start1 = new Date();
            c = IMatrix.multiply(a, b);
            Date end1 = new Date();
            System.out.println("Czas mnożenia w milisekundach: " + (end1.getTime() - start1.getTime()));

            System.out.println("Mnożę macierze z wykorzystaniem współbieżności...");
            Date start2 = new Date();
            d = IMatrix.multiplyUsingThreads(a, b);
            Date end2 = new Date();
            System.out.println("Czas mnożenia w milisekundach: " + (end2.getTime() - start2.getTime()));

        } catch (InvalidMatrixSizeException e) {
            System.out.println(e.toString());
        }
    }
}
