package photos.brooklyn.practice.codingexercises.java.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class KokoEatsBananasTest {
    private KokoEatsBananas koko = new KokoEatsBananas();

    @Test
    public void minEatingSpeed_short_1() {
        int[] piles = {3,6,7,11};
        int H = 8;
        assertEquals(4, koko.minEatingSpeed(piles, H));
    }

    @Test
    public void minEatingSpeed_short_2() {
        int[] piles = {30,11,23,4,20};
        int H = 5;
        assertEquals(30, koko.minEatingSpeed(piles, H));
    }

    @Test
    public void minEatingSpeed_short_3() {
        int[] piles = {30,11,23,4,20};
        int H = 6;
        assertEquals(23, koko.minEatingSpeed(piles, H));
    }

    @Test
    public void minEatingSpeed_big_1() {
        int[] piles = {332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673, 679580077, 337406589, 290818316, 877337160, 901728858, 679284947, 688210097, 692137887, 718203285, 629455728, 941802184};
        int H = 823855818;
        assertEquals(14, koko.minEatingSpeed(piles, H));
    }
}