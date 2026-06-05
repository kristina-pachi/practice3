package part1.task1_2;

public class GradeChecker {

    public static String getGrade(int score) {
        switch (score / 10) {
            case 10:
            case 9:
                return "Отлично (A)";
            case 8:
                return "Хорошо (B)";
            case 7:
                return "Удовлетворительно (C)";
            case 6:
                return "Слабо (D)";
            default:
                return "Неудовлетворительно (F)";
        }
    }

    public static String getGradeArrow(int score) {
        return switch (score / 10) {
            case 10, 9 -> "Отлично (A)";
            case 8 -> "Хорошо (B)";
            case 7 -> "Удовлетворительно (C)";
            case 6 -> "Слабо (D)";
            default -> "Неудовлетворительно (F)";
        };
    }

    public static void main(String[] args) {
        int[] tests = {95, 85, 73, 62, 45, 100, 0};
        System.out.println("Классический switch:");
        for (int s : tests) {
            System.out.printf("%d -> %s%n", s, getGrade(s));
        }

        System.out.println("\nСтрелочный switch:");
        for (int s : tests) {
            System.out.printf("%d -> %s%n", s, getGradeArrow(s));
        }
    }
}

