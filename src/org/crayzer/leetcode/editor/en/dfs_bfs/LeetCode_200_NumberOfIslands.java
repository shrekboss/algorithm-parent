package org.crayzer.leetcode.editor.en.dfs_bfs;

public class LeetCode_200_NumberOfIslands {

    class Solution {
        private int[] dx = {-1, 1, 0, 0};
        private int[] dy = {0, 0, -1, 1};
        char[][] g;

        public int numIslands(char[][] grid) {
            int lslands = 0;
            g = grid;

            for (int i = 0; i < g.length; i++) {
                for (int j = 0; j < g[i].length; j++) {
                    if (g[i][j] == '0') continue;
                    lslands += sink(i, j);
                }
            }
            return lslands;
        }

        private int sink(int i, int j) {
            if (g[i][j] == '0') return '0';

            for (int k = 0; k < dx.length; k++) {
                int x = i + dx[k], y = j + dy[k];
                if (x > 0 && x < g.length && y > 0 && y < g[i].length) {
                    if (g[x][y] == '0') continue;
                    sink(x, y);
                }
            }
            return 1;
        }
    }
}
