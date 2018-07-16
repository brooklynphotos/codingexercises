package photos.brooklyn.practice.codingexercises.java.leetcode.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReorderedPowerOfTwoTest {

    private ReorderedPowerOfTwo obj = new ReorderedPowerOfTwo();

    @Test
    public void reorderedPowerOf2_10() {
        assertFalse(obj.reorderedPowerOf2(10));
    }

    @Test
    public void reorderedPowerOf2_16() {
        assertTrue(obj.reorderedPowerOf2(16));
    }

    @Test
    public void counter124(){
        assertEquals(10110, ReorderedPowerOfTwo.counter(124));
    }

    @Test
    public void counter9988(){
        assertEquals(2200000000l, ReorderedPowerOfTwo.counter(9988));
    }
}