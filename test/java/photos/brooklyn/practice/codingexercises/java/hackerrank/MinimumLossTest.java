package photos.brooklyn.practice.codingexercises.java.hackerrank;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MinimumLossTest {

    @Test
    public void minimumLoss_eg0() {
        assertEquals(3, MinimumLoss.minimumLoss(Arrays.asList(20L, 15L, 8L, 2L, 12L)));
    }

    @Test
    public void minimumLoss_eg1() {
        assertEquals(2, MinimumLoss.minimumLoss(Arrays.asList(5L, 10L, 3L)));
    }

    @Test
    public void minimumLoss_eg2() {
        assertEquals(2, MinimumLoss.minimumLoss(Arrays.asList(20L, 7L, 8L, 2L, 5L)));
    }
}