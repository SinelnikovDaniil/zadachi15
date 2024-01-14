public class Zadanie3 {
    public static int sym(char s[], int n) {
        // Если строка пуста или содержит только один символ, она симметрична
        if (n <= 1) {
            return 1;
        }

        // Проверяем первый и последний символы строки на симметричность
        if (s[0] == s[n - 1]) {
            // Если первый и последний символы совпадают, сравниваем внутренние символы
            return sym(s, n - 2);  // Рекурсивно проверяем внутреннюю часть строки
        } else {
            return 0;  // Строка не симметрична
        }
    }

    public static void main(String[] args) {
        // Примеры для проверки
        String[] strings = {"", "a", "aaa", "abcba", "abcdcba", "abccba"};

        for (String string : strings) {
            char[] s = string.toCharArray();
            int result = sym(s, s.length);
            System.out.println("Строка \"" + string + "\" симметрична: " + (result == 1));
        }
    }
}

