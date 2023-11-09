public class Car {

    private boolean isStart;
    private PetrolEngine petrolEngine = new PetrolEngine();
    private Diesel diesel = new Diesel();

    Car() {
        isStart = false;
    }

    public boolean isStart() {
        return isStart;
    }

    public void start() {
        System.out.println("Uruchamianie samochodu...");
        this.petrolEngine.turnOn();
        this.diesel.turnOn();
        this.isStart = true;
        System.out.println("Samochod wlaczony.");
        System.out.println();
    }

    public void stop() {
        System.out.println("Gaszenie samochodu...");
        this.petrolEngine.turnOff();
        this.diesel.turnOff();
        this.isStart = false;
        System.out.println("Samochod zgaszony.");
        System.out.println();
    }

    public void drive() {
        try (MyContextManager myContextManager = new MyContextManager(this)) {
            if (!this.isStart) {
                throw new CarWasNotStartedException("Samochod nie wlaczony!");
            }
            if (this.petrolEngine.getFuelInTank() == 0 && this.diesel.getFuelInTank() == 0) {
                throw new ZeroFuelInTankException("Brak paliwa w baku!");
            }

            System.out.println("Samochod ruszyl.");
            System.out.println();

        } catch (CarWasNotStartedException | ZeroFuelInTankException e) {
            System.out.println(e.getMessage());
            System.out.println();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Car car = new Car();
        PetrolFuel petrolFuel = new PetrolFuel(0);
        DieselFuel dieselFuel = new DieselFuel(10);

        car.drive();

        car.start();
        car.drive();

        car.petrolEngine.addFuel(petrolFuel);
        car.diesel.addFuel(dieselFuel);
        car.start();
        car.drive();
    }
}
