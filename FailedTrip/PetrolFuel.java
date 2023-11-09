public class PetrolFuel implements Fuel {

    private int amountOfFuel;

    public PetrolFuel(int amountOfFuel) {
        this.amountOfFuel = amountOfFuel;
    }

    @Override
    public int howMuch() {
        return amountOfFuel;
    }
}
