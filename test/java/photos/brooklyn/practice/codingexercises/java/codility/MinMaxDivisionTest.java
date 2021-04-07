package photos.brooklyn.practice.codingexercises.java.codility;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MinMaxDivisionTest {

    @Test
    public void givenSortedListAndCeiling_returnCorrectIndex() {
        final long[] list = {1l, 2l, 3l, 4l, 6l};
        assertEquals(3, MinMaxDivision.search(list, 4, 0));
        assertEquals(3, MinMaxDivision.search(list, 5, 0));
        assertEquals(3, MinMaxDivision.search(list, 4, 1));
    }

    @Test
    public void givenSample_returnCorrect() {
        int K = 3;
        int M = 5;
        int[] A = {2, 1, 5, 1, 2, 2, 2};
        assertEquals(6, new MinMaxDivision().solution(K, M, A));
    }
    @Test
    public void givenOneBlock_returnSum() {
        int K = 1;
        int M = 5;
        int[] A = {2, 1, 5, 1, 2, 2, 2};
        assertEquals(15, new MinMaxDivision().solution(K, M, A));
    }
    @Test
    public void givenAllZerosButOne_returnThatONe() {
        int K = 5;
        int M = 15;
        int[] A = {0, 0, 0, 15, 0, 0, 0, 0};
        assertEquals(15, new MinMaxDivision().solution(K, M, A));
    }
    @Test
    public void givenExtraneousBlocksAndSingleA_returnSingleElement() {
        int K = 100;
        int M = 5;
        int[] A = {5};
        assertEquals(5, new MinMaxDivision().solution(K, M, A));
    }
    @Test
    public void givenExtraneousBlocks_returnMaxA() {
        int K = 100;
        int M = 5;
        int[] A = {2,3,1};
        assertEquals(3, new MinMaxDivision().solution(K, M, A));
    }
    @Test
    public void givenRepeatedVals_returnThatVal() {
        int K = 3;
        int M = 5;
        int[] A = {5,5,5};
        assertEquals(5, new MinMaxDivision().solution(K, M, A));
    }
    @Test
    public void givenLargestUniformSample_returnUnitSize() {
        int K = 100_000;
        int M = 10_000;
        int[] A = new int[100_000];
        Arrays.fill(A, M);
        assertEquals(M, new MinMaxDivision().solution(K, M, A));
    }
}