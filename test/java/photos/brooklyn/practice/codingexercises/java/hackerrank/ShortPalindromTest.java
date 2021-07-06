package photos.brooklyn.practice.codingexercises.java.hackerrank;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShortPalindromTest {

    @Test
    public void shortPalindrome_eg1() {
        assertEquals(15, ShortPalindrom.shortPalindrome("kkkkkkz"));
    }

    @Test
    public void shortPalindrome_eg2() {
        assertEquals(4, ShortPalindrom.shortPalindrome("ghhggh"));
    }

    @Test
    public void shortPalindrome_eg3() {
        assertEquals(4, ShortPalindrom.shortPalindrome("abbaab"));
    }

    @Test
    public void shortPalindrome_eg4() {
        assertEquals(2, ShortPalindrom.shortPalindrome("akakak"));
    }

}