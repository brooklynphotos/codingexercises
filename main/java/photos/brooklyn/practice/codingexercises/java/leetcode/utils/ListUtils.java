package photos.brooklyn.practice.codingexercises.java.leetcode.utils;

public class ListUtils {
    public static int maxChoice(final int a, final int... numbers) {
        int max = a;
        for (int n : numbers) {
            max = Math.max(max, n);
        }
        return max;
    }
}
