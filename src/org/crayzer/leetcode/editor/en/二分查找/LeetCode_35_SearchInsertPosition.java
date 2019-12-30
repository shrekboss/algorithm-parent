package org.crayzer.leetcode.editor.en.二分查找;

public class LeetCode_35_SearchInsertPosition {
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int length = nums.length;
            if (nums[length - 1] < target) return length;

            int left = 0, right = length - 1;
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (nums[mid] < target) left = mid + 1;
                else right = mid;
            }
            return left;
        }
    }
}
