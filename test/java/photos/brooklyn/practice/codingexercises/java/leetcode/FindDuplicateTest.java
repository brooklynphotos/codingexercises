package photos.brooklyn.practice.codingexercises.java.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindDuplicateTest {

    @Test
    public void findDuplicateExample1() {
        final int[] input = {1, 3, 4, 2, 2};
        assertEquals(2, new FindDuplicate().findDuplicate(input));
    }

    @Test
    public void findDuplicateExample2() {
        final int[] input = {3, 1, 3, 4, 2};
        assertEquals(3, new FindDuplicate().findDuplicate(input));
    }

    @Test
    public void findDuplicateExample3() {
        final int[] input = {1, 1};
        assertEquals(1, new FindDuplicate().findDuplicate(input));
    }

    @Test
    public void findDuplicateExample4() {
        final int[] input = {1, 1, 2};
        assertEquals(1, new FindDuplicate().findDuplicate(input));
    }
}