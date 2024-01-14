public class Zadanie15 {
    public static int[] makeChange(int[] coins, int[] coinCounts, int amount) {
        // Проверяем, имеется ли достаточно монет каждого номинала
        if (coins.length != coinCounts.length) {
            throw new IllegalArgumentException("Количество монет и их номиналы не совпадают");
        }

        // Создаем массив для хранения количества монет каждого номинала, которые будут использованы
        int[] change = new int[coins.length];

        int remainingAmount = amount;

        for (int i = coins.length - 1; i >= 0; i--) {
            // Проверяем, что имеется достаточное количество монет для текущего номинала
            int numCoins = Math.min(coinCounts[i], remainingAmount / coins[i]);

            // Вычитаем монеты текущего номинала из оставшейся суммы и обновляем количество монет этого номинала
            remainingAmount -= numCoins * coins[i];
            change[i] = numCoins;
        }

        if (remainingAmount > 0) {
            // Мы не смогли разменять всю сумму монетами, возвращаем null
            return null;
        }

        return change;
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 10, 20, 50};
        int[] coinCounts = {10, 5, 3, 2, 2, 1};
        int amount = 75;
        int[] change = makeChange(coins, coinCounts, amount);

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
