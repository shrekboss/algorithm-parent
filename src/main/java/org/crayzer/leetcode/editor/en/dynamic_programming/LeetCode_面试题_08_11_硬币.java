package org.crayzer.leetcode.editor.en.dynamic_programming;

/**
 * 动态规划解法：完全背包问题
 */
public class LeetCode_面试题_08_11_硬币 {
    class Solution {
        public int waysToChange(int n) {
            int[] dp = new int[n + 1];
            int[] coins = new int[]{1, 5, 10, 25};

            dp[0] = 1;
            for (int coin : coins) {
                for (int i = 0; i <= n; i++) {
                    dp[i] = (dp[i] + dp[i - coin]) % 1000000007;
                }
            }
            return dp[n];
        }
    }
}
