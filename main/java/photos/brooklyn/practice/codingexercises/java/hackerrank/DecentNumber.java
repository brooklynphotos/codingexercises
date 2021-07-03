package photos.brooklyn.practice.codingexercises.java.hackerrank;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-the-beast/problem
 */
public class DecentNumber {
    public static void decentNumber(int n) {
        System.out.println(getDecentNumber(n));
    }
    static String getDecentNumber(int n) {
        int fives;
        int threes = 0;
        int leftOver;
        while (true) {
            int threePart = threes * 5;
            if (threePart > n) {
                return "-1";
            }
            int fivePart = n - threePart;
            leftOver = fivePart % 3;
            fives = fivePart / 3;
            if (leftOver == 0) {
                break;
            }
            threes++;
        }
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fives; i++) {
            sb.append("555");
        }
        for (int i = 0; i < threes; i++) {
            sb.append("33333");
        }
        return sb.toString();
    }
}
