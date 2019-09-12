package photos.brooklyn.practice.codingexercises.java.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * For sliding windows discussion
 * https://medium.com/outco/how-to-solve-sliding-window-problems-28d67601a66
 */
public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        return lengthOfLongestSubstring(s, makeBlankArray(), 0, 0);
    }

    private static int[] makeBlankArray(){
        final int[] arr = new int[255];
        Arrays.fill(arr, -1);
        return arr;
    }

    private int lengthOfLongestSubstring(String s, int[] visited, int start, int prevMaxLength) {
        int maxLength = 0;
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            final int visitedIndex = visited[(byte)c];
            if (visitedIndex > -1) {
                return lengthOfLongestSubstring(s, makeBlankArray(), visitedIndex + 1, Math.max(prevMaxLength, maxLength));
            }
            maxLength++;
            visited[(byte)c] = i;
        }
        return Math.max(prevMaxLength, maxLength);
    }
}
