package org.crayzer.leetcode.editor.en.dynamic_programming;

public class LeetCode_64_最小路径和 {

    class Solution1 {
        public int minPathSum(int[][] grid) {
            int[][] mem = new int[grid.length][grid[0].length];
            return helper(grid,mem,0,0);
        }
        private int helper(int[][] grid,int[][] mem,int i,int j){
            if(mem[i][j] != 0)return mem[i][j];

            int right = Integer.MAX_VALUE, down = Integer.MAX_VALUE;

            if(i+1<grid.length){
                right= helper(grid,mem,i+1,j);
            }
            if(j+1<grid[0].length){
                down = helper(grid,mem,i,j+1);
            }
            int min = Math.min(right,down);
            if(min == Integer.MAX_VALUE)mem[i][j] = grid[i][j];
            else mem[i][j] = min+grid[i][j];
            return mem[i][j];
        }
    }

    class Solution {
        public int minPathSum(int[][] grid) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (i == 0 && j == 0) continue;
                    else if (i == 0) grid[i][j] = grid[i][j - 1] + grid[i][j];
                    else if (j == 0) grid[i][j] = grid[i - 1][j] + grid[i][j];
                    else grid[i][j] = Math.min(grid[i][j - 1] , grid[i - 1][j]) + grid[i][j];
                }
            }
            return grid[grid.length - 1][grid[0].length - 1];
        }
    }
}
