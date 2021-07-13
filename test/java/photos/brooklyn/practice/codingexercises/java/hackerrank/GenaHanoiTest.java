package photos.brooklyn.practice.codingexercises.java.hackerrank;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class GenaHanoiTest {

    @Test
    public void hanoi() {
        assertEquals(3, GenaHanoi.hanoi(Arrays.asList(1, 4, 1)));
    }

    @Test
    public void hanoi_1mv() {
        assertEquals(1, GenaHanoi.hanoi(Arrays.asList(2, 1, 1)));
    }
}