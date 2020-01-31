package photos.brooklyn.practice.codingexercises.java.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

import photos.brooklyn.practice.codingexercises.java.leetcode.solutions.ProfitableSchemes;

public class ProfitableSchemesTest {
    private final ProfitableSchemes obj = new ProfitableSchemes();

    @Test
    public void profitableSchemes_shortest() {
        int G = 5;
        int P = 3;
        int[] group = {2,2};
        int[] profit = {2,3};
        assertEquals(2, obj.profitableSchemes(G, P, group, profit));
    }

    @Test
    public void profitableSchemes_short() {
        int G = 10;
        int P = 5;
        int[] group = {2, 3, 5};
        int[] profit = {6, 7, 8};
        assertEquals(7, obj.profitableSchemes(G, P, group, profit));
    }

    @Test
    public void profitableSchemes_short_impossible() {
        int G = 1;
        int P = 1;
        int[] group = {2, 3, 5};
        int[] profit = {6, 7, 8};
        assertEquals(0, obj.profitableSchemes(G, P, group, profit));
    }

    @Test
    public void profitableSchemes_tiny() {
        int G = 1;
        int P = 1;
        int[] group = {1};
        int[] profit = {1};
        assertEquals(1, obj.profitableSchemes(G, P, group, profit));
    }

    @Test
    public void profitableSchemes_tiny2() {
        int G = 1;
        int P = 1;
        int[] group = {1,1,1,1,2,2,1,2,1,1};
        int[] profit = {0,1,0,0,1,1,1,0,2,2};
        assertEquals(4, obj.profitableSchemes(G, P, group, profit));
    }
}