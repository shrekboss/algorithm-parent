package org.crayzer.leetcode.editor.en.bit_operation;

public class LeetCode_136_只出现一次的数字 {

    class Solution {
        public int singleNumber(int[] nums) {
            int ans = nums[0];
            if (nums.length > 1) {
                for (int i = 1; i < nums.length; i++) {
                    ans = ans ^ nums[i];
                }
            }
            return ans;
        }
    }
}
