package photos.brooklyn.practice.codingexercises.java.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-the-duplicate-number/
 */
public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        throw new IllegalArgumentException("Array has all unique numbers");
    }
}
