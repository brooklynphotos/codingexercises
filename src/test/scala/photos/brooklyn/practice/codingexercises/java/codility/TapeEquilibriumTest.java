package photos.brooklyn.practice.codingexercises.java.codility;

import org.junit.Test;

import static org.junit.Assert.*;

public class TapeEquilibriumTest {

    @Test
    public void testTypical() {
        int[] input = {3, 1, 2, 4, 3};
        assertEquals(1, new TapeEquilibrium().solution(input));
    }
    @Test
    public void testMinN() {
        int[] input = {1,2};
        assertEquals(1, new TapeEquilibrium().solution(input));
    }
    @Test
    public void testBalanced() {
        int[] input = {1, 1, 2};
        assertEquals(0, new TapeEquilibrium().solution(input));
    }
    @Test
    public void testZeroPrefix() {
        int[] input = {0, 0, 0, 0, 2};
        assertEquals(2, new TapeEquilibrium().solution(input));
    }
    @Test
    public void testPonLast() {
        int[] input = {1, 1, 1, 1, 4};
        assertEquals(0, new TapeEquilibrium().solution(input));
    }
    @Test
    public void testGiantPos() {
        int[] input = new int[100_000];
        for (int i = 0; i < input.length; i++) {
            input[i] = 1000;
        }
        assertEquals(0, new TapeEquilibrium().solution(input));
    }
    @Test
    public void testGiantNeg() {
        int[] input = new int[100_000];
        for (int i = 0; i < input.length; i++) {
            input[i] = -1000;
        }
        assertEquals(0, new TapeEquilibrium().solution(input));
    }
    @Test
    public void testGiantOddN() {
        int[] input = new int[100_000 - 1];
        for (int i = 0; i < input.length; i++) {
            input[i] = 1000;
        }
        assertEquals(1000, new TapeEquilibrium().solution(input));
    }
}