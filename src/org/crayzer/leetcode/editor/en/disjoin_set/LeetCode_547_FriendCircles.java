package org.crayzer.leetcode.editor.en.disjoin_set;

public class LeetCode_547_FriendCircles {

    class Solution1 {
        public int findCircleNum(int[][] M) {
            int[] visited = new int[M.length];
            int count = 0;
            for (int i = 0; i < M.length; i++) {
                if (visited[i] == 0) {
                    dfs(M, visited, i);
                    count++;
                }
            }
            return count;
        }

        private void dfs(int[][] M, int[] visited, int i) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1 && visited[j] == 0) {
                    visited[i] = 1;
                    dfs(M, visited, j);
                }
            }
        }

    }

    class Solution {
        public int findCircleNum(int[][] M) {
            int n = M.length;
            DisjoinSet ds = new DisjoinSet(n);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (M[i][j] == 1) {
                        ds.union(i, j);
                    }
                }
            }
            return ds.count();
        }
    }
}
