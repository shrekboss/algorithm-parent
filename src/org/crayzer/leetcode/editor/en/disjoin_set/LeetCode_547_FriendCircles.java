package org.crayzer.leetcode.editor.en.disjoin_set;

public class LeetCode_547_FriendCircles {

    class DisjoinSet {
        private int count;
        private int[] parent;

        public DisjoinSet(int n) {
            count = n;
            parent = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            parent[rootP] = rootQ;
            count--;
        }

        public int count() {
            return count;
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
