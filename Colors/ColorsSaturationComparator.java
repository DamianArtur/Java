import java.util.Comparator;

public class ColorsSaturationComparator implements Comparator<HSVColor> {

    @Override
    public int compare(HSVColor color1, HSVColor color2) {
        if(color2.getSaturation() - color1.getSaturation() > 0) {
            return 1;
        } else if(color2.getSaturation() - color1.getSaturation() < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
