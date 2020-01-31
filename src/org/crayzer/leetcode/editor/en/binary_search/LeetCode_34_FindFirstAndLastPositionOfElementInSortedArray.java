package org.crayzer.leetcode.editor.en.binary_search;

public class LeetCode_34_FindFirstAndLastPositionOfElementInSortedArray {

    class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums == null || nums.length == 0) return new int[]{-1, -1};
            int len = nums.length;
            int fistPosition = findFirstPosition(nums, target, len);
            if (fistPosition == -1) return new int[]{-1, -1};
            int lastPostiton = findLastPosition(nums, target, len);

            return new int[]{fistPosition, lastPostiton};
        }

        private int findFirstPosition(int[] nums, int target, int len) {
            int left = 0, right = len - 1;
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    // [left, mid]
                    right = mid;
                }
            }
            if (nums[left] == target) {
                return left;
            }
            return -1;
        }

        private int findLastPosition(int[] nums, int target, int len) {
            int left = 0, right = len - 1;
            while (left < right) {
                int mid = (left + right + 1) >>> 1;
                if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    // [mid, right]
                    left = mid;
                }
            }
            return left;
        }
    }
}
