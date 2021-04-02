package photos.brooklyn.practice.codingexercises.java.codility;

import org.junit.Test;

import static org.junit.Assert.*;

public class MushroomPickerTest {

    @Test
    public void maxCollectionExample() {
        final int[] A = {2, 3, 7, 5, 1, 3, 9};
        final int k = 4;
        final int m = 6;
        assertEquals(25, MushroomPicker.maxCollection(A, k, m));
    }
}