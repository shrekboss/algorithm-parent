package org.crayzer.leetcode.editor.en.tree;

import org.crayzer.leetcode.editor.en.TreeNode;

/**
 * 二叉树的最近公共祖先
 */
public class LeetCode_236_LowestCommonAncestorOfABinaryTree {

    class Solution1 {
        class Solution {
            public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
                if (root == null || root == p || root == q) return root;
                TreeNode left = lowestCommonAncestor(root.left, p, q);

                if (left != null && left != q && left != p) return left;
                TreeNode right = lowestCommonAncestor(root.right, p, q);

                if (left != null && right != null) return root;

                else
                    return left == null ? right : left;
            }
        }
    }

    class Solution {
        TreeNode ans = null;
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            recursion(root, p, q);
            return ans;
        }

        private boolean recursion(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return false;
            int left = recursion(root.left, p, q) ? 1 : 0;
            int right = recursion(root.right, p, q) ? 1 : 0;
            int mid = root == p || root == q ? 1 : 0;
            if (mid + left + right >= 2) ans = root;
            return (mid + left + right) > 0;
        }
    }

}
