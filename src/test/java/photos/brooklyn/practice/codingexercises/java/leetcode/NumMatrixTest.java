package photos.brooklyn.practice.codingexercises.java.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumMatrixTest {

    @Test
    public void makeSumMatrix() {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6}
        };
        int[][] res = NumMatrix.makeSumMatrix(matrix);
        assertEquals(3, res[1][2]);
        assertEquals(12, res[2][2]);
        assertEquals(21, res[2][3]);
    }
    @Test
    public void makeSumMatrixLarger() {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {-1, -2, -3},
            {-4, -5, -6}
        };
        int[][] res = NumMatrix.makeSumMatrix(matrix);
        assertEquals(0, res[4][3]);
        assertEquals(9, res[3][2]);
    }

    @Test
    public void sumRegion() {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {-1, -2, -3},
            {-4, -5, -6}
        };
        final NumMatrix m = new NumMatrix(matrix);
        assertEquals(0, m.sumRegion(0,0,3,2));
        assertEquals(6, m.sumRegion(1,1,2,2));
        assertEquals(5, m.sumRegion(1,1,1,1));
    }
    @Test
    public void sumRegionEmpty() {
        int[][] matrix = {{}};
        final NumMatrix m = new NumMatrix(matrix);
        assertEquals(0, m.sumRegion(0,0,0,0));
    }
}