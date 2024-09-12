import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Введите размер массива: ");
        Scanner scanner = new Scanner(System.in);
        int arraySize = scanner.nextInt();
        int[] array = new int[arraySize];

        System.out.println("Введите элементы массива: ");
        for (int index = 0; index < arraySize; index++) {
            array[index] = scanner.nextInt();
        }

        System.out.println("Введите степень мажоритарности (%): ");
        int Porog = scanner.nextInt();

        int Vhod = 0;
        int major = 0;

        for (int i = 0; i < arraySize; i++) {
            for (int j = 0; j < arraySize; j++) {
                if (i != j && array[i] == array[j]) {
                    Vhod += 1;
                }
            }
            if (Vhod >= (arraySize * Porog) / 100) {
                major = array[i];
                i = arraySize;
            } else {
                Vhod = 0;
            }
        }

        System.out.println("Мажоритарное число: " + major);
    }
}
