package org.crayzer.leetcode.editor.en.滑动窗口;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yizhe.chen
 */
public class LeetCode_567_字符串排列 {
    public static void main(String[] args) {
        String t = "ab", s = "eidbaooo";
        System.out.println(LeetCode_567_字符串排列.Solution.checkInclusion(t, s));
        t = "ab";
        s = "eidboaoo";
        System.out.println(LeetCode_567_字符串排列.Solution.checkInclusion(t, s));

    }

    static class Solution {
        public static boolean checkInclusion(String t, String s) {
            return false;
        }
    }
}