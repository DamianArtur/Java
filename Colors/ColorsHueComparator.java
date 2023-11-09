import java.util.Comparator;

public class ColorsHueComparator implements Comparator<HSVColor> {

    @Override
    public int compare(HSVColor color1, HSVColor color2) {
        if(color2.getHue() - color1.getHue() > 0) {
            return 1;
        } else if(color2.getHue() - color1.getHue() < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}