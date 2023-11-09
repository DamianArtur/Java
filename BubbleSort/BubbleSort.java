public class BubbleSort {

    public static void main(String[] args) {

        int[] numbers = new int[] { 4, 2, 0, 2, 10, 1, 9, 12, 3, 5 };
        sort(numbers);
        printNumbers(numbers);
    }

    private static void printNumbers(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }

    private static void sort(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length - 1; j++) {
                if (isGreaterThan(numbers, j, j+1)) {
                    swap(numbers, j, j+1);
                }
            }
        }
    }

    private static boolean isGreaterThan(int[] numbers, int x, int y) {
        return numbers[x] > numbers[y];
    }

    private static void swap(int[] numbers, int x, int y) {
        int temp;
        temp = numbers[y];
        numbers[y] = numbers[x];
        numbers[x] = temp;
    }
}