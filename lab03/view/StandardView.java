import collections.IDataCollection;
import currency.Currency;
import currency.ICurrency;
import exchange.IExchange;

import java.util.Scanner;

public class StandardView implements ICurrencyView {

    protected IExchange exchange;
    protected IDataCollection collection;
    protected Scanner scanner = new Scanner(System.in);

    @Override
    public void setExchange(IExchange exchange) {
        this.exchange = exchange;
    }

    @Override
    public void setDataCollection(IDataCollection collection) {
        this.collection = collection;
    }

    @Override
    public void ViewAll(IDataCollection coll) {
        System.out.println("-----+---------+---------+-----------------------------");
        System.out.println("Kod  |   Kurs  |  Współ. |        Nazwa");
        System.out.println("-----+---------+---------+-----------------------------");
        System.out.println(coll.ToString());
    }

    @Override
    public ICurrency StringToCurrency(String code) {
        ICurrency currency = new Currency();
        currency.setCode(code);
        return collection.getCurrencyByCode(currency);
    }

    @Override
    public ICurrency ChooseCurrency() {
        System.out.print("Wprowadź kod... ");
        String code = scanner.nextLine();

        return StringToCurrency(code);
    }

    @Override
    public void exchange() {
        double amt;

        System.out.print("Podaj walutę którą posiadasz. ");
        ICurrency src = ChooseCurrency();
        if (src == null) {
            System.out.println("Waluta o podanym kodzie nie istnieje!");
            return;
        }

        System.out.print("Podaj walutę którą chcesz kupić. ");
        ICurrency tgt = ChooseCurrency();
        if (tgt == null) {
            System.out.println("Waluta o podanym kodzie nie istnieje!");
            return;
        }

        if (src.getCode().equals(tgt.getCode())) {
            System.out.println("Kod waluty źródłowej jest równy docelowej!");
            return;
        }

        System.out.print("Podaj liczbę posiadanych środków... ");
        String input = scanner.nextLine();
        try {
            amt = Double.parseDouble(input);
            if (amt < 0) {
                System.out.println("Wprowadzona wartość środka płatniczego jest ujemna!");
                return;
            }
        } catch (NumberFormatException e) {
            System.err.println("Podany argument jest nieprawidlowy!");
            return;
        }

        System.out.println("Posiadana ilość środków (" + amt + " " + src.getCode() + ") przy obecnym kursie jest równa " + exchange.exchange(src, tgt, amt) + " " + tgt.getCode() + ".");
    }

    @Override
    public void menu() {

        int choice;

        while(true) {
            System.out.println("###################################################");
            System.out.println("                         MENU                      ");
            System.out.println("###################################################");
            System.out.println("Aby wyświetlić wszystkie waluty wybierz 1.");
            System.out.println("Aby przeliczyć wartość pomiędzy walutami wybierz 2.");
            System.out.println("Aby zakończyć program wybierz 3.");
            System.out.println("###################################################");
            System.out.print("Wprowadź liczbę... ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Podany argument jest nieprawidlowy!");
                continue;
            }

            System.out.print("\n");

            switch (choice) {
                case 1 -> ViewAll(collection);
                case 2 -> exchange();
                case 3 -> {System.out.println("Zakończono."); System.exit(0);}
                default -> System.out.println("Opcja o podanym numerze nie istnieje!");
            }

            System.out.print("\n\n\n");
        }
    }
}
