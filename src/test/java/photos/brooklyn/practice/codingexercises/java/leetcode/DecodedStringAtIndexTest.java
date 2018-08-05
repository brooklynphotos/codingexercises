package photos.brooklyn.practice.codingexercises.java.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class DecodedStringAtIndexTest {
    private DecodedStringAtIndex obj = new DecodedStringAtIndex();

    @Test
    public void decodeAtIndex_10_o() {
        final String S = "leet2code3";
        final int K = 10;

        assertEquals("o", obj.decodeAtIndex(S, K));
    }

    @Test
    public void decodeAtIndex_5_h() {
        final String S = "ha22";
        final int K = 5;

        assertEquals("h", obj.decodeAtIndex(S, K));
    }

    @Test
    public void decodeAtIndex_1_a() {
        final String S = "a2345678999999999999999";
        final int K = 1;

        assertEquals("a", obj.decodeAtIndex(S, K));
    }
}