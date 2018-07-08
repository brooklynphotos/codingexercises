package photos.brooklyn.practice.codingexercises.java.leetcode;

import org.junit.Test;

import static photos.brooklyn.practice.codingexercises.java.leetcode.PrimePalindrom.*;

import static org.junit.Assert.*;

public class PrimePalindromTest {

    @Test
    public void primePalindromeOdd() {
        assertEquals(new PrimePalindrom().primePalindrome(8),11);
    }

    @Test
    public void primePalindromeEven() {
        assertEquals(new PrimePalindrom().primePalindrome(13),101);
    }

    @Test
    public void primePalindromeTest1() {
        assertEquals(new PrimePalindrom().primePalindrome(9989900),100030001);
    }

    @Test
    public void closestPalindromEvenAlready() {
        assertEquals(closestPalindrom(1221), 1221);
    }

    @Test
    public void closestPalindromEvenSmallBig() {
        assertEquals(closestPalindrom(1231), 1331);
    }

    @Test
    public void closestPalindromEvenBigSmall() {
        assertEquals(closestPalindrom(1431), 1441);
    }

    @Test
    public void isPalindromEven() {
        assertTrue(isPalindrom(1221));
    }

    @Test
    public void isPalindromOdd() {
        assertTrue(isPalindrom(12321));
    }

    @Test
    public void isNotPalindromOdd() {
        assertFalse(isPalindrom(12331));
    }

    @Test
    public void isNotPalindromEven() {
        assertFalse(isPalindrom(2345));
    }

    @Test
    public void nextPalindromEven() {
        assertEquals(nextPalindrom(1221), 1331);
    }

    @Test
    public void nextPalindromOdd() {
        assertEquals(nextPalindrom(12521), 12621);
    }

    @Test
    public void reverseEven() {
        assertEquals(reverse("abcd"), "dcba");
    }
    @Test
    public void reverseOdd() {
        assertEquals(reverse("abc"), "cba");
    }
}