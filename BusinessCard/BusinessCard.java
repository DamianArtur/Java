import java.util.ArrayList;
import java.util.Objects;

public class BusinessCard {

    public static final char BORDER_CHAR = '*';

    private String name;
    private String surname;
    private String city;
    private String phone;

    public BusinessCard(String name, String surname, String city, String phone) {
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.phone = phone;
    }

    public BusinessCard() {
        this("Piotr", "Budynek", "Krakow", "123456789");
    }

    public void setName(String name) { this.name = name; }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setCity(String city) { this.city = city; }

    public void setPhone(String phone) { this.phone = phone; }

    public String getName() {
        return name;
    }

    public String getSurname() { return surname; }

    public String getCity() { return city; }

    public String getPhone() {
        return phone;
    }

    protected char getBorderChar() {
        return BORDER_CHAR;
    }

    public String print() {
        String result;

        ArrayList<String> lines = getLines();

        int maxLength = getMaxLength(lines);

        String borderLine = "";
        for (int i = 0; i < maxLength + 2; i++) {
            borderLine += getBorderChar();
        }

        result = borderLine + '\n';

        for (String line : lines) {
            int lengthDiff = maxLength - line.length();

            for (int i = 0; i < lengthDiff; i++) {
                line += " ";
            }

            line = getBorderChar() + line + getBorderChar();

            result += line + '\n';
        }

        result += borderLine + '\n';
        return result;
    }

    private int getMaxLength(ArrayList<String> lines) {
        int maxLength = 0;

        for (String line : lines) {
            int lineLength = line.length();

            if (lineLength > maxLength) {
                maxLength = lineLength;
            }
        }

        return maxLength;
    }

    protected ArrayList<String> getLines() {
        ArrayList<String> lines = new ArrayList<>();

        lines.add(name + " " + surname);
        lines.add("Miasto: " + city);
        lines.add("tel. " + phone);

        return lines;
    }

    @Override
    public String toString() {
        return this.print();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusinessCard card = (BusinessCard) o;
        return Objects.equals(name, card.name) &&
                Objects.equals(surname, card.surname) &&
                Objects.equals(city, card.city) &&
                Objects.equals(phone, card.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, city, phone);
    }

    public static void main(String[] args) {
        BusinessCard card1 = new BusinessCard("Piotr", "Budynek", "Krakow", "123456789");
        BusinessCard card2 = new BusinessCard("Piotr", "Budynek", "Krakow", "123456789");
        if(card1 == card2) {
            System.out.println("Te same obiekty!");
        }else{
            System.out.println("Nie te same obiekty!");
        }
        if(card1.equals(card2)) {
            System.out.println("Wartosi takie same!");
        }else{
            System.out.println("Wartosci rozne!");
        }
        System.out.println();
        System.out.println(card1);
        System.out.println();
        System.out.println(card2);
    }
}