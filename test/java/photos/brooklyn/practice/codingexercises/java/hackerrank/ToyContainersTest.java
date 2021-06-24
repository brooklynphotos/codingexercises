package photos.brooklyn.practice.codingexercises.java.hackerrank;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class ToyContainersTest {

    @Test
    public void toys_eg1() {
        assertEquals(2, ToyContainers.toys(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
    }

    @Test
    public void toys_eg2() {
        assertEquals(4, ToyContainers.toys(Arrays.asList(1, 2, 3, 21, 7, 12, 14, 21)));
    }

    @Test
    public void toys_single() {
        assertEquals(1, ToyContainers.toys(Collections.singletonList(10)));
    }
}