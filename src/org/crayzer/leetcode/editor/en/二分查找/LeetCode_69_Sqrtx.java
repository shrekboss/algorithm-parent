package org.crayzer.leetcode.editor.en.二分查找;

public class LeetCode_69_Sqrtx {
    static class Solution {
        public int mySqrt(int x) {
            if (x == 0) return x;
            /*
             * 技巧点：
             * long left = 0, right = x;
             * */
            long left = 0, right = x / 2 + 1;
            while (left < right) {
                // 注意：这里一定取右中位数，如果取左中位数，代码会进入死循环
                // long mid = left + (right - left + 1) / 2;
                // mid设置int类型，针对大整型测试用例通不过
                long mid = (left + right + 1) >>> 1;
                if (mid * mid > x) right = mid - 1;
                else left = mid;
            }
            return (int) left;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("result: " + solution.mySqrt(8));
    }
}
