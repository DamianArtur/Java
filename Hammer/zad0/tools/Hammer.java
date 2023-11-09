public class Hammer {

    private String brand;

    public Hammer(String brand) {
        this.brand = brand;
    }

    public void hammerNail(Nail nail, Wall wall) {
        if(nail.getWasUsed()) {
            System.out.println("Ten gwozdz byl juz uzyty!");
        } else {
            System.out.println("Mlotek " + brand + " wbil gwozdz w sciane: " + wall.getColour());
            nail.setWasUsed();
        }
    }

}
