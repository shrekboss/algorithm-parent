package org.crayzer.leetcode.editor.en.tree;

import org.crayzer.leetcode.editor.en.TreeNode;

public class LeetCode_572_另一个树的子树 {

    class Soluton {
        public boolean isSubtree(TreeNode s, TreeNode t) {
            if (t == null) return true;
            if (s == null) return false;
            return isSubtree(s.left, t) || isSubtree(s.right, t) || isSameTree(s, t);
        }

        private boolean isSameTree(TreeNode s, TreeNode t) {
            if (s == null && t == null) return true;
            if (s == null || t == null) return false;
            if (s.val != t.val) return false;
            return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
        }
    }
}
