package photos.brooklyn.practice.codingexercises.java.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

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
}