package org.crayzer.leetcode.editor.en.dfs_bfs;

import java.util.LinkedList;
import java.util.List;

public class LeetCode_127_WordLadder2 {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(2 << 16));// 17个0 => 100000000000000000
        System.out.println(2 << 16);// 131072
        System.out.println(Integer.toBinaryString(2 << 31));// 1个0 => 0
        System.out.println(Integer.toBinaryString(2 << 33));// 2个0 => 100
        // System.out.println(Integer.toBinaryString(2 << 1));// 2个0 => 100
        int[][] obstacles = {{2, 4}};
        System.out.println(obstacles.length);
        for (int i=0;i<obstacles.length;i++) {
            System.out.printf("obstacles[%d][0] , obstacles[%d][1]", i, i);
            System.out.println();
        }

    }

    class Solution {
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            return new LinkedList<>();
        }
    }
}
