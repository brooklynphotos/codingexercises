package photos.brooklyn.practice.codingexercises.java.hackerrank;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MarkAndToysTest {

    @Test
    public void maximumToys_example1() {
        assertEquals(4, MarkAndToys.maximumToys(Arrays.asList(1, 12, 5, 111, 200, 1000, 10), 50));
    }

    @Test
    public void maximumToys_example2() {
        assertEquals(3, MarkAndToys.maximumToys(Arrays.asList(1, 2, 3, 4), 7));
    }
}