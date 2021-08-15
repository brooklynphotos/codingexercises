package photos.brooklyn.practice.codingexercises.java.hackerrank;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class QueensAttack2Test {

    @Test
    public void queensAttack_noObst() {
        assertEquals(27, QueensAttack2.queensAttack(8, 0, 4, 4, Collections.emptyList()));
    }

    @Test
    public void queensAttack_noObst2() {
        assertEquals(9, QueensAttack2.queensAttack(4, 0, 4, 4, Collections.emptyList()));
    }

    @Test
    public void queensAttack_eg1() {
        final List<List<Integer>> obs = Arrays.asList(Arrays.asList(5, 5), Arrays.asList(4, 2), Arrays.asList(2, 3));
        assertEquals(10, QueensAttack2.queensAttack(5, 3, 4, 3, obs));
    }

    @Test
    public void queensAttack_eg2() {
        assertEquals(0, QueensAttack2.queensAttack(1, 0, 1, 1, Collections.emptyList()));
    }

    @Test
    public void queensAttack_obsClose() {
        final List<List<Integer>> obs = Arrays.asList(
                Arrays.asList(4, 3),
                Arrays.asList(4, 4),
                Arrays.asList(3, 4),
                Arrays.asList(2, 4),
                Arrays.asList(2, 3),
                Arrays.asList(2, 2),
                Arrays.asList(3, 2),
                Arrays.asList(4, 2)
        );
        assertEquals(0, QueensAttack2.queensAttack(5, obs.size(), 3, 3, obs));
    }

    @Test
    public void queensAttack_obsClose_outer() {
        final List<List<Integer>> obs = new ArrayList<>();
        for (int r = 1; r <= 5; r++) {
            for (int c = 1; c <= 5; c++) {
                if (r == 1 || r == 5) {
                    obs.add(Arrays.asList(r, c));
                } else if(c==1 || c==5) {
                    obs.add(Arrays.asList(r, c));
                }
            }
        }
        assertEquals(8, QueensAttack2.queensAttack(5, obs.size(), 3, 3, obs));
    }
}