package org.crayzer.leetcode.editor.en.divide_recall;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_52_NQueens2 {

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString((1 << 8) - 1));
    }

    /**
     * 终极解法
     */
    class Solution1 {
        private int size;
        private int count;

        public int totalNQueens(int n) {
            this.count = 0;
            this.size = (1 << n) - 1; // 八皇后 1111 11111
            solves(0, 0, 0);
            return this.count;
        }

        private void solves(int row, int ld, int rd) {
            if (row == size) {
                this.count++;
                return;
            }

            int pos = size & (~(row | ld | rd));
            while (pos != 0) {
                int p = pos & -pos; // 得到最低位的1
                pos -= p; // pos = pos & pos - 1; 清零最低位的1
                solves(row | p, (ld | p) << 1, (rd | p) >> 1);
            }
        }
    }

    class Solution {
        private Set<Integer> cols = new HashSet<>();
        private Set<Integer> pie = new HashSet<>();
        private Set<Integer> na = new HashSet<>();
        private int count = 0;

        public int totalNQueens(int n) {
            dfs(n, 0);
            return count;
        }

        private void dfs(int n, int row) {
            if (row >= n) {
                count++;
                return;
            }

            for (int col = 0; col < n; col++) {
                if (cols.contains(col) || pie.contains(row + col) || na.contains(row - col)) continue;

                cols.add(col);
                pie.add(row + col);
                na.add(row - col);
                dfs(n, row + 1);
                cols.remove(col);
                pie.remove(row + col);
                na.remove(row - col);
            }
        }
    }
}
