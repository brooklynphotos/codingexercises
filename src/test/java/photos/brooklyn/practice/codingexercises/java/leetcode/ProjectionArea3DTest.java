package photos.brooklyn.practice.codingexercises.java.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProjectionArea3DTest {
    private ProjectionArea3D obj = new ProjectionArea3D();

    @Test
    public void projectionArea() {
        final int[][] input = {{2, 2, 2}, {2, 1, 2}, {2, 2, 2}};
        assertEquals(21, obj.projectionArea(input));
    }
}