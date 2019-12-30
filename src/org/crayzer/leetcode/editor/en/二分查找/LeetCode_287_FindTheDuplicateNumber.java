package org.crayzer.leetcode.editor.en.二分查找;

public class LeetCode_287_FindTheDuplicateNumber {
    class Solution {
        public int findDuplicate(int[] nums) {
            // 关键是对要定位的“数”做二分，而不是对数组的索引做二分。
            // 要定位的“数”根据题意在 1 和 n 之间，每一次二分都可以将搜索区间缩小一半
            int left = 0, right = nums.length - 1;

            while (left < right) {
                int mid = (left + right + 1) >>> 1;
                int counter = 0;
                for (int num : nums) {
                    if (num < mid) counter++;
                }

                // 如果小于 4 的个数等于 4 或者更多
                // 那么重复的数一定位于 1、2、3
                if (counter >= mid) right = mid - 1;
                else left  = mid;
            }
            return left;
        }
    }
}
