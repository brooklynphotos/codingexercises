package photos.brooklyn.practice.codingexercises.java.leetcode;

/**
 * https://leetcode.com/contest/weekly-contest-96/problems/decoded-string-at-index/
 */
public class DecodedStringAtIndex {
    public String decodeAtIndex(String S, int K) {
        StringBuilder sb = new StringBuilder();
        StringRepeater block = null;
        for (char c : S.toCharArray()) {
            final int possibleInt = Character.getNumericValue(c);
            if (possibleInt >= 2 && possibleInt <= 9) {
                block = new StringRepeater(sb.toString(), possibleInt, block);
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
            if (K <= StringRepeater.getLength(block) + sb.length()) {
                if (sb.length() > 0) {
                    return sb.substring(sb.length() - 1);
                } else {
                    return findAtIndex(K - 1, block);
                }
            }
        }
        return sb.substring(K - 1);
    }

    private static String findAtIndex(final int k, final StringRepeater block) {
        final int unitLength = block.length / block.multiplier;
        final int extra = k % unitLength;
        if (extra > StringRepeater.getLength(block.previous) - 1) {
            return Character.toString(block.chars.charAt(extra - StringRepeater.getLength(block.previous)));
        } else {
            return findAtIndex(extra, block.previous);
        }

    }

    static class StringRepeater{
        public StringRepeater(final String chars, final int multiplier, final StringRepeater previous) {
            this.chars = chars;
            this.multiplier = multiplier;
            this.length = multiplier * (chars.length() + StringRepeater.getLength(previous));
            this.previous = previous;
        }

        private String chars;
        private int multiplier;
        private StringRepeater previous;
        private int length;

        static int getLength(final StringRepeater block) {
            return block == null ? 0 : block.length;
        }
    }
}
