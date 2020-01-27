package org.crayzer.leetcode.editor.en.dynamic_programming;

import java.util.HashMap;

public class LeetCode_91_DecodeWays {

    class Solution2 {
        public int numDecodings(String s) {
            return 0;
        }
    }

    class Solution1 {
        public int numDecodings(String s) {
            HashMap<Integer, Integer> map = new HashMap<>();
            return helper(s, 0, map);
        }

        private int helper(String s, int start, HashMap<Integer, Integer> map) {
            if (start == s.length()) return 1;
            if (s.charAt(start) == '0') return 0;
            int m = map.getOrDefault(start, -1);
            if (m != -1) return m;
            int ans1 = helper(s, start + 1, map);
            int ans2 = 0;

            if (start < s.length() - 1) {
                int ten = (s.charAt(start) - '0') * 10;
                int one = s.charAt(start + 1) - '0';
                if (ten + one <= 26) ans2 = helper(s, start + 2, map);
            }
            map.put(start, ans1 + ans2);
            return ans1 + ans2;
        }
    }

    class Solution {
        public int numDecodings(String s) {
            return helper(s, 0);
        }

        private int helper(String s, int start) {
            if (start == s.length()) return 1;
            if (s.charAt(start) == '0') return 0;

            int ans1 = helper(s, start + 1);
            int ans2 = 0;

            if (start < s.length() - 1) {
                int ten = (s.charAt(start) - '0') * 10;
                int one = s.charAt(start + 1) - '0';
                if (ten + one <= 26) ans2 = helper(s, start + 2);
            }
            return ans1 + ans2;
        }
    }
}
