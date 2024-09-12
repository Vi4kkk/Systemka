import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //вводим размер массива
        System.out.print("Введите размер массива: ");
        Scanner scanner = new Scanner(System.in);
        int arraySize = scanner.nextInt(); //инициализируем размер массива
        int[] array = new int[arraySize]; //создаем массив заданного размера

        //вводим элементы массива
        System.out.println("Введите элементы массива: ");
        for (int index = 0; index < arraySize; index++) {
            array[index] = scanner.nextInt(); //заполняем массив элементами
        }

        //вводим степень мажоритарности
        System.out.println("Введите степень мажоритарности (%): ");
        int Porog = scanner.nextInt(); //инициализируем степень мажоритарности

        int Vhod = 0; //переменная для подсчета вхождений
        int major = 0; //переменная для хранения мажоритарного числа

        //поиск мажоритарного числа
        for (int i = 0; i < arraySize; i++) {
            for (int j = 0; j < arraySize; j++) {
                //проверяем, не совпадают ли индексы и равны ли элементы
                if (i != j && array[i] == array[j]) {
                    Vhod += 1; //увеличиваем счетчик вхождений
                }
            }
            //проверяем, соответствует ли количество вхождений порогу
            if (Vhod >= (arraySize * Porog) / 100) {
                major = array[i]; //устанавливаем мажоритарное число
                i = arraySize; //выходим из внешнего цикла
            } else {
                Vhod = 0; //обнуляем счетчик вхождений
            }
        }

        //выводим результат
        System.out.println("Мажоритарное число: " + major);
    }
}
