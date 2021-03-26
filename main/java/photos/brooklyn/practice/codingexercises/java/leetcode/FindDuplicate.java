package photos.brooklyn.practice.codingexercises.java.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-the-duplicate-number/
 */
public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        return substitution(nums);
    }

    private static int extraArray(int[] nums) {
        // put numbers in this new map until you find one that is already occupied
        final int[] map = new int[nums.length - 1];
        for (final int n : nums) {
            final int index = n - 1;
            if (map[index] > 0) return n;
            map[index] = n;
        }
        throw new IllegalArgumentException("Array has all unique numbers");
    }

    private static int substitution(int[] nums) {
        int n = nums[0];
        while (n < nums.length) {
            if (n == nums[n]) return n;
            int x = nums[n];
            nums[n] = n;
            n = x;
        }
        throw new IllegalArgumentException("Array has all unique numbers");
    }

    private static int useSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        throw new IllegalArgumentException("Array has all unique numbers");
    }
}
