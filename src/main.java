public static void main(String[] args) {
    System.out.println("\n=== 1.1 Классификация числа ===\n");

    int[] numbers = {-5, 0, 7, 42, 100, 1000, -999};

    for (int n : numbers) {
        System.out.println(n + " " + NumberClassifier.classify(n));
    }

    System.out.println("\n=== 1.2 классический switch ===\n");


    int[] grades = {95, 85, 73, 62, 45, 100, 0};

    for (int g : grades) {
        System.out.println(g + "-> " + GradeChecker.getGrade(g));
    }

    System.out.println("\n=== 1.2 стрелочный switch ===\n");

    for (int g : grades) {
        System.out.println(g + "-> " + GradeChecker.getGradeArrow(g));
    }

}
