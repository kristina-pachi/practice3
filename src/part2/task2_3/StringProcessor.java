package part2.task2_3;

import java.util.Locale;

public class StringProcessor {

    public static int countVowels(String text) {
        if (text == null) return 0;
        String vowels = "aeiouAEIOU" + "аеёиоуыэюяАЕЁИОУЫЭЮЯ";
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (vowels.indexOf(text.charAt(i)) >= 0) count++;
        }
        return count;
    }

    public static boolean isPalindrome(String text) {
        if (text == null) return false;
        StringBuilder filtered = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                filtered.append(Character.toLowerCase(c));
            }
        }
        int l = 0, r = filtered.length() - 1;
        while (l < r) {
            if (filtered.charAt(l) != filtered.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

    public static String reverse(String text) {
        if (text == null) return null;
        char[] arr = text.toCharArray();
        int l = 0, r = arr.length - 1;
        while (l < r) {
            char tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            l++;
            r--;
        }
        return new String(arr);
    }

    public static String findLongestWord(String sentence) {
        if (sentence == null || sentence.isEmpty()) return "";
        String[] parts = sentence.split("[^\\p{L}\\p{Nd}-]+");
        String longest = "";
        for (String p : parts) {
            if (p.length() > longest.length()) longest = p;
        }
        return longest;
    }

    public static void main(String[] args) {
        String[] tests = {
                "Привет, Java-разработчик!",
                "топот",
                "Madam",
                "hello",
                "А роза упала на лапу Азора",
                "The quick brown fox jumps over the lazy dog"
        };

        for (String s : tests) {
            System.out.println("Исходная строка: " + s);
            System.out.println("Гласных: " + countVowels(s));
            System.out.println("Реверс: " + reverse(s));
            System.out.println("Палиндром: " + (isPalindrome(s) ? "да" : "нет"));
            System.out.println("Самое длинное слово: " + findLongestWord(s));
            System.out.println();
        }
    }
}
