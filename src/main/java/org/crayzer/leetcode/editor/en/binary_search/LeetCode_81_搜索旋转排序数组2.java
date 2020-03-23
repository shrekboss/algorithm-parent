package org.crayzer.leetcode.editor.en.binary_search;

public class LeetCode_81_搜索旋转排序数组2 {
    class Solution {
        public boolean search(int[] nums, int target) {
            if (nums == null || nums.length == 0) return false;

            int left = 0, right = nums.length - 1;

            while (left <= right) {
                int mid = (left + right + 1) >>> 1;

                if (nums[mid] == target) return true;

                if (nums[left] == nums[mid]) {
                    left++;
                    continue;
                }
                //前半部分有序
                if (nums[left] < nums[mid]) {
                    //target在前半部分
                    if (nums[mid] > target && nums[left] <= target) right = mid - 1;
                    else left = mid + 1;
                } else {
                    //后半部分有序
                    //target在后半部分
                    if (nums[mid] < target && nums[right] >= target) left = mid + 1;
                    else right = mid - 1;
                }
            }
            //一直没找到，返回false
            return false;

        }
    }
}
