package photos.brooklyn.practice.codingexercises.java.hackerrank;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayLeftRotationTest {

    @Test
    public void rotLeft() {
        assertArrayEquals(new int[]{5,1,2,3,4}, ArrayLeftRotation.rotLeft(new int[]{1,2,3,4,5}, 4));
    }
}