package org.crayzer.leetcode.editor.en.string;

public class LeetCode_409_最长回文串 {
    class Solution {
        public int longestPalindrome(String s) {
            // 26 + 26 = 52, AXCII a-z A_Z 不是连续的
            int[] cnt = new int[58];
            for (char c : s.toCharArray()) {
                cnt[c - 'A']++;
            }
            int ans = 0;
            for (int x : cnt) {
                /*
                 * x & 1 = 1 奇数 x & 1 = 0 偶数
                 * 字符出现数量加起来，偶数次数的直接加，奇数次数的减一后再加。
                 */
                ans += x - (x & 1);
            }
            /**
             * 1. 通过给定的字符串s，构造出来的最长回文字符串，长度肯定小于等于s，如果小于s，那么最长回文串b的长度必然是奇数。
             */
            return ans < s.length() ? ans + 1 : ans;
        }
    }
}
