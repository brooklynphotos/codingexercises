package photos.brooklyn.practice.codingexercises.java.hackerrank;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LargestPermutationTest {

    @Test
    public void largestPermutation_eg1() {
        final List<Integer> arr = Arrays.asList(4, 2, 3, 5, 1);
        final List<Integer> expected = Arrays.asList(5, 2, 3, 4, 1);
        assertEquals(expected, LargestPermutation.largestPermutation(1, arr));
    }

    @Test
    public void largestPermutation_eg2() {
        final List<Integer> arr = Arrays.asList(2, 1, 3);
        final List<Integer> expected = Arrays.asList(3, 1, 2);
        assertEquals(expected, LargestPermutation.largestPermutation(1, arr));
    }

    @Test
    public void largestPermutation_eg3() {
        final List<Integer> arr = Arrays.asList(2, 1);
        final List<Integer> expected = Arrays.asList(2, 1);
        assertEquals(expected, LargestPermutation.largestPermutation(1, arr));
    }

    @Test
    public void largestPermutation_eg4() {
        final List<Integer> arr = Arrays.asList(4, 3, 2, 5, 1);
        final List<Integer> expected = Arrays.asList(5, 4, 2, 3, 1);
        assertEquals(expected, LargestPermutation.largestPermutation(2, arr));
    }

    @Test
    public void largestPermutation_eg5() {
        final List<Integer> arr = Arrays.asList(3, 4, 2, 5, 1);
        final List<Integer> expected = Arrays.asList(5, 4, 3, 2, 1);
        assertEquals(expected, LargestPermutation.largestPermutation(2, arr));
    }

    @Test
    public void largestPermutation_single() {
        final List<Integer> arr = Arrays.asList(1);
        final List<Integer> expected = Arrays.asList(1);
        assertEquals(expected, LargestPermutation.largestPermutation(1, arr));
    }

    @Test
    public void largestPermutation_enough() {
        final List<Integer> arr = Arrays.asList(1, 2, 3, 4);
        final List<Integer> expected = Arrays.asList(4, 3, 2, 1);
        assertEquals(expected, LargestPermutation.largestPermutation(2, arr));
    }

    @Test
    public void largestPermutation_odd() {
        final List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
        final List<Integer> expected = Arrays.asList(5, 4, 3, 2, 1);
        assertEquals(expected, LargestPermutation.largestPermutation(2, arr));
    }

    @Test
    public void largestPermutation_unordered() {
        final List<Integer> arr = Arrays.asList(1, 3, 2, 4, 5);
        final List<Integer> expected = Arrays.asList(5, 4, 2, 3, 1);
        assertEquals(expected, LargestPermutation.largestPermutation(2, arr));
    }

    @Test
    public void largestPermutation_jump() {
        final List<Integer> arr = Arrays.asList(4, 3, 5, 2, 1);
        final List<Integer> expected = Arrays.asList(5, 4, 3, 2, 1);
        assertEquals(expected, LargestPermutation.largestPermutation(2, arr));
    }

    @Test
    public void largestPermutation_bigK() {
        final List<Integer> arr = Arrays.asList(1, 2, 3, 4);
        final List<Integer> expected = Arrays.asList(4, 3, 2, 1);
        assertEquals(expected, LargestPermutation.largestPermutation(20, arr));
    }
}