package photos.brooklyn.practice.codingexercises.java.codility;

import org.junit.Test;

import static org.junit.Assert.*;

public class BiggestNumberInGridTest {

    @Test
    public void solution() {
        int[][] Board = {
                {9, 1, 1, 0, 7},
                {1, 0, 2, 1, 0},
                {1, 9, 1, 1, 9}
        };
        assertEquals(9121, new BiggestNumberInGrid().solution(Board));
    }
}