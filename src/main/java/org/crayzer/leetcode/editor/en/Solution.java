package org.crayzer.leetcode.editor.en;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int shortestPathBinaryMatrix(int[][] grid) {

        int m = grid.length, n = grid[0].length;
        if (grid[0][0] == 1 && grid[m - 1][n - 1] == 1) return -1;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        int step = 1;
        int[][] dirs = {{1, 0}, {1, 1}, {1, -1}, {0, 1}, {0, -1}, {-1, 0}, {-1, -1}, {-1, 1}};

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] data = queue.poll();
                int x = data[0];
                int y = data[1];

                if (x == m - 1 && y == n - 1) return step;

                for (int[] dir : dirs) {
                    int x1 = x + dir[0];
                    int y1 = y + dir[1];

                    if (x1 >= 0 && x1 < m && y1 >= 0 && y1 < n && grid[x1][y1] == 0) {
                        queue.add(new int[]{x1, y1});
                        grid[x1][y1] = 1;
                    }
                }
            }
            step++;
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {{0, 1}, {1, 0}};
        System.out.println(solution.shortestPathBinaryMatrix(grid));
    }
}
