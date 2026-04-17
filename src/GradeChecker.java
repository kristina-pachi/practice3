public class GradeChecker {
    public static String getGrade(int score){
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

}
