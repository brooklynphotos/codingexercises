package photos.brooklyn.practice.codingexercises.java.codility;

import org.junit.Test;

import static org.junit.Assert.*;

public class BeautifulGardenTest {

    @Test
    public void solution1() {
        final int[] A = {5, 4, 3, 2, 6};
        assertEquals(1, new BeautifulGarden().solution(A));
    }

    @Test
    public void solution2() {
        final int[] A = {3, 7, 4, 5};
        assertEquals(0, new BeautifulGarden().solution(A));
    }

    @Test
    public void single() {
        final int[] A = {3};
        assertEquals(0, new BeautifulGarden().solution(A));
    }

    @Test(timeout = 3)
    public void largest() {
        final int[] A = new int[100_000];
        for (int i = 0; i < A.length; i++) {
            A[i] = 3 + (i % 2 == 0 ? 1 : -1);
        }
        assertEquals(0, new BeautifulGarden().solution(A));
    }
}