import java.util.function.Function;

public class Zadanie1 {
    public static double fix(Function<Double, Double> f, double a, double b, double eps) {
        double c = (a + b) / 2.0;
        if (Math.abs(f.apply(c) - c) < eps) {
            return c;
        } else if (f.apply(c) < c) {
            return fix(f, a, c, eps);
        } else {
            return fix(f, c, b, eps);
        }
    }

    public static void main(String[] args) {
        // Пример использования
        Function<Double, Double> f = x -> Math.cos(x);  // Здесь нужно указать вашу функцию f(x)

        double a = 0;          // Здесь нужно указать начало отрезка [a, b]
        double b = Math.PI;    // Здесь нужно указать конец отрезка [a, b]
        double eps = 0.001;    // Здесь нужно указать требуемую точность

        double root = fix(f, a, b, eps);
        System.out.println("Корень уравнения x = f(x): " + root);
    }
}

