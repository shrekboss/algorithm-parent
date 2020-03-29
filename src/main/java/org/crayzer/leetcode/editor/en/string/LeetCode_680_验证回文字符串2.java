package org.crayzer.leetcode.editor.en.string;

public class LeetCode_680_验证回文字符串2 {

    class Solution {
        public boolean validPalindrome(String s) {
            for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
                if (s.charAt(i) != s.charAt(j)) {
                    return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
                }
            }
            return true;
        }

        private boolean isPalindrome(String s, int start, int end) {
            while (start < end) {
                if (s.charAt(start++) != s.charAt(end--)) return false;
            }
            return true;
        }
    }
}
