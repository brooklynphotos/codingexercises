package photos.brooklyn.practice.codingexercises.java.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestSubstringTest {

    @Test
    public void lengthOfLongestSubstring() {
        assertEquals(1, new LongestSubstring().lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, new LongestSubstring().lengthOfLongestSubstring("dvdf"));
        assertEquals(1, new LongestSubstring().lengthOfLongestSubstring(" "));
        assertEquals(3, new LongestSubstring().lengthOfLongestSubstring("abcabcbb"));
        assertEquals(3, new LongestSubstring().lengthOfLongestSubstring("pwwkew"));
    }
}