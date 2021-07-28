package photos.brooklyn.practice.codingexercises.java.hackerrank;

/**
 * https://www.hackerrank.com/challenges/append-and-delete/problem
 */
public class AppendAndDelete {
    public static String appendAndDelete(String s, String t, int k) {
        int i = 0;
        for (; i < s.length() && i<t.length() && s.charAt(i)==t.charAt(i); i++);
        final int count = s.length() - i + t.length() - i;
        boolean doable = count == k || k > (s.length() + t.length()) || ((count % 2 == k % 2) && count <= k);
        return doable ? "Yes" : "No";
    }
}
