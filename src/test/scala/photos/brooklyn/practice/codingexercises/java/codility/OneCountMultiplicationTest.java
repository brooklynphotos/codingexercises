package photos.brooklyn.practice.codingexercises.java.codility;

import org.junit.Test;

import static org.junit.Assert.*;

public class OneCountMultiplicationTest {

    @Test
    public void givenSample_returnCorrect() {
        assertEquals(3, new OneCountMultiplication().solution(3, 7));
    }
    @Test
    public void given0_return0() {
        assertEquals(0, new OneCountMultiplication().solution(3, 0));
    }
    @Test
    public void givenLargestBase2_return0() {
        assertEquals(1, new OneCountMultiplication().solution(1<<26, 1<<26));
    }
    @Test
    public void givenLargest_return0() {
        assertEquals(20, new OneCountMultiplication().solution(100_000_000, 100_000_000));
    }
}