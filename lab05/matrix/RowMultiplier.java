public class RowMultiplier implements Runnable {

    private final int rowNumber;
    private final IMatrix result;
    private final IMatrix a;
    private final IMatrix b;

    public RowMultiplier(IMatrix a, IMatrix b, IMatrix result, int rowNumber) {
        this.a = a;
        this.b = b;
        this.result = result;
        this.rowNumber = rowNumber;
    }

    @Override
    public void run() {
        for(int i = 0; i < b.columnCount(); i++) {
            result.getData()[rowNumber][i] = 0;
            for(int j = 0; j < a.rowCount(); j++) {
                result.getData()[rowNumber][i] += a.getData()[rowNumber][j] * b.getData()[j][i];
            }
        }
    }
}
