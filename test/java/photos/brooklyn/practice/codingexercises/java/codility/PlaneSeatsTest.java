package photos.brooklyn.practice.codingexercises.java.codility;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlaneSeatsTest {

    @Test
    public void solution_2rows() {
        final int N = 2;
        final String S = "1A 2F 1C";
        assertEquals(2, new PlaneSeats().solution(N, S));
    }

    @Test
    public void solution_emptyrow() {
        final int N = 1;
        final String S = "";
        assertEquals(2, new PlaneSeats().solution(N, S));
    }

    @Test
    public void solution_full() {
        final int N = 1;
        final String S = "1A 1B 1C 1D 1E 1F 1G 1H 1J 1K";
        assertEquals(0, new PlaneSeats().solution(N, S));
    }

    @Test
    public void solution_aisles() {
        final int N = 1;
        final String S = "1C 1D 1G 1H";
        assertEquals(0, new PlaneSeats().solution(N, S));
    }
}