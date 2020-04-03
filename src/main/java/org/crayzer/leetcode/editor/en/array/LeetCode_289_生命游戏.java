package org.crayzer.leetcode.editor.en.array;

public class LeetCode_289_生命游戏 {

    class Solution {
        int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
        int[][] board;
        int m, n;

        public void gameOfLife(int[][] board) {
            this.board = board;
            if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) return;
            this.m = board.length;
            this.n = board[0].length;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int cnt = countLive(i, j);
                    if (board[i][j] == 1 && (cnt == 2 || cnt == 3)) board[i][j] = 3;
                    if (board[i][j] == 0 && cnt == 3) board[i][j] = 2;
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] >>= 1;
                }
            }
        }

        private int countLive(int x, int y) {
            int cnt = 0;
            for (int k = 0; k < 8; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                cnt += (board[nx][ny] & 1);
            }
            return cnt;
        }
    }
}
