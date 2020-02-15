package org.crayzer.leetcode.editor.en.string;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_76_MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(Solution.minWindow(s, t));
    }

    class Solution1 {
        public String minWindow(String s, String t) {
            int count = t.length();
            int[] map = new int[128];
            for (char c : t.toCharArray()) {
                map[c]++;
            }
            int left = 0, right = 0, begin = 0, min = Integer.MAX_VALUE;
            while (right < s.length()) {
                if (map[s.charAt(right)] > 0) {
                    count--;
                }
                map[s.charAt(right++)]--;
                while (count == 0) {
                    if (right - left < min) {
                        min = right - left;
                        begin = left;
                    }
                    if (map[s.charAt(left)] == 0) {
                        count++;
                    }
                    map[s.charAt(left++)]++;
                }
            }
            return min == Integer.MAX_VALUE ? "" : s.substring(begin, begin + min);
        }
    }

    static class Solution {
        public static String minWindow(String s, String t) {
            // 记录最短子串的开始位置和长度
            int start = 0, minLen = Integer.MAX_VALUE;
            int left = 0, right = 0;

            Map<Character, Integer> window = new HashMap<>();
            Map<Character, Integer> needs = new HashMap<>();
            for (char c : t.toCharArray()) {
                needs.put(c, needs.getOrDefault(c, 0) + 1);
            }

            int match = 0;
            while (right < s.length()) {
                char c1 = s.charAt(right);
                if (needs.containsKey(c1)) {
                    window.put(c1, window.getOrDefault(c1, 0) + 1);
                    if (window.get(c1).equals(needs.get(c1)))
                        // 字符 c1 的出现次数符合要求了
                        match++;
                }
                right++;
                while (match == needs.size()) {
                    if (right - left < minLen) {
                        // 更新最小子串的位置和长度
                        start = left;
                        minLen = right - left;
                    }
                    char c2 = s.charAt(left);
                    if (needs.containsKey(c2)) {
                        window.put(c2, window.get(c2) - 1);
                        if (window.get(c2) < needs.get(c2))
                            match--;
                    }
                    left++;
                }
            }
            return minLen == Integer.MAX_VALUE ?
                    "" : s.substring(start, start + minLen);
        }
    }
}
