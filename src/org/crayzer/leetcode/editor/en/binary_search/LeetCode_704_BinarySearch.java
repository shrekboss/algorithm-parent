package org.crayzer.leetcode.editor.en.binary_search;

public class LeetCode_704_BinarySearch {

    class Solution {
        public int search(int[] nums, int target) {
            if (nums == null) return -1;

            int left = 0, right = nums.length - 1;
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (nums[mid] < target) left = mid + 1;
                else right = mid;
            }

            return nums[left] == target ? left : -1;
        }
    }
}
