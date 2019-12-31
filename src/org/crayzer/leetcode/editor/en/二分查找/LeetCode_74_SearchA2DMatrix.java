package org.crayzer.leetcode.editor.en.二分查找;

public class LeetCode_74_SearchA2DMatrix {
    static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            if (m == 0) return false;
            int n = matrix[0].length;
            int left = 0, right = m * n - 1;
            while (left <= right) {
                int midIndex = (left + right) >>> 1;
                int midValue = matrix[midIndex / n][midIndex % n];

                if (midValue == target) return true;
                else {
                    if (midValue < target) left = midIndex + 1;
                    else right = midIndex - 1;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        int target = 13;
        System.out.println(so.searchMatrix(matrix, target));
    }
}
