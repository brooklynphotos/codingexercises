package photos.brooklyn.practice.codingexercises.java.hackerrank;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class GenaHanoiTest {

    @Test
    public void hanoi() {
        assertEquals(3, GenaHanoi.hanoi(Arrays.asList(1, 4, 1)));
    }
}