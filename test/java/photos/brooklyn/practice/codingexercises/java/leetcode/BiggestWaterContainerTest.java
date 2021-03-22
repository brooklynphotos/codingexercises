package photos.brooklyn.practice.codingexercises.java.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class BiggestWaterContainerTest {
    private BiggestWaterContainer c = new BiggestWaterContainer();

    @Test
    public void maxAreaExample1() {
        assertEquals(49, c.maxArea(new int[]{
                1, 8, 6, 2, 5, 4, 8, 3, 7
        }));
    }

    @Test
    public void maxAreaExample2() {
        assertEquals(1, c.maxArea(new int[]{
                1, 1
        }));
    }

    @Test
    public void maxAreaExample3() {
        assertEquals(16, c.maxArea(new int[]{
                4, 3, 2, 1, 4
        }));
    }

    @Test
    public void maxAreaExample4() {
        assertEquals(2, c.maxArea(new int[]{
                1, 2, 1
        }));
    }

    @Test
    public void maxAreaExampleBig() {
        int[] heights = new int[100_000];
        heights[0] = 10_000;
        heights[heights.length - 1] = 10_000;
        assertEquals(1_000_000_000 - 10_000, c.maxArea(heights));
    }
}