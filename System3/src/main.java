import java.util.*;

public class main { //название класса с заглавной буквы
    public static void main(String[] args) {
        final int maxPairs = 16; //максимальное количество пар
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество пришедших sms-сообщений: ");
        int numberOfVotes = scanner.nextInt();

        //создание массива для хранения голосов
        int[] votes = new int[maxPairs + 1]; //индексы с 1 по 16, 0 не используется

        System.out.println("Введите номера пар от 1 до 16:");
        for (int i = 0; i < numberOfVotes; i++) {
            if (scanner.hasNextInt()) { //проверка, является ли ввод целым числом
                int pairNumber = scanner.nextInt();
                if (pairNumber >= 1 && pairNumber <= maxPairs) {
                    votes[pairNumber]++;
                } else {
                    System.out.println("Некорректный номер пары: " + pairNumber + ", он должен быть в диапазоне от 1 до 16");
                }
            } else {
                System.out.println("Пожалуйста, введите целое число.");
                scanner.next(); //очищаем сканнер от некорректного ввода
            }
        }

        //создание списка пар с их голосами
        List<PairVotes> pairVotesList = new ArrayList<>();
        for (int i = 1; i <= maxPairs; i++) {
            pairVotesList.add(new PairVotes(i, votes[i]));
        }

        //сортировка расческой по количеству голосов в порядке убывания
        combSort(pairVotesList);

        //вывод результатов
        System.out.println("Результаты голосования:");
        for (PairVotes pairVotes : pairVotesList) {
            System.out.println("пара " + pairVotes.getPairNumber() + ": " + pairVotes.getVoteCount() + " голосов");
        }
    }

    //сортировка расческой
    private static void combSort(List<PairVotes> pairVotesList) {
        int gap = pairVotesList.size();
        boolean swapped = true;
        while (gap > 1 || swapped) {
            //уменьшаем gap
            gap = (int) (gap / 1.3);
            if (gap < 1) gap = 1;

            swapped = false;

            //сравниваем и меняем местами элементы
            for (int i = 0; i < pairVotesList.size() - gap; i++) {
                if (pairVotesList.get(i).getVoteCount() < pairVotesList.get(i + gap).getVoteCount()) {
                    //меняем местами элементы
                    PairVotes temp = pairVotesList.get(i);
                    pairVotesList.set(i, pairVotesList.get(i + gap));
                    pairVotesList.set(i + gap, temp);
                    swapped = true;
                }
            }
        }
    }
}

//класс для хранения номера пары и количества голосов
class PairVotes {
    private final int pairNumber;
    private final int voteCount;

    public PairVotes(int pairNumber, int voteCount) {

        this.pairNumber = pairNumber;
        this.voteCount = voteCount;
    }

    public int getPairNumber() {
        return pairNumber;
    }

    public int getVoteCount() {
        return voteCount;
    }
}

