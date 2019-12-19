package org.crayzer.leetcode.editor.en.treez_recursion;

public class LeetCode_509_FibonacciNumber {

        class Solution {
            public int fib(int N) {
                int curr = 0, next = 1;
                while (N-- > 0) {
                    next = curr + next;
                    curr = next - curr;
                }

                return curr;
            }
        }
}
