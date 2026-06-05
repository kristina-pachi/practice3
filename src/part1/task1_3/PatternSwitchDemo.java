package part1.task1_3;

public class PatternSwitchDemo {

    public static String describe(Object obj) {
        return switch (obj) {
            case null -> "null";
            case Integer i -> "Integer: " + i + (i > 0 ? " (positive)" : " (not positive)");
            case String s -> s.isEmpty() ? "String: (empty)" : "String: \"" + s + "\"";
            case Double d -> "Double: " + d;
            case int[] arr -> {
                StringBuilder sb = new StringBuilder();
                sb.append("int[]: length=").append(arr.length).append(", values=[");
                for (int k = 0; k < arr.length; k++) {
                    if (k > 0) sb.append(", ");
                    sb.append(arr[k]);
                }
                sb.append("]");
                yield sb.toString();
            }
            default -> "Other type: " + obj;
        };
    }

    public static void main(String[] args) {
        Object[] tests = {
                null,
                42,
                -5,
                "",
                "Привет",
                3.14,
                new int[] {1, 2, 3},
                true
        };

        for (Object t : tests) {
            System.out.printf("%s -> %s%n", t, describe(t));
        }
    }
}

