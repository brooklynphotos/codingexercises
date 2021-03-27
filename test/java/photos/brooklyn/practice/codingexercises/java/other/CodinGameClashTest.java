package photos.brooklyn.practice.codingexercises.java.other;

import org.junit.Test;

import static org.junit.Assert.*;

import static photos.brooklyn.practice.codingexercises.java.other.CodinGameClash.*;

public class CodinGameClashTest {

    @Test
    public void scrambleHalfHalfEmpty() {
        assertEquals("", scrambleHalfHalf(""));
    }

    @Test
    public void scrambleHalfHalfOne() {
        assertEquals("x", scrambleHalfHalf("x"));
    }

    @Test
    public void scrambleHalfHalf1() {
        assertEquals("Hleol", scrambleHalfHalf("Hello"));
    }

    @Test
    public void scrambleHalfHalf2() {
        assertEquals("Hleol!", scrambleHalfHalf("Hello!"));
    }

    @Test
    public void getNonMultipleEx1() {
        assertEquals(13, getNonMultiple(new int[]{2, 3}, 1, 5));
    }
}