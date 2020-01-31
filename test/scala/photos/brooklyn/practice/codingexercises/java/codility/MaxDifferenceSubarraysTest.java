package photos.brooklyn.practice.codingexercises.java.codility;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class MaxDifferenceSubarraysTest {

    @Test
    public void giveSample1_returnCorrect() {
        final int[] A = {1, 3, -3};
        assertEquals(6, new MaxDifferenceSubarrays().solution(A));
    }
    @Test
    public void giveSample2_returnCorrect() {
        final int[] A = {4, 3, 2, 5, 1, 1};
        assertEquals(4, new MaxDifferenceSubarrays().solution(A));
    }
    @Test
    public void giveMinN_returnDiff() {
        final int[] A = {1, -1};
        assertEquals(2, new MaxDifferenceSubarrays().solution(A));
    }
    @Test
    public void giveAllSameButOneInMiddle_return0() {
        final int[] A = {1, 1, 1, 1, 1, 1, 1, -1, 1};
        assertEquals(0, new MaxDifferenceSubarrays().solution(A));
    }
    @Test
    public void givenMySample_returnCorrect() {
        final int[] A = {1, 3, 6, -1, 2, -5};
        assertEquals(11, new MaxDifferenceSubarrays().solution(A));
    }
    @Test
    public void givenSinglePeakAndSmallerStart() {
        final int[] A = {-5, -3, -1, 1, 5, 4, 3};
        assertEquals(10, new MaxDifferenceSubarrays().solution(A));
    }
    @Test
    public void givenSinglePeakAndFlankingSmallerEdgePeaks_returnDiffHighSmall() {
        final int[] A = {2, -1, 1, 5, 4, 1, 2};
        assertEquals(3, new MaxDifferenceSubarrays().solution(A));
    }
    @Test
    public void givenLargestSampleWithAbsPeaksOnEnds_return0() {
        final int[] A = new int[100_000];
        for (int i = 0; i < A.length; i++) {
            if (i == 0 || i == A.length - 1) {
                A[i] = 1_000_000_000;
            } else {
                A[i] = new Random().nextInt(1_500_000_000) - 750_000_000;
            }
        }
        final long start = System.currentTimeMillis();
        assertEquals(0, new MaxDifferenceSubarrays().solution(A));
        final long duration = System.currentTimeMillis() - start;
        assertTrue("Duration too long: "+duration, duration <18);
    }
}