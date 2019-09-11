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
}