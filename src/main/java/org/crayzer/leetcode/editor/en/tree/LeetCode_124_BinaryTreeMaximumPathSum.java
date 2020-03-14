package org.crayzer.leetcode.editor.en.tree;

import org.crayzer.leetcode.editor.en.TreeNode;

public class LeetCode_124_BinaryTreeMaximumPathSum {
    private int maxPath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxPath;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int leftGain = Math.max(helper(root.left), 0);
        int rightGain = Math.max(helper(root.right), 0);

        maxPath = root.val + Math.max(leftGain, rightGain);
        return root.val + Math.max(leftGain, rightGain);
    }
}
