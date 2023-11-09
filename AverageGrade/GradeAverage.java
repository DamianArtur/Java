import java.util.Scanner;

public class GradeAverage {

    public static double average(int[] marks) {
        int sum = 0;

        for(int i=0; i<marks.length; i++) {
            sum += marks[i];
        }

        return sum/(double)marks.length;
    }

    public static int maximum(int[] marks) {
        int max = marks[0];
        for(int i = 1; i < marks.length; i++) {
            if(marks[i] > max) {
                max = marks[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj liczbę ocen: ");
        int number = scanner.nextInt();
        int[] marks = new int[number];
        System.out.print("Podaj oceny ucznia: ");
        for(int i = 0; i < number; i++) {
            marks[i] = scanner.nextInt();
        }

        System.out.println("Srednia z ocen wynosi: " + average(marks));
        System.out.println("Najwyzsza z ocen to: " + maximum(marks));
    }
}
