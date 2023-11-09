import java.util.*;

public class Lotto {

    private static ArrayList<Integer> RandomSix(ArrayList<Integer> allNumbers) {
        Random random = new Random();
        ArrayList<Integer> results = new ArrayList<>();
        for(int i = 0; i < 6; i++) {
            int lottoIndex = random.nextInt(allNumbers.size());
            Integer lottoResult = allNumbers.get(lottoIndex);
            results.add(lottoResult);
            allNumbers.remove(lottoIndex);
        }
        allNumbers.addAll(results);
        Collections.sort(results);
        return results;
    }

    public static void main(String[] args) {
        ArrayList<Integer> allNumbers = new ArrayList<>();
        for(int i = 1; i <= 49; i++) {
            allNumbers.add(i);
        }
        ArrayList<Integer> myNumbers = RandomSix(allNumbers);
        ArrayList<Integer> newRandom;
        int counter = 0;

        do {
            newRandom = RandomSix(allNumbers);
            counter++;
        } while (!myNumbers.equals(newRandom));

        System.out.print("Moje typy: ");
        System.out.println(myNumbers);
        System.out.print("Ostatnie losowanie: ");
        System.out.println(newRandom);
        System.out.println("Trafilem szostke po " + counter + " losowaniach!");
    }
}