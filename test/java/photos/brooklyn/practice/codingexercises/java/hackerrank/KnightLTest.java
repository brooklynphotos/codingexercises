package photos.brooklyn.practice.codingexercises.java.hackerrank;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class KnightLTest {

    @Test
    public void knightlOnAChessboard_eg0() {
        final List<List<Integer>> res = Arrays.asList(
                Arrays.asList(4, 4, 2, 8),
                Arrays.asList(4, 2, 4, 4),
                Arrays.asList(2, 4, -1, -1),
                Arrays.asList(8, 4, -1, 1)
        );
        assertEquals(res, KnightL.knightlOnAChessboard(5));

    }

    @Ignore
    public void knightlOnAChessboard_large() {
        final List<List<Integer>> res = Arrays.asList(
                Arrays.asList(4, 4, 2, 8),
                Arrays.asList(4, 2, 4, 4),
                Arrays.asList(2, 4, -1, -1),
                Arrays.asList(8, 4, -1, 1)
        );
        assertEquals(res, KnightL.knightlOnAChessboard(25));

    }
}