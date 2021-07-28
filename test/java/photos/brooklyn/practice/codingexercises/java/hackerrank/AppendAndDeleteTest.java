package photos.brooklyn.practice.codingexercises.java.hackerrank;

import org.junit.Test;

import static org.junit.Assert.*;

public class AppendAndDeleteTest {

    @Test
    public void appendAndDelete_eg0() {
        assertEquals("Yes", AppendAndDelete.appendAndDelete("abc", "def", 6));
    }

    @Test
    public void appendAndDelete_eg0a() {
        assertEquals("Yes", AppendAndDelete.appendAndDelete("abc", "def", 7));
    }

    @Test
    public void appendAndDelete_eg1() {
        assertEquals("Yes", AppendAndDelete.appendAndDelete("hackerhappy", "hackerrank", 9));
    }

    @Test
    public void appendAndDelete_eg2() {
        assertEquals("Yes", AppendAndDelete.appendAndDelete("aba", "aba", 7));
    }

    @Test
    public void appendAndDelete_eg3() {
        assertEquals("No", AppendAndDelete.appendAndDelete("ashley", "ash", 2));
    }

    @Test
    public void appendAndDelete_yes_odd() {
        assertEquals("Yes", AppendAndDelete.appendAndDelete("abcd", "abc", 3));
    }

    @Test
    public void appendAndDelete_no_even() {
        assertEquals("No", AppendAndDelete.appendAndDelete("abcd", "abc", 2));
    }

    @Test
    public void appendAndDelete_yes_even() {
        assertEquals("Yes", AppendAndDelete.appendAndDelete("abcde", "abc", 4));
    }

    @Test
    public void appendAndDelete_no_odd() {
        assertEquals("No", AppendAndDelete.appendAndDelete("abcde", "abc", 3));
    }
}