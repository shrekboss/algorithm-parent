package org.crayzer.leetcode.editor.en.binary_search;

public class LeetCode_81_SearchInRotatedSortedArray2 {
    class Solution {
        public boolean search(int[] nums, int target) {
            int len = nums.length;
            if (len == 0) return false;

            int left = 0, right = len - 1;
            while (left < right) {
                int mid = (left + right + 1) >>> 1;
                if(nums[mid] < nums[right]) {
                    if (nums[mid] <= target && target <= nums[right]) left = mid;
                    else right = mid - 1;
                } else if (nums[mid] > nums[right]) {
                    if (nums[left] <= target && target <= nums[mid - 1]) right = mid - 1;
                    else left = mid;
                } else {
                    // 要排除掉左边界之前，先看一看左边界可以不可以排除
                    // if (nums[left] == target) {
                    //     return true;
                    // } else {
                    //     left = left + 1;
                    // }

                    // 要排除掉右边边界之前，先看一看边边界可以不可以排除
                    if(nums[right] == target){
                        return true;
                    }
                    right = right -1;
                }
            }
            System.out.println(left);
            return nums[left] == target;
        }
    }
}
