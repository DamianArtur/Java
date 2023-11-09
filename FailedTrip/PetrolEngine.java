public class PetrolEngine implements Engine{

    private int fuelInTank;

    PetrolEngine() {
        fuelInTank = 0;
    }

    public int getFuelInTank() {
        return fuelInTank;
    }

    public void addFuel(PetrolFuel petrolFuel) {
        fuelInTank = petrolFuel.howMuch();
        System.out.println("Uzupelniam benzyne.");
        System.out.println();
    }

    @Override
    public void turnOn() {
        System.out.println("Silnik benzynowy odpalony.");
    }

    @Override
    public void turnOff() {
        System.out.println("Silnik benzynowy zgasl.");
    }
}
