package org.crayzer.leetcode.editor.en.string;

public class LeetCode_14_LongestCommonPrefix {
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) return "";
            String result = strs[0];
            for (int i = 1; i < strs.length; i++) {
                //重点：如果result不是当前的子串，则删除最后一位再次比较，直到取出子串为止
                while (strs[i].indexOf(result) != 0) {
                    result = result.substring(0, result.length() - 1);
                    if (result.equals(""))
                        return "";
                }
            }
            return result;
        }
    }
}
