package org.crayzer.leetcode.editor.en.dynamic_programming;

public class LeetCode_714_BestTimeToBuyAndSellStockWithTransactionFee {
    class Solution {
        public int maxProfit(int[] prices, int fee) {
            int n = prices.length;
            if (n == 0) return 0;

            int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                int temp = dp_i_0;
                dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
                dp_i_1 = Math.max(dp_i_1, temp - prices[i] - fee);
            }
            return dp_i_0;
        }
    }
}
