package org.crayzer.leetcode.editor.en.array;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_62_圆圈中最后剩下的数字 {

    class Solution {
        public int lastRemaining(int n, int m) {
            ArrayList<Integer> ans = new ArrayList<>(n);
            for (int i = 0; i < n; i++) ans.add(i);
            int idx = 0;

            while (n > 1) {
                idx = (idx + m - 1) % n;
                ans.remove(idx);
                n--;
            }
            return ans.get(0);
        }
    }

    class Solution1 {
        public int lastRemaining(int n, int m) {
            int ans = 0;
            for (int i = 2; i <= n; i++) {
                ans = (ans + m) % i;
            }
            return ans;
        }
    }
}
