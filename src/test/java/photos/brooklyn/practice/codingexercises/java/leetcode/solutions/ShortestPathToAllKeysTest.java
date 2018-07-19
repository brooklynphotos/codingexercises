package photos.brooklyn.practice.codingexercises.java.leetcode.solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShortestPathToAllKeysTest {
    private ShortestPathToAllKeys obj = new ShortestPathToAllKeys();

    @Test
    public void shortestPathAllKeys_1() {
        assertEquals(8, obj.shortestPathAllKeys(new String[]{"@.a.#","###.#","b.A.B"}));
    }

    @Test
    public void shortestPathAllKeys_2() {
        assertEquals(6, obj.shortestPathAllKeys(new String[]{"@..aA","..B#.","....b"}));
    }

    @Test
    public void shortestPathAllKeys_3() {
        assertEquals(7, obj.shortestPathAllKeys(new String[]{"@..a","##.#",".bA."}));
    }
}