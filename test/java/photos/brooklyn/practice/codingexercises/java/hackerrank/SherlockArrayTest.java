package photos.brooklyn.practice.codingexercises.java.hackerrank;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SherlockArrayTest {

    @Test
    public void balancedSums_eg1() {
        assertEquals("YES", SherlockArray.balancedSums(Arrays.asList(5, 6, 8, 11)));
    }

    @Test
    public void balancedSums_eg0() {
        assertEquals("NO", SherlockArray.balancedSums(Arrays.asList(1, 2, 3)));
    }

    @Test
    public void balancedSums_eg2() {
        assertEquals("YES", SherlockArray.balancedSums(Arrays.asList(1, 2, 3, 3)));
    }

    @Test
    public void balancedSums_eg3() {
        assertEquals("YES", SherlockArray.balancedSums(Arrays.asList(1, 1, 4, 1, 1)));
    }

    @Test
    public void balancedSums_eg4() {
        assertEquals("YES", SherlockArray.balancedSums(Arrays.asList(2, 0, 0, 0)));
    }

    @Test
    public void balancedSums_eg5() {
        assertEquals("YES", SherlockArray.balancedSums(Arrays.asList(0, 0, 2, 0)));
    }
}