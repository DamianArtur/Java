import java.util.ArrayList;
import java.util.HashSet;

public class Wallet {

    public enum Operation {

    }

    private HashSet<BusinessCard> cards = new HashSet<>();

    public void addCard(BusinessCard card) {
        this.cards.add(card);
    }

    private String printAllCards() {
        String result = "";
        for(BusinessCard card : cards) {
            result += card.toString() + '\n';
        }
        return result;
    }

    public Wallet findByCity(String city) {
        Wallet newWallet = new Wallet();
        for(BusinessCard card : this.cards) {
            if(card.getCity().equals(city)) {
                newWallet.addCard(card);
            }
        }
        return newWallet;
    }

    @Override
    public String toString() {
        return printAllCards();
    }

    public static void main(String[] args) {
        Wallet wallet1 = new Wallet();
        BusinessCard card1 = new BusinessCard("Piotr", "Budynek", "Krakow", "123456789");
        BusinessCard card2 = new BusinessCard("Piotr", "Budynek", "Warszawa", "123456789");
        BusinessCard card3 = new BankCard("Piotr", "Budynek", "Krakow", "123456789", "1234 5678 8765 4321");
        wallet1.addCard(card1);
        wallet1.addCard(card2);
        wallet1.addCard(card3);

        System.out.println(wallet1.toString());
        System.out.println("#######################");
        System.out.println(wallet1.findByCity("Krakow").toString());
    }

}
