package org.crayzer.leetcode.editor.en.binary_search;

public class LeetCode_35_SearchInsertPosition {
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int len = nums.length;
            // if (nums[len - 1] < target) return len;
            int left = 0;
            // int right = len - 1;
            int right = len;

            while (left < right) {
                int mid = (left + right) >> 1;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }
    }
}
