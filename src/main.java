public static void main(String[] args) {
    int[] numbers = {-5, 0, 7, 42, 100, 1000, -999};

    for (int n : numbers) {
        System.out.println(n + " " + NumberClassifier.classify(n));
    }
}
