import java.util.*;

public class Main {
    public static void main(String[] args) {
        final int ARRAY_SIZE = 1000;
        int[] array = new int[ARRAY_SIZE];
        Random random = new Random();
        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = random.nextInt(10001);
        }

        int minNum = Integer.MAX_VALUE;
        boolean found = false;
        HashSet<Integer> set = new HashSet<>();
        for (int num : array) {
            set.add(num);
        }

        for (int i = 0; i < ARRAY_SIZE; i++) {
            for (int j = i + 1; j < ARRAY_SIZE; j++) {
                int product = array[i] * array[j];
                if (product % 21 == 0 && product < minNum && set.contains(product)) {
                    minNum = product;
                    found = true;
                }
            }
        }

        if (found) {
            System.out.println(minNum);
        } else {
            System.out.println(-1);
        }
    }
}
