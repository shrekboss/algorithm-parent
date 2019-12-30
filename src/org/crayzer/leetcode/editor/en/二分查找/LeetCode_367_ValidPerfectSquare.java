package org.crayzer.leetcode.editor.en.二分查找;

public class LeetCode_367_ValidPerfectSquare {
    class Solution {
        public boolean isPerfectSquare(int num) {
            long left  = 1, right = num;

            while (left < right) {
                long mid = (left + right + 1) >>> 1;
                if (mid * mid > num) right = mid - 1;
                else left = mid;
            }

            return left * left == num;
        }
    }
}
