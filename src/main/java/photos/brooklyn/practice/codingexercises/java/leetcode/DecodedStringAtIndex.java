package photos.brooklyn.practice.codingexercises.java.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/contest/weekly-contest-96/problems/decoded-string-at-index/
 */
public class DecodedStringAtIndex {
    public String decodeAtIndex(String S, int K) {
        final char[] chars = new char[K];
        int pointer = 0;
        for (char c : S.toCharArray()) {
            final int possibleInt = Character.getNumericValue(c);
            if (possibleInt >= 2 && possibleInt <= 9) {
                final char found = copy(chars, pointer, possibleInt, K);
                if(found != '0') return Character.toString(found);
                pointer = possibleInt * pointer;
            } else {
                chars[pointer++] = c;
                if(pointer==K) return Character.toString(c);
            }
        }
        throw new IllegalArgumentException("Can't happen with " + S + " and " + K);
    }

    private static char copy(final char[] chars, final int upperBound, final int multiplier, final int K) {
        for (int n = 1; n < multiplier; n++) {
            int start = upperBound * n;
            for (int c = 0; c < upperBound; c++) {
                int d = start + c;
                chars[d] = chars[c];
                if(d+1 == K) return chars[d];
            }
        }
        return '0';
    }

    public String decodeAtIndex_(String S, int K) {
        StringRepeater lastBlock = null;
        List<Character> characterBlock = new LinkedList<>();
        int lastLength = 0;
        for (char c : S.toCharArray()) {
            final int possibleInt = Character.getNumericValue(c);
            if (possibleInt >= 2 && possibleInt <= 9) {
                lastLength *= possibleInt;
                lastBlock = new StringRepeater(characterBlock, possibleInt);
                characterBlock = new LinkedList<>();

            } else {
                characterBlock.add(c);
                lastLength++;
            }
            if (K <= lastLength) {
                // we've found it
            }
        }
        throw new UnsupportedOperationException();
    }

    class StringRepeater{
        public StringRepeater(final List<Character> chars, final int multiplier) {
            this.chars = chars;
            this.multiplier = multiplier;
        }

        private List<Character> chars = new LinkedList<>();
        private int multiplier = 1;
    }
}
