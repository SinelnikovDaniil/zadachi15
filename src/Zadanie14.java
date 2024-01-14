import java.util.Arrays;

public class Zadanie14 {
    public static int[] makeChange(int[] coins, int amount) {
        // Сортируем монеты в порядке убывания
        Arrays.sort(coins);

        // Создаем массив для хранения количества монет каждого номинала
        int[] change = new int[coins.length];

        int index = coins.length - 1;

        while (index >= 0) {
            // Если текущая монета больше суммы, пропускаем ее
            if (coins[index] > amount) {
                index--;
                continue;
            }

            // Вычитаем текущую монету из суммы и увеличиваем счетчик монет
            while (amount >= coins[index]) {
                amount -= coins[index];
                change[index]++;
            }

            if (amount == 0) {
                // Сумма разменяна полностью
                break;
            }

            index--;
        }

        if (amount > 0) {
            // Мы не смогли разменять сумму монетами
            return null;
        }

        return change;
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 10, 20, 50};
        int amount = 75;
        int[] change = makeChange(coins, amount);

        if (change != null) {
            System.out.println("Размен суммы " + amount + ": ");
            for (int i = 0; i < change.length; i++) {
                if (change[i] > 0) {
                    System.out.println(coins[i] + " рублей: " + change[i] + " шт.");
                }
            }
        } else {
            System.out.println("Невозможно разменять заданную сумму монетами.");
        }
    }
}
