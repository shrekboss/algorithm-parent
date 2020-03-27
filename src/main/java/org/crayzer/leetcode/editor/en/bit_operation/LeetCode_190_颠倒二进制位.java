package org.crayzer.leetcode.editor.en.bit_operation;

public class LeetCode_190_颠倒二进制位 {

    class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            int res = 0;
            for (int i = 0; i < 32; i++) {
                res <<= 1;
                res += n & 1;
                n >>= 1;
            }
            return res;
        }
    }
}
