import java.util.ArrayList;

public class BankCard extends BusinessCard {

    public static final char BORDER_CHAR = '$';

    private String bankAccount;

    public BankCard(String name, String surname, String city, String phone, String bankAccount) {
        super(name, surname, city, phone);
        this.bankAccount = bankAccount;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public char getBorderChar() {
        return BORDER_CHAR;
    }

    @Override
    protected ArrayList<String> getLines() {
        ArrayList<String> lines = super.getLines();
        lines.add(bankAccount);
        return lines;
    }

    public static void main(String[] args) {
        BankCard bankCard1 = new BankCard("Jan", "Kowalski", "Krakow,", "123456789", "1111 2222 3333 4444 5555");
        bankCard1.print();
    }

}
