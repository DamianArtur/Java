public class DieselFuel implements Fuel {

    private int amountOfFuel;

    public DieselFuel(int amountOfFuel) {
        this.amountOfFuel = amountOfFuel;
    }

    @Override
    public int howMuch() {
        return amountOfFuel;
    }
}
