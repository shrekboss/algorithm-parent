package org.crayzer.leetcode.editor.en.stack;

import java.util.Stack;

public class LeetCode_20_ValidParentheses {

    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();

            for (Character c : s.toCharArray()) {
                if (c == '(') {
                    stack.push(')');
                } else if (c == '{') {
                    stack.push('}');
                } else if (c == '[') {
                    stack.push(']');
                } else if (stack.isEmpty() || !stack.pop().equals(c)) {
                    return false;
                }
            }

            return stack.isEmpty();
        }
    }
}
