package photos.brooklyn.practice.codingexercises.java.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

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

    @Test
    public void decodeAtIndex_1_y() {
        final String S = "y959q969u3hb22odq595";
        final int K = 222280369;

        assertEquals("y", obj.decodeAtIndex(S, K));
    }

    @Test
    public void decodeAtIndex_9_b() {
        final String S = "a2b3c4d5e6f7g8h9";
        final int K = 9;

        assertEquals("b", obj.decodeAtIndex(S, K));
    }

    @Test
    public void decodeAtIndex_768077956_c() {
        final String S = "czjkk9elaqwiz7s6kgvl4gjixan3ky7jfdg3kyop3husw3fm289thisef8blt7a7zr5v5lhxqpntenvxnmlq7l34ay3jaayikjps";
        final int K = 768077956;

        assertEquals("c", obj.decodeAtIndex(S, K));
    }
}