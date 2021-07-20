package photos.brooklyn.practice.codingexercises.java.hackerrank;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class CountLuckTest {

    @Test
    public void countLuck_eg0() {
        assertEquals("Impressed", CountLuck.countLuck(Arrays.asList(".X.X......X", ".X*.X.XXX.X", ".XX.X.XM...", "......XXXX."), 3));
    }

    @Test
    public void countLuck_eg0b() {
        assertEquals("Oops!", CountLuck.countLuck(Arrays.asList(".X.X......X", ".X*.X.XXX.X", ".XX.X.XM...", "......XXXX."), 4));
    }

    @Test
    public void countLuck_eg1() {
        assertEquals("Impressed", CountLuck.countLuck(Arrays.asList("*.M", ".X."), 1));
    }
}