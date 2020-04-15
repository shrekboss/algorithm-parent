package org.crayzer.leetcode.editor.en.dynamic_programming;

public class LeetCode_542_01矩阵 {

    class Solution {
        public int[][] updateMatrix(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) return matrix;
            int m = matrix.length;
            int n = matrix[0].length;
            int[][] dis = new int[m][n];
            int range = m * n;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0) matrix[i][j] = 0;
                    else {
                        int upCell = (i > 0) ? dis[i - 1][j] : range;
                        int leftCell = (j > 0) ? dis[i][j - 1] : range;
                        dis[i][j] = Math.min(upCell, leftCell) + 1;
                    }
                }
            }
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    if (matrix[i][j] == 0) matrix[i][j] = 0;
                    else {
                        int downCell = (i < m - 1) ? dis[i + 1][j] : range;
                        int rightCell = (j < n - 1) ? dis[i][j + 1] : range;
                        dis[i][j] = Math.min(Math.min(downCell, rightCell) + 1, dis[i][j]);
                    }
                }
            }
            return dis;
        }
    }
}
