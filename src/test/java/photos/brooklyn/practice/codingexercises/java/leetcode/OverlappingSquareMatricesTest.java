package photos.brooklyn.practice.codingexercises.java.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class OverlappingSquareMatricesTest {

    @Test
    public void largestOverlap() {
        final int[][] A = {{1,1,0}, {0,1,0},{0,1,0}};
        final int[][] B = {{0,0,0}, {0,1,1},{0,0,1}};
        assertEquals(3, new OverlappingSquareMatrices().largestOverlap(A, B));
    }

    @Test
    public void largestOverlap2x2() {
        final int[][] A = {{0,1}, {1,1}};
        final int[][] B = {{1,1}, {1,0}};
        assertEquals(3, new OverlappingSquareMatrices().largestOverlap(A, B));
    }
}