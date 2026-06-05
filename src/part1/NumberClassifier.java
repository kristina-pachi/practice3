package part1;

public class NumberClassifier {
    public static String classify(int number) {
        if (number < 0) return "-> отрицательное";
        if (number == 0) return "-> ноль";
        if (number < 10) return "-> однозначное";
        if (number < 100) return "-> двузначное";
        if (number < 1000) return "-> трёхзначное";
        return "-> большое";
    }
}