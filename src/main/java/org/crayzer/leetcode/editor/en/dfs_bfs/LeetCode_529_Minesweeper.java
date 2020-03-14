package org.crayzer.leetcode.editor.en.dfs_bfs;

/**
 * class_name: LeetCode_529_Minesweeper
 * describe: 扫雷游戏
 **/
public class LeetCode_529_Minesweeper {

    public static void main(String[] args) {
        System.out.println(Character.forDigit(0, 10));
        System.out.println(Character.forDigit(1, 10));
        System.out.println(Character.forDigit(2, 10));
        System.out.println(Character.forDigit(9, 9));
    }

    /**
     * 二维矩阵，
     * M 未挖出的地雷；
     * E 未挖出的空方块；
     * B 没有相邻地雷的已挖出的空白块(上下左右和四个对角线)；
     * X 则表示一个已挖出的地雷
     **/
    class Solution {

        public char[][] updateBoard(char[][] board, int[] click) {
            if (board[click[0]][click[1]] == 'M') {
                board[click[0]][click[1]] = 'X';
                return board;
            }
            return click(board, click[0], click[1]);
        }

        private char[][] click(char[][] board, int x, int y) {
            int num = getNum(board, x, y);
            if (num == 0) {
                board[x][y] = 'B';
            } else {
                board[x][y] = Character.forDigit(num, 10);
                return board;
            }
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (x + i >= 0 && x + i < board.length && y + j >= 0 && y + j < board[0].length && board[x + i][y + j] == 'E') {
                        board = click(board, x + i, y + j);
                    }
                }
            }
            return board;
        }

        private int getNum(char[][] board, int x, int y) {
            int num = 0;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (x + i >= 0 && x + i < board.length && y + j >= 0
                            && y + j < board[0].length && board[x + i][y + j] == 'M') {
                        num++;
                    }
                }
            }
            return num;
        }
    }
}
