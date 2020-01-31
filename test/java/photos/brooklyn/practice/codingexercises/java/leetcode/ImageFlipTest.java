package photos.brooklyn.practice.codingexercises.java.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class ImageFlipTest {

    @Test
    public void testFlipNormalEven(){
        final int[][] A = {{1,1,1,0},{0,0,1,1},{1,0,1,0},{1,0,0,1}};
        final int[][] T = new ImageFlip().flipAndInvertImage(A);
        assertEquals(A.length, T.length);
        assertEquals(1, T[0][0]);
        assertEquals(0, T[3][3]);
    }

    @Test
    public void testFlipNormalOdd(){
        final int[][] A = {{1,1,0},{0,1,1},{1,1,0}};
        final int[][] T = new ImageFlip().flipAndInvertImage(A);
        assertEquals(A.length, T.length);
        assertEquals(1, T[0][0]);
        assertEquals(0, T[2][2]);
        assertEquals(0, T[1][1]);
    }
}