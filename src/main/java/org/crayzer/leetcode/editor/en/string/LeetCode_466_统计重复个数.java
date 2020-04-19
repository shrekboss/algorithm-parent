package org.crayzer.leetcode.editor.en.string;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

/**
 * 由 n 个连接的字符串 s 组成字符串 S，记作 S = [s,n]。例如，["abc",3]=“abcabcabc”。
 * 如果我们可以从 s2 中删除某些字符使其变为 s1，则称字符串 s1 可以从字符串 s2 获得。例如，根据定义，"abc" 可以从 “abdbec” 获得，但不能从 “acbbe” 获得。
 * 现在给你两个非空字符串 s1 和 s2（每个最多 100 个字符长）和两个整数 0 ≤ n1 ≤ 106 和 1 ≤ n2 ≤ 106。现在考虑字符串 S1 和 S2，其中 S1=[s1,n1] 、S2=[s2,n2] 。
 * 请你找出一个可以满足使[S2,M] 从 S1 获得的最大整数 M 。
 *
 * 示例：
 * 输入：
 * s1 ="acb",n1 = 4
 * s2 ="ab",n2 = 2
 *
 * 返回：
 * 2
 */
public class LeetCode_466_统计重复个数 {

    static class Solution {
        public static int getMaxRepetitions(String s1, int n1, String s2, int n2) {
            int l1 = s1.length();
            int l2 = s2.length();
            if (l1 == 0 || l2 == 0 || l1 * n1 < l2 * n2) return 0;

            String str;
            char[] c1 = s1.toCharArray();
            char[] c2 = s2.toCharArray();
            int cnt1 = 0, cnt2 = 0, p = 0;
            Map<Integer, int[]> map = new HashMap<>();

            while (cnt1 < n1) {
                for (int i = 0; i < l1; i++) {
                    if (c1[i] == c2[p]) {
                        p++;
                        if (p == l2) {
                            p = 0;
                            cnt2++;
                        }
                    }
                }
                cnt1++;
                if (!map.containsKey(p)) map.put(p, new int[]{cnt1, cnt2});
                else {
                    int[] last = map.get(p);
                    int circle1 = cnt1 - last[0];
                    int circle2 = cnt2 - last[1];
                    cnt2 += circle2 * ((n1 - cnt1) / circle1);
                    cnt1 += circle1 * ((n1 - cnt1) / circle1);
                }
            }
            return cnt2 / n2;
        }
    }

    public static void main(String[] args) {
        String s1 = "acb";
        int n1 = 4;
        String s2 = "aa";
        int n2 = 2;
        System.out.println(Solution.getMaxRepetitions(s1, n1, s2, n2));
    }
}
