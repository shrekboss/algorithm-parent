package org.crayzer.leetcode.editor.en.树;

public class LeetCode_111_MinimumDepthOfBinaryTree {

    class Solution1 {
        public int minDepth(TreeNode root) {
            if (root == null) return 0;
            if (root.left == null && root.right == null) return 1;
            int m1 = minDepth(root.left);
            int m2 = minDepth(root.right);
            return (root.left == null || root.right == null) ? m1 + m2 + 1 : Math.min(m1, m2) + 1;
        }
    }

    class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) return 0;
            if (root.left == null && root.right == null) return 1;

            int m1 = minDepth(root.left);
            int m2 = minDepth(root.right);

            if (root.left == null || root.right == null) return m1 + m2 + 1;

            return Math.min(m1, m2) + 1;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
