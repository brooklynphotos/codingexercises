package photos.brooklyn.practice.codingexercises.java.codility;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxNonoverlappingSegmentsTest {

    @Test
    public void givenSampleAndCandidate0_findNonOverlappingReturn2() {
        final int[] A = {1, 3, 7, 9, 9};
        final int[] B = {5, 6, 8, 9, 10};
        assertEquals(2, MaxNonoverlappingSegments.findNonoverlapping(0, A, B));
    }
    @Test
    public void givenSample_returnCorrect() {
        final int[] A = {1, 3, 7, 9, 9};
        final int[] B = {5, 6, 8, 9, 10};
        assertEquals(3, new MaxNonoverlappingSegments().solution(A, B));
    }
    @Test
    public void givenNoSegment_return0() {
        final int[] A = {};
        final int[] B = {};
        assertEquals(0, new MaxNonoverlappingSegments().solution(A, B));
    }
    @Test
    public void givenOnlyOverlaps_return0() {
        final int[] A = {1, 1, 1};
        final int[] B = {5, 5, 5};
        assertEquals(0, new MaxNonoverlappingSegments().solution(A, B));
    }
    @Test
    public void givenSameStartDifferentEnds_return0() {
        final int[] A = {1, 1, 1};
        final int[] B = {5, 6, 7};
        assertEquals(0, new MaxNonoverlappingSegments().solution(A, B));
    }
    @Test
    public void givenSharedStartEnd_returnHalf() {
        final int[] A = {1, 3, 9, 12};
        final int[] B = {3, 9, 12, 20};
        assertEquals(A.length / 2, new MaxNonoverlappingSegments().solution(A, B));
    }
    @Test
    public void givenSameEnds_return0() {
        final int[] A = {12, 9, 3, 2};
        final int[] B = {20, 20, 20, 20};
        assertEquals(0, new MaxNonoverlappingSegments().solution(A, B));
    }
    @Test
    public void givenOneBigAndTwoSmaller_return2() {
        final int[] A = {3, 1, 12};
        final int[] B = {10, 20, 20};
        assertEquals(2, new MaxNonoverlappingSegments().solution(A, B));
    }
    @Test
    public void givenOneSegment_return1() {
        final int[] A = {3};
        final int[] B = {10};
        assertEquals(1, new MaxNonoverlappingSegments().solution(A, B));
    }
}