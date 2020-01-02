package photos.brooklyn.practice.codingexercises.java.codility;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class MaxCountersTest {

    @Test
    public void givenRegularInput_expectCorrectOutput() {
        final int N = 5;
        final int[] A = {3, 4, 4, 6, 1, 4, 4};
        assertEquals("3, 2, 2, 4, 2", makeString(new MaxCounters().solution(N, A), ", "));
    }
    @Test
    public void givenMinNAndAIs1_expectSimpleIncrement() {
        final int N = 1;
        final int[] A = {1};
        assertEquals("1", makeString(new MaxCounters().solution(N, A), ", "));
    }
    @Test
    public void givenMinNAndAIs2_expect0() {
        final int N = 1;
        final int[] A = {2};
        assertEquals("0", makeString(new MaxCounters().solution(N, A), ", "));
    }
    @Test
    public void givenMaxNAndM_expectNotSlow() {
        final int N = 100_000;
        final int[] A = makeRandom(100_000, 100_000);
        assertEquals(100_000, new MaxCounters().solution(N, A).length);
    }

    static final String makeString(int[] arr, String delimiter) {
        return Arrays.stream(arr).boxed().map(i->Integer.toString(i)).collect(Collectors.joining(delimiter));
    }

    static final int[] makeRandom(int size, int bound) {
        final int[] res = new int[size];
        for (int i = 0; i < res.length; i++) {
            res[i] = new Random().nextInt(bound) + 1;
        }
        return res;
    }
}