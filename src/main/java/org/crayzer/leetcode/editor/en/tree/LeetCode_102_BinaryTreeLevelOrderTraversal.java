package org.crayzer.leetcode.editor.en.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode_102_BinaryTreeLevelOrderTraversal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    class Solution {
        private List<List<Integer>> res = new LinkedList<>();

        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) return res;
            dfs(root, 0);
            return res;
        }

        private void dfs(TreeNode root, int depth) {
            if (depth >= res.size()) res.add(new LinkedList<>());

            res.get(depth).add(root.val);
            if (root.left != null) dfs(root.left, depth + 1);
            if (root.right != null) dfs(root.right, depth + 1);
        }
    }

    class Solution1 {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new LinkedList<>();
            if (root == null) return res;

            Queue<TreeNode> track = new LinkedList<>();
            track.add(root);

            while (!track.isEmpty()) {
                int size = track.size();
                List<Integer> level = new LinkedList<>();

                for (int i = 0; i < size; i++) {
                    TreeNode cur = track.poll();
                    level.add(cur.val);

                    if (cur.left != null) track.offer(cur.left);
                    if (cur.right != null) track.offer(cur.right);
                }
                res.add(new LinkedList<>(level));
            }
            return res;
        }
    }
}
