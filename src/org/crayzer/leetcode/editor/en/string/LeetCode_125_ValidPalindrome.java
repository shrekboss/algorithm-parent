package org.crayzer.leetcode.editor.en.string;

public class LeetCode_125_ValidPalindrome {

    public static void main(String[] args) {

        Solution solution = new LeetCode_125_ValidPalindrome().new Solution();

        String testCase1 = "A man, a plan, a canal: Panama";
        System.out.println(solution.isPalindrome(testCase1));

        String testCase2 = "race a car";
        System.out.println(solution.isPalindrome(testCase2));
    }

    class Solution {
        public boolean isPalindrome(String s) {
            String filteredStr = filterNonNumberAndChar(s);
            String reverseStr = reverseString(filteredStr);
            return filteredStr.equalsIgnoreCase(reverseStr);
        }

        private String filterNonNumberAndChar(String s) {

            return s.replaceAll("[^a-zA-Z0-9]", "");
        }

        private String reverseString(String s) {

            return new StringBuilder(s).reverse().toString();
        }
    }
}
