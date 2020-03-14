package org.crayzer.leetcode.editor.en.dynamic_programming;

public class LeetCode_518_CoinChange2 {

    class Solution1 {
        public int change(int amount, int[] coins) {
            if (coins == null) return 0;
            int[] dp = new int[amount + 1];
            dp[0] = 1;

            for (int coin : coins) {
                for (int i = coin; i <= amount; i++) {
                    dp[i] += dp[i - coin];
                }
            }
            return dp[amount];
        }
    }

    class Solution {
        public int change(int amount, int[] coins) {
            int len = coins.length;
            if (len == 0) {
                if (amount == 0) return 1;
                return 0;
            }
            int[][] dp = new int[len][amount + 1];
            for (int i = coins[0]; i <= amount; i += coins[0]) {
                dp[0][i] = 1;
            }

            for (int i = 1; i < len; i++) {
                for (int j = 0; j <= amount; j++) {
                    for (int k = 0; j - k * coins[i] >= 0; k++) {
                        dp[i][j] += dp[i - 1][j - k * coins[i]];
                    }
                }
            }
            return dp[len - 1][amount];
        }
    }
}
