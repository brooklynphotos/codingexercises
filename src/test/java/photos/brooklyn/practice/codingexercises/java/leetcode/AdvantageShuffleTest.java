package photos.brooklyn.practice.codingexercises.java.leetcode;

import org.junit.Test;
import photos.brooklyn.practice.codingexercises.java.leetcode.utils.FileUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AdvantageShuffleTest {
    private final AdvantageShuffle shuffle = new AdvantageShuffle();

    @Test
    public void advantageCount1() {
        final int[] A = {2,7,11,15};
        final int[] B = {1,10,4,11};
        assertTrue(Arrays.equals(new int[]{2,11,7,15}, shuffle.advantageCount(A, B)));
    }

    @Test
    public void advantageCount2() {
        final int[] A = {12,24,8,32};
        final int[] B = {13,25,32,11};
        assertTrue(Arrays.equals(new int[]{24,32,8,12}, shuffle.advantageCount(A, B)));
    }

    @Test
    public void advantageCount3() {
        final int[] A = {2,0,4,1,2};
        final int[] B = {1,3,0,0,2};
        assertEquals(getAdvantage(new int[]{2,0,2,1,4}, B), getAdvantage(shuffle.advantageCount(A, B), B));
    }

    @Test
    public void advantageCountLong() throws IOException {
        final Map<String, int[]> data = FileUtils.loadData("advantage_shuffle");
        final int[] A = data.get("a");
        final int[] B = data.get("b");
        final int[] C = data.get("c");
        assertEquals(getAdvantage(C,B), getAdvantage(shuffle.advantageCount(A, B),B));
    }

    @Test
    public void advantageCount4() {
        final int[] A = {5621,1743,5532,3549,9581};
        final int[] B = {913,9787,4121,5039,1481};
        assertEquals(getAdvantage(new int[]{1743,9581,5532,5621,3549},B), getAdvantage(shuffle.advantageCount(A, B),B));
    }

    @Test
    public void advantageCount5() {
        final int[] A = {15777,7355,6475,15448,18412};
        final int[] B = {986,13574,14234,18412,19893};
        assertEquals(getAdvantage(new int[]{6475,15448,15777,18412,7355},B), getAdvantage(shuffle.advantageCount(A, B),B));
    }

    private static int getAdvantage(final int[] x, final int[] y){
        int advantage = 0;
        for(int i=0;i<x.length;i++){
            if(x[i]==-1) throw new IllegalArgumentException("No -1 allowed: "+i);
            if(x[i]>y[i]) advantage++;
        }
        return advantage;
    }

}