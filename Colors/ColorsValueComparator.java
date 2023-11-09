import java.util.Comparator;

public class ColorsValueComparator implements Comparator<HSVColor> {

    @Override
    public int compare(HSVColor color1, HSVColor color2) {
        if(color2.getValue() - color1.getValue() > 0) {
            return 1;
        } else if(color2.getValue() - color1.getValue() < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
