import java.util.ArrayList;

public interface IMatrix {
    /**
     *
     * @return zwraca dane macierzy prostokątnej
     */
    double[][] getData();

    /**
     *
     * @param data dane macierzy prostokątnej
     */
    void setData(double[][] data);

    /**
     *
     * @return zwraca liczbę wierszy
     */
    int rowCount();

    /**
     *
     * @return zwraca liczbę kolumn
     */
    int columnCount();

    /**
     *
     * @return zwraca reprezentację tekstową
     */
    String toString();

    /**
     *
     * @param a macierz A
     * @param b macierz B
     * @return AxB
     */
    static IMatrix multiply(IMatrix a, IMatrix b) throws InvalidMatrixSizeException{
        if(a.columnCount() != b.rowCount()) {
            throw new InvalidMatrixSizeException("Wymiary macierzy są nieprawidłowe!");
        }

        int resultRows=a.rowCount();
        int resultColumns=b.columnCount();
        IMatrix result = new Matrix(resultRows,resultColumns);
        int colCount = b.columnCount(),i=0,j=0,k=0;
        for(i=0;i<resultRows;i++){
            for(j=0;j<colCount;j++){
                result.getData()[i][j]=0;
                for(k=0;k<resultColumns;k++)
                    result.getData()[i][j]+=a.getData()[i][k]*b.getData()[k][j];
            }
        }

        return result;
    }

    /**
     *
     * @param a macierz A
     * @param b macierz B
     * @return AxB
     */
    static IMatrix multiplyUsingThreads(IMatrix a, IMatrix b) throws InvalidMatrixSizeException {
        if(a.columnCount() != b.rowCount()) {
            throw new InvalidMatrixSizeException("Wymiary macierzy są nieprawidłowe!");
        }

        int maxNumberOfThreads = Runtime.getRuntime().availableProcessors();
        IMatrix result = new Matrix(a.rowCount(), b.columnCount());

        try {
            ArrayList<Thread> threads = new ArrayList<>();

            for(int i = 0; i < a.rowCount(); i++) {
                RowMultiplier rowMultiplier = new RowMultiplier(a, b, result, i);
                Thread thread = new Thread(rowMultiplier);
                thread.start();
                threads.add(thread);

                if(threads.size() % maxNumberOfThreads == 0) {
                    for(Thread thr : threads) {
                        try {
                            thr.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    threads.clear();
                }
            }

            for(Thread thr: threads) {
                try {
                    thr.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
