import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zadanie2 {
    public static boolean findSum(List<Integer> weights, int target, List<Integer> combination) {
        if (target == 0) {
            return true;  // Найден набор гирь, суммирующихся в заданное число
        } else if (target < 0 || weights.isEmpty()) {
            return false;  // Не удалось найти набор гирь
        } else {
            // Выполняем перебор всех возможных комбинаций гирь
            for (int i = 0; i < weights.size(); i++) {
                int weight = weights.get(i);  // Вес текущей гири

                combination.add(weight);  // Добавляем гирю в текущую комбинацию
                boolean found = findSum(weights.subList(i, weights.size()), target - weight, combination);

                if (found) {
                    return true;  // Найден набор гирь, суммирующихся в заданное число
                }

                combination.remove(combination.size() - 1);  // Удаляем гирю из текущей комбинации
            }

            return false;  // Не удалось найти набор гирь
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество гирь: ");
        int n = scanner.nextInt();

        List<Integer> weights = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Введите вес гири " + (i + 1) + ": ");
            int weight = scanner.nextInt();
            weights.add(weight);
        }

        System.out.print("Введите заданное число: ");
        int target = scanner.nextInt();

        List<Integer> combination = new ArrayList<>();
        boolean found = findSum(weights, target, combination);

        if (found) {
            System.out.println("Набор гирь, суммирующихся в заданное число:");
            for (int weight : combination) {
                System.out.print(weight + " ");
            }
        } else {
            System.out.println("Набор гирь для заданного числа не найден.");
        }
    }
}

