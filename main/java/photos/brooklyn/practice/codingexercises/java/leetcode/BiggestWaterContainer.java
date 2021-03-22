package photos.brooklyn.practice.codingexercises.java.leetcode;

/**
 * https://leetcode.com/problems/container-with-most-water/
 */
public class BiggestWaterContainer {
    /**
     * |height| between 2 and 10^5
     * @param height each number between 0 and 10^4
     * @return
     */
    public int maxArea(int[] height) {
        /*
         * start with first and last numbers, two pointers
         * find the area
         * take the smaller, or the smaller index if the same heights, and increment index
         * if new height is greater, find the area; new answer is the bigger of the area or the previous answer
         * if the new height is greater than the second pointer, repeat the steps using the second pointer, else repeat step
         * stop when two pointers are the same
         */
        int area = 0;
        int left = 0;
        int right = height.length - 1;
        int[] prevMaxHeights = {0, 0};
        while (left < right) {
            final int leftHeight = height[left];
            final int rightHeight = height[right];
            // find current area if the heights are more
            if (leftHeight >= prevMaxHeights[0] && rightHeight >= prevMaxHeights[1]) {
                int newArea = (right - left) * Math.min(leftHeight, rightHeight);
                area = Math.max(newArea, area);
                prevMaxHeights[0] = leftHeight;
                prevMaxHeights[1] = rightHeight;
            }
            // decide which pointer to move
            if (leftHeight > rightHeight) {
                right--;
            } else {
                left++;
            }
        }
        return area;
    }
}
