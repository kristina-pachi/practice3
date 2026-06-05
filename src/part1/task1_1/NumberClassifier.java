package part1.task1_1;

public class NumberClassifier {

    public static String classify(int number) {
        if (number < 0) return "отрицательное";
        if (number == 0) return "ноль";
        if (number < 10) return "однозначное";
        if (number < 100) return "двузначное";
        if (number < 1000) return "трёхзначное";
        return "большое";
    }

    public static void main(String[] args) {
        int[] tests = { -5, 0, 7, 42, 100, 1000, -999 };
        for (int n : tests) {
            System.out.println(n + " -> " + classify(n));
        }
    }
}
