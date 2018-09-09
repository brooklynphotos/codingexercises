package photos.brooklyn.practice.codingexercises.java.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class RLEIteratorTest {

    @Test
    public void next_example1() {
        final int[] rle = {3, 8, 0, 9, 2, 5};
        final RLEIterator it = new RLEIterator(rle);
        assertEquals(8, it.next(2));
    }
}