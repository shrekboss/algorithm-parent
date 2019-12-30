package org.crayzer.leetcode.editor.en.二分查找;

public class LeetCode_154_FindMinimumInRotatedSortedArray2 {
    class Solution {
        public int findMin(int[] nums) {
            int len = nums.length;
            if (len == 0) return 0;
            int left = 0, right = len - 1;
            while (left < right) {
                int mid = (left + right) >>> 1;

                if (nums[mid] > nums[right]) left = mid + 1;
                else if (nums[mid] < nums[right]) right = mid;
                else {
                    assert nums[mid] == nums[right];
                    right--;
                }
            }
            return nums[left];
        }
    }
}
