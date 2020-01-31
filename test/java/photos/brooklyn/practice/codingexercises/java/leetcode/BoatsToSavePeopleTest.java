package photos.brooklyn.practice.codingexercises.java.leetcode;

import org.junit.Test;

import photos.brooklyn.practice.codingexercises.java.leetcode.solutions.BoatsToSavePeople;

import static org.junit.Assert.*;

public class BoatsToSavePeopleTest {
    private BoatsToSavePeople obj = new BoatsToSavePeople();
//    private BoatsToSavePeople obj = new BoatsToSavePeople();

    @Test
    public void numRescueBoats_small() {
        final int[] people = {1,2};
        final int limit = 3;
        assertEquals(1, obj.numRescueBoats(people, limit));
    }

    @Test
    public void numRescueBoats_small3_3() {
        final int[] people = {3,2,2,1};
        final int limit = 3;
        assertEquals(3, obj.numRescueBoats(people, limit));
    }

    @Test
    public void numRescueBoats_small4() {
        final int[] people = {3,5,3,4};
        final int limit = 5;
        assertEquals(4, obj.numRescueBoats(people, limit));
    }

    @Test
    public void numRescueBoats_small3_6() {
        final int[] people = {3,2,3,2,2};
        final int limit = 6;
        assertEquals(3, obj.numRescueBoats(people, limit));
    }

    @Test
    public void numRescueBoats_small7_4() {
        final int[] people = {5,1,7,4,2,4};
        final int limit = 7;
        assertEquals(4, obj.numRescueBoats(people, limit));
    }

    @Test
    public void numRescueBoats_larger1000_5() {
        final int[] people = {445,597,385,576,291,190,187,613,657,477};
        final int limit = 1000;
        assertEquals(5, obj.numRescueBoats(people, limit));
    }
}