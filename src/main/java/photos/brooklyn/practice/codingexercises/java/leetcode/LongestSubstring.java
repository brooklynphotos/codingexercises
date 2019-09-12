package photos.brooklyn.practice.codingexercises.java.leetcode;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        return lengthOfLongestSubstring(s, makeBlankArray(), 0, 0);
    }

    private static int[] makeBlankArray(){
        final int[] arr = new int[255];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }
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
