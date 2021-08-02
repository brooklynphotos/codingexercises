package photos.brooklyn.practice.codingexercises.java.hackerrank;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class NonDivisbleSetTest {

    @Test
    public void nonDivisibleSubset_eg0() {
        assertEquals(3, NonDivisbleSet.nonDivisibleSubset(4, Arrays.asList(19, 10, 12, 10, 24, 25, 22)));
    }

    @Test
    public void nonDivisibleSubset_eg1() {
        assertEquals(3, NonDivisbleSet.nonDivisibleSubset(3, Arrays.asList(1, 7, 2, 4)));
    }
}