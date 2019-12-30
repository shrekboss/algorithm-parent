package org.crayzer.leetcode.editor.en.二分查找;

public class LeetCode_33_SearchInRotatedSortedArray {
    class Solution {
        // 将待搜索区间从中间一分为二，mid 一定会落在其中一个有序区间里。
        public int search(int[] nums, int target) {
            int len = nums.length;
            if (len == 0) {
                return -1;
            }

            int left = 0, right = len - 1;
            while (left < right) {
                int mid = (left + right + 1) >>> 1;
                if (nums[mid] < nums[right]) {
                    if (nums[mid] <= target && target <= nums[right]) left = mid;
                    else right = mid - 1;
                } else {
                    // 当区间只有 2 个元素的时候 int mid = (left + right + 1) >>> 1; 一定会取到右边
                    // 此时 mid - 1 不会越界，就是这么刚刚好
                    if (nums[left] <= target && target <= nums[mid- 1]) right = mid - 1;
                    else left = mid;
                }
            }
            // System.out.println(left);

            return nums[left] == target ? left : -1;
        }
    }
}
