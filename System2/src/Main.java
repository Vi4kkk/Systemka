import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //определяем размер массива
        final int SIZE = 1000;

        //создаем массив для хранения чисел
        int[] nums = new int[SIZE];

        //создаем объект для генерации случайных чисел
        Random rand = new Random();

        //заполняем массив случайными числами от 0 до 999
        for (int i = 0; i < SIZE; i++) {
            nums[i] = rand.nextInt(1000); //генерируем случайное число от 0 до 999
        }

        //инициализация переменных для хранения минимальных чисел
        int min3 = Integer.MAX_VALUE;   //минимальное число, кратное 3
        int min7 = Integer.MAX_VALUE;   //минимальное число, кратное 7
        int min21 = Integer.MAX_VALUE;  //минимальное число, кратное 21
        int min = Integer.MAX_VALUE;    //минимальное число, не кратное 3, 7 и 21

        //поиск минимальных чисел среди элементов массива
        for (int i = 0; i < SIZE; i++) {
            //проверяем, кратно ли число 21 и если оно меньше текущего min21
            if (nums[i] % 21 == 0 && nums[i] < min21) {
                min21 = nums[i];
            }
            //проверяем, кратно ли число 3 и если оно меньше текущего min3
            else if (nums[i] % 3 == 0 && nums[i] < min3) {
                min3 = nums[i]; //аналогично что и для 7
            }
            //проверяем, кратно ли число 7 и если оно меньше текущего min7
            else if (nums[i] % 7 == 0 && nums[i] < min7) {
                min7 = nums[i]; //если число делится на 7 и меньше текущего значения min7
            }
            //обновляем минимальное число, если число меньше текущего значения
            else if (nums[i] < min) {
                min = nums[i];
            }
        }

        int result1 = 0; //результат для произведения кратного 3 и 7
        int result2 = 0; //результат для произведения минимального числа и кратного 21

        //находим произведение минимального числа, кратного 3 и кратного 7
        if (min3 != Integer.MAX_VALUE && min7 != Integer.MAX_VALUE) {
            result1 = min3 * min7;
        }

        //находим произведение минимального числа, кратного 21, и минимального числа из трех переменных
        if (min21 != Integer.MAX_VALUE) {
            result2 = min21 * Math.min(min3, Math.min(min7, min)); //сравниваем min7, min3 и минимальное значение
        }

        //определяем минимальный результат из двух возможных
        int answer = Math.min(result1, result2);

        //выводим ответ или -1, если результат не найден
        if (answer != -1) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }
}
