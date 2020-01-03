package org.crayzer.leetcode.editor.en.greedy;

public class LeetCode_45_JumpGame2 {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(new Solution().jump(nums));
    }

    static class Solution {
        public int jump(int[] nums) {
            int end = 0;
            int maxPosition = 0;
            int steps = 0;

            for (int i = 0; i < nums.length - 1; i++) {
                maxPosition = Math.max(maxPosition, nums[i] + i);
                // 遇到边界，就更新边界，并且步数加一
                if (i == end) {
                    end = maxPosition;
                    steps++;
                }
            }

            return steps;
        }
    }
}
