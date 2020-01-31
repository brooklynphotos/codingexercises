package photos.brooklyn.practice.codingexercises.java.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReorderedPowerOfTwoTest {
    final private ReorderedPowerOfTwo obj = new ReorderedPowerOfTwo();

    @Test
    public void reorderedPowerOf2_1() {
        assertTrue(obj.reorderedPowerOf2(1));
    }

    @Test
    public void reorderedPowerOf2_10() {
        assertFalse(obj.reorderedPowerOf2(10));
    }

    @Test
    public void reorderedPowerOf2_16() {
        assertTrue(obj.reorderedPowerOf2(16));
    }

    @Test
    public void reorderedPowerOf2_24() {
        assertFalse(obj.reorderedPowerOf2(24));
    }
    @Test
    public void reorderedPowerOf2_46() {
        assertTrue(obj.reorderedPowerOf2(46));
    }
}