package org.crayzer.leetcode.editor.en.divide_recall;

public class LeetCode_338_CountingBits {

    class Solution2 {
        public int[] countBits(int num) {
            int[] dp = new int[num + 1];
            for (int i = 1; i <= num; i++) {
                dp[i] = dp[i >> 1] + (i & 1);
            }
            return dp;
        }
    }

    class Solution1 {
        public int[] countBits(int num) {
            int[] dp = new int[num + 1];
            for (int i = 1; i <= num; i++) {
                dp[i] = dp[i & i - 1] + 1;
            }
            return dp;
        }
    }

    class Solution {
        public int[] countBits(int num) {
            int[] ans = new int[num + 1];
            for (int i = 0; i <= num; i++) {
                ans[i] = popCount(i);
            }
            return ans;
        }

        private int popCount(int x) {
            int count = 0;
            for (count = 0; x != 0; count++) {
                count++;
                x = x & x - 1;
            }
            return count;
        }
    }
}
