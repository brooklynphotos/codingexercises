package photos.brooklyn.practice.codingexercises.java.codility;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinPerimeterRectangleTest {

    @Test
    public void perimPrime() {
        assertEquals(40, new MinPerimeterRectangle().solution(19));
    }

    @Test
    public void perimComposite() {
        assertEquals(22, new MinPerimeterRectangle().solution(30));
    }
}