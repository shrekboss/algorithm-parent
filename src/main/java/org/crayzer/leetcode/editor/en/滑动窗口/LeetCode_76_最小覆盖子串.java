package org.crayzer.leetcode.editor.en.滑动窗口;

import org.checkerframework.checker.units.qual.min;

import java.util.Map;

/**
 * @author yizhe.chen
 */
public class LeetCode_76_最小覆盖子串 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(Solution.minWindow(s, t));
    }

    static class Solution {
        public static String minWindow(String s, String t) {
            int count = t.length();
            int[] map = new int[128];
            for (char c : t.toCharArray()) map[c]++;

            int left = 0, right = 0;
            int begin = 0, min = Integer.MAX_VALUE;

            while (right < s.length()) {
                if (map[s.charAt(right)] > 0) count--;
                map[s.charAt(right++)]--;

                while (count == 0) {
                    if (right - left  < min) {
                        min = right - left;
                        begin = left;
                    }

                    if (map[s.charAt(left)] == 0) count++;
                    map[s.charAt(left++)]++;
                }
            }
            return min == Integer.MAX_VALUE ? "" : s.substring(begin, begin + min);
        }
    }
}