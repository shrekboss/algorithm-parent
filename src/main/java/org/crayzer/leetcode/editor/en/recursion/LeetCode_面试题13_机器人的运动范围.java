package org.crayzer.leetcode.editor.en.recursion;

public class LeetCode_面试题13_机器人的运动范围 {
    class Solution {
        private int cnt = 0;

        public int movingCount(int m, int n, int k) {
            int[][] visited = new int[m][n];
            recur(visited, 0, 0, m - 1, n - 1, k);
            return cnt;
        }

        private void recur(int[][] visited, int i, int j, int m, int n, int k) {
            if (i <= m && j <= n && visited[i][j] != 1 && (indexSum(i) + indexSum(j) <= k)) {
                cnt++;
                visited[i][j] = 1;
                recur(visited, i + 1, j, m, n, k);
                recur(visited, i, j + 1, m, n, k);
            }
        }

        private int indexSum(int index) {
            int sum = index % 10;
            int temp = index / 10;
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }
            return sum;
        }
    }
}
