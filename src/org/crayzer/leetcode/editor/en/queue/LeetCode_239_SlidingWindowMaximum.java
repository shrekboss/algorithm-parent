package org.crayzer.leetcode.editor.en.queue;

public class LeetCode_239_SlidingWindowMaximum {

    /**
     * O(nk)
     */
    class Solution1 {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            if (n * k == 0) return new int[0];
            if (k == 1) return nums;

            int[] output = new int[n - k + 1];
            for (int i = 0; i < n - k + 1; i++) {
                int max = Integer.MAX_VALUE;

                for (int j = i; j < i + k; j++) {
                    max = Math.max(max, nums[j]);
                }

                output[i] = max;
            }

            return output;
        }
    }
}
