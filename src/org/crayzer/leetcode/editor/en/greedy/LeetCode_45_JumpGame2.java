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

            /*
             * 这里要注意一个细节，就是 for 循环中，i < nums.length - 1，少了末尾。
             * 因为开始的时候边界是第 00 个位置，steps 已经加 11 了。如下图，
             * 如果最后一步刚好跳到了末尾，此时 steps 其实不用加 11 了。
             * 如果是 i < nums.length，i 遍历到最后的时候，会进入 if 语句中，steps 会多加 11。
             */
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
