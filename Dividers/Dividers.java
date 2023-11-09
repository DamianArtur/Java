public class Dividers {

    public static int readNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbe naturalna:");
        return scanner.nextInt();
    }

    public static boolean checkDivider(int a, int b) {
        return a % b == 0;
    }

    public static int[] findDividers(int x) {
        int[] Array = {1};
        for(int i = 2; i <= x/2 + 1; i++) {
            if(checkDivider(x, i)) {
                Array = Arrays.copyOf(Array, Array.length + 1);
                Array[Array.length-1] = i;
            }
        }
        Array = Arrays.copyOf(Array, Array.length + 1);
        Array[Array.length-1] = x;
        return Array;
    }

    public static void printDividers(int[] Array) {
        System.out.println(Arrays.toString(Array));
    }

    public static void main(String[] args) {
        printDividers(findDividers(readNumber()));
    }
}
