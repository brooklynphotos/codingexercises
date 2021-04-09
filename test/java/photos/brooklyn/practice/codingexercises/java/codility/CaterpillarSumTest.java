package photos.brooklyn.practice.codingexercises.java.codility;

import org.junit.Test;

import static org.junit.Assert.*;

public class CaterpillarSumTest {

    @Test
    public void canMakeSum() {
        final int[] A = {6, 2, 7, 4, 1, 3, 6};
        assertTrue(CaterpillarSum.canMakeSum(A, 12));
    }

    @Test
    public void canMakeSumImpossible() {
        final int[] A = {6, 2, 7, 4, 1, 3, 6};
        assertFalse(CaterpillarSum.canMakeSum(A, 40));
    }
}