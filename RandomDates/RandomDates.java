import java.time.LocalDate;
import java.time.Period;
import java.util.Random;
import java.util.Scanner;

public class RandomDates {

    private static LocalDate loadUserDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wpisz rok: ");
        int year = scanner.nextInt();
        System.out.println("Wpisz miesiac: ");
        int month = scanner.nextInt();
        System.out.println("Wpisz dzien: ");
        int day = scanner.nextInt();

        return LocalDate.of(year, month, day);
    }

    private static LocalDate loadRandomDate() {
        int year = generateRandomNumber(1900, 2015);
        int month = generateRandomNumber(1, 12);
        int day = generateRandomNumber(1, 28);
        LocalDate randomDate = LocalDate.of(year, month, day);
        return randomDate;
    }

    private static int generateRandomNumber(int from, int to) {
        Random random = new Random();
        return random.nextInt(to-from+1) + from;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wybierz jedna z dostepnych opcji:");
        System.out.println("1 - ręcznie podana data");
        System.out.println("2 - losowa data");

        int option = scanner.nextInt();
        LocalDate currentDate = LocalDate.now();
        LocalDate date = null;

        switch (option){
            case 1:
                date = loadUserDate();
                break;
            case 2:
                date = loadRandomDate();
                break;
            default:
                System.out.println("Nie ma takiej opcji!");
                System.exit(-1);
                break;
        }

        System.out.println(date);
        Period difference = Period.between(date, currentDate);
        System.out.println("Roznica miedzy ta data a dzisiaj wynosi: ");
        System.out.print(Math.abs(difference.getYears()) + " lat ");
        System.out.print(Math.abs(difference.getMonths()) + " miesiecy ");
        System.out.print(Math.abs(difference.getDays()) + " dni");
    }
}