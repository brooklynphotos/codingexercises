package photos.brooklyn.practice.codingexercises.java.leetcode.solutions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrimePalindromTest {

    @Test
    public void primePalindromeEven() {
        assertEquals(new PrimePalindrom().primePalindrome(13),101);
    }

    @Test
    public void primePalindromeTest1() {
        assertEquals(new PrimePalindrom().primePalindrome(9989900),100030001);
    }
}