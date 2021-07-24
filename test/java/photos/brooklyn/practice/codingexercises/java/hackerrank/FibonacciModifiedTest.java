package photos.brooklyn.practice.codingexercises.java.hackerrank;

import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciModifiedTest {

    @Test
    public void fibonacciModified_eg0() {
        assertEquals(5, FibonacciModified.fibonacciModified(0, 1, 5));
    }

    @Test
    public void fibonacciModified_6() {
        assertEquals(27, FibonacciModified.fibonacciModified(0, 1, 6));
    }
}