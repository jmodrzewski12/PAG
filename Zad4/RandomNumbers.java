import java.util.ArrayList;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Generates random numbers in range [0, MAX]. Then prints first N numbers and last N numbers.
 * Afterwards, sorts list using TreeSet (no duplicates).
 */
public class RandomNumbers {

    public ArrayList<Integer> generateRandomNumbers(int max, int n, int s) {
        ArrayList<Integer> randomNumbers = new ArrayList<>();

        while (true) {
            int randomValue = ThreadLocalRandom.current().nextInt(max);
            randomNumbers.add(randomValue);

            if (randomValue == s){
                break;
            }
        }
        System.out.println(randomNumbers);

        if (randomNumbers.size() < n){
            n = randomNumbers.size(); // when N is less than ArrayList size
        }

        for (int i = 0; i < n; i++){
            System.out.print(randomNumbers.get(i) + " "); // first N numbers
        }

        System.out.print("\n");
        for (int i = 0; i < n; i++){
            System.out.print(randomNumbers.get(randomNumbers.size() - i - 1) + " "); // last N numbers
        }

        return randomNumbers;
    }

    /**
     * Calls method generateRandomNumbers and then converts ArrayList to TreeSet
     * @param arg not used
     */
    public static void main(String[] arg) {
        int MAX = 100;
        int N = 50;
        int S = 12;

        RandomNumbers r = new RandomNumbers();
        ArrayList<Integer> arr = r.generateRandomNumbers(MAX, N, S);

        TreeSet<Integer> treeSet = new TreeSet<>(arr); // sorted and unique
        System.out.print("\n" + treeSet);
    }
}