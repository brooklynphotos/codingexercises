package photos.brooklyn.practice.codingexercises.java.leetcode;

import org.junit.Test;
import photos.brooklyn.practice.codingexercises.java.leetcode.utils.FileUtils;

import java.io.IOException;

import static org.junit.Assert.*;

public class StoneGameTest {
    private final StoneGame obj = new StoneGame();

    @Test
    public void stoneGame_short() {
        final int[] setup = {5, 3, 4, 5};
        assertTrue(obj.stoneGame(setup));
    }

    @Test
    public void stoneGame_short2() {
        final int[] setup = {3,7,2,3};
        assertTrue(obj.stoneGame(setup));
    }

    @Test
    public void stoneGame_long() {
        final int[] setup = readFile("long1");
        assertTrue(obj.stoneGame(setup));
    }

    private static int[] readFile(final String id) {
        try {
            return FileUtils.loadData("stone_game").get(id);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read stonegame props", e);
        }
    }
}