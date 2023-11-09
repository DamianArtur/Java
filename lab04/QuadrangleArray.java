import java.util.ArrayList;

public class QuadrangleArray {

    private final ArrayList<Quadrangle> quadrangleArrayList = new ArrayList<>();

    public void add(Quadrangle quadrangle) {
        this.quadrangleArrayList.add(quadrangle);
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        for(Quadrangle quadrangle : quadrangleArrayList) {
            ret.append(quadrangle.getArea()).append("\n");
        }
        return ret.toString();
    }

    public void sort() {
        quadrangleArrayList.sort((Quadrangle::compareTo));
    }

}