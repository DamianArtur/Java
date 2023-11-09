public class Results {

    private long numberOfShots;
    private long allShots;
    private long shotsInCircle;

    Results(long numberOfShots) {
        this.numberOfShots = numberOfShots;
    }

    public boolean notAllShotsTaken() {
        return allShots < numberOfShots;
    }

    public double getPiApproximation() {
        return (4.0 * shotsInCircle) / allShots;
    }

    public long getAllShots() {
        return allShots;
    }

    public long getShotsInCircle() {
        return shotsInCircle;
    }

    public void setAllShots(long allShots) {
        this.allShots = allShots;
    }

    public void setShotsInCircle(long shotsInCircle) {
        this.shotsInCircle = shotsInCircle;
    }
}