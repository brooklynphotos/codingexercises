package photos.brooklyn.practice.codingexercises.java.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class MininumRefuelingStopsTest {
    private final MininumRefuelingStops obj = new MininumRefuelingStops();

    @Test
    public void minRefuelStopsNoStop() {
        assertEquals(obj.minRefuelStops(1, 1, new int[][]{}), 0);
    }

    @Test
    public void minRefuelStopsImpossible1() {
        assertEquals(obj.minRefuelStops(100, 1, new int[][]{{10, 100}}), -1);
    }

    @Test
    public void minRefuelStopsImpossible2() {
        assertEquals(obj.minRefuelStops(100, 50, new int[][]{{25, 30}}), -1);
    }

    @Test
    public void minRefuelStops_2() {
        assertEquals(obj.minRefuelStops(100, 10, new int[][]{{10,60},{20,30},{30,30},{60,40}}), 2);
    }

    @Test
    public void minRefuelStops_1() {
        assertEquals(obj.minRefuelStops(100, 50, new int[][]{{50,50}}), 1);
    }
}