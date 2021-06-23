package photos.brooklyn.practice.codingexercises.java.hackerrank;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class PermutingArraysTest {

    @Test
    public void twoArrays_eg1() {
        assertEquals("YES", PermutingArrays.twoArrays(10, Arrays.asList(2, 1, 3), Arrays.asList(7, 8, 9)));
    }

    @Test
    public void twoArrays_eg2() {
        assertEquals("NO", PermutingArrays.twoArrays(10, Arrays.asList(1, 2, 2, 1), Arrays.asList(3, 3, 3, 4)));
    }
}