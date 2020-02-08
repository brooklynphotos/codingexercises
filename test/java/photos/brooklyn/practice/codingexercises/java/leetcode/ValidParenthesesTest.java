package photos.brooklyn.practice.codingexercises.java.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidParenthesesTest {

    @Test
    public void isValid() {
        assertTrue(new ValidParentheses().isValid("[()]"));
        assertTrue(new ValidParentheses().isValid("[(){}]"));
        assertFalse(new ValidParentheses().isValid("[(){}[)]"));
    }
}