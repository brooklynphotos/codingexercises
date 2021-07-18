package photos.brooklyn.practice.codingexercises.java.hackerrank;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class TargetedPairsTest {

    @Test
    public void pairs_staggered() {
        assertEquals(2, TargetedPairs.pairs(100, Arrays.asList(1, 2, 101, 102, 103)));
    }

    @Test
    public void pairs_toofar() {
        assertEquals(0, TargetedPairs.pairs(10, Arrays.asList(1, 2, 3, 4)));
    }

    @Test
    public void pairs_never_exact() {
        assertEquals(0, TargetedPairs.pairs(3, Arrays.asList(1, 3, 5, 7)));
    }

    @Test
    public void pairs_eg1() {
        assertEquals(3, TargetedPairs.pairs(1, Arrays.asList(1, 2, 3, 4)));
    }

    @Test
    public void pairs_eg2() {
        assertEquals(3, TargetedPairs.pairs(2, Arrays.asList(1, 5, 3, 4, 2)));
    }
}