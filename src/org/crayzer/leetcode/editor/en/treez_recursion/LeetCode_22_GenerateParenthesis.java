package org.crayzer.leetcode.editor.en.treez_recursion;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_22_GenerateParenthesis {

    static class Solution {
        private List<String> res;

        public List<String> generateParenthesis(int n) {
            res = new ArrayList<>();
            generate(0, 0, n, "");
            return res;
        }

        private void generate(int left, int right, int n, String s) {
            // terminator
            // if (level >= max) {
            if (left == n && right == n) {
                res.add(s);
                // System.out.println(s);
                return;
            }

            // process current logic
            //drill down
            if (left < n) generate(left + 1, right, n, s + "(");
            if (left > right) generate(left, right + 1, n, s + ")");

            // reverse states
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(3));
    }
}
