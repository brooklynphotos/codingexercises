package photos.brooklyn.practice.codingexercises.java.leetcode;

import org.junit.Test;
//import photos.brooklyn.practice.codingexercises.java.leetcode.solutions.LargeGroupPositions;
import java.util.List;

import static org.junit.Assert.*;

public class LargeGroupPositionsTest {

    private final LargeGroupPositions lgp = new LargeGroupPositions();

    @Test
    public void largeGroupPositionsOneLarge() {
        final String s = "abbxxxxzzy";
        final List<List<Integer>> r= lgp.largeGroupPositions(s);
        assertEquals(r.size(),1);
        assertEquals(r.get(0).get(0).intValue(), 3);
        assertEquals(r.get(0).get(1).intValue(), 6);
    }

    @Test
    public void largeGroupPositionsNoLarge() {
        final String s = "abc";
        final List<List<Integer>> r= lgp.largeGroupPositions(s);
        assertEquals(r.size(),0);
    }

    @Test
    public void largeGroupPositionsThreeLarge() {
        final String s = "abcdddeeeeaabbbcd";
        final List<List<Integer>> r= lgp.largeGroupPositions(s);
        assertEquals(r.size(),3);
    }
}