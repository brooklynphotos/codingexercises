package photos.brooklyn.practice.codingexercises.java.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class BuddyStringsTest {

    @Test
    public void buddyStringsReversed() {
        assertTrue(new BuddyStrings().buddyStrings("ab", "ba"));
    }
    @Test
    public void buddyStringsSame() {
        assertFalse(new BuddyStrings().buddyStrings("ab", "ab"));
    }
    @Test
    public void buddyStringsSameRepeat() {
        assertTrue(new BuddyStrings().buddyStrings("aa", "aa"));
    }
    @Test
    public void buddyStringsDiffEnd() {
        assertTrue(new BuddyStrings().buddyStrings("aaaaaaabc", "aaaaaaacb"));
    }
    @Test
    public void buddyStringsDiffLength() {
        assertFalse(new BuddyStrings().buddyStrings("", "aa"));
    }
}