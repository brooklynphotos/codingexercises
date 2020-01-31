package photos.brooklyn.practice.codingexercises.java.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class SurfaceArea3DShapesTest {
    private SurfaceArea3DShapes obj = new SurfaceArea3DShapes();

    @Test
    public void surfaceArea_single() {
        final int[][] grid = {{2}};
        assertEquals(10, obj.surfaceArea(grid));
    }

    @Test
    public void surfaceArea_3x3() {
        final int[][] grid = {{1,1,1},{1,0,1},{1,1,1}};
        assertEquals(32, obj.surfaceArea(grid));
    }
}