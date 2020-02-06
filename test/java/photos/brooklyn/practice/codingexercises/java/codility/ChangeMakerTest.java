package photos.brooklyn.practice.codingexercises.java.codility;

import org.junit.Test;

import static org.junit.Assert.*;

public class ChangeMakerTest {

    @Test
    public void getChange_example1() {
        assertArrayEquals(new int[]{1, 0, 0, 0, 0, 4}, new ChangeMaker().getChange(5, 0.99));
        assertArrayEquals(new int[]{0, 1, 1, 0, 0, 1}, new ChangeMaker().getChange(3.14, 1.99));
        assertArrayEquals(new int[]{1, 0, 1, 1, 1, 0}, new ChangeMaker().getChange(4, 3.14));
        assertArrayEquals(new int[]{1, 0, 1, 0, 0, 0}, new ChangeMaker().getChange(0.45, 0.34));
    }
}