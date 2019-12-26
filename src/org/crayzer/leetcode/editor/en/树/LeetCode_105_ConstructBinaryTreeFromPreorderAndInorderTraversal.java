package org.crayzer.leetcode.editor.en.树;

import java.util.HashMap;

/**
 * 从前序与中序遍历序列构造二叉树
 */
public class LeetCode_105_ConstructBinaryTreeFromPreorderAndInorderTraversal {

    class Solution2 {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            HashMap<Integer, Integer> map = new HashMap<>(16);
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return doBuildTree(preorder, 0, preorder.length, inorder, 0, inorder.length, map);
        }

        private TreeNode doBuildTree(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd, HashMap<Integer, Integer> map) {
            if (pStart == pEnd) return null;

            int rootVal = preorder[pStart];
            TreeNode root = new TreeNode(rootVal);
            int iRootIndex = map.get(rootVal);
            int leftNum = iRootIndex - iStart;
            root.left = doBuildTree(preorder, pStart + 1, pStart + leftNum + 1, inorder, iStart, iRootIndex, map);
            root.right = doBuildTree(preorder, pStart + leftNum + 1, pEnd, inorder, iRootIndex + 1, iEnd, map);
            return root;
        }
    }

    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return doBuildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
        }

        private TreeNode doBuildTree(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
            if (pStart == pEnd) return null;

            int rootVal = preorder[pStart];
            TreeNode root = new TreeNode(rootVal);

            int iRootIndex = 0;
            for (int i = iStart; i < iEnd; i++) {
                if (rootVal == inorder[i]) {
                    iRootIndex = i;
                    break;
                }
            }
            int leftNum = iRootIndex - iStart;
            root.left = doBuildTree(preorder, pStart + 1, pStart + leftNum + 1, inorder, iStart, iRootIndex);
            root.right = doBuildTree(preorder, pStart + leftNum + 1, pEnd, inorder, iRootIndex + 1, iEnd);
            return root;
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}
