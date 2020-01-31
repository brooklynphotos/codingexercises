package photos.brooklyn.practice.codingexercises.java.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindReplaceStringTest {

    @Test
    public void findReplaceStringSuccess2() {
        final String S = "abcd";
        final int[] indexes = {0,2};
        final String[] sources = {"a","cd"};
        final String[] targets = {"eee","ffff"};
        final String changed = new FindReplaceString().findReplaceString(S, indexes, sources, targets);
        assertEquals("eeebffff", changed);
    }

    @Test
    public void findReplaceStringWithNothing() {
        final String S = "abcd";
        final int[] indexes = {};
        final String[] sources = {};
        final String[] targets = {};
        final String changed = new FindReplaceString().findReplaceString(S, indexes, sources, targets);
        assertEquals("abcd", changed);
    }

    @Test
    public void findReplaceStringWithNoSuccess() {
        final String S = "abcd";
        final int[] indexes = {1,2};
        final String[] sources = {"x","y"};
        final String[] targets = {"m","n"};
        final String changed = new FindReplaceString().findReplaceString(S, indexes, sources, targets);
        assertEquals("abcd", changed);
    }

    @Test
    public void findReplaceStringSuccess1() {
        final String S = "abcd";
        final int[] indexes = {0,2};
        final String[] sources = {"ab","ec"};
        final String[] targets = {"eee","ffff"};
        final String changed = new FindReplaceString().findReplaceString(S, indexes, sources, targets);
        assertEquals("eeecd", changed);
    }
}