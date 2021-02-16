package photos.brooklyn.practice.codingexercises.java.leetcode.solutions;

/**
 * Problem: https://leetcode.com/problems/trapping-rain-water/
 * Solution: https://leetcode.com/problems/trapping-rain-water/discuss/1064970/Java-Solution-Explanation-%2B-Code
 */
public class RainWater {
    public int trap(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int water = 0;
        int maxLeft = 0;
        int maxRight = 0;
        while (i < j) {
            int left = height[i];
            int right = height[j];
            if (left < right) {
                if (maxLeft < left) { // found something taller
                    maxLeft = left; // new max left
                } else {
                    // we can collect water here since we are lower than the left max
                    water += maxLeft - left;
                }
                i++;
            } else { // right has the same height or greater than the left
                if (maxRight < right) {
                    maxRight = right;
                } else {
                    water += maxRight - right;
                }
                j--;
            }
        }
        return water;
    }

}
