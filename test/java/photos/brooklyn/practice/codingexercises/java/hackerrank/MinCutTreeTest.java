package photos.brooklyn.practice.codingexercises.java.hackerrank;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MinCutTreeTest {

    @Test
    public void cutTheTree_eg1() {
        final List<Integer> data = Arrays.asList(1, 2, 3, 4, 5, 6);
        final List<List<Integer>> edges = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(1, 3),
                Arrays.asList(2, 6),
                Arrays.asList(3, 4),
                Arrays.asList(3, 5)
        );
        assertEquals(3, MinCutTree.cutTheTree(data, edges));
    }
}