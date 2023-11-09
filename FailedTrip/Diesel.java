public class Diesel implements Engine{

    private int fuelInTank;

    Diesel() {
        fuelInTank = 0;
    }

    public int getFuelInTank() {
        return fuelInTank;
    }

    public void addFuel(DieselFuel dieselFuel) {
        fuelInTank = dieselFuel.howMuch();
        System.out.println("Uzupelniam olej napedowy.");
        System.out.println();
    }

    @Override
    public void turnOn() {
        System.out.println("Silnik Diesla odpalony.");
    }

    @Override
    public void turnOff() {
        System.out.println("Silnik Diesla zgasl.");
    }
}
