package org.crayzer.leetcode.editor.en;

import java.util.Arrays;

public class LeetCode_41_FirstMissingPositive {

    class Solution {
        public int firstMissingPositive(int[] nums) {
            int len = nums.length;
            Arrays.sort(nums);

            for (int i = 1; i <= len; i++) {
                int res = binarySearch(nums, i);
                if (res == -1) {
                    return i;
                }
            }
            return len + 1;
        }

        private int binarySearch(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) >>> 1;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return -1;
        }
    }
}
