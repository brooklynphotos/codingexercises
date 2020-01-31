package photos.brooklyn.practice.codingexercises.java.hackerrank;

import org.junit.Test;

import static org.junit.Assert.*;

public class DijkstraShortReachTest {
    @Test
    public void shortestReach_simple() {
        final int nodeCount = 4;
        final int[][] edges = {
                {1, 2, 24},
                {1, 4, 20},
                {3, 1, 3},
                {4, 3, 12},
        };
        final int starting = 1;
        final int[] res = DijkstraShortReach.shortestReach(nodeCount, edges, starting);
        final int[] exp = {24, 3, 15};
        assertArrayEquals(exp, res);
    }

    @Test
    public void shortestReach_simple_1island() {
        final int nodeCount = 5;
        final int[][] edges = {
                {1, 2, 5},
                {2, 3, 6},
                {3, 4, 2},
                {1, 3, 15},
        };
        final int starting = 1;
        final int[] res = DijkstraShortReach.shortestReach(nodeCount, edges, starting);
        final int[] exp = {5, 11, 13, -1};
        assertArrayEquals(exp, res);
    }
}