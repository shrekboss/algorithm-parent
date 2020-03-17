package org.crayzer.leetcode.editor.en.sort;

public class LeetCode_440_KthSmallestInLexicographicalOrder {
    class Solution {
        public int findKthNumber(int n, int k) {
            long cur = 1;
            while (k > 1) {
                long gap = findGap(cur, cur + 1, n);
                if (gap <= k - 1) {
                    k -= gap;
                    cur += 1;
                } else {
                    cur *= 10;
                    k -= 1;
                }
            }
            return (int) cur;
        }

        private long findGap(long a, long b, int n) {
            // eg 198 113
            // a = 1, b = 2, 2 - 1 = 1
            // a = 10, b = 20, 20 - 10 = 10
            // n = 198, a = 100, b = 200 199 - 100 = 99
            // gap = 1 + 10 + 99 = 110 < 113
            int gap = 0;
            while (a <= n) {
                gap += Math.min(n + 1, b) - a;
                a *= 10;
                b *= 10;
            }
            return gap;
        }
    }
}
