package part2.task2_2;

public class Fibonacci {

    public static long fibIterative(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        long a = 0;
        long b = 1;
        int i = 1;
        while (i < n) {
            long c = a + b;
            a = b;
            b = c;
            i++;
        }
        return b;
    }

    public static long fibFor(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        long a = 0;
        long b = 1;
        for (int i = 1; i < n; i++) {
            long c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println("F(0)..F(15):");
        for (int n = 0; n <= 15; n++) {
            // можно использовать любую реализацию — обе дают одинаковый результат
            System.out.printf("F(%2d) = %d%n", n, fibIterative(n));
        }

        int index = 0;
        long value;
        do {
            value = fibIterative(index);
            index++;
        } while (value <= 1000);

        System.out.printf("%nПервое число Фибоначчи, превышающее 1000: F(%d) = %d%n",
                index - 1, value);
    }
}

