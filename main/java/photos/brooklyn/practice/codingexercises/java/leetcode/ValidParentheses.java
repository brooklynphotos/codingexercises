package photos.brooklyn.practice.codingexercises.java.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://www.baeldung.com/java-balanced-brackets-algorithm
 */
public class ValidParentheses {
    private static final String LEFT = "{[(";
    private static final String RIGHT = "}])";
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            int leftPIndex = LEFT.indexOf(c);
            if (leftPIndex > -1) {
                stack.addFirst(c);
            } else {
                // we have a right parenthesis, so what is the expected one?
                Character stackTop = stack.peekFirst();
                if (stackTop != null && RIGHT.charAt(LEFT.indexOf(stackTop)) == c) {
                    stack.removeFirst();
                } else {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }
}
