package photos.brooklyn.practice.codingexercises.java.other;

public class CodinGameClash {
    public static final String scrambleHalfHalf(String s) {
        if (s.length() < 2) {
            return s;
        }
        int midPoint = s.length() / 2;
        if (s.length() % 2 == 1) {
            midPoint++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < midPoint; i++) {
            sb.append(s.charAt(i));
            int h2Index = midPoint + i;
            if (h2Index < s.length()) {
                sb.append(s.charAt(h2Index));
            }
        }
        return sb.toString();
    }
    public static int getNonMultiple(int[] ps, int X, int C) {
        int i = 0;
        int c = 0;
        int ci = 0;
        while (ci < C) {
            int x = X + i;
            if (!isMultiple(x, ps)) {
                c = x;
                ci++;
            }
            i++;
        }
        return c;
    }

    private static boolean isMultiple(final int x, final int[] ps) {
        for (int pi : ps) {
            if(x%pi==0) return true;
        }
        return false;
    }
}
