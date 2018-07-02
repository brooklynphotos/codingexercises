package photos.brooklyn.practice.codingexercises.java.leetcode.solutions;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ScoreOfParenthesesTest {

    @Test
    public void scoreOfParenthesesSimplest() {
        assertThat(new ScoreOfParentheses().scoreOfParentheses("()"), is(1));
    }
    @Test
    public void scoreOfParenthesesEnclosed() {
        assertThat(new ScoreOfParentheses().scoreOfParentheses("(())"), is(2));
    }

    @Test
    public void scoreOfParenthesesDouble() {
        assertThat(new ScoreOfParentheses().scoreOfParentheses("()()"), is(2));
    }

    @Test
    public void scoreOfParenthesesComplex1() {
        assertThat(new ScoreOfParentheses().scoreOfParentheses("(()(()))"), is(6));
    }

    @Test
    public void scoreOfParenthesesComplex2() {
        assertThat(new ScoreOfParentheses().scoreOfParentheses("(()())()"), is(5));
    }
}