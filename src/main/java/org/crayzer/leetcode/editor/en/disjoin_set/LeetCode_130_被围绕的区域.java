package org.crayzer.leetcode.editor.en.disjoin_set;

public class LeetCode_130_被围绕的区域 {

    class Solution {
        int[] parent; // union find set
        boolean[] hasEdgeO; // whether an union has an 'O' which is on the edge of the matrix

        public void solve(char[][] board) {
            if (board.length == 0 || board[0].length == 0) return;

            // init, every char itself is an union
            int rows = board.length, cols = board[0].length;
            parent = new int[rows * cols];
            hasEdgeO = new boolean[parent.length];
            for (int i = 0; i < parent.length; i++) parent[i] = i;
            for (int i = 0; i < hasEdgeO.length; i++) {
                int x = i / cols, y = i % cols;
                hasEdgeO[i] = (board[x][y] == 'O' && (x == 0 || x == rows - 1 || y == 0 || y == cols - 1));
            }

            // iterate the matrix, for each char, union it + its upper char + its right char if they equals to each other
            for (int i = 0; i < parent.length; i++) {
                int x = i / cols, y = i % cols, up = x - 1, right = y + 1;
                if (up >= 0 && board[x][y] == board[up][y]) union(i, i - cols);
                if (right < cols && board[x][y] == board[x][right]) union(i, i + 1);
            }

            // for each char in the matrix, if it is an 'O' and its union doesn't has an 'edge O', the whole union should be setted as 'X'
            for (int i = 0; i < parent.length; i++) {
                int x = i / cols, y = i % cols;
                if (board[x][y] == 'O' && !hasEdgeO[findSet(i)])
                    board[x][y] = 'X';
            }
        }

        private void union(int x, int y) {
            int rootX = findSet(x);
            int rootY = findSet(y);
            // if there is an union has an 'edge O',the union after merge should be marked too
            boolean hasEdgeO = this.hasEdgeO[rootX] || this.hasEdgeO[rootY];
            parent[rootX] = rootY;
            this.hasEdgeO[rootY] = hasEdgeO;
        }

        private int findSet(int x) {
            if (parent[x] == x) return x;
            parent[x] = findSet(parent[x]);
            return parent[x];
        }
    }

    class Solution1 {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        public void solve(char[][] board) {
            if (board == null || board.length == 0) return;

            int rows = board.length;
            int cols = board[0].length;

            for (int j = 0; j < cols; j++) {
                if (board[0][j] == 'O') dfs(0, j, board, rows, cols);
                if (board[rows - 1][j] == 'O') dfs(rows - 1, j, board, rows, cols);
            }

            for (int i = 0; i < rows; i++) {
                if (board[i][0] == 'O') dfs(i, 0, board, rows, cols);
                if (board[i][cols - 1] == 'O') dfs(i, cols - 1, board, rows, cols);
            }
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (board[i][j] == 'O') board[i][j] = 'X';
                    if (board[i][j] == 'B') board[i][j] = 'O';
                }
            }
        }

        private void dfs(int i, int j, char[][] board, int rows, int cols) {
            board[i][j] = 'B';
            for (int[] dir : dirs) {
                int temp_i = dir[0] + i;
                int temp_j = dir[1] + j;
                if (temp_i < 0 || temp_j < 0 || temp_i >= rows || temp_j >= cols || board[temp_i][temp_j] != 'O')
                    continue;
                dfs(temp_i, temp_j, board, rows, cols);
            }
        }
    }
}
