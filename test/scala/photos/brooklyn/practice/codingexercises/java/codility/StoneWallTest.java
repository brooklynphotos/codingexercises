package photos.brooklyn.practice.codingexercises.java.codility;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class StoneWallTest {

    @Test
    public void givenSample_returnExpected() {
        final int[] H = {8, 8, 5, 7, 9, 8, 7, 4, 8};
        assertEquals(7, new StoneWall().solution(H));
    }
    @Test
    public void givenOneHeight_return1() {
        final int[] H = {8};
        assertEquals(1, new StoneWall().solution(H));
    }
    @Test
    public void givenIncreasingHeight_returnN() {
        final int[] H = {1,2,3,4};
        assertEquals(H.length, new StoneWall().solution(H));
    }
    @Test
    public void givenIncreasingHeightAndDifferentDecreasing_returnN() {
        final int[] H = {2,4,6,8,7,5,3,1};
        assertEquals(H.length, new StoneWall().solution(H));
    }
    @Test
    public void givenLargeRandomData_stillReturnsGreaterThan1() {
        final int[] H = new int[100_000];
        final int minRange = 800_000;
        final int maxRange = 1_000_000;
        for (int i = 0; i < H.length; i++) {
            H[i] = new Random().nextInt(maxRange - minRange + 1) + minRange;
        }
        assertTrue(new StoneWall().solution(H)> 1);
    }
    @Test
    public void givenThreeGiantBlocks_return3() {
        final int[] H = new int[100_000];
        final int lowStart = H.length / 3;
        final int lowEnd = 2 * lowStart;
        for (int i = 0; i < lowStart; i++) H[i] = 900_000;
        for (int i = lowStart; i < lowEnd; i++) H[i] = 800_000;
        for (int i = lowEnd; i < H.length; i++) H[i] = 1_000_000;
        assertEquals(3, new StoneWall().solution(H));
    }
}