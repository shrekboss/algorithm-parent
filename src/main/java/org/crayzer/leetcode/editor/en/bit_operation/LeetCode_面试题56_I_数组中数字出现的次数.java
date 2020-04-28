package org.crayzer.leetcode.editor.en.bit_operation;


import sun.print.SunMinMaxPage;

public class LeetCode_面试题56_I_数组中数字出现的次数 {
    class Solution {
        public int[] singleNumbers(int[] nums) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) sum ^= nums[i];

            int first = 1;
            while ((sum & first) == 0) first = first << 1;

            int[] result = new int[2];
            for (int i = 0; i < nums.length; i++) {
                if ((nums[i] & first) == 0) result[0] ^= nums[i];
                else result[1] ^= nums[i];
            }
            return result;
        }
    }
}
