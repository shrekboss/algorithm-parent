package org.crayzer.leetcode.editor.en.array;

public class LeetCode_RotateMatrixLCCI {
    class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            // 先以对角线（左上-右下）为轴进行翻转
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
            int mid = n >> 1;
            // 再对每一行以中点进行翻转
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < mid; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[i][n - 1 - j];
                    matrix[i][n - 1 - j] = temp;
                }
            }
        }
    }
}
