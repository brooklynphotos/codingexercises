package photos.brooklyn.practice.codingexercises.java.codility;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class FrogRiverRunTest {

    @Test
    public void givenTargetBeingBehindOthers_returnTargetIndex() {
        final int[] A = {1, 3, 1, 4, 2, 3, 5, 4};
        final int X = 5;
        assertEquals(6, new FrogRiverRun().solution(X, A));
    }
    @Test
    public void givenTargetNotBeingBehindOthers_returnMissingsIndex() {
        final int[] A = {1, 3, 1, 5, 2, 3, 4, 5};
        final int X = 5;
        assertEquals(6, new FrogRiverRun().solution(X, A));
    }
    @Test
    public void givenSingleElementArrayAndThatPositionReturn0() {
        final int[] A = {1};
        final int X = 1;
        assertEquals(0, new FrogRiverRun().solution(X, A));
    }
    @Test
    public void givenSingleElementArrayAndFartherPositionReturnNegative() {
        final int[] A = {1};
        final int X = 2;
        assertEquals(-1, new FrogRiverRun().solution(X, A));
    }
    @Test
    public void givenTypicalInputButTooFarReturnNegative() {
        final int[] A = {1, 3, 1, 4, 2, 3, 5, 4};
        final int X = 7;
        assertEquals(-1, new FrogRiverRun().solution(X, A));
    }
    @Test
    public void givenAGap_returnNegative() {
        final int[] A = {1, 3, 1, 3, 2, 3, 5, 1}; // missing a 4
        final int X = 5;
        assertEquals(-1, new FrogRiverRun().solution(X, A));
    }
    @Test
    public void givenBigAAndOnlyOneBigPosition_returnNegative() {
        int[] A = new int[100_000];
        for (int i = 0; i < A.length; i++) {
            A[i] = 100_000;
        }
        final int X = 100_000;
        assertEquals(-1, new FrogRiverRun().solution(X, A));
    }
    @Test
    public void givenBigAAndRandom_returnLastIndex() {
        List<Integer> l = new ArrayList<>(100_000);
        for (int i = 0; i < l.size(); i++) {
            l.add(i + 1);
        }
        Collections.shuffle(l);
        int[] A = new int[l.size()];
        for (int i = 0; i < A.length; i++) {
            A[i] = l.get(i);
        }
        final int X = 100_000;
        assertEquals(A.length - 1, new FrogRiverRun().solution(X, A));
    }
}