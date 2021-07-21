package photos.brooklyn.practice.codingexercises.java.hackerrank;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ConnectedCellsInGridTest {

    @Test
    public void connectedCell_eg1() {
        assertEquals(5, ConnectedCellsInGrid.connectedCell(Arrays.asList(
                Arrays.asList(1, 1, 0, 0),
                Arrays.asList(0, 1, 1, 0),
                Arrays.asList(0, 0, 1, 0),
                Arrays.asList(1, 0, 0, 0)
        )));
    }
}