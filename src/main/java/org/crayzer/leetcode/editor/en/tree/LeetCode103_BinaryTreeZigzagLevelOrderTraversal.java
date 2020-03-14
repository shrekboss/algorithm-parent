package org.crayzer.leetcode.editor.en.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode103_BinaryTreeZigzagLevelOrderTraversal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new LinkedList<>();
            if (root == null) return res;

            Queue<TreeNode> track = new LinkedList<>();
            track.offer(root);
            int depth = 0;

            while (!track.isEmpty()) {
                int size = track.size();
                List<Integer> level = new LinkedList<>();

                for (int i = 0; i < size; i++) {
                    TreeNode curr = track.poll();
                    if (depth % 2 == 0) level.add(curr.val);
                    else level.add(0, curr.val);

                    if (curr.left != null) track.offer(curr.left);
                    if (curr.right != null) track.offer(curr.right);
                }
                depth++;
                res.add(new LinkedList<>(level));
            }
            return res;
        }
    }

    class Solution1 {
        private List<List<Integer>> res = new LinkedList<>();

        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if (root == null) return res;
            dfs(root, 0);
            return res;
        }

        private void dfs(TreeNode root, int depth) {
            if (depth >= res.size()) res.add(new LinkedList<>());

            if (depth % 2 == 0) res.get(depth).add(root.val);
            else res.get(depth).add(0, root.val);

            if (root.left != null) dfs(root.left, depth + 1);
            if (root.right != null) dfs(root.right, depth + 1);
        }
    }
}
