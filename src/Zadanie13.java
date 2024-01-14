import java.util.Arrays;

public class Zadanie13 {
    public static int findMinCoins(int[] coins, int amount) {
        // Сортируем монеты в порядке убывания
        Arrays.sort(coins);
        int numCoins = 0;
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
                numCoins++;
            }

            if (amount == 0) {
                // Сумма разменяна полностью
                break;
            }

            index--;
        }

        if (amount > 0) {
            // Мы не смогли разменять сумму монетами
            return -1;
        }

        return numCoins;
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 10, 20, 50};
        int amount = 75;
        int minCoins = findMinCoins(coins, amount);

        if (minCoins != -1) {
            System.out.println("Минимальное количество монет, необходимых для размена " + amount + ": " + minCoins);
        } else {
            System.out.println("Невозможно разменять заданную сумму монетами.");
        }
    }
}
