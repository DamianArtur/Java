import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class HSVColor {

    private int hue;
    private double saturation;
    private double value;

    public HSVColor(int hue, double saturation, double value) throws ColorFormatException {
        if(hue < 0 || hue > 360) {
            throw new ColorFormatException("Hue out of bounds: " + hue);
        }
        if(saturation < 0 || saturation > 1) {
            throw new ColorFormatException("Saturation out of bounds: " + saturation);
        }
        if(value < 0 || value > 1) {
            throw new ColorFormatException("Value out of bounds: " + value);
        }

        this.hue = hue;
        this.saturation = saturation;
        this.value = value;
    }

    public int getHue() {
        return hue;
    }

    public double getSaturation() {
        return saturation;
    }

    public double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HSVColor hsvColor = (HSVColor) o;
        return hue == hsvColor.hue &&
                Double.compare(hsvColor.saturation, saturation) == 0 &&
                Double.compare(hsvColor.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hue, saturation, value);
    }

    public static void main(String[] args) {
        try {
            int goodColorsCounter = 0;
            int badColorCounter = 0;

            File file = new File("colors.csv");
            Scanner scanner = new Scanner(file);

            while(scanner.hasNext()) {
                String[] data = scanner.next().split(";");
                try {
                    new HSVColor(Integer.parseInt(data[0]), Double.parseDouble(data[1]), Double.parseDouble(data[2]));
                    goodColorsCounter++;
                } catch (ColorFormatException | NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    badColorCounter++;
                }
            }

            scanner.close();
            System.out.println("Poprawnie wczytanych danych: " + goodColorsCounter);
            System.out.println("Niepoprawnie wczytanych danych: " + badColorCounter);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}